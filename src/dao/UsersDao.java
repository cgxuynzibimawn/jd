package dao;

import entity.Users;

public interface UsersDao {
    Users login(String username, String password);
}
