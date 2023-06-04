package io.xiaochangbai.sensitive.core.main;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SensitiveWordBsTest {
    SensitiveWordDispatcher sensitiveWordBs;
    @Before
    public void init(){
        sensitiveWordBs = SensitiveWordDispatcher.newInstance();
    }

    @Test
    public void contains() {
        boolean contains = sensitiveWordBs.contains("黄色的");
        Assert.assertTrue(contains);
    }

    @Test
    public void replace() {
        String replaced = sensitiveWordBs.replace("adfsa黄色adfasfa");
        Assert.assertEquals(null,replaced,"adfsa**adfasfa");
    }
}