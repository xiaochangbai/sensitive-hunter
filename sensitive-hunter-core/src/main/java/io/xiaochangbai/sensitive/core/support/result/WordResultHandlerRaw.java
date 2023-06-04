package io.xiaochangbai.sensitive.core.support.result;

import io.xiaochangbai.sensitive.core.api.IWordResult;
import io.xiaochangbai.sensitive.core.api.IWordResultHandler;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;

/**
 * 不做任何处理
 * xiaochangbai
 *
 */
@ThreadSafe
public class WordResultHandlerRaw implements IWordResultHandler<IWordResult> {

    @Override
    public IWordResult handle(IWordResult wordResult) {
        return wordResult;
    }

}
