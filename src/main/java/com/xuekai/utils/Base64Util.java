package com.xuekai.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @Author shixuekai
 * @CreateDate 2019/1/3
 * @Description
 **/
public class Base64Util {


    public static String encode(byte[] bytes){
        return new BASE64Encoder().encode(bytes);
    }

    public static byte[] decode(String encodeStr) throws IOException {
        return new BASE64Decoder().decodeBuffer(encodeStr);
    }

    public static void main(String[] args) throws Exception{

        String str = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC7pd9wLYZn3SQR\n" +
                "J/3Kc+njw1vs888dURfnkow9c76jcGgKCSTD2SEJPbHf3QB4tOzYUWTOxqL21StX\n" +
                "XSlrunNs2rZODgTyAwIDQBWs2a+6TgHfHwnwD7luIymNhfsPt+KklkVRceRgSrMc\n" +
                "gkT86QbPbhsvAH6Hz1JZww+v4bo2tvhB/f10K3tgZV6Mp8VGz3Ig0NQCcVvtfnrD\n" +
                "8zaXOWsENMfYroGgOGwtv9LnEyXzW2sdfCUTWsmZbubnRspZTy3rCC8Ox71GeahA\n" +
                "w06UST8YPhpE4fVbtuD+C56Au6bdh4KNItiJwK0zRRAfHBfRLcWjWFLNe09xdggR\n" +
                "29jb7fvNAgMBAAECggEBAI21EivQ9XNyWU5reQlux+6tFbq31G07VGYZEbdGtW0P\n" +
                "8kHB7fXI/13PLYj1iOmfGE20CgDtmRv2l6h+Pk2QnKJT+OCxTaLGCrsRpkzGiCKV\n" +
                "zmwFMKgN9+bovvSVfae9IndQ1EBRVjoxr1mUNy0XfYEgkX7JTMSbGIGZATu9p7aw\n" +
                "4Z1E1B9x7J0lY/K78V30DNX18lOnX37wfrDlBoW2JntwqTbBXcmjeMFjtn3BQ729\n" +
                "NPu7vQtQRmBA8MLrCd7hfZJVIFHvCl5WbS4MOoQAL1oaT9T9JILhiNyOOUJ+YzUQ\n" +
                "y/8kHYANdhAc2xZePDJMtO89rNqD/u3FnWXmfLboVDECgYEA86fqa/jQef16fLNL\n" +
                "HZgwgNSTIkPhnfPTTAYI6jUbRqaF+6lIwpM1Zj7lD5sTNA004eHEBAqXA56R6FwA\n" +
                "gBw/6m4YzblNT+MXTYvN/bVm8AWRy2gX9sRsh62pdUsbRyrtMoarmDq+mVDhZKRT\n" +
                "GKJPZUBvFfk72GZ9uGl/V9Cv90MCgYEAxSeQbTCXVngn7vIBKZDB75yLxxahhPY2\n" +
                "pZmVrazY6V6zeF9C4WbXmkxPT7wEkmChtiWZAca2+mKwtkYbtJjS8wZTJ8dRr8vy\n" +
                "y5HMXfdjUNHc26RsgiOkaipr8CRkscdQTFe8hMrYK0bd2YT1OB6p3mPZbgeI2IFb\n" +
                "RticjCW4Z68CgYEA622oGMPFzNmbbLphLitLUnAT6tvkOJbL5309R/AgdteYRl5/\n" +
                "q2JKCo1jDv0sRPMt0cQvfigtWpXxLa8X3LFvILlYxg7yIOqwLYGUfDy3Rdxbz0q5\n" +
                "PPr2UvL99hOoO8/CeTueueypFcMMxg3xLLBIPvFPZM/5f1MozvNA1D0UibkCgYA3\n" +
                "ZEdKtkU+0SF/G9VBxV8HoDcRZ4VX4wk1e7I3CoIjBy1rW3Bh/dADlP8PiubJ7YZh\n" +
                "s6yKeDc+n+3AOHBeTDWwfA1u9qw3tRhxI3SEzhXERkJEH60w3yy5e1O6M69q13Hz\n" +
                "EQ9xS8ByYEXCcH2pF8xoJCuZo1pKYgWwIPnS0mI+FwKBgQC7LWfy1aNq7j8Z/orS\n" +
                "dMdHf6icVpvvgVX9r+VZUrlLNfmcCr4UZX508uZ4nQWluL7Y4Qcv65C0GdLAKGPe\n" +
                "u1JEQ1crx4iR1BVilel4/sEmN/Dtdj5CH8N2CIaO7IAlxj9HDOlTY9F9lmoQx8Ds\n" +
                "OMHXt6s/CJG/T29tE4lsWe5vUQ==";
        byte[] bytes = str.getBytes();
        String encodedStr = encode(bytes);
        System.out.println(encodedStr);

        String temp="TUlJRXZ3SUJBREFOQmdrcWhraUc5dzBCQVFFRkFBU0NCS2t3Z2dTbEFnRUFBb0lCQVFDN3BkOXdM\n" +
                "WVpuM1NRUgpKLzNLYytuancxdnM4ODhkVVJmbmtvdzljNzZqY0dnS0NTVEQyU0VKUGJIZjNRQjR0";
        System.out.println(temp);
        String as=jiami(temp);
        System.out.println(as);

        String af=jiemi(as);
        System.out.println(af);

        //byte[] decodedBytes = decode(af);
        //System.out.println(new String(decodedBytes));
    }

    private static int count=9;
    private static String jiami(String str){
        String result=str;
        for(int i=1;i<=count;i++){
            result=result.substring(0,i*10)+"K"+result.substring(i*10,result.length());
        }

        return result;
    }


    private static String jiemi(String str){
        String result=str;
        for(int i=1;i<=count;i++){
            result=result.substring(0,i*10)+result.substring(i*10+i,result.length());
        }

        return result;
    }

}
