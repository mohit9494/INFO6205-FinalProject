package edu.neu.coe.info6205.util;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.text.Collator;
import java.util.Locale;
import java.util.function.UnaryOperator;

public class SortUtils {



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

