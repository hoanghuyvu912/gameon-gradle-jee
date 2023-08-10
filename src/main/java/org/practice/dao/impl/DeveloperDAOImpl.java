package org.practice.dao.impl;

import org.practice.dao.DeveloperDAO;
import org.practice.entity.DeveloperEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DeveloperDAOImpl implements DeveloperDAO {
    @PersistenceContext(name = "gameon")
    EntityManager em;

    @Override
    public List<DeveloperEntity> getAll() {
        return em.createQuery("SELECT d from DeveloperEntity d", DeveloperEntity.class).getResultList();
    }
}
