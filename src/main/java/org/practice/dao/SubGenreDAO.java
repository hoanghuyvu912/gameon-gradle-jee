package org.practice.dao;

import org.practice.entity.GenreEntity;
import org.practice.entity.SubGenreEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class SubGenreDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;

    public List<SubGenreEntity> findAll() {
        return em.createQuery("SELECT DISTINCT sg FROM SubGenreEntity sg ORDER BY sg.id", SubGenreEntity.class).getResultList();
    }

    public Optional<SubGenreEntity> findById(Integer id) {
        List<SubGenreEntity> subGenreEntityList = em.createQuery("SELECT DISTINCT sg FROM SubGenreEntity sg " +
                        "ORDER BY sg.id, sg.name", SubGenreEntity.class)
                .setParameter("id", id)
                .getResultList();

        return subGenreEntityList.isEmpty() ? Optional.empty() : Optional.of(subGenreEntityList.get(0));
    }
}
