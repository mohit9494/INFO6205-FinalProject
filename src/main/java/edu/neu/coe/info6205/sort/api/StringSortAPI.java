package edu.neu.coe.info6205.sort.api;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.jetbrains.annotations.NotNull;

import java.util.function.UnaryOperator;

/**
 * @author Sai Akhil
 */
public abstract class StringSortAPI extends SortAPI<String> {

    protected String getCustomStringFromOperator(@NotNull String s) {
        return (this.getUnaryOperator() == null) ? s : this.getUnaryOperator().apply(s);
    }

    public static final UnaryOperator<String> PINYIN_STRING_SUPPLIER = (str) -> {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            stringBuilder.append(PinyinHelper.toHanyuPinyinStringArray(c)[0]);
        }
        return stringBuilder.toString();
    };


}
