package io.xiaochangbai.sensitive.core.support.replace;

import io.xiaochangbai.sensitive.core.api.ISensitiveWordReplace;
import io.xiaochangbai.sensitive.core.api.ISensitiveWordReplaceContext;
import io.xiaochangbai.sensitive.common.utils.CharUtil;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;

/**
 * 指定字符的替换策略
 * xiaochangbai
 *
 */
@ThreadSafe
public class SensitiveWordReplaceChar implements ISensitiveWordReplace {

    private final char replaceChar;

    public SensitiveWordReplaceChar(char replaceChar) {
        this.replaceChar = replaceChar;
    }

    @Override
    public String replace(ISensitiveWordReplaceContext context) {
        int wordLength = context.wordLength();

        return CharUtil.repeat(replaceChar, wordLength);
    }

}
