package io.xiaochangbai.sensitive.core.support.format;

import io.xiaochangbai.sensitive.core.api.ICharFormat;
import io.xiaochangbai.sensitive.core.api.IWordContext;
import io.xiaochangbai.sensitive.common.utils.CharUtils;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;

/**
 * 忽略英文的各种格式
 * xiaochangbai
 *
 */
@ThreadSafe
public class IgnoreEnglishStyleFormat implements ICharFormat {

    @Override
    public char format(char original, IWordContext context) {
        return CharUtils.getMappingChar(original);
    }

}
