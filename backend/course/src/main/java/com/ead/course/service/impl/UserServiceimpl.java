package com.ead.course.service.impl;

    import com.ead.course.repositories.UserRepositoy;
import com.ead.course.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

    final
    UserRepositoy userRepositoy;

    public UserServiceimpl(UserRepositoy userRepositoy) {
        this.userRepositoy = userRepositoy;
    }

}
