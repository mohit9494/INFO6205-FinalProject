package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.sort.huskysort.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.huskysort.PureHuskySort;
import edu.neu.coe.info6205.util.FileReader;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;

public class HuskySortTest {
    @Test
    public void sortChinese99(){
        String[] expected = new String[]{"阿安","阿彬","阿兵","阿冰冰","阿晨","阿称","阿丛","阿丹丹","阿德力","阿迪迪","阿迪江","阿迪雅","阿栋","阿繁","阿方","阿菲","阿飞儿","阿飞飞","阿芬","阿丰","阿夏","阿鲜","阿湘","阿晓","阿新","阿行","阿旭","阿轩","乔江","乔娇",};
        String[] input = Arrays.copyOf(expected,expected.length);
        Collections.shuffle(Arrays.asList(input));
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortChinese98() {
        String[] expected = new String[]{"阿芬", "阿丰", "阿夏", "阿鲜", "阿湘", "阿晓", "阿新", "阿行", "阿旭", "阿轩", "乔江", "乔娇"};
        String[] input = Arrays.copyOf(expected, expected.length);
        Collections.shuffle(Arrays.asList(input));
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortChineseFile1() throws URISyntaxException, IOException {
        String[] input = FileReader.fileReader("shuffledChinese.txt");
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input);
        assert input[0].equals("阿安");
        assert input[40].equals("阿绯");
        assert input[100].equals("阿桔");
    }

    @Test
    public void sortChinese97() {
        String[] expected = new String[]{"阿芬", "阿丰", "阿夏", "阿鲜", "阿湘", "阿晓"};
        String[] input = Arrays.copyOf(expected, expected.length);
        Collections.shuffle(Arrays.asList(input));
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortEnglish1() {
        String[] input = "she sells seashells by the seashore the shells she sells are surely seashells".split(" ");
        String[] expected = "are by seashells seashells seashore sells sells she she shells surely the the".split(" ");
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortEnglish2() {
        String[] input = "she sells seashells seashore shells she sells surely seashells".split(" ");
        String[] expected = "seashells seashells seashore sells sells she she shells surely".split(" ");
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortEnglishFile3() throws URISyntaxException, IOException {
        String[] input = FileReader.fileReader("ENG_1M.txt");
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input);
        assert input[0].equals("1\t!\t25992");
        assert input[100].equals("100087\t7i\t3");
        assert input[800].equals("100717\tAldebaran\t3");
    }

    @Test
    public void sortTelugu0() {
        String[] expected = new String[]{"అంటూ", "అడగ్గా", "అతిథిగా", "అది", "అనిల్", "అనిల్", "అన్నారు", "అన్‌స్టాపబుల్‌", "అలరించార", "ఆట", "ఆడుకున్నారు", "ఇద్దరితో", "ఈ", "ఈ", "ఈ", "ఎందుకో", "ఏది", "ఓ", "ఓ", "ఓ", "కార్యక్రమ", "కార్యక్రమానికి", "కోప్పడ్డారు", "చూపించి", "చేశారు", "తనకెంత", "తీసుకొచ్చిన", "దర్శకుడు", "దీన్ని", "దేనికి", "నటుడు", "నవ్వులు", "పంచారు", "పడితే", "పేరు", "ఫొటోను", "బాలకృష్ణ", "బాలకృష్ణ", "బాలకృష్ణ", "బాలకృష్ణ", "బ్రహ్మానందం", "బ్రహ్మానందం", "బ్రహ్మానందంపై", "మరో", "మాంచి", "రావిపూడి", "రావిపూడి", "విచ్చేసి", "వినోదం", "సంభాషించారు", "సమాధానం"};
        String[] input = Arrays.copyOf(expected, expected.length);
        Collections.shuffle(Arrays.asList(input));
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortTelugu2() {
        String[] expected = new String[]{"అనిల్", "అన్నారు", "అన్‌స్టాపబుల్‌", "అలరించార", "ఆట", "ఆడుకున్నారు", "ఇద్దరితో", "ఈ", "ఈ", "ఈ", "ఎందుకో", "ఏది", "ఓ", "ఓ", "ఓ", "చూపించి", "చేశారు", "తనకెంత", "తీసుకొచ్చిన", "దర్శకుడు", "దీన్ని", "దేనికి", "నటుడు", "నవ్వులు", "పంచారు", "పడితే", "బాలకృష్ణ", "బాలకృష్ణ", "బ్రహ్మానందం", "బ్రహ్మానందం", "బ్రహ్మానందంపై", "మరో", "మాంచి", "రావిపూడి", "రావిపూడి", "విచ్చేసి", "వినోదం", "సంభాషించారు", "సమాధానం"};
        String[] input = Arrays.copyOf(expected, expected.length);
        Collections.shuffle(Arrays.asList(input));
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortTeluguFile3() throws URISyntaxException, IOException {
        String[] input = FileReader.fileReader("Telugu_1K.txt");
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input);
        assert input[0].equals("అంగ్రేజోన్");
        assert input[10].equals("అందుబాటు");
        assert input[83].equals("అవుతా");
        assert input[200].equals("ఎల్");
        assert input[500].equals("తెస్తాడు");
    }
}
