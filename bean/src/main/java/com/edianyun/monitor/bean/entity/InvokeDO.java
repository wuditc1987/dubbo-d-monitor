package com.edianyun.monitor.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvokeDO implements Serializable {
    private Long id;

    private String application;

    private String appType;

    private String service;

    private String method;

    private String consumerHost;

    private String consumerPort;

    private String providerHost;

    private String providerPort;

    private Integer success;

    private Integer failure;

    private Integer elapsed;

    private Integer concurrent;

    private Integer maxElapsed;

    private Integer maxConcurrent;

    private String invokeDate;

    private String invokeHour;

    private Long invokeTime;

    private Date createTime;

    private Date updateTime;
}