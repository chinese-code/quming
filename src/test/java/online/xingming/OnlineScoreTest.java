package online.xingming;

import online.xingming.wuxinchar.Wuxin;
import online.xingming.wuxinchar.WuxinCharacter;
import online.xingming.wuxinchar.WuxinProperty;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

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
        person.setXing("涂");
        person.setSex(1);
        person.setYear(2017);
        person.setMonth(12);
        person.setDay(8);
        person.setHour(2);
        person.setMinute(8);
        this.person = person;
    }

    @Test
    public void test2() {
        String wuxinHanziRandom = WuxinCharacter.getWuxinHanziRandom(Wuxin.火, 13);
        System.out.println(wuxinHanziRandom);
    }

    @Test
    public void findCharTest() {
        WuxinProperty result = WuxinCharacter.findHanzi("涂");
        System.out.println(result);
    }

    @Test
    public void singMingTest() {
        FullNameExecutor executor = new FullNameExecutor();
        List<XinMing> xinMings = executor.limitScore(90d).limitWugeScore(90d).yongshen(Wuxin.土).xishen(Wuxin.火)
                .person(person).singleMingSearch();
        System.out.println(xinMings);
    }

    @Test
    public void doubleMingTest() {
        FullNameExecutor executor = new FullNameExecutor();
        List<XinMing> xinMings = executor.limitScore(98d).limitWugeScore(90d).yongshen(Wuxin.火).xishen(Wuxin.土)
                .person(person).doubleMingSearch();
        System.out.println(xinMings);
    }

    @Test
    public void uncode() throws Exception {
//        System.out.println(new String("�Բ��������������룡".getBytes("GB2312"),"GBK"));
    }
}
