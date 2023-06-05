package io.xiaochangbai.sensitive.core.config;

import io.xiaochangbai.sensitive.common.core.WordContext;
import io.xiaochangbai.sensitive.common.instance.Instances;
import io.xiaochangbai.sensitive.core.api.IWordAllow;
import io.xiaochangbai.sensitive.core.api.IWordDeny;
import io.xiaochangbai.sensitive.core.support.allow.WordAllowSystem;
import io.xiaochangbai.sensitive.core.support.check.SensitiveCheckWord;
import io.xiaochangbai.sensitive.core.support.deny.WordDenySystem;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * 上下文
 * xiaochangbai
 *
 */
@Data
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
    }

    /**
     * 新建一个对象实例
     * @return 对象实例
     *
     */
    public static SensitiveWordConfig defaultConfig() {
        SensitiveWordConfig sensitiveWordConfig = new SensitiveWordConfig();
        // 格式统一化
        sensitiveWordConfig.setIgnoreRepeat(false);
        // 额外配置
        sensitiveWordConfig.setSensitiveCheckNumLen(8);
        sensitiveWordConfig.addSensitiveChecks(Instances.singleton(SensitiveCheckWord.class));
        sensitiveWordConfig.setWordAllows(Arrays.asList(new WordAllowSystem()));
        sensitiveWordConfig.setWordDenys(Arrays.asList(new WordDenySystem()));
        return sensitiveWordConfig;
    }


}
