package com.isurunix.graphqldemo.service.impl;

import com.isurunix.graphqldemo.domain.App;
import com.isurunix.graphqldemo.exceptions.ResourceNotFoundException;
import com.isurunix.graphqldemo.repository.AppRepository;
import com.isurunix.graphqldemo.service.AppService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    private final AppRepository appRepository;

    public AppServiceImpl(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    public List<App> findAllApps() {
        return appRepository.findAll();
    }

    @Override
    public App findAppById(Integer appId) {
        return appRepository.findById(appId.longValue())
                .orElseThrow(() -> new ResourceNotFoundException("No application found for appId: " + appId));
    }

    @Override
    public App updateApp(App app) {
        App currentApp = appRepository.findById(app.getAppId())
                .orElseThrow(() -> new ResourceNotFoundException("No application found for appId: " + app.getAppId()));
        currentApp.setAppName(app.getAppName());
        return appRepository.save(currentApp);
    }

    @Override
    public boolean deleteApp(Integer appId) {
        return false;
    }

    @Override
    public App createApp(App app) {
        return null;
    }
}
