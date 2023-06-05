package io.xiaochangbai.sensitive.core.support.format;


import io.xiaochangbai.sensitive.common.core.ICharFormat;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;

/**
 * 忽略大小写
 * xiaochangbai
 *
 */
@ThreadSafe
public class IgnoreChineseStyleFormat implements ICharFormat {

    @Override
    public char format(char original) {
//        String string = String.valueOf(original);
//        String simple = ZhConvertBootstrap.newInstance(new CharSegment()).toSimple(string);
//        return simple.charAt(0);
        return original;
    }

}
