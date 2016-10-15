package dao.impl;

import dao.ProvinceDao;
import entity.Province;
import util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDaoImpl extends BaseDao implements ProvinceDao {
    @Override
    public List<Province> getAll() {
        String sql = "SELECT * FROM Province";
        ResultSet rs = super.executeQuery(sql);
        List<Province> list = new ArrayList<Province>();
        try {
            while (rs.next()){
                Province p = new Province();
                p.setId(rs.getInt("ID"));
                p.setName(rs.getString("NAME"));
                list.add(p);
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
        return list;
    }
}
