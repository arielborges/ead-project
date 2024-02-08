package com.ead.course.service;

import com.ead.course.models.ModuleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModuleService {

    void delete(ModuleModel moduleModel);

    Object save(ModuleModel modulesModel);

    Optional<ModuleModel> findModuleIntoCourse(UUID courseId, UUID moduleId);

    Optional<ModuleModel> findById(UUID moduleId);

    Page<ModuleModel> findAllByCourse(Specification<ModuleModel> spec, Pageable pageable);
}
