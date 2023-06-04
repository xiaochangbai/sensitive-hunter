package io.xiaochangbai.sensitive.core.support.allow;


import io.xiaochangbai.sensitive.core.api.IWordAllow;
import io.xiaochangbai.sensitive.common.utils.ArrayUtil;
import io.xiaochangbai.sensitive.common.instance.Instances;
import io.xiaochangbai.sensitive.common.pipeline.Pipeline;

/**
 * 所有允许的结果
 * xiaochangbai
 *3
 */
public final class WordAllows {

    private WordAllows(){}

    /**
     * 责任链
     * @param wordAllow 允许
     * @param others 其他
     * @return 结果
     *3
     */
    public static IWordAllow chains(final IWordAllow wordAllow,
                                    final IWordAllow... others) {
        return new WordAllowInit() {
            @Override
            protected void init(Pipeline<IWordAllow> pipeline) {
                pipeline.addLast(wordAllow);

                if(ArrayUtil.isNotEmpty(others)) {
                    for(IWordAllow other : others) {
                        pipeline.addLast(other);
                    }
                }
            }
        };
    }

    /**
     * 系统实现
     * @return 结果
     *3
     */
    public static IWordAllow system() {
        return Instances.singleton(WordAllowSystem.class);
    }

}
