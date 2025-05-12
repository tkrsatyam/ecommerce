package com.project.ecommerce.service;

import com.project.ecommerce.bean.UserBean;
import com.project.ecommerce.model.User;
import com.project.ecommerce.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserBean signUp(UserBean userBean) {
        User user = new User();
        BeanUtils.copyProperties(userBean, user);
        user = this.userRepository.save(user);
        UserBean saved = new UserBean();
        BeanUtils.copyProperties(user, saved);
        return saved;
    }

    public UserBean login(String email, String password) {
        User user = this.userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new RuntimeException("Invalid email or password");
        }
        UserBean found = new UserBean();
        BeanUtils.copyProperties(user, found);
        return found;
    }
}
