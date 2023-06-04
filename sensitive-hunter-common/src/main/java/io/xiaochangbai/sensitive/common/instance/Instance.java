package io.xiaochangbai.sensitive.common.instance;

/**
 * @author xiaochangbai
 * @date 2023-06-04 17:24
 */
public interface Instance {
    <T> T singleton(Class<T> var1, String var2);

    <T> T singleton(Class<T> var1);

    <T> T threadLocal(Class<T> var1);

    <T> T multiple(Class<T> var1);

    <T> T threadSafe(Class<T> var1);
}

