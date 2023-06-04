package io.xiaochangbai.sensitive.common.utils;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author xiaochangbai
 * @date 2023-06-04 17:07
 */
public class ArgUtil {

    private ArgUtil() {
    }

    public static void notNull(Object object, String name) {
        if (null == object) {
            throw new IllegalArgumentException(name + " can not be null!");
        }
    }


    public static void notEmpty(String string, String name) {
        if (StringUtil.isEmpty(string)) {
            throw new IllegalArgumentException(name + " can not be null!");
        }
    }

}
