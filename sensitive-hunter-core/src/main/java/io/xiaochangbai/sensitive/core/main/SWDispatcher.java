package io.xiaochangbai.sensitive.core.main;

import io.xiaochangbai.sensitive.core.api.ISensitiveWordReplace;
import io.xiaochangbai.sensitive.core.api.IWordResultHandler;

import java.util.List;

/**
 * @description:
 * @author: xiaochangbai
 * @date: 2023/6/6 14:43
 */
public interface SWDispatcher {


    /**
     * 是否包含敏感词
     *
     * @param target 目标字符串
     * @return 是否
     *
     */
    boolean contains(final String target);

    /**
     * 返回所有的敏感词
     *
     */
    List<String> findAll(final String target);

    /**
     * 返回第一个敏感词
     * （1）如果不存在，则返回 {@code null}
     *
     * @param target 目标字符串
     * @return 敏感词
     *
     */
    String findFirst(final String target);

    /**
     * 返回所有的敏感词
     *
     */
    <R> List<R> findAll(final String target, final IWordResultHandler<R> handler);

    /**
     * 返回第一个敏感词
     * （1）如果不存在，则返回 {@code null}
     *
     * @param target 目标字符串
     * @param handler 处理类
     * @param <R> 泛型
     * @return 敏感词
     *
     */
    <R> R findFirst(final String target, final IWordResultHandler<R> handler);

    /**
     * 替换所有内容
     */
    String replace(final String target, final char replaceChar);

    /**
     * 替换所有内容
     *
     * @param target      目标字符串
     * @param replace 替换策略
     * @return 替换后结果
     *
     */
    String replace(final String target, final ISensitiveWordReplace replace);

    /**
     * 替换所有内容
     * @param target 目标字符串
     * @return 替换后结果
     *
     */
    String replace(final String target);



}
