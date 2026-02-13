package dev.lpa;

import dev.lpa.music.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainQuery {

    public static void main(String[] args) {

        List<Artist> artists = null;
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "dev.lpa.music");
             EntityManager em = emf.createEntityManager();) {
            var transaction = em.getTransaction();
            transaction.begin();
//            artists = getArtistsJPQL(em, "");
//            artists = getArtistsJPQL(em, "%Stev%");
            artists = getArtistsJPQL(em, "%Greatest Hits%");
            artists.forEach(System.out::println);

//            var names = getArtistNames(em, "Stev%");
//            names.forEach(System.out::println);
//            names
//                    .map(a -> new Artist(
//                            a.get(0, Integer.class),
//                            (String) a.get(1)))
//                    .forEach(System.out::println);
//            names
//                    .map(a -> new Artist(
//                            a.get("id", Integer.class),
//                            (String) a.get("name")))
//                    .forEach(System.out::println);

            System.out.println("----------------------------------");
            Stream<Artist> sartists = getArtistsBuilder(em, "Bl%");
            var map = sartists
                    .limit(10)
                            .collect(Collectors.toMap(
                                    Artist::getArtistName,
                                    (a) -> a.getAlbums().size(),
                                    Integer::sum,
                                    TreeMap::new
                            ));

            map.forEach((k, v) -> System.out.println(k + " : " + v));

            System.out.println("----------------------------------");
            Stream<Artist> sartists2 = getArtistsSQL(em, "Bl%");
            var map2 = sartists2
                    .limit(10)
                    .collect(Collectors.toMap(
                            Artist::getArtistName,
                            (a) -> a.getAlbums().size(),
                            Integer::sum,
                            TreeMap::new
                    ));

            map2.forEach((k, v) -> System.out.println(k + " : " + v));

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Artist> getArtistsJPQL(EntityManager em, String matchedValue) {

//        String jpql = "SELECT a FROM Artist a";
//        String jpql = "SELECT a FROM Artist a WHERE a.artistName LIKE :partialName";
//        var query = em.createQuery(jpql, Artist.class);
//        query.setParameter("partialName", matchedValue);
//        String jpql = "SELECT a FROM Artist a WHERE a.artistName LIKE ?1"; // search from artist name
//        String jpql = "SELECT a FROM Artist a JOIN albums album " +
//                "WHERE album.albumName LIKE ?1";
        String jpql = "SELECT a FROM Artist a JOIN albums album " +
                "WHERE album.albumName LIKE ?1 OR album.albumName LIKE ?2";
        var query = em.createQuery(jpql, Artist.class);
        query.setParameter(1, matchedValue);
        query.setParameter(2, "%Best of%");
        return query.getResultList();
    }

//    private static List<String> getArtistNames(EntityManager em, String matchedValue) {
    private static Stream<Tuple> getArtistNames(EntityManager em, String matchedValue) {

//        String jpql = "SELECT a.artistId, a.artistName FROM Artist a WHERE a.artistName LIKE ?1";
//        String jpql = "SELECT a.artistId, a.artistName FROM Artist a " +
//                "WHERE a.artistName LIKE ?1";
        String jpql = "SELECT a.artistId id, a.artistName as name FROM Artist a " +
                "WHERE a.artistName LIKE ?1";
//        var query = em.createQuery(jpql, String.class);
        var query = em.createQuery(jpql,Tuple.class);
        query.setParameter(1, matchedValue);
//        return query.getResultList();
        return query.getResultStream();
    }

    private static Stream<Artist> getArtistsBuilder(EntityManager em,
                                                    String matchedValue) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Artist> criteriaQuery = builder.createQuery(Artist.class);
        Root<Artist> root = criteriaQuery.from(Artist.class);
//        criteriaQuery.select(root);
//        criteriaQuery.where(builder.like(root.get("artistName"), matchedValue)); // Where like in SQL
//        criteriaQuery.orderBy(builder.asc(root.get("artistName"))); // Orderby in SQL
        criteriaQuery
                .select(root)
                .where(builder.like(root.get("artistName"), matchedValue))
                .orderBy(builder.asc(root.get("artistName"))); // chain of three method
        return em.createQuery(criteriaQuery).getResultStream();
    }

    private static Stream<Artist> getArtistsSQL(EntityManager em, String matchedValue) {

        var query = em.createNativeQuery(
                "SELECT * FROM music.artists where artist_name like ?1",
                Artist.class);
        query.setParameter(1, matchedValue);
        return query.getResultStream();
    }
}
