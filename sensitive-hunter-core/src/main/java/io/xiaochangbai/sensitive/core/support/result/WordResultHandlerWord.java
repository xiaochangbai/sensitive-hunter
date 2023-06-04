package io.xiaochangbai.sensitive.core.support.result;

import io.xiaochangbai.sensitive.core.api.IWordResult;
import io.xiaochangbai.sensitive.core.api.IWordResultHandler;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;

/**
 * 只保留单词
 *
 * xiaochangbai
 *
 */
@ThreadSafe
public class WordResultHandlerWord implements IWordResultHandler<String> {

    @Override
    public String handle(IWordResult wordResult) {
        if(wordResult == null) {
            return null;
        }
        return wordResult.word();
    }
    
}
