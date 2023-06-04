package io.xiaochangbai.sensitive.common.utils;


/**
 * @author xiaochangbai
 * @date 2023-06-04 17:16
 */
public class ObjectUtil {
    public static <V> boolean isNull(Object values) {
        return values==null;
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }
}
