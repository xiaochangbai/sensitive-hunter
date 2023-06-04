package io.xiaochangbai.sensitive.core.support.deny;

import io.xiaochangbai.sensitive.common.utils.FileUtils;
import io.xiaochangbai.sensitive.core.api.IWordDeny;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;

import java.util.List;

/**
 * 系统默认的信息
 * xiaochangbai
 *3
 */
@ThreadSafe
public class WordDenySystem implements IWordDeny {

    @Override
    public List<String> deny() {
        return FileUtils.readAllLinesForZip("deny.zip");
    }

}
