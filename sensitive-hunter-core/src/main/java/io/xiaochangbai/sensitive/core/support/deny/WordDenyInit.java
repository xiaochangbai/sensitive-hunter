package io.xiaochangbai.sensitive.core.support.deny;

import io.xiaochangbai.sensitive.core.api.IWordDeny;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;
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
@ThreadSafe
public abstract class WordDenyInit implements IWordDeny {

    /**
     * 初始化列表
     *
     * @param pipeline 当前列表泳道
     *3
     */
    protected abstract void init(final Pipeline<IWordDeny> pipeline);

    @Override
    public List<String> deny() {
        Pipeline<IWordDeny> pipeline = new DefaultPipeline<>();
        this.init(pipeline);

        List<String> results = new ArrayList<>();
        List<IWordDeny> wordDenies = pipeline.list();
        for (IWordDeny wordDeny : wordDenies) {
            List<String> denyList = wordDeny.deny();
            results.addAll(denyList);
        }

        return results;
    }

}
