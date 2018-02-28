package com.imooc.demo.service;

import com.imooc.demo.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> getAreaList();
    List<Area> getAreaListPage(int area_id, int limit);
    Area getAreaById(int areaId);
    Area getAreaByName(String areaName);
    boolean addArea(Area area);
    boolean modifyArea(Area area);
    boolean deleteArea(int areaId);
}
