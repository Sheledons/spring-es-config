package com.kingsoft.servicea.controller;

import com.kingsoft.servicea.config.api.Api;
import com.kingsoft.servicea.controller.entity.CustomResponse;
import com.kingsoft.servicea.entity.User;
import com.kingsoft.servicea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author Sheledon
 * @date 2022/4/11
 */
@RestController
@RequestMapping(Api.UserApi.BASE_URL)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(Api.UserApi.LOGIN)
    public CustomResponse login(@RequestBody User user, HttpServletRequest request){
        User result = userService.loginVerify(user);
        if (!Objects.isNull(result)){
            HttpSession session = request.getSession();
            session.setAttribute("user",result);
            return CustomResponse.builder().code(200).build();
        }
        return CustomResponse.builder().code(4040).build();
    }
}
