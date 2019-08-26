package com.nexwise.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.nexwise.common.JsonResult;
import com.nexwise.dao.database2.LbsDeviceMapper;
import com.nexwise.entity.LbsDevice;
import com.nexwise.entity.LbsDeviceExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeviceServiceImpl {

    @Autowired
    LbsDeviceMapper lbsDeviceMapper;

    /**
     * 分页查询设备信息
     * @param page
     * @param pageSize
     * @return
     * @throws JsonProcessingException
     */
    @Cacheable(value = "deviceCache")
    public String findDeviceByPage(int page, int pageSize) throws JsonProcessingException {
        LbsDeviceExample lbsDeviceExample = new LbsDeviceExample();
        List<LbsDevice> list = lbsDeviceMapper.selectByExampleWithRowbounds(lbsDeviceExample, new RowBounds((page - 1) * pageSize, pageSize));
        long total = lbsDeviceMapper.countByExample(lbsDeviceExample);
        return JsonResult.getPageData(list, total);
    }

    /**
     * 根据ID查询设备
     * @param id
     * @return
     */
    @Cacheable(value = "deviceListCache", key = "#id")
    public LbsDevice getDeviceById(Long id) {
        return lbsDeviceMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加设备
     * @param lbsDevice
     * @return
     */
    @CacheEvict(value = "deviceListCache", allEntries = true)
    public int addDevice(LbsDevice lbsDevice) {
        lbsDevice.setCreationtime(new Date());
        return lbsDeviceMapper.insert(lbsDevice);
    }

    /**
     * 更新设备
     * @param lbsDevice
     * @return
     */
    @CachePut(value = "deviceCache", key = "#lbsDevice.getId()")
    public int updateDevice(LbsDevice lbsDevice) {
        LbsDevice updateDevice = lbsDeviceMapper.selectByPrimaryKey(lbsDevice.getId());
        updateDevice.setUpdatetime(new Date());
        return lbsDeviceMapper.updateByPrimaryKey(updateDevice);
    }

    /**
     * 批量删除设备
     * @param id
     * @return
     */
    @Caching(evict = {@CacheEvict(value = "deviceListCache", allEntries = true), @CacheEvict(value = "deviceCache", allEntries = true)})
    public int batchDeleteDevice(List<Long> id) {
        LbsDeviceExample lbsDeviceExample = new LbsDeviceExample();
        lbsDeviceExample.createCriteria().andIdIn(id);
        return lbsDeviceMapper.deleteByExample(lbsDeviceExample);
    }

}
