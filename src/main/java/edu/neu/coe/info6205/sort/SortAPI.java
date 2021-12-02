package edu.neu.coe.info6205.sort;



import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.Collator;
import java.util.Locale;

/**
 * @author Sai Akhil
 */
public abstract class SortAPI<T extends Comparable<T>> {

    private Locale locale;


    /**
     * Sorts a given array
     * @param t -= Array
     */
    public void sort(@NotNull T[] t){
        this.sort(t,0,t.length-1);
    }

    public abstract void sort(@NotNull T[] t, int from, int to);

    /**
     * Sort Method used for 3 way sorts
     * @param t
     * @param from
     * @param to
     * @param d
     */
    public void sort(@NotNull T[] t, int from, int to, int d){};

    protected int compare(@NotNull T[] t, int i, int j){
        return t[i].compareTo(t[j]);
    }

    protected boolean less(String a, String b) {
        return a.compareTo(b) < 0;
    }

    protected boolean less(String a, String b,@Nullable Locale locale){
        if (locale==null) return this.less(a,b);
        return Collator.getInstance(locale).compare(a, b) < 0;
    }

    /**
     * Swap array items, j element will be moved to i position and vice verse
     * @param t -= Array
     * @param j -= 2nd position
     * @param i -= 1st position
     */
    protected void swap(T[] t, int j, int i) {
        T temp = t[j];
        t[j] = t[i];
        t[i] = temp;
    }


    public Locale getLocale() {
        return locale;
    }

    public SortAPI<T> withLocale(Locale locale) {
        this.locale = locale;
        return this;
    }
}
