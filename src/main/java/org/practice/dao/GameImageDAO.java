package org.practice.dao;

import org.practice.entity.GameImageEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GameImageDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;

    public List<GameImageEntity> findAll() {
        return em.createQuery("SELECT DISTINCT gi FROM GameImageEntity gi ORDER BY gi.id", GameImageEntity.class).getResultList();
    }
}
