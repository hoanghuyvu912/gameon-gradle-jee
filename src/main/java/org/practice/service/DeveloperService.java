package org.practice.service;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.practice.dao.DeveloperDAO;
import org.practice.entity.DeveloperEntity;
import org.practice.security.ErrorMessage;
import org.practice.security.ResourceNotFoundException;
import org.practice.service.mapper.DeveloperMapper;
import org.practice.service.model.Developer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;

@Stateless
public class DeveloperService {
    private static final Validator validator =
            Validation.byDefaultProvider()
                    .configure()
                    .messageInterpolator(new ParameterMessageInterpolator())
                    .buildValidatorFactory()
                    .getValidator();

    @Inject
    private DeveloperDAO developerDAO;

    @Inject
    private DeveloperMapper developerMapper;

    public List<Developer> getAll() {
        return developerMapper.toDTOList(developerDAO.findAll());
    }

    public Developer getById(Integer id) throws ResourceNotFoundException {
        DeveloperEntity developerEntity = developerDAO.findById(id)
                .orElseThrow(()
                        -> new ResourceNotFoundException(ErrorMessage.KEY_DEVELOPER_NOT_FOUND, ErrorMessage.DEVELOPER_NOT_FOUND));
        return developerMapper.toDTO(developerEntity);
    }
}
