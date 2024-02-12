package com.ead.course.service;

import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UtilsService {

    String urlAllUserByCourse(UUID courseId, Pageable pageable);

    String urlOneUserById(UUID userId);

    String urlPostSubscription(UUID userId);

    String urlDeleteCourseInAuthuser(UUID courseId);
}
