package com.ead.course.service.impl;

import com.ead.course.repositories.LessonRepository;
import com.ead.course.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    LessonRepository lessonRepository;
}
