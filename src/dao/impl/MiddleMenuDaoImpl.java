package dao.impl;

import dao.MiddleMenuDao;
import entity.MiddleMenu;
import util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MiddleMenuDaoImpl extends BaseDao implements MiddleMenuDao {
    @Override
    public List<MiddleMenu> getByLevelId(Integer levelId) {
        String sql = "SELECT * FROM MiddleMenu WHERE LEVEL = ?";
        List<MiddleMenu> list = new ArrayList<MiddleMenu>();
        ResultSet rs = executeQuery(sql, levelId);
        try {
            while (rs.next()){
                MiddleMenu mm = new MiddleMenu();
                mm.setId(rs.getInt("ID"));
                mm.setName(rs.getString("NAME"));
                mm.setLevel(rs.getInt("LEVEL"));
                mm.setLargeid(rs.getInt("LARGE_ID"));
                list.add(mm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                closeAll(rs.getStatement().getConnection(),rs.getStatement(),rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
