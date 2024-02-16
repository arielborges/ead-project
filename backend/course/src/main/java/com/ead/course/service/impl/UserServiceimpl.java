package com.ead.course.service.impl;

    import com.ead.course.models.UserModel;
    import com.ead.course.repositories.UserRepositoy;
    import com.ead.course.service.UserService;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.jpa.domain.Specification;
    import org.springframework.stereotype.Service;

    import java.util.UUID;

@Service
public class UserServiceimpl implements UserService {

    final
    UserRepositoy userRepositoy;

    public UserServiceimpl(UserRepositoy userRepositoy) {
        this.userRepositoy = userRepositoy;
    }

    @Override
    public Page<UserModel> findAll(Specification<UserModel> spec, Pageable pageable) {
        return userRepositoy.findAll(spec, pageable);
    }

    @Override
    public UserModel save(UserModel userModel) {
        return userRepositoy.save(userModel);
    }

    @Override
    public void delete(UUID userId) {
        userRepositoy.deleteById(userId);
    }
}
