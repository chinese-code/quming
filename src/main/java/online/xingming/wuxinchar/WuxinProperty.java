package online.xingming.wuxinchar;

import java.io.Serializable;

/**
 * Created by tumingjian on 2017/12/23.
 */
public class WuxinProperty implements Serializable {
    private String hazi;
    private Wuxin wuxin;
    private Integer huashu;

    public WuxinProperty(String haizi,Wuxin wuxin, Integer huashu) {
        this.hazi=haizi;
        this.wuxin = wuxin;
        this.huashu = huashu;
    }

    public Wuxin getWuxin() {
        return wuxin;
    }

    public Integer getHuashu() {
        return huashu;
    }

    public String getHazi() {
        return hazi;
    }
}
