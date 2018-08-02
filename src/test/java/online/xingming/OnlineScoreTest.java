package online.xingming;

import online.xingming.wuxinchar.Wuxin;
import online.xingming.wuxinchar.WuxinCharacter;
import online.xingming.wuxinchar.WuxinProperty;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by tumingjian on 2017/12/23.
 */
public class OnlineScoreTest {
    private Person person;
    private static Logger logger = Logger.getLogger(OnlineScoreTest.class);

    @Before
    public void initPerson() {
        Person person = new Person();
        person.setXing("何");
        person.setSex(1);
        person.setYear(2018);
        person.setMonth(1);
        person.setDay(18);
        person.setHour(9);
        person.setMinute(25);
        this.person = person;
    }

    @Test
    public void test2() {
        String wuxinHanziRandom = WuxinCharacter.getWuxinHanziRandom(Wuxin.木, 7);
        System.out.println(wuxinHanziRandom);
    }

    @Test
    public void findCharTest() {
        WuxinProperty result = WuxinCharacter.findHanzi("何");
        System.out.println(result);
    }

    @Test
    public void singMingTest() {
        FullNameExecutor executor = new FullNameExecutor();
        List<XinMing> xinMings = executor.limitScore(90d).limitWugeScore(90d).yongshen(Wuxin.木).xishen(Wuxin.水)
                .person(person).singleMingSearch();
        System.out.println(xinMings);
    }

    @Test
    public void doubleMingTest() {
        FullNameExecutor executor = new FullNameExecutor();
        List<XinMing> xinMings = executor.limitScore(98d).limitWugeScore(90d).yongshen(Wuxin.木).xishen(Wuxin.火)
                .person(person).doubleMingSearch();
        System.out.println(xinMings);
    }

    @Test
    public void uncode() throws Exception {
        InputStream resourceAsStream = OnlineScoreTest.class.getResourceAsStream("/wuxinhanzi");
        List<String> hanziLists = IOUtils.readLines(resourceAsStream);
    }
}
