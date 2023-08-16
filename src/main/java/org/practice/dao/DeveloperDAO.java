package org.practice.dao;

import org.practice.entity.DeveloperEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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

    public Optional<DeveloperEntity> findById(Integer id) {
        List<DeveloperEntity> developerEntityList = em.createQuery("SELECT DISTINCT d FROM DeveloperEntity d " +
                        "LEFT JOIN FETCH d.gameEntityList g " +
                        "LEFT JOIN FETCH g.publisher p " +
                        "WHERE d.id = :id" +
                        "ORDER BY d.id, d.name", DeveloperEntity.class)
                .setParameter("id", id)
                .getResultList();

        return developerEntityList.isEmpty() ? Optional.empty() : Optional.of(developerEntityList.get(0));
    }
}
