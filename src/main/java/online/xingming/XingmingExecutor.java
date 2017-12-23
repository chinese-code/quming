package online.xingming;

import com.alibaba.fastjson.JSON;
import online.xingming.wuxinchar.WuxinCharacter;
import online.xingming.wuxinchar.WuxinProperty;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by tumingjian on 2017/12/23.
 */
public class XingmingExecutor {
    private static Logger logger = Logger.getLogger(XingmingExecutor.class);

    /**
     * @param person
     * @param classes
     * @return 名字的与分数;
     */
    public static XingMing getXingming(Person person, Class<? extends AbstractOnlineScore> classes) {
        try {
            Constructor<? extends OnlineScore> constructor = classes.getConstructor(Person.class);
            OnlineScore onlineScore = constructor.newInstance(person);
            String mingzi = person.getXing() + person.getMing();
            List<String> xingming = Arrays.asList(mingzi.split(""));
            List<WuxinProperty> collect = xingming.parallelStream().map(WuxinCharacter::findHanzi).peek(p -> {
//                logger.info(MessageFormat.format("汉字:{0},五行属性:{1},笔画数:{2}", p.getHazi(), p.getWuxin(), p.getHuashu()));
            }).collect(Collectors.toList());
            Double score = onlineScore.getScore();
            Double wugeScore = onlineScore.getWugeScore();
//            logger.info(MessageFormat.format("姓名:{0},总分数:{1},五行与笔画:{2}", mingzi, score, JSON.toJSONString(collect)));
            return new XingMing(collect,person.getXing(),person.getMing(),score,wugeScore);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
