package online.xingming;

import com.alibaba.fastjson.JSON;
import online.xingming.impl.XingmingOnlineScore;
import online.xingming.wuxinchar.Wuxin;
import online.xingming.wuxinchar.WuxinCharacter;
import online.xingming.wuxinchar.WuxinProperty;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tumingjian on 2017/12/23.
 */
public class OnlineScoreTest {
    private Person person;
    private static Logger logger= Logger.getLogger(OnlineScoreTest.class);
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
        String wuxinHanziRandom = WuxinCharacter.getWuxinHanziRandom(Wuxin.火, 13);
        System.out.println(wuxinHanziRandom);
    }

    @Test
    public void findCharTest() {
        WuxinProperty result = WuxinCharacter.findHanzi("涂");
        System.out.println(result);
    }
    @Test
    public void xingmingTest(){
        List<XingMing> xingmings =new ArrayList<>();
        for(int i=0;i<30;i++){
            String mingzi = WuxinCharacter.getWuxinHanziRandom(Wuxin.土, i);
            if(mingzi==null)continue;
            Person person = new Person();
            person.setXing("涂");
            person.setSex(1);
            person.setYear(2017);
            person.setMonth(12);
            person.setDay(8);
            person.setHour(2);
            person.setMinute(8);
            person.setMing(mingzi);
           XingMing p = XingmingExecutor.getXingming(person, XingmingOnlineScore.class);
            if(p!=null){
                if(p.getScore()>=80 && p.getWugeScore()>=80){
                    logger.info(MessageFormat.format("姓名:{0},五格分数:{1},八字配合分数:{2}",p.getXing()+p.getMing(),p.getWugeScore(),p.getScore()));
                    p.getXingmingWuxins().forEach(j->{
                        logger.info(MessageFormat.format("汉字:{0},五行属性:{1},笔画数:{2}", j.getHazi(), j.getWuxin(), j.getHuashu()));
                    });
                }
            }
            xingmings.add(p);
        }
    }

    @Test
    public void uncode()throws Exception{
//        System.out.println(new String("�Բ��������������룡".getBytes("GB2312"),"GBK"));
    }
}
