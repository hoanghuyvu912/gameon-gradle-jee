package org.practice.dao;

import org.practice.entity.DeveloperEntity;
import org.practice.entity.Gender;
import org.practice.entity.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless

public class UserDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;

    public List<UserEntity> findByGender(Gender gender) {
        return em.createNamedQuery(UserEntity.GET_BY_GENDER, UserEntity.class).setParameter("gender", gender).getResultList();
    }

    public Optional<UserEntity> findByEmail(String email) {
        List<UserEntity> userEntityList = em.createQuery("SELECT u FROM UserEntity u " +
                        "WHERE LOWER(trim(both from u.email)) LIKE LOWER(trim(both from :email))", UserEntity.class)
                .setParameter("email", email)
                .getResultList();

        return userEntityList.isEmpty() ? Optional.empty() : Optional.of(userEntityList.get(0));
    }

    public Optional<UserEntity> findById(Integer id) {
        List<UserEntity> userEntityList = em.createQuery("SELECT DISTINCT u FROM UserEntity u " +
                        "LEFT JOIN FETCH u.receiptEntityList r " +
                        "LEFT JOIN FETCH r.receiptDetailsEntityList rd " +
                        "LEFT JOIN u.roles " +
                        "WHERE u.id = :id" +
                        "ORDER BY u.id, u.name", UserEntity.class)
                .setParameter("id", id)
                .getResultList();

        return userEntityList.isEmpty() ? Optional.empty() : Optional.of(userEntityList.get(0));
    }
}
