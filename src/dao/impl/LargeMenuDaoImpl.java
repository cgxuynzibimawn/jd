package dao.impl;

import dao.LargeMenuDao;
import entity.LargeMenu;
import util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargeMenuDaoImpl extends BaseDao implements LargeMenuDao {
    @Override
    public Map<String, List<LargeMenu>> getAllLargeMenu() {
        String sql = "SELECT * FROM LargeMenu WHERE LEVEL=? ORDER BY LEVEL";
        Map<String, List<LargeMenu>> maps = new HashMap<String,List<LargeMenu>>();
        for(int i = 1;i<=getMaxLargeMenuLevel();i++) {
            List<LargeMenu> list = new ArrayList<LargeMenu>();
            ResultSet rs = super.executeQuery(sql,i);
            try {
                while(rs.next()){
                    LargeMenu lm = new LargeMenu();
                    lm.setId(rs.getInt("ID"));
                    lm.setName(rs.getString("NAME"));
                    lm.setLevel(rs.getInt("LEVEL"));
                    list.add(lm);
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
            if(list.size()>0) maps.put("level"+i,list);
        }
        return maps;
    }

    public int getMaxLargeMenuLevel(){
        String sql = "SELECT MAX(LEVEL) AS LEVEL FROM LargeMenu";
        int max = 0;
        ResultSet rs = super.executeQuery(sql);
        try {
            if(rs.next()){
                max = rs.getInt("LEVEL");
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
        return max;
    }
}
