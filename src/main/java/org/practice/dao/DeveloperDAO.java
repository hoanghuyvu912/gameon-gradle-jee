package org.practice.dao;

import org.practice.entity.DeveloperEntity;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public interface DeveloperDAO {
    List<DeveloperEntity> getAll();
}
