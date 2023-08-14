package org.practice.dao;

import org.practice.entity.GameGenreEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GameGenreDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;

    public List<GameGenreEntity> findAll() {
        return em.createQuery("SELECT DISTINCT gg FROM GameGenreEntity gg ORDER BY gg.id", GameGenreEntity.class).getResultList();
    }
}
