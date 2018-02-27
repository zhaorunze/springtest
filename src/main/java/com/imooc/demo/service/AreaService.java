package com.imooc.demo.service;

import com.imooc.demo.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> getAreaList();
    Area getAreaById(int areaId);
    List<Area> getAreaByName(String areaName);
    boolean addArea(Area area);
    boolean modifyArea(Area area);
    boolean deleteArea(int areaId);
}
