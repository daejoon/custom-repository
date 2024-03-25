package com.ddoong2.customrepository.repository.impl;

import com.ddoong2.customrepository.entity.UserEntity;
import com.ddoong2.customrepository.repository.UserPasswordCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.ddoong2.customrepository.entity.QUserEntity.userEntity;

@RequiredArgsConstructor
public class UserPasswordCustomRepositoryImpl implements UserPasswordCustomRepository {

    private final JPAQueryFactory query;

    @Override
    public Optional<UserEntity> findByPassword(String password) {

        return Optional.ofNullable(
                this.query.selectFrom(userEntity)
                        .where(userEntity.password.eq(password))
                        .fetchOne()
        );
    }
}
