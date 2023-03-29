package com.xuekai.rule.engine.groovy;
import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * groovy 相关语法  https://www.w3cschool.cn/groovy/groovy_if_statement.html
 */
public class GroovyShellExample {

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");

        // 变量
        Bindings bind = engine.createBindings();
        bind.put("value",10);

        //groovy 脚本
        String scriptStr = "if (value == null) { println (\"hello xk\")}\n" +
                " if (value <= 0) { println (\"hello meituan\") } \n" +
                " else { println (\"Be happy , you are best\")}";

        // 执行脚本
        Object res = engine.eval(scriptStr, bind);
        System.out.println(res);

    }
}
