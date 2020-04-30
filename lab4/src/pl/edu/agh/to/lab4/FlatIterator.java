package pl.edu.agh.to.lab4;

import java.util.Iterator;
import java.util.List;


class FlatIterator<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> iterators;
    private Iterator<T> currentIterator;

    public FlatIterator(List<Iterator<T>> iterators) {
        if (iterators.isEmpty())
            throw new UnsupportedOperationException("given list of iterators must not be empty");
        this.iterators = iterators.iterator();
        this.currentIterator = this.iterators.next();
    }

    @Override
    public boolean hasNext() {
        if (currentIterator.hasNext()) {
            return true;
        }
        if (!iterators.hasNext()) return false;
        currentIterator = iterators.next();
        return currentIterator.hasNext();
    }

    @Override
    public T next() {
        return currentIterator.next();
    }
}
