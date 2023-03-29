package com.xuekai.entity;

import lombok.Data;

@Data
public class VideoModel {

    private String s3Key;

    private Long frontVideoStartTime;
    private Long frontVideoEndTime;
    private Long frontVideoDuration;
    private Long frontPicTime;
    private Long rearVideoStartTime;
    private Long rearVideoEndTime;
    private Long rearVideoDuration;
    private Long rearPicTime;

}
