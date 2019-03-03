package com.nexwise.service;

import com.nexwise.dao.database1.ScoreMapper;
import com.nexwise.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ScoreService {

    @Autowired
    ScoreMapper scoreMapper;

    @Transactional
    @CachePut(key = "1000", value = "score")
    public int addScore(Score score) {
        return scoreMapper.insert(score);
    }

    @Transactional
    @Cacheable(key = "1000", value = "score")
    public Score getScore(Integer id) {
        return scoreMapper.selectById(id);
    }

}
