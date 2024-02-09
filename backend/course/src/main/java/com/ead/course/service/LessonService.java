package com.ead.course.service;

import com.ead.course.models.LessonModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LessonService {
    Object save(LessonModel lessonModel);

    Optional<LessonModel> findlLessonIntoModule(UUID moduleId, UUID lessonId);

    void delete(LessonModel lessonModel);

    Page<LessonModel> findAllByModule(Specification<LessonModel> spec, Pageable pageable);
}
