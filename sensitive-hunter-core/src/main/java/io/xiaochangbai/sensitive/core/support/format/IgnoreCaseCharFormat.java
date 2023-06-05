package io.xiaochangbai.sensitive.core.support.format;

import io.xiaochangbai.sensitive.common.core.ICharFormat;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;

/**
 * 忽略大小写
 * xiaochangbai
 *
 */
@ThreadSafe

public class IgnoreCaseCharFormat implements ICharFormat {

    @Override
    public char format(char original) {
        return Character.toLowerCase(original);
    }

}
