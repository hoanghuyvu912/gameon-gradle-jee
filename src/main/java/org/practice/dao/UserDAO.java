package org.practice.dao;

import org.practice.entity.Gender;
import org.practice.entity.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless

public class UserDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;

    public List<UserEntity> findByGender(Gender gender) {
        return em.createNamedQuery(UserEntity.GET_BY_GENDER, UserEntity.class).setParameter("gender", gender).getResultList();
    }
}
