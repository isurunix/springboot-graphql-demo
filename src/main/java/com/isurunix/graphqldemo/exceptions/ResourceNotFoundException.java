package com.isurunix.graphqldemo.exceptions;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class ResourceNotFoundException extends RuntimeException implements GraphQLError {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
