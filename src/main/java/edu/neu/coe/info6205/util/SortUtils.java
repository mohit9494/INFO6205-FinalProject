package edu.neu.coe.info6205.util;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.function.BinaryOperator;

public class SortUtils {

    public static BinaryOperator<String> PINYIN_CHAR_BINARY_OPERATOR = (item, d) -> {
        int tempD = Integer.parseInt(d);
        String pinyin = SortUtils.getPinYinString(item);
        if (tempD < pinyin.length()) return String.valueOf((int) pinyin.charAt(tempD));
        return "-1";
    };

    public static BinaryOperator<String> STRING_CHAR_BINARY_OPERATOR = (item, d) -> {
        int tempD = Integer.parseInt(d);
        if (tempD < item.length()) return String.valueOf((int) item.charAt(tempD));
        return "-1";
    };


    public static String getPinYinString(String src) {

        StringBuilder pinyin = new StringBuilder();
        for (char c : src.toCharArray()) {
            pinyin.append(PinyinHelper.toHanyuPinyinStringArray(c)[0]);
        }
        return pinyin.toString();
    }


    public static int findMaxLengthPinyin(String[] strArr) {
        int maxLength = getPinYinString(strArr[0]).length();
        for (String str : strArr) {
            maxLength = Math.max(maxLength, getPinYinString(str).length());
        }

        return maxLength;
    }
}

