package com.ddoong2.customrepository.repository;

import com.ddoong2.customrepository.entity.UserEntity;

import java.util.Optional;

public interface UserPasswordCustomRepository {
    Optional<UserEntity> findByPassword(String password);
}
