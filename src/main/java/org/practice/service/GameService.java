package org.practice.service;

import org.practice.dao.GameDAO;
import org.practice.service.mapper.GameMapper;
import org.practice.service.model.Game;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class GameService {
    @Inject
    private GameDAO gameDAO;

    @Inject
    private GameMapper gameMapper;

    public List<Game> getAll() {
        return gameMapper.toDTOList(gameDAO.findAll());
    }
}
