package edu.neu.coe.info6205.sort.api;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.UnaryOperator;

/**
 * @author Sai Akhil
 */
public abstract class StringSortAPI extends SortAPI<String> {

    protected int getCharAtPosition(@NotNull String str, int charPosition, @Nullable UnaryOperator<String> stringSupplier) {
        String currentStr = (stringSupplier != null) ? stringSupplier.apply(str) : str;
        return (charPosition >= currentStr.length()) ? 0 : currentStr.charAt(charPosition);
    }

    protected String getCustomStringFromOperator(String s) {
        return (this.getOperator() == null) ? s : this.getOperator().apply(s);
    }

    public static final UnaryOperator<String> PINYIN_STRING_SUPPLIER = (str) -> {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            stringBuilder.append(PinyinHelper.toHanyuPinyinStringArray(c)[0]);
        }
        return stringBuilder.toString();
    };

}
