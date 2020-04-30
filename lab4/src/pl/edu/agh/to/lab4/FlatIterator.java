package pl.edu.agh.to.lab4;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatIterator<T> implements Iterator<T> {
    private Iterator<Iterator<T>> iterators;
    private Iterator<T> currentIterator;

    public FlatIterator(List<Iterator<T>> iterators) {
        if (!iterators.isEmpty()) {
            this.iterators = iterators.iterator();
            this.currentIterator = this.iterators.next();
        }
    }

    @Override
    public boolean hasNext() {
        if (currentIterator == null) return false;
        if (currentIterator.hasNext()) {
            return true;
        }
        if (!iterators.hasNext()) return false;
        currentIterator = iterators.next();
        return currentIterator.hasNext();
    }

    @Override
    public T next() {
        if (currentIterator == null)
            throw new NoSuchElementException("probably list given to FlatIterator has been empty");
        return currentIterator.next();
    }
}
