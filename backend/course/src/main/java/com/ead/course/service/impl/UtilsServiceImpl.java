package com.ead.course.service.impl;

import com.ead.course.service.UtilsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtilsServiceImpl implements UtilsService {

    @Value("${ead.api.url.authuser}")
    String REQUEST_URI_AUTHUSER;

    public String urlAllUserByCourse(UUID courseId, Pageable pageable) {
        return REQUEST_URI_AUTHUSER + "/users?courseId=" + courseId + "&page=" + pageable.getPageNumber() + "&size=" + pageable.getPageSize() +
                "&sort=" + pageable.getSort().toString().replaceAll(": ", ",");
    }

    @Override
    public String urlOneUserById(UUID userId) {
        return REQUEST_URI_AUTHUSER + "/users/" + userId;
    }

    @Override
    public String urlDeleteCourseInAuthuser(UUID courseId) {
        return REQUEST_URI_AUTHUSER + "/users/courses/" + courseId;
    }

    @Override
    public String urlPostSubscription(UUID userId) {
        return REQUEST_URI_AUTHUSER + "/users/" + userId + "/courses/subscription";
    }
}
