package io.xiaochangbai.sensitive.common.handler;

/**
 * @author xiaochangbai
 * @date 2023-06-04 17:12
 */
public interface IHandler<T, R> {
    R handle(T var1);
}