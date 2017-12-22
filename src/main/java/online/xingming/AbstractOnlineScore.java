package online.xingming;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by tumingjian on 2017/12/23.
 */
public abstract class AbstractOnlineScore implements OnlineScore {
    protected String url;
    protected Person person;
    protected Document document;
    public AbstractOnlineScore(Person person){
        this.person=person;
    }
    protected OnlineScore post(){
        try{
            Map<String, String> requestParam = getRequestParam();
            Document post = Jsoup.connect(url).data(requestParam).post();
            this.document=post;
        }catch (Exception e){
            e.printStackTrace();
        }
        return this;
    }
    public String getURL() {
        return this.url;
    }
}
