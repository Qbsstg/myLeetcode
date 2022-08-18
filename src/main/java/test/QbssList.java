package test;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Qbss
 * @date 2022/8/18
 * @desc
 */
public class QbssList<E> extends AbstractList<E> {


    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    public QbssList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public QbssList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public QbssList(Collection<? extends E> c) {
        Object[] a = c.toArray();
        /*
         * a.length赋值给size
         * 再判断是否等于0
         * */
        if ((size = a.length) != 0) {
            if (c.getClass() == QbssList.class) {
                elementData = a;
            } else {
                elementData = Arrays.copyOf(a, size, Object[].class);
            }
        } else {
            elementData = EMPTY_ELEMENTDATA;
        }
    }


    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
