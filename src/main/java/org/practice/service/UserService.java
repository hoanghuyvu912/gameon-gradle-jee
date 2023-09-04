package org.practice.service;

import org.practice.dao.UserDAO;
import org.practice.entity.UserEntity;
import org.practice.exception.ErrorMessage;
import org.practice.exception.InputValidationException;
import org.practice.service.mapper.UserMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserService {
    @Inject
    private UserDAO userDAO;

    @Inject
    private UserMapper userMapper;

    public UserEntity getEntityByEmail(String email) throws InputValidationException {
        return userDAO.findByEmail(email)
                .orElseThrow(() -> new InputValidationException(ErrorMessage.KEY_PASS_EMAIL_INVALID, ErrorMessage.PASS_EMAIL_INVALID));
    }
}
