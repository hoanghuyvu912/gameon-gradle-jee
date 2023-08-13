package org.practice.service;

import org.practice.dao.DeveloperDAO;
import org.practice.entity.DeveloperEntity;
import org.practice.service.mapper.DeveloperMapper;
import org.practice.service.model.Developer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DeveloperService {
    @Inject
    private DeveloperDAO developerDAO;

    @Inject
    private DeveloperMapper developerMapper;

    public List<Developer> getAll() {
//            return developerDAO.findAll();
        return developerMapper.toDTOList(developerDAO.findAll());
    }
}
