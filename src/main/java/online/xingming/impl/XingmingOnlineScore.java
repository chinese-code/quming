package online.xingming.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import online.xingming.AbstractOnlineScore;
import online.xingming.Person;

import java.util.Map;

/**
 * Created by tumingjian on 2017/12/23.
 */
public class XingmingOnlineScore extends AbstractOnlineScore{
    protected String url="http://life.httpcn.com/xingming.asp";
    public XingmingOnlineScore(Person person){
        super(person);
    }
    public Map<String, String> getRequestParam() {
        String s = JSON.toJSONString(person);
        Map<String, String> data = JSON.parseObject(s, new TypeReference<Map<String, String>>() {});
        data.put("act","submit");
        data.put("data_type","0");
        data.put("isbz","1");
        return data;
    }
    public String getScore() {
        post();
        String s = this.document.body().toString();
        System.out.println(s);
        return s;
    }
}
