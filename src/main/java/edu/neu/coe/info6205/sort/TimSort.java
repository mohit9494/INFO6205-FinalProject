package edu.neu.coe.info6205.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Sai Akhil
 * @param <T> Generic
 */
public class TimSort<T extends Comparable<T>> extends SortAPI<T> implements Comparator<T> {

    @Override
    protected void sort(@NotNull T[] t, int from, int to) {
        Arrays.sort(t,from,to+1,this);
    }

    @Override
    public int compare(T o1, T o2) {
        return (this.less(o1,o2,this.getLocale())) ? -1:1;
    }
}
