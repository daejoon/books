package com.ddoong2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Criteria implements Iterable<Criterion> {

    private List<Criterion> criteriaList = new ArrayList<>();
    private int index = 0;

    @Override
    public Iterator<Criterion> iterator() {
        if (isLast()) {
            return new MyIterator(false, null);
        }
        return  new MyIterator(true, criteriaList.get(index++));
    }

    private boolean isLast() {
        return index + 1 >= criteriaList.size();
    }


    public void add(Criterion criterion) {
        criteriaList.add(criterion);
    }

    public static class MyIterator implements Iterator<Criterion> {
        private boolean isNext;
        private Criterion criterion;

        public MyIterator(boolean isNext, Criterion criterion) {
            this.isNext = isNext;
            this.criterion = criterion;
        }

        @Override
        public boolean hasNext() {
            return this.isNext;
        }

        @Override
        public Criterion next() {
            return this.criterion;
        }
    }

}
