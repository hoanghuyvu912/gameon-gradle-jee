package org.practice.service;

import org.practice.dao.GenreDAO;
import org.practice.service.mapper.GenreMapper;
import org.practice.service.model.Genre;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class GenreService {
    @Inject
    private GenreDAO genreDAO;

    @Inject
    private GenreMapper genreMapper;

    public List<Genre> getAll() {
        return genreMapper.toDTOList(genreDAO.findAll());
    }

}
