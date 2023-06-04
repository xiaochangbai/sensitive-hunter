package io.xiaochangbai.sensitive.core.support.format;

import io.xiaochangbai.sensitive.core.api.IWordContext;
import io.xiaochangbai.sensitive.core.api.ICharFormat;
import io.xiaochangbai.sensitive.common.utils.NumUtils;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;

/**
 * 忽略数字的样式
 * xiaochangbai
 *
 */
@ThreadSafe
public class IgnoreNumStyleCharFormat implements ICharFormat {

    @Override
    public char format(char original, IWordContext context) {
        return NumUtils.getMappingChar(original);
    }

}
