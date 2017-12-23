package online.xingming;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by tumingjian on 2017/12/23.
 */
public abstract class AbstractOnlineScore implements OnlineScore {
    protected String url;
    protected Person person;
    protected Document document;
    protected  Map<String,String> cookies=new HashMap<>();
    protected  Map<String,String> header=new HashMap<>();
    public AbstractOnlineScore(Person person){
        this.person=person;
    }
    public String getURL() {
        return this.url;
    }

    public void header(String str) {
        this.header.put(str.split(":")[0], str.split(":")[1]);
    }
}
