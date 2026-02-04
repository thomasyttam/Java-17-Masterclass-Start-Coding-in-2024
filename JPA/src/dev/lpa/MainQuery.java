package dev.lpa;

import dev.lpa.music.Artist;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainQuery {

    public static void main(String[] args) {

        List<Artist> artists = null;
    }

    private static List<Artist> getArtistsJPQL(EntityManager em, String matchedValue) {

        String jpql = "SELECT a FROM Artist a";
        var query = em.createQuery(jpql, Artist.class);
        return query.getResultList();
    }
}
