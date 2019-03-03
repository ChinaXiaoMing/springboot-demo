package com.nexwise.dao.database2;

import com.nexwise.entity.LbsDevice;
import com.nexwise.entity.LbsDeviceExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface LbsDeviceMapper {
    long countByExample(LbsDeviceExample example);

    int deleteByExample(LbsDeviceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LbsDevice record);

    int insertSelective(LbsDevice record);

    List<LbsDevice> selectByExampleWithRowbounds(LbsDeviceExample example, RowBounds rowBounds);

    List<LbsDevice> selectByExample(LbsDeviceExample example);

    LbsDevice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LbsDevice record, @Param("example") LbsDeviceExample example);

    int updateByExample(@Param("record") LbsDevice record, @Param("example") LbsDeviceExample example);

    int updateByPrimaryKeySelective(LbsDevice record);

    int updateByPrimaryKey(LbsDevice record);
}