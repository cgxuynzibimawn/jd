package dao;

import entity.SmallMenu;

import java.util.List;

public interface SmallMenuDao {
    List<SmallMenu> getSmallMenu( Integer level, Integer middle);
}
