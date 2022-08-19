package test;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

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

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {

            int newCapacity;

            int preLength = oldCapacity + Math.max(minCapacity - oldCapacity, oldCapacity >> 1);
            if (preLength > 0 && preLength <= Integer.MAX_VALUE - 8) {
                newCapacity = preLength;
            } else {
                int minLength = oldCapacity + (minCapacity - oldCapacity);
                if (minLength < 0) {
                    throw new OutOfMemoryError("数组的长度太大");
                } else if (minLength <= Integer.MAX_VALUE - 8) {
                    newCapacity = Integer.MAX_VALUE - 8;
                } else {
                    newCapacity = minCapacity;
                }
            }
            return elementData = Arrays.copyOf(elementData, newCapacity);
        }
        //数组原长度为0的情况下，直接按照指定的大小与默认10的最大值返回一个新数组
        else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private Object[] grow() {
        //数组想要扩容，输入想要的最小扩容大小
        return grow(size + 1);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //在数组中指定开始后结束位置查找第一次出现该元素的下标
    int indexOfRange(Object o, int start, int end) {

        Object[] es = elementData;

        if (start < 0 || end >= size) {
            return -1;
        }
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (es[i].equals(o)) {
                    return i;
                }
            }
        }

        return -1;
    }

    /*
     * 在list中添加一位，但其实对于数组来说可能还没到最后一个位置
     * 因为数组的长度是动态扩容后的，所以elementData.length的值是大于等于list.size()的
     * 所以判断，当list的长度即数组中实际保存元素的长度 与 数组的长度相等时，list开始扩容
     * */
    public boolean add(E e) {

        if (size == elementData.length) {
            elementData = grow();
        }
        elementData[size] = e;
        size += 1;
        return true;
    }


    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("数组越界");
        }
    }

    public void add(int index, E element) {
        rangeCheckForAdd(index);

        final int s;
        Object[] elementData;
        //数组空间已经满了，扩容
        if ((s = size) == (elementData = this.elementData).length) {
            elementData = grow();
        }
        System.arraycopy(elementData, index, elementData, index + 1, s - index);
        elementData[index] = element;
        size = s + 1;
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;

        E oldValue = (E) es[index];
        fastRemove(es, index);
        return oldValue;
    }

    public boolean remove(Object o) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found:
        {
            if (o == null) {
                for (; i < size; i++) {
                    if (es[i] == null) {
                        break found;
                    }
                }
            } else {
                for (; i < size; i++) {
                    if (es[i].equals(o)) {
                        break found;
                    }
                }
            }
            return false;
        }

        fastRemove(es, i);
        return true;
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i) {
            System.arraycopy(es, i + 1, es, i, newSize - i);
        }
        es[size = newSize] = null;
    }

    public void clear() {
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++) {
            es[i] = null;
        }
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0) {
            return false;
        }
        Object[] elementData;
        final int s;
        //如果要添加的集合长度大于数组空余的长度，扩容
        if (numNew > (elementData = this.elementData).length - (s = size)) {
            elementData = grow(s + numNew);
        }
        System.arraycopy(a, 0, elementData, s, numNew);
        size = s + numNew;
        return true;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0) {
            return false;
        }

        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size)) {
            elementData = grow(s + numNew);
        }

        int numMoved = s - index;
        if (numMoved > 0) {
            System.arraycopy(elementData, index, elementData, index + numNew, numMoved);
        }
        System.arraycopy(a, 0, elementData, index, numNew);
        size = s + numNew;
        return true;

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
