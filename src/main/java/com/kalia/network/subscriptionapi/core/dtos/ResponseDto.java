package com.kalia.network.subscriptionapi.core.dtos;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private boolean IsSuccess = true;
    private Object Result;
    private String DisplayMessage;
    private String ErrorMessage;
}
