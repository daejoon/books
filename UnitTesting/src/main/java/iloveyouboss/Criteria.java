package iloveyouboss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Criteria implements Iterable<Criterion> {

    private List<Criterion> criteriaList = new ArrayList<>();

    @Override
    public Iterator<Criterion> iterator() {
        return new MyIterator(criteriaList);
    }

    public void add(Criterion criterion) {
        criteriaList.add(criterion);
    }

    private class MyIterator implements Iterator<Criterion> {
        private int position = 0;
        private List<Criterion> data;

        public MyIterator(List<Criterion> data) {
            this.data = data;
        }

        @Override
        public boolean hasNext() {
            if (position < this.data.size()) {
                return true;
            } else {
                return false;
            }

        }

        @Override
        public Criterion next() {
            if (this.hasNext()) {
                return this.data.get(position++);
            } else {
                return null;
            }
        }
    }

}
