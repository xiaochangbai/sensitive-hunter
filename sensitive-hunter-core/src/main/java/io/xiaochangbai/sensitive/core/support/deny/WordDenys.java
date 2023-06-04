package io.xiaochangbai.sensitive.core.support.deny;


import io.xiaochangbai.sensitive.common.utils.ArrayUtil;
import io.xiaochangbai.sensitive.common.pipeline.Pipeline;
import io.xiaochangbai.sensitive.core.api.IWordDeny;
import io.xiaochangbai.sensitive.common.instance.Instances;

/**
 * 所有拒绝的结果
 * xiaochangbai
 *3
 */
public final class WordDenys {

    private WordDenys(){}

    /**
     * 责任链
     * @param wordDeny 拒绝
     * @param others 其他
     * @return 结果
     *3
     */
    public static IWordDeny chains(final IWordDeny wordDeny,
                                   final IWordDeny... others) {
        return new WordDenyInit() {
            @Override
            protected void init(Pipeline<IWordDeny> pipeline) {
                pipeline.addLast(wordDeny);

                if(ArrayUtil.isNotEmpty(others)) {
                    for(IWordDeny other : others) {
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
    public static IWordDeny system() {
        return Instances.singleton(WordDenySystem.class);
    }

}
