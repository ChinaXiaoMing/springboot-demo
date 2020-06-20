package com.opencode.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ${className} implements Serializable {
    private Long id;

    private String username;

    private String name;

    private String password;

    private Boolean sex;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String remark;

    private static final long serialVersionUID = 1L;

}