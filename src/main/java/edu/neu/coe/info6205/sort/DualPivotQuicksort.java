package edu.neu.coe.info6205.sort;

import static edu.neu.coe.info6205.util.SortUtils.less_chineseString;
import static edu.neu.coe.info6205.util.SortUtils.swap;

public class DualPivotQuicksort {

    public static void sort(String[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(String[] a, int low, int high) {

        if (high <= low) return;

        // a[low] must be <= a[high]
        if (less_chineseString(a[high], a[low])) {
            swap(a, low, high);
        }

        int lt = low + 1;
        int gt = high - 1;
        int i = low + 1;

        while (i <= gt) {
            if (less_chineseString(a[i], a[low])) swap(a, lt++, i++);
            else if (less_chineseString(a[high], a[low])) swap(a, i, gt--);
            else i++;
        }

        // Moving the left and right pivot elements
        swap(a, low, --lt);
        swap(a, high, ++gt);

        // recursively sort three subarrays
        sort(a, low, lt - 1);

        // only sorting if pivot elements are in place
        if (less_chineseString(a[lt], a[gt])) sort(a, lt + 1, gt - 1);

        sort(a, gt + 1, high);


    }


}
