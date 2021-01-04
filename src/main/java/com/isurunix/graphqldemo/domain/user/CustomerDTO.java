package com.isurunix.graphqldemo.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties
public class CustomerDTO {
    private String customerCode;
    private String contactNo;
    private String address;
    private long userId;
}
