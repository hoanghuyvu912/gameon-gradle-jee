package org.practice.service;

import org.practice.dao.SubGenreDAO;
import org.practice.service.mapper.SubGenreMapper;
import org.practice.service.model.SubGenre;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class SubGenreService {
    @Inject
    private SubGenreDAO subGenreDAO;

    @Inject
    private SubGenreMapper subGenreMapper;

    public List<SubGenre> getAll() {
        return subGenreMapper.toDTOList(subGenreDAO.findAll());
    }

}
