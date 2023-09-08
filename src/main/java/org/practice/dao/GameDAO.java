package org.practice.dao;

import org.practice.entity.GameCodeStatus;
import org.practice.entity.GameEntity;

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
                        "WHERE g.id = :id " +
                        "ORDER BY g.id, g.name", GameEntity.class)
                .setParameter("id", id)
                .getResultList();

        return gameEntityList.isEmpty() ? Optional.empty() : Optional.of(gameEntityList.get(0));
    }

    public List<Object[]> findByNumberOfCodes(GameCodeStatus gameCodeStatus) {
        return em.createQuery("SELECT DISTINCT g.id, g.name, COUNT(gc.id) " +
                        "FROM GameEntity g JOIN GameCodeEntity gc on g.id = gc.game.id " +
                        "GROUP BY g.id, gc.gameCodeStatus " +
                        "HAVING gc.gameCodeStatus = :gameCodeStatus " +
                        "ORDER BY g.id, g.name", Object[].class)
                .setParameter("gameCodeStatus", gameCodeStatus)
                .getResultList();
    }

    public List<Object[]> findByGenre(GameCodeStatus gameCodeStatus) {
        return em.createQuery("SELECT DISTINCT g.id, g.name, COUNT(gc.id) " +
                        "FROM GameEntity g JOIN GameCodeEntity gc on g.id = gc.game.id " +
                        "GROUP BY g.id, gc.gameCodeStatus " +
                        "HAVING gc.gameCodeStatus = :gameCodeStatus " +
                        "ORDER BY g.id, g.name", Object[].class)
                .setParameter("gameCodeStatus", gameCodeStatus)
                .getResultList();
    }
}
