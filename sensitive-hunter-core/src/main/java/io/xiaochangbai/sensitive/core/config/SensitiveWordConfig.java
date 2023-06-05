package io.xiaochangbai.sensitive.core.config;

import io.xiaochangbai.sensitive.common.core.WordContext;
import io.xiaochangbai.sensitive.common.instance.Instances;
import io.xiaochangbai.sensitive.core.api.IWordAllow;
import io.xiaochangbai.sensitive.core.api.IWordDeny;
import io.xiaochangbai.sensitive.core.support.allow.WordAllowSystem;
import io.xiaochangbai.sensitive.core.support.check.SensitiveCheckWord;
import io.xiaochangbai.sensitive.core.support.deny.WordDenySystem;
import lombok.Data;

/**
 * 上下文
 * xiaochangbai
 *
 */
@Data
public class SensitiveWordConfig extends WordContext{


    /**
     * 敏感词
     */
    private IWordDeny wordDeny;

    /**
     * 白名单
     */
    private IWordAllow wordAllow;


    /**
     * 私有化构造器
     *
     */
    private SensitiveWordConfig() {
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

        sensitiveWordConfig.setWordDeny(new WordDenySystem());
        sensitiveWordConfig.setWordAllow(new WordAllowSystem());

        sensitiveWordConfig.addSensitiveChecks(Instances.singleton(SensitiveCheckWord.class));
        return sensitiveWordConfig;
    }


}
