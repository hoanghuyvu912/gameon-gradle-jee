package org.practice.service;

import org.practice.dao.GameDAO;
import org.practice.entity.GameCodeStatus;
import org.practice.entity.GameEntity;
import org.practice.exception.ErrorMessage;
import org.practice.exception.ResourceNotFoundException;
import org.practice.service.mapper.GameMapper;
import org.practice.service.model.Game;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;
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

    public Game getById(Integer id) throws ResourceNotFoundException {
        GameEntity gameEntity = gameDAO.findById(id)
                .orElseThrow(()
                        -> new ResourceNotFoundException(ErrorMessage.KEY_GAME_NOT_FOUND, ErrorMessage.GAME_NOT_FOUND));
        return gameMapper.toDTO(gameEntity);
    }

    public Collection<Object[]> getWithCodesSold() {
        return gameDAO.findByNumberOfCodes(GameCodeStatus.Used);
    }

    public Collection<Object[]> getWithCodesAvailable() {
        return gameDAO.findByNumberOfCodes(GameCodeStatus.Available);
    }
}
