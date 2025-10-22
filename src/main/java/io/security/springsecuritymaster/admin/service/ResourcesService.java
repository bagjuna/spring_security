package io.security.springsecuritymaster.admin.service;

import java.util.List;

import io.security.springsecuritymaster.domain.entity.Resources;

public interface ResourcesService {
    Resources getResources(long id);
    List<Resources> getResources();

    void createResources(Resources Resources);

    void deleteResources(long id);
}
