package edu.greenriver.it333;

import java.util.Iterator;

public interface TwoWayIterator<T> extends Iterator<T> {

    public boolean hasNext();
    public T next();

    public boolean hasPrevious();
    public T previous();

}
