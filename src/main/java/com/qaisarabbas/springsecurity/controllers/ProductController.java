package com.qaisarabbas.springsecurity.controllers;

/*
 * @created 27/08/2023 - 2:16 pm
 * @project springsecurity
 * @package com.qaisarabbas.springsecurity.controllers
 * @author Qaisar Abbas
 */

import com.qaisarabbas.springsecurity.models.requests.RegisterRequest;
import com.qaisarabbas.springsecurity.models.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping
    public ApiResponse getProduct(){
        return new ApiResponse("This is Test!");
    }
}
