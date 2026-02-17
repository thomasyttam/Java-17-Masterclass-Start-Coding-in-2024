package dev.lpa;

import dev.lpa.music.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        try (var sessionFactory =
                     Persistence.createEntityManagerFactory(
                             "dev.lpa.music");
             EntityManager entityManager = sessionFactory.createEntityManager();
        ) {
            var transaction = entityManager.getTransaction();
            transaction.begin();
//            entityManager.persist(new Artist("Muddy Water"));
//            Artist artist = entityManager.find(Artist.class, 203);
//            entityManager.remove(artist);
//            Artist artist = new Artist(202, "Muddy Water");
//            entityManager.merge(artist);
//            artist.setArtistName("Muddy Waters");
//            Artist artist = entityManager.find(Artist.class, 201);
//            artist.removeDuplicates();
            Artist artist = entityManager.find(Artist.class, 103);
            System.out.println(artist);
//            artist.addAlbum("The Best of Muddy Waters");
//            System.out.println(artist);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
