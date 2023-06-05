package io.xiaochangbai.sensitive.core.support.deny;

import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;
import io.xiaochangbai.sensitive.common.utils.FileUtils;
import io.xiaochangbai.sensitive.core.api.IWordDeny;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;


@ThreadSafe
public class FileWordDeny implements IWordDeny {

    private InputStream ios;
    public FileWordDeny(InputStream ios){
        this.ios = ios;
    }

    @Override
    public List<String> deny() {
        return FileUtils.readAllLines(ios);
    }

}
