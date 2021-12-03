package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.FileReader;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Sai Akhil
 */
public class MSDStringSortTest {
    @Test
    public void sortEnglish0(){
        String[] input = new String[]{"c","b","a","f","d","e"};
        String[] expected = new String[]{"a","b","c","d","e","f"};
        new MSDStringSort(input.length,ThreeWayRadixQuicksort.getStringCharOperator())
                .withInsertionSortMSDOperator(InsertionSortMSD.getStringBinaryOperator())
                .sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortEnglish1(){
        String[] input = "she sells seashells by the seashore the shells she sells are surely seashells".split(" ");
        String[] expected = "are by seashells seashells seashore sells sells she she shells surely the the".split(" ");
        new MSDStringSort(input.length,ThreeWayRadixQuicksort.getStringCharOperator())
                .withInsertionSortMSDOperator(InsertionSortMSD.getStringBinaryOperator())
                .sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortEnglish2(){
        String[] input = "she sells seashells seashore shells she sells surely seashells".split(" ");
        String[] expected = "seashells seashells seashore sells sells she she shells surely".split(" ");
        new MSDStringSort(input.length,ThreeWayRadixQuicksort.getStringCharOperator())
                .withInsertionSortMSDOperator(InsertionSortMSD.getStringBinaryOperator())
                .sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortChinese0() throws URISyntaxException, IOException {
        String[] k = FileReader.fileReader("shuffledChinese.txt");
        String[] a = FileReader.fileReader("sortedChinese.txt");
        new MSDStringSort(k.length,ThreeWayRadixQuicksort.getPinyinCharOperator())
                .withInsertionSortMSDOperator(InsertionSortMSD.getPinYinStringBinaryOperator())
                .sort(k);
        assertArrayEquals(a, k);
    }

    @Test
    public void sortTelugu0() {
        String[] k = new String[]{"శుభోదయం","నమస్కారం","రాత్రి","నమస్కారం","శుభోదయం"};
        String[] a = new String[]{"నమస్కారం","నమస్కారం","రాత్రి","శుభోదయం","శుభోదయం"};
        new MSDStringSort(k.length,ThreeWayRadixQuicksort.getStringCharOperator())
                .withInsertionSortMSDOperator(InsertionSortMSD.getStringBinaryOperator())
                .sort(k);
        assertArrayEquals(a, k);
    }
}
