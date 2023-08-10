package org.practice.service.mapper;

import java.util.List;
public interface BaseMapper<E, D> {
    D toDTO(E entity);

    List<D> toDTOList(List<E> entityList);
}
