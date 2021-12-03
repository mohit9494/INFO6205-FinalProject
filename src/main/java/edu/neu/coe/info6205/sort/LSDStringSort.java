package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.SortUtils;
import org.jetbrains.annotations.NotNull;


public class LSDStringSort extends SortAPI<String> {

    private static final int ASCII_RANGE = 65536;

    private int getCharAtPosition(String str, int charPosition) {
        String currentStr = this.getStringBasedOnLocale(str);
        return (charPosition >= currentStr.length()) ? 0 : currentStr.charAt(charPosition);
    }

    private void charSort(String[] strArr, int charPosition, int from, int to) {
        int[] count = new int[ASCII_RANGE + 2];
        String[] result = new String[strArr.length];

        for (int i = from; i <= to; i++) {
            int c = this.getCharAtPosition(strArr[i], charPosition);
            count[c + 2]++;
        }

        for (int r = 1; r < ASCII_RANGE + 2; r++) count[r] += count[r - 1];

        for (int i = from; i <= to; i++) {
            int c = this.getCharAtPosition(strArr[i], charPosition);
            result[count[c + 1]++] = strArr[i];
        }

        if (to + 1 - from >= 0) System.arraycopy(result, 0, strArr, from, to + 1 - from);
    }

    public void sort(String[] strArr, int from, int to) {
        int maxLength = this.getMaxStringLength(strArr);
        for (int i = maxLength - 1; i >= 0; i--) charSort(strArr, i, from, to);
    }

    private int getMaxStringLength(@NotNull String[] strArray) {
        int maxLength = 0;
        for (String s : strArray) {
            maxLength = Math.max(maxLength, this.getStringBasedOnLocale(s).length());
        }
        return maxLength;
    }

    private String getStringBasedOnLocale(@NotNull String str) {
        return (this.getLocale() == null) ? str : SortUtils.getPinYinString(str);
    }

}
