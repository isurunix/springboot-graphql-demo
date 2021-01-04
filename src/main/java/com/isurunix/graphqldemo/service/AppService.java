package com.isurunix.graphqldemo.service;

import com.isurunix.graphqldemo.domain.App;
import com.isurunix.graphqldemo.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AppService {
    List<App> findAllApps();
    App findAppById(Integer appId);
    App updateApp(App app) throws ResourceNotFoundException;
    boolean deleteApp(Integer appId);
    App createApp(App app);
}
