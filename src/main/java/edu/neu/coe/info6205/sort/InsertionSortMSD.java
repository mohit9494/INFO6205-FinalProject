package edu.neu.coe.info6205.sort;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.jetbrains.annotations.NotNull;

import java.util.function.BinaryOperator;

/**
 * This is a basic implementation of insertion sort.
 * It does not extend Sort, nor does it employ any optimizations.
 */
public class InsertionSortMSD<T extends Comparable<T>> extends SortAPI<T> {

    int digit = 0;

    public InsertionSortMSD() {
        this((item,d) -> item,0);
    }

    public InsertionSortMSD(BinaryOperator<T> binaryOperator, int digit) {
        this.withBinaryOperator(binaryOperator);
        this.digit = digit;
    }

    @Override
    protected void sort(@NotNull T[] t, int from, int to) {
        this.sort(t, from, to, this.digit);
    }


    @Override
    protected void sort(@NotNull T[] arr, int from, int to, int d) {
        T temp = (arr instanceof String[])? (T)String.valueOf(d):null;
        for (int i = from; i <= to; i++)
            for (int j = i; j > from && this.less(this.getBinaryOperator().apply(arr[j],temp),
                    this.getBinaryOperator().apply(arr[j - 1],temp)); j--) {
                this.swap(arr, j, j - 1);
            }
    }

    public static BinaryOperator<String> getPinYinStringBinaryOperator() {
        return (str, d) -> {
            StringBuilder pinyin = new StringBuilder();
            for (char c : str.toCharArray()) {
                pinyin.append(PinyinHelper.toHanyuPinyinStringArray(c)[0]);
            }
            return pinyin.substring(Integer.parseInt(d));
        };
    }

    public static BinaryOperator<String> getStringBinaryOperator() {
        return (str, d) -> {
            int tempD = Integer.parseInt(d);
            if (tempD<str.length()) return str.substring(tempD);
            return "-1";
        };
    }
}
