package com.auth_service.Dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class LoginResponse {

    private final String token;

}
