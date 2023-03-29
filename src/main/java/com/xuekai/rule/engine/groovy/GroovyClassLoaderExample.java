package com.xuekai.rule.engine.groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;

/**
 * 注意实用classloader方式，需要格外注意，每次读取groovyclass就会生成一个文件cache，且不会清除，容易引发oom
 */
public class GroovyClassLoaderExample {

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        GroovyClassLoaderExample test = new GroovyClassLoaderExample();
        ClassLoader parent = test.getClass().getClassLoader();
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(parent);
        Class groovyClass = groovyClassLoader.parseClass(new File("src/main/java/com/xuekai/groovyscript/test.groovy"));

        GroovyObject groovyObject= (GroovyObject)groovyClass.newInstance();

        String result = (String) groovyObject.invokeMethod("test","asd");

        System.out.println(result);
    }
}
