package io.xiaochangbai.sensitive.common.pipeline;

import java.util.List;

/**
 * @author xiaochangbai
 * @date 2023-06-04 17:19
 */
public interface Pipeline<T> {
    Pipeline addLast(T var1);

    Pipeline addFirst(T var1);

    Pipeline set(int var1, T var2);

    Pipeline removeLast();

    Pipeline removeFirst();

    Pipeline remove(int var1);

    T get(int var1);

    T getFirst();

    T getLast();

    List<T> list();

    List<T> slice(int var1, int var2);
}
