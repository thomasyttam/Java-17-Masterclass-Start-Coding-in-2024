package dev.lpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        try (var sessionFactory =
                     Persistence.createEntityManagerFactory(
                             "dev.lpa.music");
             EntityManager entityManager = sessionFactory.createEntityManager();
        ) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
