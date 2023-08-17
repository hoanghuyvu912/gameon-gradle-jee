package org.practice.dao;

import org.practice.entity.GenreEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class GenreDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;

    public List<GenreEntity> findAll() {
        return em.createQuery("SELECT DISTINCT g FROM GenreEntity g ORDER BY g.id", GenreEntity.class).getResultList();
    }

    public Optional<GenreEntity> findById(Integer id) {
        List<GenreEntity> genreEntityList = em.createQuery("SELECT DISTINCT g FROM GenreEntity g " +
                        "ORDER BY g.id, g.name", GenreEntity.class)
                .setParameter("id", id)
                .getResultList();

        return genreEntityList.isEmpty() ? Optional.empty() : Optional.of(genreEntityList.get(0));
    }
}
