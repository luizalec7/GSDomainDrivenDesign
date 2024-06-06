package com.oceanguardians.bo;

import com.oceanguardians.dao.UserDao;
import com.oceanguardians.exceptions.AppException;
import com.oceanguardians.model.User;

import java.util.List;

public class UserBO {

    private UserDao userDao;

    public UserBO() {
        userDao = new UserDao();
    }

    public void createUser(User user) throws AppException {
        userDao.insertUser(user);
    }

    public List<User> getAllUsers() throws AppException {
        return userDao.selectAllUsers();
    }

    // Outros métodos BO conforme necessário...
}