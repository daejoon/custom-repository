package com.ddoong2.customrepository.repository;

import com.ddoong2.customrepository.config.JpaConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(JpaConfiguration.class)
class UserRepositoryTest {

    @Autowired
    ApplicationContext context;

    @Test
    @DisplayName("UserRepository는 Bean 이다")
    void UserRepository는_Bean_이다() {

        // given
        // when
        UserRepository actual = context.getBean(UserRepository.class);

        // then
        assertThat(actual).isNotNull();
    }

    @Test
    @DisplayName("명시적으로 Bean으로 선언하면 암시적으로 생성되지 않는다")
    void 명시적으로_bean으로_선언하면_암시적으로_생성되지_않는다() {

        // given
        // when
        Map<String, UserAgeCustomRepository> actual = context.getBeansOfType(UserAgeCustomRepository.class);

        // then
        assertThat(actual).hasSize(2);
        assertThat(actual).containsKeys("userCustomRepository", "userRepository");
    }

    @Test
    @DisplayName("명시적으로 선언하지 않았지만 UserPasswordCusomRepository도 Bean 이다")
    void 명시적으로_선언하지_않았지만_UserPasswordCusomRepository도_bean_이다() {

        // given

        Map<String, UserPasswordCustomRepository> actual = context.getBeansOfType(UserPasswordCustomRepository.class);

        // then
        assertThat(actual).hasSize(2);
        assertThat(actual).containsKeys("userPasswordCustomRepositoryImpl", "userRepository");
    }

}