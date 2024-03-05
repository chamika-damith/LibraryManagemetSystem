package org.example.bo.custom.impl;

import org.example.bo.custom.UserBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.UserDAO;
import org.example.dto.BookDto;
import org.example.dto.UserDto;
import org.example.entity.User;

import java.util.List;

public class UserBOImpl implements UserBO {

    private UserDAO userDAO= (UserDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.USER);
    @Override
    public boolean addUser(UserDto dto) {
        return userDAO.add(new User(dto.getUserId(),dto.getUserName(),dto.getEmail(),dto.getPassword()));
    }

    @Override
    public List<UserDto> getAllUser() {
        return null;
    }

    @Override
    public boolean updateUser(UserDto dto) {
        return userDAO.update(new User(dto.getUserId(),dto.getUserName(),dto.getEmail(),dto.getPassword()));
    }

    @Override
    public boolean isExistUser(String id) {
        return false;
    }

    @Override
    public BookDto searchUser(String id) {
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }
}
