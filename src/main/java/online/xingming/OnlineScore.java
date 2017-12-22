package online.xingming;

import org.jsoup.nodes.Document;

import java.util.Map;

/**
 * Created by tumingjian on 2017/12/22.
 */
public interface OnlineScore {
    Map<String,String>  getRequestParam(); //获取请求参数
    String getScore();//获取分数
}
