package com.karolgruszczynski.assigment.spring.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BasicOutput {
    private final int code;
    private final String serviceName;
    private final String message;


}
