package io.xiaochangbai.sensitive.core.support.format;

import io.xiaochangbai.sensitive.common.core.ICharFormat;
import io.xiaochangbai.sensitive.common.utils.CharUtil;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;

/**
 * 格式化责任链
 * xiaochangbai
 *
 */
@ThreadSafe
public class IgnoreWidthCharFormat implements ICharFormat {

    @Override
    public char format(char original) {
        return CharUtil.toHalfWidth(original);
    }

}
