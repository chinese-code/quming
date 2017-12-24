package online.xingming;

import online.xingming.wuxinchar.WuxinProperty;

import java.util.List;

/**
 * Created by tumingjian on 2017/12/23.
 */
public class XinMing {
    private List<WuxinProperty> xinmingWuxins;
    private String xin;
    private String ming;
    private Double score;
    private Double wugeScore;
    public XinMing() {
    }

    public XinMing(List<WuxinProperty> xinmingWuxins, String xin, String ming, Double score, Double wugeScore) {
        this.xinmingWuxins = xinmingWuxins;
        this.xin = xin;
        this.ming = ming;
        this.score = score;
        this.wugeScore=wugeScore;
    }

    public List<WuxinProperty> getXinmingWuxins() {
        return xinmingWuxins;
    }

    public void setXinmingWuxins(List<WuxinProperty> xinmingWuxins) {
        this.xinmingWuxins = xinmingWuxins;
    }

    public String getXin() {
        return xin;
    }

    public void setXin(String xin) {
        this.xin = xin;
    }

    public String getMing() {
        return ming;
    }

    public void setMing(String ming) {
        this.ming = ming;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getWugeScore() {
        return wugeScore;
    }

    public void setWugeScore(Double wugeScore) {
        this.wugeScore = wugeScore;
    }
}
