package dao.impl;

import dao.SmallMenuDao;
import entity.SmallMenu;
import util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SmallMenuDaoImpl extends BaseDao implements SmallMenuDao {
    @Override
    public List<SmallMenu> getSmallMenu(Integer level,Integer middle) {
        String sql = "SELECT * FROM SmallMenu WHERE level_id = ? AND middle_id=?";
        ResultSet rs = executeQuery(sql,level,middle);
        List<SmallMenu> list = new ArrayList<SmallMenu>();
        try {
            while(rs.next()){
                SmallMenu sm = new SmallMenu();
                sm.setId(rs.getInt("ID"));
                sm.setName(rs.getString("NAME"));
                sm.setLevel(rs.getInt("LEVEL_ID"));
                sm.setMiddleid(rs.getInt("MIDDLE_ID"));
                list.add(sm);
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
