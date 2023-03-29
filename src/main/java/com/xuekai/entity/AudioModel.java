package com.xuekai.entity;

import lombok.Data;

@Data
public class AudioModel {

    private String s3Key;

    private Long audioStartTime;

    private Long audioEndTime;

    private Long audioDuration;

}
