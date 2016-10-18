package dao.impl;

import dao.BannerDao;
import entity.Banner;
import util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BannerDaoImpl extends BaseDao implements BannerDao {
    @Override
    public List<Banner> getAllBanner() {
        String sql = "SELECT * FROM Banner WHERE ISSHOW=1";
        ResultSet rs = super.executeQuery(sql);
        List<Banner> list = new ArrayList<Banner>();
        try {
            while (rs.next()){
                Banner b = new Banner();
                b.setId(rs.getInt("ID"));
                b.setName(rs.getString("NAME"));
                b.setShow(rs.getBoolean("ISSHOW"));
                b.setUrl(rs.getString("URL"));
                list.add(b);
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
