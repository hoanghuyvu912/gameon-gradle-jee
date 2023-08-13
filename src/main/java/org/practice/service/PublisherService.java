package org.practice.service;

import org.practice.dao.PublisherDAO;
import org.practice.service.mapper.PublisherMapper;
import org.practice.service.model.Publisher;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PublisherService {
    @Inject
    private PublisherDAO publisherDAO;

    @Inject
    private PublisherMapper publisherMapper;

    public List<Publisher> getAll() {
        return publisherMapper.toDTOList(publisherDAO.findAll());
    }
}
