package io.xiaochangbai.sensitive.common.pipeline.impl;

import io.xiaochangbai.sensitive.common.pipeline.Pipeline;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaochangbai
 * @date 2023-06-04 17:19
 */
public class DefaultPipeline<T> implements Pipeline<T> {
    private LinkedList<T> list = new LinkedList();

    public DefaultPipeline() {
    }

    public Pipeline addLast(T t) {
        this.list.addLast(t);
        return this;
    }

    public Pipeline addFirst(T t) {
        this.list.addFirst(t);
        return this;
    }

    public Pipeline set(int index, T t) {
        this.list.set(index, t);
        return this;
    }

    public Pipeline removeLast() {
        this.list.removeLast();
        return this;
    }

    public Pipeline removeFirst() {
        this.list.removeFirst();
        return this;
    }

    public Pipeline remove(int index) {
        this.list.remove(index);
        return this;
    }

    public T get(int index) {
        return this.list.get(index);
    }

    public T getFirst() {
        return this.list.getFirst();
    }

    public T getLast() {
        return this.list.getLast();
    }

    public List<T> list() {
        return Collections.unmodifiableList(this.list);
    }

    public List<T> slice(int startIndex, int endIndex) {
        return this.list.subList(startIndex, endIndex);
    }
}
