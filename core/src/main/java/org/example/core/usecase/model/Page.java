package org.example.core.usecase.model;

import java.util.List;

/**
 * @author : wangqijia create at:  2024/12/5  11:00 AM
 */
public class Page<T> {

    private List<T> list;

    private boolean hasNext;
    private int page;
    private int size;
    private int total;


    public Page(List<T> list, int page, int size, int total) {
        this.list = list;
        this.page = page;
        this.size = size;
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public boolean isHasNext() {
        return (page + 1) * size <= total;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getTotal() {
        return total;
    }

    public boolean isEmpty() {
        return list == null || list.isEmpty();
    }
}
