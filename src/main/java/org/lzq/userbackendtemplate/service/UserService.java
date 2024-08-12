package org.lzq.userbackendtemplate.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.lzq.userbackendtemplate.model.domain.User;
import org.lzq.userbackendtemplate.model.request.UserLoginRequest;
import org.lzq.userbackendtemplate.model.request.UserRegisterRequest;
import org.lzq.userbackendtemplate.model.request.UserUpdateRequest;
import org.lzq.userbackendtemplate.model.response.UserLoginResponse;

/**
* @author liangzhiquan
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2024-08-12 20:42:48
*/
public interface UserService extends IService<User> {
    void userRegister(UserRegisterRequest userRegisterRequest);

    UserLoginResponse userLogin(UserLoginRequest requestParam);

    void updateUser(UserUpdateRequest requestParam);

    Boolean checkLogin(String userName, String token);

    void logout(String userName, String token);
}
