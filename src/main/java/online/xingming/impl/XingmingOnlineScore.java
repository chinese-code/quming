package online.xingming.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import online.xingming.AbstractOnlineScore;
import online.xingming.Person;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by tumingjian on 2017/12/23.
 */
public class XingmingOnlineScore extends AbstractOnlineScore {
    private Double wugeScore;
    private Double score;

    public XingmingOnlineScore(Person person) {
        super(person);
        this.url = "http://m.life.httpcn.com/m/xingming";
        post();
    }

    public Map<String, String> getRequestParam() {
        String s = JSON.toJSONString(person);
        Map<String, String> data = JSON.parseObject(s, new TypeReference<Map<String, String>>() {
        });
        data.put("act", "submit");
        data.put("data_type", "0");
        data.put("isbz", "1");
        data.put("RenYue", "0");
        return data;
    }

    public void post() {
        try {
            Map<String, String> requestParam = getRequestParam();
//            Thread.sleep(1000);
            this.header.put(" User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1");
            Document post = Jsoup.connect(this.url).data(requestParam).cookies(cookies).headers(this.header).post();
            this.document = post;
            List<String> strings = this.document.body().select(".progress-bar").eachText();
            this.score = Double.valueOf(strings.get(1).replace("分", "").trim());
            this.wugeScore = Double.valueOf(strings.get(0).replace("分", "").trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Double getScore() {
        return this.score;
    }

    @Override
    public Double getWugeScore() {
        return this.wugeScore;
    }
}
