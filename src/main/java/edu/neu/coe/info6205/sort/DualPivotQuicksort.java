package edu.neu.coe.info6205.sort;


import edu.neu.coe.info6205.sort.api.SortAPI;

public class DualPivotQuicksort<T extends Comparable<T>> extends SortAPI<T> {


    @Override
    protected void sort(T[] arr, int from, int to) {
        if (to <= from) return;
        // a[low] must be <= a[high]
        if (this.less(arr[to], arr[from], this.getLocale())) {
            swap(arr, from, to);
        }
        int lt = from + 1;
        int gt = to - 1;
        int i = from + 1;
        while (i <= gt) {
            if (this.less(arr[i], arr[from], this.getLocale())) this.swap(arr, lt++, i++);
            else if (this.less(arr[to], arr[i],this.getLocale())) this.swap(arr, i, gt--);
            else i++;
        }
        // Moving the left and right pivot elements
        this.swap(arr, from, --lt);
        this.swap(arr, to, ++gt);
        // recursively sort three subarrays
        this.sort(arr, from, lt - 1);
        // only sorting if pivot elements are in place
        if (this.less(arr[lt], arr[gt], this.getLocale())) this.sort(arr, lt + 1, gt - 1);
        this.sort(arr, gt + 1, to);
    }


}
