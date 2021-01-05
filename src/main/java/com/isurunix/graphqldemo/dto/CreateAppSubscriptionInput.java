package com.isurunix.graphqldemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateAppSubscriptionInput {
    private Integer customerCode;
    private Integer appId;
}
