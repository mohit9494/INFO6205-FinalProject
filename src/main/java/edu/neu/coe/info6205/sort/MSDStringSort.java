package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.sort.api.StringSortAPI;
import org.jetbrains.annotations.NotNull;

import java.util.function.BinaryOperator;

/**
 * Class to implement Most significant digit string sort (a radix sort).
 */
public class MSDStringSort extends StringSortAPI {

    private final int radix = 65536;
    private int cutoff = 15;
    private final String[] aux;       // auxiliary array for distribution

    private BinaryOperator<String> insertionSortMSDOperator = null;

    public MSDStringSort(int n) {
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

    @Override
    protected void sort(@NotNull String[] t, int from, int to) {
        this.sort(t, from, to, 0);
    }

    @Override
    protected void sort(@NotNull String[] arr, int from, int to, int d) {
        if (to < from + cutoff && this.insertionSortMSDOperator != null)
            new InsertionSortMSD<>(this.insertionSortMSDOperator).sort(arr, from, to, d);
        else {
            int[] count = new int[radix + 2];        // Compute frequency counts.
            for (int i = from; i <= to; i++)
                count[this.getCharAtPosition(arr[i], d, this.getUnaryOperator()) + 2]++;
            for (int r = 0; r < radix + 1; r++)      // Transform counts to indices.
                count[r + 1] += count[r];
            for (int i = from; i <= to; i++)     // Distribute.
                aux[count[this.getCharAtPosition(arr[i], d, this.getUnaryOperator()) + 1]++] = arr[i];
            // Copy back.
            if (to + 1 - from >= 0) System.arraycopy(aux, 0, arr, from, to + 1 - from);

            // Recursively sort for each character value.
            for (int r = 0; r < radix; r++) {
                sort(arr, from + count[r], from + count[r + 1] - 1, d + 1);
            }
        }
    }
}