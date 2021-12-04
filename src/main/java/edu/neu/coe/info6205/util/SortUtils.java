package edu.neu.coe.info6205.util;

import net.sourceforge.pinyin4j.PinyinHelper;

public class SortUtils {


    public static String getPinYinString(String src) {

        try {
            StringBuilder pinyin = new StringBuilder();
            for (char c : src.toCharArray()) {
                pinyin.append(PinyinHelper.toHanyuPinyinStringArray(c)[0]);
            }
            return pinyin.toString();
        } catch (NullPointerException e) {
            return src;
        }

    }

}

