package com.nexwise.dao.database1;

import com.nexwise.entity.Score;
import com.nexwise.entity.ScoreExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreMapper {
    long countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectById(@Param("id") Integer id);

    List<Score> selectByExample(ScoreExample example);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);
}