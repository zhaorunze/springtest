package com.imooc.demo.web;

import com.imooc.demo.Constants.Constant;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import com.imooc.demo.utils.DataEncapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.nio.cs.ext.MacHebrew;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    private Map<String, Object> listArea() {
        Map<String, Object> modeMap = DataEncapUtil.getModeMap();
        List<Area> list = areaService.getAreaList();
        modeMap.put("areaList", list);
        return DataEncapUtil.encap(modeMap);
    }


    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(@RequestParam("areaid") Integer areaId) {
        Map<String, Object> areaMap = DataEncapUtil.getModeMap();
        Area area = areaService.getAreaById(areaId);
        areaMap.put("area", area);
        return DataEncapUtil.encap(areaMap);
    }
    @RequestMapping(value = "/getareabyname", method = RequestMethod.GET)
    private Map<String, Object> getAreaByName(@RequestParam("areaname") String areaName) {
        Map<String, Object> areaMap = DataEncapUtil.getModeMap();
        List<Area> areaes = areaService.getAreaByName(areaName);
        areaMap.put("area", areaes);
        return DataEncapUtil.encap(areaMap);
    }
    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    private Map<String, Object> addArea(@RequestBody Area area) {
        areaService.addArea(area);
        return DataEncapUtil.encap(null);
    }

    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    private Map<String, Object> modifyarea(@RequestBody Area area) {
        areaService.modifyArea(area);
        return DataEncapUtil.encap(null);
    }

    @RequestMapping(value = "/removearea", method = RequestMethod.GET)
    private Map<String, Object> removearea(@RequestParam("areaid") Integer areaid) {
        areaService.deleteArea(areaid);
        return DataEncapUtil.encap(null);
    }
}
