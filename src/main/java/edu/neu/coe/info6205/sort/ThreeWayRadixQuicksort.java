package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.sort.api.SortAPI;
import org.jetbrains.annotations.NotNull;


public class ThreeWayRadixQuicksort<T extends Comparable<T>> extends SortAPI<T> {

    @Override
    public void sort(@NotNull T[] arr, int from, int to) {
        this.sort(arr, from, to,0);
    }

    @Override
    protected void sort(@NotNull T[] arr, int from, int to, int d) {
        if (to <= from) return;

        int lt = from;

        int gt = to;
        int i = from;
        int v = this.getCharAtPosition(arr[from], d, this.getUnaryOperator());

        while (i <= gt) {
            int t = this.getCharAtPosition(arr[i], d, this.getUnaryOperator());
            if (t == v) i++;
            else if (t < v) this.swap(arr, i++, lt++);
            else this.swap(arr, i, gt--);
        }

        this.sort(arr, from, lt - 1, d);
        if (v >= 0) this.sort(arr, lt, gt, d + 1); // look here how u skipped dth character wow!!!!
        this.sort(arr, gt + 1, to, d);
    }

}
