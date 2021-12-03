package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.SortUtils;
import org.jetbrains.annotations.NotNull;

import java.util.function.BinaryOperator;

/**
 * Class to implement Most significant digit string sort (a radix sort).
 */
public class MSDStringSort extends SortAPI<String> {

    private final int radix = 65536;
    private  int cutoff = 15;
    private final String[] aux;       // auxiliary array for distribution

    private BinaryOperator<String> insertionSortMSDOperator = null;

    public MSDStringSort(int n) {
        this(n,(item,d)->item);
    }

    public MSDStringSort(int n, BinaryOperator<String> binaryOperator){
        this.withBinaryOperator(binaryOperator);
        this.aux = new String[n];
    }

    public MSDStringSort withInsertionSortMSDOperator(BinaryOperator<String> insertionSortMSDOperator){
        this.insertionSortMSDOperator = insertionSortMSDOperator;
        return this;
    }

    public MSDStringSort withCustomCutOff(int cutoff){
        this.cutoff = cutoff;
        return this;
    }

    /**
     * Sort an array of Strings using MSDStringSort.
     *
     * @param a the array to be sorted.
     */
//    public static void sort(String[] a) {
//        int n = a.length;
//        aux = new String[n];
//        sort(a, 0, n, 0);
//    }

    /**
     * Sort from a[lo] to a[hi] (exclusive), ignoring the first d characters of each String.
     * This method is recursive.
     *
     * @param a  the array to be sorted.
     * @param lo the low index.
     * @param hi the high index (one above the highest actually processed).
     * @param d  the number of characters in each String to be skipped.
     */
    //private static void sort(String[] a, int lo, int hi, int d) {
    // if (hi < lo + cutoff) InsertionSortMSD.sort(a, lo, hi, d);
//        else {
//            int[] count = new int[radix + 2];        // Compute frequency counts.
//            for (int i = lo; i < hi; i++)
//                count[charAt(a[i], d) + 2]++;
//            for (int r = 0; r < radix + 1; r++)      // Transform counts to indices.
//                count[r + 1] += count[r];
//            for (int i = lo; i < hi; i++)     // Distribute.
//                aux[count[charAt(a[i], d) + 1]++] = a[i];
//            // Copy back.
//            if (hi - lo >= 0) System.arraycopy(aux, 0, a, lo, hi - lo);
//
//            // Recursively sort for each character value.
//            for (int r = 0; r < radix; r++) {
//                sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
//            }
//        }
    // }


    @Override
    protected void sort(@NotNull String[] t, int from, int to) {
        this.sort(t, from, to, 0);
    }

    @Override
    protected void sort(@NotNull String[] arr, int from, int to, int d) {
        if (to < from + cutoff && this.insertionSortMSDOperator != null)
            new InsertionSortMSD<>(this.insertionSortMSDOperator, d).sort(arr,from,to,d);
        else {
            int[] count = new int[radix + 2];        // Compute frequency counts.
            for (int i = from; i <= to; i++)
                count[Integer.parseInt(this.getBinaryOperator().apply(arr[i],String.valueOf(d))) + 2]++;
            for (int r = 0; r < radix + 1; r++)      // Transform counts to indices.
                count[r + 1] += count[r];
            for (int i = from; i <= to; i++)     // Distribute.
                aux[count[Integer.parseInt(this.getBinaryOperator().apply(arr[i],String.valueOf(d))) + 1]++] = arr[i];
            // Copy back.
            for (int i = from; i <= to; i++) {
                arr[i] =  aux[i - from];
            }

            // Recursively sort for each character value.
            for (int r = 0; r < radix; r++) {
                sort(arr, from + count[r], from + count[r + 1] - 1, d + 1);
            }
        }
    }
}