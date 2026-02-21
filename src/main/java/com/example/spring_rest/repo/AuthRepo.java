package com.example.spring_rest.repo;

import com.example.spring_rest.dto.SignupRequest;
import com.example.spring_rest.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class AuthRepo {
    User data  = new User();

    public int signUpUser(SignupRequest loginData) {

        data.setEmail(loginData.getEmail());
        data.setUserName(loginData.getUserName());
        data.setPassword(loginData.getPassword());


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em0 = emf.createEntityManager();
        EntityTransaction et = em0.getTransaction();

        try {
            // Begin transaction
            et.begin();

            // Persist the new user object
            em0.persist(data);

            // Commit the transaction
            et.commit();

            System.out.println("✅ User inserted successfully with ID: " + data.getId());
            return 1; // Success
        } catch (Exception e) {
            // In case of an error, rollback the transaction
            if (et != null && et.isActive()) {
                et.rollback(); // Rollback if transaction is active
            }
            e.printStackTrace();
            return 0; // Failure
        } finally {
            // Close resources to avoid memory leaks
            if (em0 != null) {
                em0.close(); // Close EntityManager
            }
            if (emf != null) {
                emf.close(); // Close EntityManagerFactory
            }
        }
    }


    public User fetchUserByEmail(String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em0 = emf.createEntityManager();
        EntityTransaction et = em0.getTransaction();

        try {
            // Begin transaction (although you may not need this for read operations)
            et.begin();

            // HQL query to fetch users by email
            String hql = "FROM User u WHERE u.email = :email";
            Query query = em0.createQuery(hql);
            query.setParameter("email", email); // Set the email parameter in the query

            // Execute the query and get the result list
            User user = (User) query.getSingleResult();

            // Commit the transaction (if you made any modifications, for example, delete)
            et.commit();

            return user; // Return the list of users matching the email
        } catch (Exception e) {
            // In case of an error, rollback the transaction
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
            return null; // Failure or no result
        } finally {
            // Close resources to avoid memory leaks
            if (em0 != null) {
                em0.close(); // Close EntityManager
            }
            if (emf != null) {
                emf.close(); // Close EntityManagerFactory
            }
        }
    }
}
