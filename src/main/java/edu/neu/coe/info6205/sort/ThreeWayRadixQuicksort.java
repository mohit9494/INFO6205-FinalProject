package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.SortUtils;

public class ThreeWayRadixQuicksort {


    public static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
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

    private static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void sort(String[] a, int low, int high, int d) {

        // 3 way partitioning (using dth character)
        if (high <= low) return;
        int lt = low;
        int gt = high;
        int i = low;
        int v = charAt(a[low], d);

        while (i <= gt) {
            int t = charAt(a[i], d);

            if (t == v) i++;
            else if (t < v) swap(a, i++, lt++);
            else if (t > v) swap(a, i, gt--);
        }

        sort(a, low, lt - 1, d);
        if (v >= 0) sort(a, lt, gt, d + 1); // look here how u skipped dth character wow!!!!
        sort(a, gt + 1, high, d);

    }


}
