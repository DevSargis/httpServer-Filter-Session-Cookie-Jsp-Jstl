package com.onlinsestore.servletsonlinestore.Dao;

import com.onlinsestore.servletsonlinestore.Entity.User;
import com.onlinsestore.servletsonlinestore.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Long, User> {

    private static final UserDao INSTANCE  = new UserDao();

    private UserDao(){

    }

    private static final String FIND_ALL = """
            SELECT * FROM users
            """;

    @Override
    public List<User> findAll() {
        try (var connection = ConnectionManager.get()) {
            var preparedStatment = connection.prepareStatement(FIND_ALL);
            var resultSet = preparedStatment.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()){
                users.add(castResultSetToUser(resultSet));
            }
            return users;

        }catch (SQLException ex){
            throw new RuntimeException();
        }
    }
    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }
    @Override
    public User save(User entity) {
        return null;
    }
    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }
    public static UserDao getInstance(){
            return INSTANCE;
    }

    private User castResultSetToUser(ResultSet resultSet){
        try {
            return User.builder()
                    .userName(resultSet.getString("username"))
                    .id(resultSet.getLong("user_id"))
                    .email(resultSet.getString("email"))
                    .password(resultSet.getString("password"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
