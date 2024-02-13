package com.ead.course.repositories;

import com.ead.course.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoy extends JpaRepository<UserModel, UUID> {
}