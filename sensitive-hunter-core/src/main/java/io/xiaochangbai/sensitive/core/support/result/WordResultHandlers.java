package io.xiaochangbai.sensitive.core.support.result;

import io.xiaochangbai.sensitive.core.api.IWordResult;
import io.xiaochangbai.sensitive.core.api.IWordResultHandler;
import io.xiaochangbai.sensitive.common.instance.Instances;

/**
 * 敏感词的结果处理
 * xiaochangbai
 *
 */
public final class WordResultHandlers {

    private WordResultHandlers(){}

    /**
     * 不做任何处理
     * @return 结果
     *
     */
    public static IWordResultHandler<IWordResult> raw() {
        return Instances.singleton(WordResultHandlerRaw.class);
    }

    /**
     * 只保留单词
     * @return 结果
     *
     */
    public static IWordResultHandler<String> word() {
        return Instances.singleton(WordResultHandlerWord.class);
    }

}
