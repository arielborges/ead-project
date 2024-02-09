package com.ead.course.service.impl;

import com.ead.course.clients.AuthUserClient;
import com.ead.course.models.CourseModel;
import com.ead.course.models.CourseUserModel;
import com.ead.course.repositories.CourseUserRepositoy;
import com.ead.course.service.CourseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class CourseUserServiceimpl implements CourseUserService {

    final
    CourseUserRepositoy courseUserRepositoy;

    final
    AuthUserClient authUserClient;

    public CourseUserServiceimpl(CourseUserRepositoy courseUserRepositoy, AuthUserClient authUserClient) {
        this.courseUserRepositoy = courseUserRepositoy;
        this.authUserClient = authUserClient;
    }

    @Override
    public boolean existsByCourseIdAndUserId(CourseModel courseModel, UUID userId) {
        return courseUserRepositoy.existsByCourseAndUserId(courseModel,userId);
    }

    @Override
    public CourseUserModel save(CourseUserModel courseUserModel) {
        return courseUserRepositoy.save(courseUserModel);
    }

    @Transactional
    @Override
    public CourseUserModel saveAndSendSubscriptionUserInCourse(CourseUserModel courseUserModel) {
        courseUserModel = courseUserRepositoy.save(courseUserModel);
        authUserClient.postSubscriptionuserInCourse(courseUserModel.getCourse().getCourseId(),courseUserModel.getUserId());
        return courseUserModel;
    }
}
