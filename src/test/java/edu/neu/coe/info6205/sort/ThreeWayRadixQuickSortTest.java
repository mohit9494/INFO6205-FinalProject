package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.sort.api.StringSortAPI;
import edu.neu.coe.info6205.util.FileReader;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Sai Akhil
 */
public class ThreeWayRadixQuickSortTest {

    @Test
    public void sortEnglish0(){
        String[] input = new String[]{"c","b","a","f","d","e"};
        String[] expected = new String[]{"a","b","c","d","e","f"};
        new ThreeWayRadixQuicksort<String>().sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortEnglish1(){
        String[] input = "she sells seashells by the seashore the shells she sells are surely seashells".split(" ");
        String[] expected = "are by seashells seashells seashore sells sells she she shells surely the the".split(" ");
        new ThreeWayRadixQuicksort<String>().sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortEnglish2() {
        String[] input = "she sells seashells seashore shells she sells surely seashells".split(" ");
        String[] expected = "seashells seashells seashore sells sells she she shells surely".split(" ");
        new ThreeWayRadixQuicksort<String>().sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortEnglishFile3() throws URISyntaxException, IOException {
        String[] input = FileReader.fileReader("ENG_1M.txt");
        new ThreeWayRadixQuicksort<String>().sort(input);
        assert input[0].equals("1\t!\t25992");
        assert input[100].equals("100087\t7i\t3");
        assert input[800].equals("100717\tAldebaran\t3");
    }


    @Test
    public void sortChinese0() {
        String[] expected = new String[]{"阿安", "阿彬", "阿兵", "阿冰冰", "阿晨", "阿称", "阿丛", "阿丹丹", "阿德力", "阿迪迪", "阿迪江", "阿迪雅", "阿栋", "阿繁", "阿方", "阿菲", "阿飞儿", "阿飞飞", "阿芬", "阿丰", "阿夏", "阿鲜", "阿湘", "阿晓", "阿新", "阿行", "阿旭", "阿轩", "乔建雄", "乔建业", "乔建永", "乔建云", "乔建珍", "乔建忠", "乔江", "乔江涛", "乔娇", "乔娇娇"};
        String[] input = Arrays.copyOf(expected, expected.length);
        Collections.shuffle(Arrays.asList(input));
        new ThreeWayRadixQuicksort<String>()
                .withUnaryOperator(StringSortAPI.PINYIN_STRING_SUPPLIER)
                .sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortChineseInsertion1() {
        String[] expected = new String[]{"阿彬", "阿兵", "阿称", "阿栋", "阿菲", "阿芬", "阿丰", "阿晓", "阿新", "乔江", "乔江涛", "乔娇", "乔娇娇"};
        String[] input = Arrays.copyOf(expected, expected.length);
        Collections.shuffle(Arrays.asList(input));
        new ThreeWayRadixQuicksort<String>()
                .withUnaryOperator(StringSortAPI.PINYIN_STRING_SUPPLIER)
                .sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortChinese2() {
        String[] expected = new String[]{"阿安", "阿彬", "阿兵", "阿冰冰", "阿晨", "阿称", "阿丛", "阿栋", "阿繁", "阿方", "阿菲", "阿丰", "阿夏", "阿鲜", "阿行", "阿旭", "阿轩", "乔建雄", "乔建珍", "乔建忠", "乔江", "乔江涛", "乔娇", "乔娇娇"};
        String[] input = Arrays.copyOf(expected, expected.length);
        Collections.shuffle(Arrays.asList(input));
        new ThreeWayRadixQuicksort<String>()
                .withUnaryOperator(StringSortAPI.PINYIN_STRING_SUPPLIER)
                .sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortChineseFile1() throws URISyntaxException, IOException {
        String[] input = FileReader.fileReader("shuffledChinese.txt");
        new ThreeWayRadixQuicksort<String>()
                .withUnaryOperator(StringSortAPI.PINYIN_STRING_SUPPLIER)
                .sort(input);
        assert input[0].equals("阿安");
        assert input[40].equals("阿绯");
        assert input[180].equals("阿念");
    }

    @Test
    public void sortTelugu0() {
        String[] expected = new String[]{"అంటూ", "అడగ్గా", "అతిథిగా", "అది", "అనిల్", "అనిల్", "అన్నారు", "అన్‌స్టాపబుల్‌", "అలరించార", "ఆట", "ఆడుకున్నారు", "ఇద్దరితో", "ఈ", "ఈ", "ఈ", "ఎందుకో", "ఏది", "ఓ", "ఓ", "ఓ", "కార్యక్రమ", "కార్యక్రమానికి", "కోప్పడ్డారు", "చూపించి", "చేశారు", "తనకెంత", "తీసుకొచ్చిన", "దర్శకుడు", "దీన్ని", "దేనికి", "నటుడు", "నవ్వులు", "పంచారు", "పడితే", "పేరు", "ఫొటోను", "బాలకృష్ణ", "బాలకృష్ణ", "బాలకృష్ణ", "బాలకృష్ణ", "బ్రహ్మానందం", "బ్రహ్మానందం", "బ్రహ్మానందంపై", "మరో", "మాంచి", "రావిపూడి", "రావిపూడి", "విచ్చేసి", "వినోదం", "సంభాషించారు", "సమాధానం"};
        String[] input = Arrays.copyOf(expected, expected.length);
        Collections.shuffle(Arrays.asList(input));
        new ThreeWayRadixQuicksort<String>().sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortTeluguInsertionCut1() {
        String[] expected = new String[]{"అన్‌స్టాపబుల్‌","అలరించార","ఆట","ఆడుకున్నారు","ఇద్దరితో","ఈ","చూపించి","దేనికి","నటుడు","నవ్వులు","మరో","మాంచి","విచ్చేసి","సమాధానం"};
        String[] input = Arrays.copyOf(expected,expected.length);
        Collections.shuffle(Arrays.asList(input));
        new ThreeWayRadixQuicksort<String>().sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortTelugu2() {
        String[] expected = new String[]{"అనిల్", "అన్నారు", "అన్‌స్టాపబుల్‌", "అలరించార", "ఆట", "ఆడుకున్నారు", "ఇద్దరితో", "ఈ", "ఈ", "ఈ", "ఎందుకో", "ఏది", "ఓ", "ఓ", "ఓ", "చూపించి", "చేశారు", "తనకెంత", "తీసుకొచ్చిన", "దర్శకుడు", "దీన్ని", "దేనికి", "నటుడు", "నవ్వులు", "పంచారు", "పడితే", "బాలకృష్ణ", "బాలకృష్ణ", "బ్రహ్మానందం", "బ్రహ్మానందం", "బ్రహ్మానందంపై", "మరో", "మాంచి", "రావిపూడి", "రావిపూడి", "విచ్చేసి", "వినోదం", "సంభాషించారు", "సమాధానం"};
        String[] input = Arrays.copyOf(expected, expected.length);
        Collections.shuffle(Arrays.asList(input));
        new ThreeWayRadixQuicksort<String>().sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortTeluguFile3() throws URISyntaxException, IOException {
        String[] input = FileReader.fileReader("Telugu_1K.txt");
        new ThreeWayRadixQuicksort<String>().sort(input);
        assert input[0].equals("అంగ్రేజోన్");
        assert input[10].equals("అందుబాటు");
        assert input[83].equals("అవుతా");
        assert input[200].equals("ఎల్");
        assert input[500].equals("తెస్తాడు");
    }


}
