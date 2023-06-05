package io.xiaochangbai.sensitive.core.config;

import io.xiaochangbai.sensitive.common.core.WordContext;
import io.xiaochangbai.sensitive.common.instance.Instances;
import io.xiaochangbai.sensitive.core.api.IWordAllow;
import io.xiaochangbai.sensitive.core.api.IWordDeny;
import io.xiaochangbai.sensitive.core.support.allow.SystemDefaultWordAllow;
import io.xiaochangbai.sensitive.core.support.check.SensitiveCheckWord;
import io.xiaochangbai.sensitive.core.support.deny.SystemDefaultWordDeny;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 上下文
 * xiaochangbai
 *
 */
public class SensitiveWordConfig extends WordContext{


    /**
     * 敏感词源
     */
    private List<IWordDeny> wordDenys;

    /**
     * 白名单源
     */
    private List<IWordAllow> wordAllows;


    public SensitiveWordConfig() {
        this.addSensitiveChecks(Instances.singleton(SensitiveCheckWord.class));
    }

    /**
     * 新建一个对象实例
     * @return 对象实例
     *
     */
    public static SensitiveWordConfig defaultConfig() {
        SensitiveWordConfig sensitiveWordConfig = new SensitiveWordConfig();
        sensitiveWordConfig.setIgnoreRepeat(false);
        sensitiveWordConfig.setSensitiveCheckNumLen(20);
        sensitiveWordConfig.addWordAllows(new SystemDefaultWordAllow());
        sensitiveWordConfig.addWordDenys(new SystemDefaultWordDeny());
        return sensitiveWordConfig;
    }

    public void addWordAllows(IWordAllow iWordAllow){
        if(wordAllows==null){
            wordAllows = new ArrayList<>(8);
        }
        wordAllows.add(iWordAllow);
    }

    public void addWordDenys(IWordDeny iWordDeny){
        if(wordDenys==null){
            wordDenys = new ArrayList<>(8);
        }
        wordDenys.add(iWordDeny);
    }

    public List<IWordDeny> findWordDenys(){
        if(this.wordDenys==null){
            return Collections.emptyList();
        }
        return this.wordDenys;
    }

    public List<IWordAllow> findWordAllows(){
        if(this.wordAllows==null){
            return Collections.emptyList();
        }
        return this.wordAllows;
    }


}
