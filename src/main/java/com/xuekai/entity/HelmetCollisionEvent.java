package com.xuekai.entity;

import lombok.Data;

@Data
public class HelmetCollisionEvent {

    private Long userId;

    private String sn;

    private Integer eventType;

    private String event;

    private ContentModel content;

}
