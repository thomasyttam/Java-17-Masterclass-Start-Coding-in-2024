package dev.lpa;

import dev.lpa.music.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;

import java.util.List;
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
            artists = getArtistsJPQL(em, "%Stev%");
            artists.forEach(System.out::println);

            var names = getArtistNames(em, "Stev%");
//            names.forEach(System.out::println);
//            names
//                    .map(a -> new Artist(
//                            a.get(0, Integer.class),
//                            (String) a.get(1)))
//                    .forEach(System.out::println);
            names
                    .map(a -> new Artist(
                            a.get("id", Integer.class),
                            (String) a.get("name")))
                    .forEach(System.out::println);
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
        String jpql = "SELECT a FROM Artist a WHERE a.artistName LIKE ?1";
        var query = em.createQuery(jpql, Artist.class);
        query.setParameter(1, matchedValue);
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
}
