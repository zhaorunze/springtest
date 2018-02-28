package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AreaDao {
    List<Area> queryArea();
    List<Area> queryAreaByPage(@Param("areaid") int areaid, @Param("page_size")int page_size);
    Area queryAreaById(int area_Id);
    Area queryAreaByName(String area_name);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
}
