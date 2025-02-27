package dev.lpa.util;

import java.util.List;

public class QueryList <T extends QueryItem> {

    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }
}
