package online.xingming;

import com.alibaba.fastjson.JSON;
import online.xingming.impl.XingmingOnlineScore;
import online.xingming.wuxinchar.Wuxin;
import online.xingming.wuxinchar.WuxinCharacter;
import online.xingming.wuxinchar.WuxinProperty;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 姓名分数匹配.
 * Created by tumingjian on 2017/12/23.
 */
public class FullNameExecutor {
    private static Logger logger = Logger.getLogger(FullNameExecutor.class);
    private Person person;  //人的基本信息
    private Double wugeScoure = 0d;  //名字的五格分数
    private Double score = 0d;  //五行八字配合分数(最重要)
    private Wuxin xishen;  //喜神
    private Wuxin yongshen; //用神

    /**
     * 五格最低分数
     * @param score
     * @return
     */
    public FullNameExecutor limitWugeScore(Double score) {
        this.wugeScoure = score;
        return this;
    }

    /**
     * 五行八字最低分数
     * @param score
     * @return
     */
    public FullNameExecutor limitScore(Double score) {
        this.score = score;
        return this;
    }

    /**
     * 喜神
     * @param xishen
     * @return
     */
    public FullNameExecutor xishen(Wuxin xishen) {
        this.xishen = xishen;
        return this;
    }

    /**
     * 用神
     * @param yongshen
     * @return
     */
    public FullNameExecutor yongshen(Wuxin yongshen) {
        this.yongshen = yongshen;
        return this;
    }

    /**
     * 小孩基本信息
     * @param person
     * @return
     */
    public FullNameExecutor person(Person person) {
        this.person = person;
        return this;
    }

    /**
     * @param person
     * @param classes
     * @return 名字的分数;
     */
    public static XinMing getXinming(Person person, Class<? extends AbstractOnlineScore> classes) {
        try {
            Constructor<? extends OnlineScore> constructor = classes.getConstructor(Person.class);
            OnlineScore onlineScore = constructor.newInstance(person);
            String mingzi = person.getXing() + person.getMing();
            List<String> xingming = Arrays.asList(mingzi.split(""));
            //查找姓名的五行属性.
            List<WuxinProperty> collect = xingming.parallelStream().map(WuxinCharacter::findHanzi).peek(p -> {
//                logger.info(MessageFormat.format("汉字:{0},五行属性:{1},笔画数:{2}", p.getHazi(), p.getWuxin(), p.getHuashu()));
            }).collect(Collectors.toList());
            //获取五行八字匹配分数
            Double score = onlineScore.getScore();
            //获取五格分数
            Double wugeScore = onlineScore.getWugeScore();
//            logger.info(MessageFormat.format("姓名:{0},总分数:{1},五行与笔画:{2}", mingzi, score, JSON.toJSONString(collect)));
            return new XinMing(collect, person.getXing(), person.getMing(), score, wugeScore);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 单名字查询.
     * @return
     */
    public List<XinMing> singleMingSearch() {
        List<XinMing> xingmings = new ArrayList<>();
        if (yongshen != null || xishen != null) {
            for (int i = 0; i < 30; i++) {
                String mingzi = WuxinCharacter.getWuxinHanziRandom(yongshen == null ? xishen : yongshen, i);
                if (mingzi == null) continue;
                Person person = JSON.parseObject(JSON.toJSONString(this.person), Person.class);
                person.setMing(mingzi);
                XinMing p = eachXinming(person);
                xingmings.add(p);
            }
        } else {
            throw new RuntimeException("喜神和用神必须选填一个");
        }
        return xingmings;
    }

    /**
     * 双名字查询
     * @return
     */
    public List<XinMing> doubleMingSearch() {
        List<XinMing> xinmings = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            String mingzi = WuxinCharacter.getWuxinHanziRandom(yongshen, i);
            if (mingzi == null) continue;
            for (int j = 0; j < 30; j++) {
                String zi = WuxinCharacter.getWuxinHanziRandom(xishen, j);
                if (zi == null) continue;
                Person person = JSON.parseObject(JSON.toJSONString(this.person), Person.class);
                person.setMing(mingzi+zi);
                XinMing p = eachXinming(person);
                xinmings.add(p);
            }
        }
        return xinmings;
    }

    private XinMing eachXinming(Person person) {
        XinMing p = FullNameExecutor.getXinming(person, XingmingOnlineScore.class);
        if (p != null && p.getScore()!=null && p.getWugeScore()!=null) {
            if (p.getScore() >= score && p.getWugeScore() >= wugeScoure) {
                System.out.println(MessageFormat.format("姓名:{0},五格分数:{1},八字配合分数:{2}", p.getXin() + p.getMing(), p.getWugeScore(), p.getScore()));
                p.getXinmingWuxins().forEach(j -> {
                    System.out.println(MessageFormat.format("汉字:{0},五行属性:{1},笔画数:{2}", j.getHazi(), j.getWuxin(), j.getHuashu()));
                });
            }
        }
        return p;
    }
}
