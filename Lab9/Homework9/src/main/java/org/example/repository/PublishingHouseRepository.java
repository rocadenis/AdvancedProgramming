package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.model.PublishingHouse;
import org.example.persistence.EntityManagerFactorySingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;
import java.util.logging.Level;



public class PublishingHouseRepository {

    private static final Logger logger = LogManager.getLogger(PublishingHouseRepository.class);

    private final EntityManagerFactory entityManagerFactory;

    public PublishingHouseRepository() {
        entityManagerFactory = EntityManagerFactorySingleton.getEntityManagerFactory();
    }

    public void create(PublishingHouse publishingHouse) {
        long startTime = System.currentTimeMillis();
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(publishingHouse);
            transaction.commit();
            entityManager.close();
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            logger.info("PublishingHouse created successfully in {} milliseconds", executionTime);
        } catch (Exception ex) {
            logger.error("An error occurred while creating the publishing house", ex);
        }
    }


    public PublishingHouse findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        PublishingHouse publishingHouse = null;
        try {
            publishingHouse = entityManager.find(PublishingHouse.class, id);
        } catch (Exception ex) {
            ex.printStackTrace(); // Handle or log exception appropriately
        } finally {
            entityManager.close();
        }
        return publishingHouse;
    }

    public List<PublishingHouse> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<PublishingHouse> publishingHouses = null;
        try {
            TypedQuery<PublishingHouse> query = entityManager.createQuery("SELECT ph FROM PublishingHouse ph", PublishingHouse.class);
            publishingHouses = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace(); // Handle or log exception appropriately
        } finally {
            entityManager.close();
        }
        return publishingHouses;
    }

    public void update(PublishingHouse publishingHouse) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(publishingHouse);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace(); // Handle or log exception appropriately
        } finally {
            entityManager.close();
        }
    }

    public void delete(PublishingHouse publishingHouse) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entityManager.contains(publishingHouse) ? publishingHouse : entityManager.merge(publishingHouse));
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace(); // Handle or log exception appropriately
        } finally {
            entityManager.close();
        }
    }
}
