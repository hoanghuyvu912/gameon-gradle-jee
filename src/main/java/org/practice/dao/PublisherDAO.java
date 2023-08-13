package org.practice.dao;

import org.practice.entity.PublisherEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Stateless
public class PublisherDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;
    public List<PublisherEntity> findAll() {
        return em.createQuery("SELECT DISTINCT p FROM PublisherEntity p LEFT JOIN FETCH p.gameEntityList g LEFT JOIN FETCH g.developer d ORDER BY p.id, p.name", PublisherEntity.class).
                getResultList();
    }
}
