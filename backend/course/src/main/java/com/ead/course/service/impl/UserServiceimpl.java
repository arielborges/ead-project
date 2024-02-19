package com.ead.course.service.impl;

import com.ead.course.models.UserModel;
import com.ead.course.repositories.CourseRepository;
import com.ead.course.repositories.UserRepositoy;
import com.ead.course.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceimpl implements UserService {

    final UserRepositoy userRepositoy;
    final CourseRepository courseRepository;
    public UserServiceimpl(UserRepositoy userRepositoy, CourseRepository courseRepository) {
        this.userRepositoy = userRepositoy;
        this.courseRepository = courseRepository;
    }

    @Override
    public Page<UserModel> findAll(Specification<UserModel> spec, Pageable pageable) {
        return userRepositoy.findAll(spec, pageable);
    }

    @Override
    public UserModel save(UserModel userModel) {
        return userRepositoy.save(userModel);
    }

    @Override
    public Optional<UserModel> findById(UUID userInstructor) {
        return userRepositoy.findById(userInstructor);
    }

    @Transactional
    @Override
    public void delete(UUID userId) {
        courseRepository.deleteCourseUserByUser(userId);
        userRepositoy.deleteById(userId);
    }
}
