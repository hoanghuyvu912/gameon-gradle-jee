package org.practice.dao;

import org.practice.entity.CommentEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CommentDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;

    public List<CommentEntity> findAll() {
        return em.createQuery("SELECT DISTINCT c FROM CommentEntity c ORDER BY c.id", CommentEntity.class).getResultList();
    }
}
