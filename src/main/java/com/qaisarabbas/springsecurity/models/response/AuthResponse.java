package com.qaisarabbas.springsecurity.models.response;

/*
 * @created 27/08/2023 - 8:48 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.models.response
 * @author Qaisar Abbas
 */

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String token;
}
