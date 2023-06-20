package com.onlinsestore.servletsonlinestore.Services;

import com.onlinsestore.servletsonlinestore.Dao.UserDao;
import com.onlinsestore.servletsonlinestore.Entity.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsersService {
        private UserDao userDao = UserDao.getInstance();
        private static final UsersService INSTANCE = new UsersService();

        private UsersService(){

        }
        public List<User> findAllUsers(){
            return  userDao.findAll();
        }

        public static UsersService getInstance(){
            return INSTANCE;
        }
        
        
        public Optional<User> login(String email, String password){
            List<User> users = findAllUsers();
            return users.stream().filter(user -> email.equals(user.getEmail()) && password.equals(user.getPassword()))
                    .map(user -> User.builder().userName(user.getUserName()).password(user.getPassword()).email(user.getEmail()).build()).findFirst();
        }

}
