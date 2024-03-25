package com.ddoong2.customrepository.repository.impl;

import com.ddoong2.customrepository.entity.UserEntity;
import com.ddoong2.customrepository.repository.UserAgeCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.ddoong2.customrepository.entity.QUserEntity.userEntity;

@RequiredArgsConstructor
@Component("userAgeCustomRepository")
public class UserAgeCustomRepositoryImpl implements UserAgeCustomRepository {

    private final JPAQueryFactory query;

    @Override
    public Optional<UserEntity> findByAge(Integer age) {

        return Optional.ofNullable(
                query.selectFrom(userEntity)
                        .where(userEntity.age.eq(age))
                        .fetchOne()
        );
    }
}
