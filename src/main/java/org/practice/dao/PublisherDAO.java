package org.practice.dao;

import org.practice.entity.DeveloperEntity;
import org.practice.entity.PublisherEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class PublisherDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;
    public List<PublisherEntity> findAll() {
        return em.createQuery("SELECT DISTINCT p FROM PublisherEntity p " +
                        "LEFT JOIN FETCH p.gameEntityList g " +
                        "LEFT JOIN FETCH g.developer d " +
                        "ORDER BY p.id, p.name", PublisherEntity.class).
                getResultList();
    }

    public Optional<PublisherEntity> findById(Integer id) {
        List<PublisherEntity> publisherEntityList = em.createQuery("SELECT DISTINCT p FROM PublisherEntity p " +
                        "LEFT JOIN FETCH d.gameEntityList g " +
                        "LEFT JOIN FETCH g.developer d " +
                        "WHERE p.id = :id" +
                        "ORDER BY p.id, p.name", PublisherEntity.class)
                .setParameter("id", id)
                .getResultList();

        return publisherEntityList.isEmpty() ? Optional.empty() : Optional.of(publisherEntityList.get(0));
    }
}
