package org.practice.dao;

import org.practice.entity.CommentEntity;
import org.practice.entity.GenreEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GenreDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;

    public List<GenreEntity> findAll() {
        return em.createQuery("SELECT DISTINCT g FROM GenreEntity g ORDER BY g.id", GenreEntity.class).getResultList();
    }
}
