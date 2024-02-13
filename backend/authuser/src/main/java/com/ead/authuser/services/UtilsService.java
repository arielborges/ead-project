package com.ead.authuser.services;

import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UtilsService {

    String urlAllCoursesByUser(UUID userId, Pageable pageable);

    String urlDeleteUserInCourse(UUID userId);
}
