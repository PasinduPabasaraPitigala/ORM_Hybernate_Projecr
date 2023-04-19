package lk.ijse.gdse.service.custom.impl;

import lk.ijse.gdse.dao.DaoFactory;
import lk.ijse.gdse.dao.custom.UserDao;
import lk.ijse.gdse.dto.UserDto;
import lk.ijse.gdse.entity.User;
import lk.ijse.gdse.service.custom.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao=(UserDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.USERFORM);
    @Override
    public boolean saveUser(UserDto userDto) throws Exception {
        return userDao.save(new User(userDto.getUserId(),userDto.getUserName(),userDto.getTelNumber(),userDto.getEmail(),userDto.getPassword()));
    }

    @Override
    public boolean updateUser(UserDto userDto) throws Exception {
        return userDao.update(new User(userDto.getUserId(),userDto.getUserName(),userDto.getTelNumber(),userDto.getEmail(),userDto.getPassword()));
    }

    @Override
    public boolean deleteUser(String id) throws Exception {
        return userDao.delete(id);
    }

    @Override
    public String generateUserId() throws Exception {
        String id=userDao.genarateId();
        return id;
    }

    @Override
    public List<UserDto> getAllUser() throws IOException {
        List<User>all=userDao.getAll();
        List<UserDto>userDtos=new ArrayList<>();
        for (User user:all){
            userDtos.add(
                new UserDto(user.getUserId(),user.getUserName(),user.getTelNumber(),user.getEmail(),user.getPassword())
            );
        }
        return userDtos;
    }
}
