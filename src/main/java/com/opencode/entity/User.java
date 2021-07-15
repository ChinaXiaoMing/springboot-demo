package com.opencode.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String name;

    private String password;

    private Boolean sex;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String remark;

}