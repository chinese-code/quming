package online.xingming;

import online.xingming.wuxinchar.WuxinCharacter;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by tumingjian on 2017/12/23.
 */
public class OnlineScoreTest {
    private Person person;

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
    public void test2(){
        WuxinCharacter jingCharacter=new WuxinCharacter();
    }

    @Test
    public void xingming() {

    }
}
