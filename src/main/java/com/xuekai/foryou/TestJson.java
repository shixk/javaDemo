package com.xuekai.foryou;

import com.xuekai.entity.AudioModel;
import com.xuekai.entity.ContentModel;
import com.xuekai.entity.HelmetCollisionEvent;
import com.xuekai.entity.VideoModel;
import com.xuekai.utils.JsonTool;

public class TestJson {


    public static void main(String[] args) {

        AudioModel audioModel = new AudioModel();
        audioModel.setS3Key("AASDFGHJ");
        audioModel.setAudioDuration(1456789l);
        audioModel.setAudioStartTime(1456789l);
        audioModel.setAudioEndTime(1456789l);


        VideoModel video = new VideoModel();
        video.setS3Key("SDUIOJHG");
        video.setFrontVideoStartTime(1456789l);
        video.setFrontVideoEndTime(1456789l);
        video.setFrontVideoDuration(1456789l);
        video.setFrontPicTime(1456789l);
        video.setRearVideoStartTime(1456789l);
        video.setRearVideoEndTime(1456789l);
        video.setRearVideoDuration(1456789l);
        video.setRearPicTime(1456789l);

        ContentModel content = new ContentModel();

        content.setAudio(audioModel);
        content.setMeidia(video);


        HelmetCollisionEvent helmetCollisionEvent = new HelmetCollisionEvent();

        helmetCollisionEvent.setEvent("HelmetCollision");
        helmetCollisionEvent.setEventType(1);
        helmetCollisionEvent.setSn("1234efa");
        helmetCollisionEvent.setUserId(3345346l);
        helmetCollisionEvent.setContent(content);


        String str = JsonTool.writeToString(helmetCollisionEvent);

        System.out.println(str);

    }
}
