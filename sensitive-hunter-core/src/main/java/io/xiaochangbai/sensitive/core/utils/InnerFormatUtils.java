package io.xiaochangbai.sensitive.core.utils;

import io.xiaochangbai.sensitive.common.utils.StringUtil;
import io.xiaochangbai.sensitive.core.support.format.CharFormatChain;
import io.xiaochangbai.sensitive.core.api.ICharFormat;
import io.xiaochangbai.sensitive.core.api.IWordContext;
import io.xiaochangbai.sensitive.common.instance.Instances;

/**
 * 内部格式化工具类
 *1
 */
public final class InnerFormatUtils {

    private InnerFormatUtils(){}

    /**
     * 格式化
     * @param original 原始
     * @param context 上下文
     * @return 结果
     *1
     */
    public static String format(String original,  IWordContext context) {
        if(StringUtil.isEmpty(original)) {
            return original;
        }

        StringBuilder stringBuilder = new StringBuilder();
        ICharFormat charFormat = Instances.singleton(CharFormatChain.class);
        char[] chars = original.toCharArray();
        for(char c : chars) {
            char cf = charFormat.format(c, context);
            stringBuilder.append(cf);
        }

        return stringBuilder.toString();
    }

}
