package com.xuekai.foryou;

import lombok.Getter;

public class CacheFactory {

    public class Constant{
        public static final int LFUFLAG=1;
        public static final int LRUFLAG=2;
    }

    @Getter
    public enum CacheFlagEnum{
        LFUEN(1,"lfucache"),
        LRUEN(2,"lrucache");

        int code;
        String des;

        CacheFlagEnum(int code,String des){
            this.code=code;
            this.des=des;
        }
    }

    public CacheFather getOneCache(int flag){

        CacheFather cache;
        switch (flag){
            case Constant.LFUFLAG:
                cache = new LfuCache();
                break;
            case Constant.LRUFLAG:
                cache = new LruCache();
                break;
            default:
                cache = new LruCache();
                break;
        }

        return cache;
    }

}
