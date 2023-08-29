package com.qaisarabbas.springsecurity.models.response;

/*
 * @created 27/08/2023 - 2:42 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.models.response
 * @author Qaisar Abbas
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

    public String code = "200";
    public String message = "success";
    public Object data;

    public ApiResponse(String status, String message, Object data){
        this.code = status;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(Object data){
        this.data = data;
    }

}
