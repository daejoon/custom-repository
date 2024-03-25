package com.ddoong2.customrepository.repository.impl;

import com.ddoong2.customrepository.entity.UserEntity;
import com.ddoong2.customrepository.repository.UserCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserCustomRepositoryImpl implements UserCustomRepository {

    private final JPAQueryFactory query;

    @Override
    public Optional<UserEntity> findByAge(Integer age) {
        return Optional.empty();
    }
}
