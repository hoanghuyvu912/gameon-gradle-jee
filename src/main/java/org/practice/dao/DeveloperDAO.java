package org.practice.dao;

import org.practice.entity.DeveloperEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DeveloperDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;

    public List<DeveloperEntity> findAll() {
        return em.createQuery("SELECT DISTINCT d FROM DeveloperEntity d " +
                        "LEFT JOIN FETCH d.gameEntityList g " +
                        "LEFT JOIN FETCH g.publisher p " +
                        "ORDER BY d.id, d.name", DeveloperEntity.class).
                getResultList();
    }
}
