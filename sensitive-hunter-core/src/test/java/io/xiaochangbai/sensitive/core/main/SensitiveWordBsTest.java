package io.xiaochangbai.sensitive.core.main;


import io.xiaochangbai.sensitive.core.config.SensitiveWordConfig;
import io.xiaochangbai.sensitive.core.support.deny.FileWordDeny;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class SensitiveWordBsTest {


    @Test
    public void simple() {
        SensitiveWordDispatcher sensitiveWordBs = SensitiveWordDispatcher
                .newInstance(SensitiveWordConfig.defaultConfig());
        //共152404个词
        boolean contains = sensitiveWordBs.contains("黄色的");
        Assert.assertTrue(contains);
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