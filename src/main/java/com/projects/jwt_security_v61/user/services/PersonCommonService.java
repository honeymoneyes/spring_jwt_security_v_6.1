package com.projects.jwt_security_v61.user.services;

import java.util.List;

public interface PersonCommonService<T, K> {
    List<T> findAll();

    T findById(K id);

    void save(T t);

    void delete(T t);
}
