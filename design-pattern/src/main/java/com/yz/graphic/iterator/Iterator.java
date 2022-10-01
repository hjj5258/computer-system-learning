package com.yz.graphic.iterator;

/**
 * @author hjj
 * @create 2022/09/21/23:47
 */
public interface Iterator {
    /**
     * 判断是否能够继续迭代下去
     *
     * @return
     */
    boolean hasNext();

    /**
     * 这个是获取当前对象
     *
     * @return
     */
    Object next();
}
