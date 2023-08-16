package org.practice.dao;

import org.practice.entity.GameEntity;
import org.practice.entity.PublisherEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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

    public Optional<GameEntity> findById(Integer id) {
        List<GameEntity> gameEntityList = em.createQuery("SELECT DISTINCT g FROM GameEntity g " +
                        "LEFT JOIN FETCH g.commentEntityList c " +
                        "LEFT JOIN g.ratingEntityList r " +
                        "WHERE g.id = :id" +
                        "ORDER BY g.id, g.name", GameEntity.class)
                .setParameter("id", id)
                .getResultList();

        return gameEntityList.isEmpty() ? Optional.empty() : Optional.of(gameEntityList.get(0));
    }
}
