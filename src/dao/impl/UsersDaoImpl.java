package dao.impl;

import dao.UsersDao;
import entity.Users;
import util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by guoyisha on 2016/10/16.
 */
public class UsersDaoImpl extends BaseDao implements UsersDao {
    @Override
    public Users login(String username, String password) {
        String sql = "SELECT * FROM Users WHERE USERNAME=? AND PASSWORD=?";
        ResultSet rs = super.executeQuery(sql,username,password);
        Users u = null;
        try {
            if(rs.next()){
                u = new Users();
                u.setId(rs.getInt("ID"));
                u.setUsername(rs.getString("USERNAME"));
                u.setPassword(rs.getString("PASSWORD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                super.closeAll(rs.getStatement().getConnection(),rs.getStatement(),rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return u;
    }
}
