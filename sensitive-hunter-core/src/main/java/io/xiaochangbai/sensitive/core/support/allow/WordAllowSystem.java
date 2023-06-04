package io.xiaochangbai.sensitive.core.support.allow;

import io.xiaochangbai.sensitive.common.utils.FileUtils;
import io.xiaochangbai.sensitive.core.api.IWordAllow;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;

import java.util.List;

/**
 * 系统默认的信息
 * xiaochangbai
 *3
 */
@ThreadSafe
public class WordAllowSystem implements IWordAllow {

    @Override
    public List<String> allow() {
        return FileUtils.readAllLinesForZip("allow.zip");
    }

}
