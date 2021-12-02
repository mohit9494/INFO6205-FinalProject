package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.SortUtils;
import org.jetbrains.annotations.NotNull;

import java.util.function.BinaryOperator;

public class ThreeWayRadixQuicksort<T extends Comparable<T>> extends SortAPI<T>{

    public ThreeWayRadixQuicksort(){
        this((item,d)->d);
    }

    public ThreeWayRadixQuicksort(BinaryOperator<T> binaryOperator){
        this.withBinaryOperator(binaryOperator);
    }

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
        int v = Integer.parseInt(this.getBinaryOperator().apply(arr[from],(T)String.valueOf(d)).toString());

        while (i <= gt) {
            int t = Integer.parseInt(this.getBinaryOperator().apply(arr[i],(T)String.valueOf(d)).toString());
            if (t == v) i++;
            else if (t < v) this.swap(arr, i++, lt++);
            else this.swap(arr, i, gt--);
        }

        this.sort(arr, from, lt - 1, d);
        if (v >= 0) this.sort(arr, lt, gt, d + 1); // look here how u skipped dth character wow!!!!
        this.sort(arr, gt + 1, to, d);
    }

    public static BinaryOperator<String> getPinyinCharOperator(){
        return (item,d)->{
            int tempD = Integer.parseInt(d);
            String pinyin = SortUtils.getPinYinString(item);
            if (tempD < pinyin.length()) return String.valueOf((int)pinyin.charAt(tempD));
            return "-1";
        };
    }

    public static BinaryOperator<String> getStringCharOperator(){
        return (item,d)->{
            int tempD = Integer.parseInt(d);
            if (tempD < item.length()) return String.valueOf((int)item.charAt(tempD));
            return "-1";
        };
    }



}
