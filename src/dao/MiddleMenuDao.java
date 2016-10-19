package dao;

import entity.MiddleMenu;

import java.util.List;

public interface MiddleMenuDao {
    List<MiddleMenu> getByLevelId( Integer levelId);
}
