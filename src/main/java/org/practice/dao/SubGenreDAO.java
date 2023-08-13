package org.practice.dao;

import org.practice.entity.GenreEntity;
import org.practice.entity.SubGenreEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SubGenreDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;

    public List<SubGenreEntity> findAll() {
        return em.createQuery("SELECT DISTINCT sg FROM SubGenreEntity sg ORDER BY sg.id", SubGenreEntity.class).getResultList();
    }
}
