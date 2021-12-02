package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.SortUtils;
import org.jetbrains.annotations.NotNull;

public class ThreeWayRadixQuicksort extends SortAPI<String>{

    @Override
    public void sort(@NotNull String[] arr, int from, int to) {
        this.sort(arr, from, to,0);
    }

    @Override
    protected void sort(@NotNull String[] arr, int from, int to, int d) {
        if (to <= from) return;

        int lt = from;

        int gt = to;
        int i = from;
        int v = charAt(arr[from], d);

        while (i <= gt) {
            int t = charAt(arr[i], d);

            if (t == v) i++;
            else if (t < v) this.swap(arr, i++, lt++);
            else this.swap(arr, i, gt--);
        }

        this.sort(arr, from, lt - 1, d);
        if (v >= 0) this.sort(arr, lt, gt, d + 1); // look here how u skipped dth character wow!!!!
        this.sort(arr, gt + 1, to, d);
    }

    private static int charAt(String s, int d) {
        String pinyin = SortUtils.getPinYinString(s);
        if (d < pinyin.length()) return pinyin.charAt(d);
        else return -1;
    /*    if (d < s.length()) {
            System.out.println("Char ====> " + s.charAt(d) + " Ascii ===> " + (int) s.charAt(d));
            return s.charAt(d);
        } else return -1;*/
    }

//    private static void swap(String[] a, int i, int j) {
//        String temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }

//    private static void sort1(String[] arr, int from, int to, int d) {
//
//        // 3 way partitioning (using dth character)
//        if (to <= from) return;
//        int lt = from;
//        int gt = to;
//        int i = from;
//        int v = charAt(arr[from], d);
//
//        while (i <= gt) {
//            int t = charAt(arr[i], d);
//
//            if (t == v) i++;
//            else if (t < v) swap(arr, i++, lt++);
//            else if (t > v) swap(arr, i, gt--);
//        }
//
//        sort(arr, from, lt - 1, d);
//        if (v >= 0) sort(arr, lt, gt, d + 1); // look here how u skipped dth character wow!!!!
//        sort(arr, gt + 1, to, d);
//
//    }


}
