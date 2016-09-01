package com.hellpring.service;

import com.hellpring.dao.UserDAO;
import com.hellpring.model.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final static Logger LOGGER = LogManager.getLogger(UserService.class);

    @Autowired
    private UserDAO userDAO;

    private UserModel getByEmail(String email) {
        return userDAO.selectByEmail(email);
    }

    public int register(UserModel userModel) {
        if (getByEmail(userModel.getEmail()) != null) {
            throw new DuplicateKeyException("already exists email:" + userModel.getEmail());
        }

        return userDAO.insert(userModel);
    }

    public UserModel login(String email, String password) {
        UserModel user = getByEmail(email);
        if (user == null) {
            return null;
        }

        LOGGER.debug("user={}", user.toString());

        return user.getPassword().equals(password) ? user : null;
    }
}
