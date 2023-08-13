package org.practice.service;

import org.practice.dao.CommentDAO;
import org.practice.dao.RatingDAO;
import org.practice.service.mapper.CommentMapper;
import org.practice.service.mapper.RatingMapper;
import org.practice.service.model.Comment;
import org.practice.service.model.Rating;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class RatingService {
    @Inject
    RatingDAO ratingDAO;

    @Inject
    RatingMapper ratingMapper;

    public List<Rating> getAll() {
        return ratingMapper.toDTOList(ratingDAO.findAll());
    }
}
