package com.nexwise.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nexwise.common.JsonResult;
import com.nexwise.dao.database2.LbsDeviceMapper;
import com.nexwise.entity.LbsDevice;
import com.nexwise.entity.LbsDeviceExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl {

    @Autowired
    LbsDeviceMapper lbsDeviceMapper;

    public String findDeviceByPage(int page, int pageSize) throws JsonProcessingException {
        LbsDeviceExample lbsDeviceExample = new LbsDeviceExample();
        List<LbsDevice> list = lbsDeviceMapper.selectByExampleWithRowbounds(lbsDeviceExample, new RowBounds((page - 1) * pageSize, pageSize));
        long total = lbsDeviceMapper.countByExample(lbsDeviceExample);
        return JsonResult.getPageData(list, total);
    }

}
