package org.practice.dao;

import org.practice.entity.GameEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GameDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;

    public List<GameEntity> findAll() {
        return em.createQuery("SELECT DISTINCT g FROM GameEntity g " +
                "LEFT JOIN FETCH g.commentEntityList c " +
                "LEFT JOIN g.ratingEntityList r " +
                "ORDER BY g.id, g.name", GameEntity.class).getResultList();
    }
}
