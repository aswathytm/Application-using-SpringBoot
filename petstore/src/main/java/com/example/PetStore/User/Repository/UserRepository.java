package com.example.PetStore.User.Repository;

import com.example.PetStore.User.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {
    Optional<UserModel> findByUserName(String username);

    Optional<UserModel> deleteByUserName(String username);
    boolean existUserModelByUserName(String username);
}