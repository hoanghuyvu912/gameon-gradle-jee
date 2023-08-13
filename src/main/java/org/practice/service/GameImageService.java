package org.practice.service;

import org.practice.dao.GameImageDAO;
import org.practice.service.mapper.GameImageMapper;
import org.practice.service.model.GameImage;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class GameImageService {
    @Inject
    GameImageDAO gameImageDAO;
    @Inject
    GameImageMapper gameImageMapper;

    public List<GameImage> getAll() {
        return gameImageMapper.toDTOList(gameImageDAO.findAll());
    }
}
