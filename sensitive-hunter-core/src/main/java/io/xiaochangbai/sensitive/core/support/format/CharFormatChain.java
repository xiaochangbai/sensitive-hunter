package io.xiaochangbai.sensitive.core.support.format;


import io.xiaochangbai.sensitive.core.api.IWordContext;
import io.xiaochangbai.sensitive.core.api.ICharFormat;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;
import io.xiaochangbai.sensitive.common.instance.Instances;

import java.util.ArrayList;
import java.util.List;

/**
 * 格式化责任链
 * xiaochangbai
 *
 */
@ThreadSafe
public class CharFormatChain implements ICharFormat {

    @Override
    public char format(char original, IWordContext context) {
        char result = original;

        List<ICharFormat> charFormats = new ArrayList<>();
        if(context.ignoreEnglishStyle()) {
            charFormats.add(Instances.singleton(IgnoreEnglishStyleFormat.class));
        }
        if(context.ignoreCase()) {
            charFormats.add(Instances.singleton(IgnoreCaseCharFormat.class));
        }
        if(context.ignoreWidth()) {
            charFormats.add(Instances.singleton(IgnoreWidthCharFormat.class));
        }
        if(context.ignoreNumStyle()) {
            charFormats.add(Instances.singleton(IgnoreNumStyleCharFormat.class));
        }
        if(context.ignoreChineseStyle()) {
            charFormats.add(Instances.singleton(IgnoreChineseStyleFormat.class));
        }

        // 循环执行
        for(ICharFormat charFormat : charFormats) {
            result = charFormat.format(result, context);
        }

        return result;
    }

}
