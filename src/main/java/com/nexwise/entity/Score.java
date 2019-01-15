package com.nexwise.entity;

import java.math.BigDecimal;

public class Score {

    public Score() {

    }

    public Score(Integer id, BigDecimal score) {
        this.id = id;
        this.score = score;
    }

    private Integer id;

    private BigDecimal score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }
}