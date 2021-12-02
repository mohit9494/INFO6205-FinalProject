package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.FileReader;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Sai Akhil
 */
public class ThreeWayRadixQuickSortTest {
    @Test
    public void sortInteger0(){
        int n = 20;
        Integer[] input = new Integer[]{4,3,5,6,1};
        Integer[] expected = Arrays.copyOf(input,input.length);
        Arrays.sort(expected);
        new ThreeWayRadixQuicksort<Integer>().sort(input);
        assertArrayEquals(expected,input);
    }

    @Test
    public void sortEnglish0(){
        String[] input = new String[]{"c","b","a","f","d","e"};
        String[] expected = new String[]{"a","b","c","d","e","f"};
        new ThreeWayRadixQuicksort<>(ThreeWayRadixQuicksort.getStringCharOperator()).sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortEnglish1(){
        String[] input = "she sells seashells by the seashore the shells she sells are surely seashells".split(" ");
        String[] expected = "are by seashells seashells seashore sells sells she she shells surely the the".split(" ");
        new ThreeWayRadixQuicksort<>(ThreeWayRadixQuicksort.getStringCharOperator()).sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortEnglish2(){
        String[] input = "she sells seashells seashore shells she sells surely seashells".split(" ");
        String[] expected = "seashells seashells seashore sells sells she she shells surely".split(" ");
        new ThreeWayRadixQuicksort<>(ThreeWayRadixQuicksort.getStringCharOperator()).sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortChineese0() throws URISyntaxException, IOException {
        String[] k = FileReader.fileReader("shuffledChinese.txt");
        String[] a = FileReader.fileReader("sortedChinese.txt");
        new ThreeWayRadixQuicksort<>(ThreeWayRadixQuicksort.getPinyinCharOperator()).sort(k);
        assertArrayEquals(a, k);
    }

    @Test
    public void sortTelugu0() {
        String[] k = new String[]{"శుభోదయం","నమస్కారం","రాత్రి","నమస్కారం","శుభోదయం"};
        String[] a = new String[]{"నమస్కారం","నమస్కారం","రాత్రి","శుభోదయం","శుభోదయం"};
        new ThreeWayRadixQuicksort<>(ThreeWayRadixQuicksort.getStringCharOperator()).sort(k);
        assertArrayEquals(a, k);
    }
}
