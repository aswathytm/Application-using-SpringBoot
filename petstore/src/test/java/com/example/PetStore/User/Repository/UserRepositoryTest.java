package com.example.PetStore.User.Repository;
import com.example.PetStore.User.Model.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

//behaviour driven development
    @Test
    void existUserModelByUserName() {
        //given
        UserModel username = new UserModel("aswathy123", "aswathy", "tm", "aswathy123", "aswathy@qburst.com", "+91 6238011079", 1);
        userRepository.save(username);
        //when
        boolean exist= userRepository.existUserModelByUserName("aswathy123");
        //Then
        assertThat(exist).isTrue();

    }
    @Test
    void notExistsUserByUsername() {
        //given
        UserModel username = new UserModel("aswathi", "aswathy", "tm", "aswathy123", "aswathy@qburst.com", "+91 6238011079", 1);
        userRepository.save(username);
        //when
        boolean exist= userRepository.existUserModelByUserName("aswa123");
        //Then
        assertThat(exist).isFalse();

    }
    @Test
    void findByUsername() {
        //given
        UserModel username = new UserModel("aswathi123", "aswathy", "tm", "aswathy123", "aswathy@qburst.com", "+91 6238011079", 1);
        userRepository.save(username);
        //when
        Optional<UserModel> user1 = userRepository.findByUserName("aswathy123");
        //Then
        assertThat(user1.get()).isEqualTo(username);
    }
    @Test
    void notFindByUsername() {
        //given
        UserModel username = new UserModel("aswathy123", "aswathy", "tm", "aswathy123", "aswathy@qburst.com", "+91 6238011079", 1);
        userRepository.save(username);
        //when
        Optional<UserModel> user1 = userRepository.findByUserName("aswathy3");
        //Then
        assertThat(user1.isPresent()).isFalse();
    }
}

