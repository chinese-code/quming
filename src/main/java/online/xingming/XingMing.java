package online.xingming;

import online.xingming.wuxinchar.WuxinProperty;

import java.util.List;

/**
 * Created by tumingjian on 2017/12/23.
 */
public class XingMing {
    private List<WuxinProperty> xingmingWuxins;
    private String xing;
    private String ming;
    private Double score;
    private Double wugeScore;
    public XingMing() {
    }

    public XingMing(List<WuxinProperty> xingmingWuxins, String xing, String ming, Double score,Double wugeScore) {
        this.xingmingWuxins = xingmingWuxins;
        this.xing = xing;
        this.ming = ming;
        this.score = score;
        this.wugeScore=wugeScore;
    }

    public List<WuxinProperty> getXingmingWuxins() {
        return xingmingWuxins;
    }

    public void setXingmingWuxins(List<WuxinProperty> xingmingWuxins) {
        this.xingmingWuxins = xingmingWuxins;
    }

    public String getXing() {
        return xing;
    }

    public void setXing(String xing) {
        this.xing = xing;
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
