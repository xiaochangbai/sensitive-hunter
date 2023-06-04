package io.xiaochangbai.sensitive.core.support.check.impl;

import io.xiaochangbai.sensitive.common.constant.enums.ValidModeEnum;
import io.xiaochangbai.sensitive.core.support.format.CharFormatChain;
import io.xiaochangbai.sensitive.core.api.IWordContext;
import io.xiaochangbai.sensitive.core.support.check.ISensitiveCheck;
import io.xiaochangbai.sensitive.core.support.check.SensitiveCheckResult;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;
import io.xiaochangbai.sensitive.common.instance.Instances;

/**
 * 敏感词监测实现
 *
 * 这里可以提供一个公共的父类。
 * xiaochangbai
 *
 */
@ThreadSafe
public class SensitiveCheckNum implements ISensitiveCheck {

    @Override
    public SensitiveCheckResult sensitiveCheck(String txt, int beginIndex, ValidModeEnum validModeEnum, IWordContext context) {
        // 记录敏感词的长度
        int lengthCount = 0;
        int actualLength = 0;

        for (int i = beginIndex; i < txt.length(); i++) {
            char c = txt.charAt(i);
            char charKey = Instances.singleton(CharFormatChain.class).format(c, context);

            // 如果是数字
            // 满足进入的条件
            if (Character.isDigit(charKey)) {
                lengthCount++;

                // 满足结束的条件
                boolean isCondition = isCondition(lengthCount, context);
                if (isCondition) {
                    // 只在匹配到结束的时候才记录长度，避免不完全匹配导致的问题。
                    actualLength = lengthCount;

                    // 这里确实需要一种验证模式，主要是为了最大匹配从而达到最佳匹配的效果。
                    if (ValidModeEnum.FAIL_FAST.equals(validModeEnum)) {
                        break;
                    }
                }
            } else {
                // 直接跳出循环
                break;
            }
        }

        return SensitiveCheckResult.of(actualLength, SensitiveCheckNum.class);
    }

    /**
     * 这里指定一个阈值条件
     * TODO: 这里有一个问题，会把一些 url 中的数字替换掉。
     * @param lengthCount 长度
     * @param context 上下文
     * @return 是否满足条件
     *
     */
    protected boolean isCondition(final int lengthCount,
                                final IWordContext context) {
        return lengthCount >= context.sensitiveCheckNumLen();
    }

}
