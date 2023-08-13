package org.practice.service;

import org.practice.dao.CommentDAO;
import org.practice.service.mapper.CommentMapper;
import org.practice.service.model.Comment;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CommentService {
    @Inject
    CommentDAO commentDAO;

    @Inject
    CommentMapper commentMapper;

    public List<Comment> getAll() {
        return commentMapper.toDTOList(commentDAO.findAll());
    }
}
