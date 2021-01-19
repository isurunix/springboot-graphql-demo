package com.isurunix.graphqldemo.service;

import com.isurunix.graphqldemo.domain.App;
import com.isurunix.graphqldemo.exceptions.ResourceNotFoundException;

import java.util.List;


public interface AppService {
    /**
     * Returns the list of all available applications
     * This will return an empty list if no applications are available
     * @return  list of applications
     */
    List<App> findAllApps();

    /**
     * Returns the App with the given appId.
     * @param  appId the ID of the app
     * @return  Application with the given appId
     */
    App findAppById(Integer appId);

    /**
     * Modify the details of an existing application
     * Method will always return the updated application after a successful operation
     * @param app the application being modified
     * @return  the application with updated details
     */
    App updateApp(App app);

    /**
     * Deletes the application with the given application Id
     * @param appId the Id of the application to delete
     * @return true if application was deleted successfully
     */
    boolean deleteApp(Integer appId);

    /**
     * Creates a new application
     * @param app the new application to be created
     * @return the created application
     */
    App createApp(App app);
}
