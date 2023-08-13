package org.practice.dao;

import org.practice.entity.RatingEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RatingDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;

    public List<RatingEntity> findAll() {
        return em.createQuery("SELECT DISTINCT r FROM RatingEntity r ORDER BY r.id", RatingEntity.class).getResultList();
    }
}
