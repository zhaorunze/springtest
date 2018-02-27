package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;

import java.util.List;

public interface AreaDao {
    List<Area> queryArea();
    Area queryAreaById(int area_Id);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
    List<Area> queryAreaByName(String area_name);
    List<Area> queryAreaByPage(int areaid, int page_size);
}
