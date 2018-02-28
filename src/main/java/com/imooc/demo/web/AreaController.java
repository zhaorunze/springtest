package com.imooc.demo.web;

import com.imooc.demo.Constants.AreaConfig;
import com.imooc.demo.Constants.Constant;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import com.imooc.demo.utils.DataEncapUtil;
import com.mchange.v2.log.MLog;
import com.mchange.v2.log.MLogger;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.Log_$logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public static final Logger LOG = LoggerFactory.getLogger(AreaController.class);
    @RequestMapping(value = AreaConfig.AREA_LIST, method = RequestMethod.GET)
    private Map<String, Object> listArea() {
        Map<String, Object> modeMap = DataEncapUtil.getModeMap();
        List<Area> list = areaService.getAreaList();
        modeMap.put("areaList", list);
        return DataEncapUtil.encap(modeMap);
    }

    @RequestMapping(value = AreaConfig.AREA_LIST_PAGE, method = RequestMethod.GET)
    private Map<String, Object> listAreaPage(@RequestParam(value = "areaid", defaultValue = "0") Integer areaid, @RequestParam(value = "limit", defaultValue = Constant.PAGE_SIZE) Integer limit){
        Map<String, Object> modeMap = DataEncapUtil.getModeMap();
        LOG.info("areaid="+ areaid+", limit=" + limit);
        List<Area> list = areaService.getAreaListPage(areaid, limit);
        modeMap.put("areaList", list);
        return DataEncapUtil.encap(modeMap);
    }

    @RequestMapping(value = AreaConfig.AREA_GET_BY_ID, method = RequestMethod.GET)
    private Map<String, Object> getAreaById(@RequestParam("areaid") Integer areaId) {
        Map<String, Object> areaMap = DataEncapUtil.getModeMap();
        Area area = areaService.getAreaById(areaId);
        areaMap.put("area", area);
        return DataEncapUtil.encap(areaMap);
    }
    @RequestMapping(value = AreaConfig.AREA_GET_BY_NAME, method = RequestMethod.GET)
    private Map<String, Object> getAreaByName(@RequestParam("areaname") String areaName) {
        Map<String, Object> areaMap = DataEncapUtil.getModeMap();
        Area area = areaService.getAreaByName(areaName);
        areaMap.put("area", area);
        return DataEncapUtil.encap(areaMap);
    }
    @RequestMapping(value = AreaConfig.AREA_ADD, method = RequestMethod.POST)
    private Map<String, Object> addArea(@RequestBody Area area) {
        areaService.addArea(area);
        return DataEncapUtil.encap(null);
    }

    @RequestMapping(value = AreaConfig.AREA_MODIFY, method = RequestMethod.POST)
    private Map<String, Object> modifyarea(@RequestBody Area area) {
        areaService.modifyArea(area);
        return DataEncapUtil.encap(null);
    }

    @RequestMapping(value = AreaConfig.AREA_REMOVE, method = RequestMethod.GET)
    private Map<String, Object> removearea(@RequestParam("areaid") Integer areaid) {
        areaService.deleteArea(areaid);
        return DataEncapUtil.encap(null);
    }
}
