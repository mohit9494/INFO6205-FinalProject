package edu.neu.coe.info6205.sort.api;



import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.Collator;
import java.util.Locale;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * @author Sai Akhil
 */
public abstract class SortAPI<T extends Comparable<T>> {

    private Locale locale;
    private UnaryOperator<T> operator;
    private BinaryOperator<T> binaryOperator;


    /**
     * Sorts a given array
     *
     * @param t -= Array
     */
    public void sort(@NotNull T[] t) {
        this.sort(t, 0, t.length - 1);
    }

    public void sort(@NotNull T[] t, int position) {
        this.sort(t, 0, t.length - 1, position);
    }

    protected void sort(@NotNull T[] t, int from, int to) {
        throw new IllegalStateException("Method is UnImplemented");
    }

    /**
     * Sort Method used for 3 way sorts
     *
     * @param t
     * @param from
     * @param to
     * @param d
     */
    protected void sort(@NotNull T[] t, int from, int to, int d) {
        throw new IllegalStateException("Method is UnImplemented");
    }

    ;

    protected int compare(@NotNull T[] t, int i, int j) {
        return t[i].compareTo(t[j]);
    }

    protected boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    protected boolean less(T a, T b, @Nullable Locale locale) {
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

    public SortAPI<T> withOperator(UnaryOperator<T> unaryOperator){
        this.operator = unaryOperator;
        return this;
    }

    protected UnaryOperator<T> getOperator(){
        return this.operator;
    }

    public SortAPI<T> withBinaryOperator(BinaryOperator<T> binaryOperator) {
        this.binaryOperator = binaryOperator;
        return this;
    }

    protected BinaryOperator<T> getBinaryOperator() {
        return this.binaryOperator;
    }

//    protected int getCharAtPosition(T t, int position){
//
//    }
}
