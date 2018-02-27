package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class AreaDaoTest {
    @Autowired
    AreaDao areaDao;
    @Test
    @Ignore
    public void queryArea() throws Exception {
        List<Area> areas= areaDao.queryArea();
        assertEquals(2, areas.size());
    }

    @Test
    @Ignore
    public void queryAreaById() throws Exception {
        Area area = areaDao.queryAreaById(1);
        assertEquals("北苑",area.getAreaName());
    }

    @Test
    public void insertArea() throws Exception {
        Area area = new Area();
        area.setAreaName("东苑");
        area.setPriority(3);
        int effectNum = areaDao.insertArea(area);
        assertEquals(1, effectNum);
    }

    @Test
    @Ignore
    public void updateArea() throws Exception {
        Area area = new Area();
        area.setAreaName("北京");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        int effectNum = areaDao.updateArea(area);
        assertEquals(1,effectNum);
    }

    @Test
    public void deleteArea() throws Exception {
        int effectNum = areaDao.deleteArea(3);
        assertEquals(1, effectNum);
    }

}