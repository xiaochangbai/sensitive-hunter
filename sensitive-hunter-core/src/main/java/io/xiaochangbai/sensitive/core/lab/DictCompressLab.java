package io.xiaochangbai.sensitive.core.lab;

import io.xiaochangbai.sensitive.common.utils.FileUtils;

import java.io.InputStream;
import java.net.URL;

/**
 * @author xiaochangbai
 * @date 2023-06-04 21:51
 * 数据字典压缩
 */
public class DictCompressLab {


    public static void main(String[] args) throws Exception {
        URL url = DictCompressLab.class.getResource("/deny.txt");
        FileUtils.compressFileByZIP(url.getPath());
    }

}
