package dao;

import entity.LargeMenu;

import java.util.List;
import java.util.Map;

public interface LargeMenuDao {
    Map<String, List<LargeMenu>> getAllLargeMenu();
}
