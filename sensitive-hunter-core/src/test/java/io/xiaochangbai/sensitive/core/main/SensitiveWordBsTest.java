package io.xiaochangbai.sensitive.core.main;


import io.xiaochangbai.sensitive.core.config.SensitiveWordConfig;
import io.xiaochangbai.sensitive.core.support.deny.FileWordDeny;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class SensitiveWordBsTest {


    @Test
    public void simple() {
        //构建api对象
        SensitiveWordDispatcher sensitiveWordBs = SensitiveWordDispatcher
                .newInstance(SensitiveWordConfig.defaultConfig());
        //判断是否包含敏感词
        Assert.assertTrue(sensitiveWordBs.contains("好好学习，天天向上"));
        sensitiveWordBs.replace("高考加油噢！",'*');
    }

    @Test
    public void custom() {
        SensitiveWordConfig sensitiveWordConfig = new SensitiveWordConfig();
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/aa.txt");
        sensitiveWordConfig.addWordDenys(new FileWordDeny(resourceAsStream));
        SensitiveWordDispatcher sensitiveWordBs=SensitiveWordDispatcher.newInstance(sensitiveWordConfig);
        boolean contains = sensitiveWordBs.contains("明星");
        Assert.assertTrue(contains);
    }
}