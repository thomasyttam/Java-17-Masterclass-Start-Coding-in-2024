package dev.lpa.domain;

import java.util.Comparator;

public class StoreEmployee extends Employee{

    private String store;

    public class StoreComparator<T extends StoreComparator>
    implements Comparator<StoreEmployee> {

        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int result = o1.store.compareTo(o2.store);
            return result;
        }
    }
}
