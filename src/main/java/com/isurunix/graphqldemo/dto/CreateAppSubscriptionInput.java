package com.isurunix.graphqldemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateAppSubscriptionInput {
    private String customerCode;
    private Integer appId;
}
