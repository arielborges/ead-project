package com.ead.authuser.services;

import com.ead.authuser.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Optional<UserModel> findById(UUID userId);

    UserModel saveUser(UserModel userModel);

    UserModel updateUser(UserModel userModel);

    void deleteUser(UserModel userModel);

    UserModel updatePassword(UserModel userModel);

    boolean existByUserName(String username);

    boolean existByEmail(String email);

    Page<UserModel> findAll(Specification<UserModel> spec, Pageable pageable);
}
