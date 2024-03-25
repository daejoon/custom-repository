package com.ddoong2.customrepository.repository;

import com.ddoong2.customrepository.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long>,
                                        UserAgeCustomRepository,
                                        UserPasswordCustomRepository {
    Optional<UserEntity> findByName(String name);
}
