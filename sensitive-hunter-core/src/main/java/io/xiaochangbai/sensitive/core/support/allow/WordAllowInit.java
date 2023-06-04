package io.xiaochangbai.sensitive.core.support.allow;

import io.xiaochangbai.sensitive.core.api.IWordAllow;
import io.xiaochangbai.sensitive.common.pipeline.Pipeline;
import io.xiaochangbai.sensitive.common.pipeline.impl.DefaultPipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化类
 *
 * xiaochangbai
 *3
 */
public abstract class WordAllowInit implements IWordAllow {

    /**
     * 初始化列表
     *
     * @param pipeline 当前列表泳道
     *3
     */
    protected abstract void init(final Pipeline<IWordAllow> pipeline);

    @Override
    public List<String> allow() {
        Pipeline<IWordAllow> pipeline = new DefaultPipeline<>();
        this.init(pipeline);

        List<String> results = new ArrayList<>();
        List<IWordAllow> wordAllows = pipeline.list();
        for (IWordAllow wordAllow : wordAllows) {
            List<String> allowList = wordAllow.allow();
            results.addAll(allowList);
        }

        return results;
    }

}
