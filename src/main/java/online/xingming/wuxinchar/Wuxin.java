package online.xingming.wuxinchar;

/**
 * Created by tumingjian on 2017/12/23.
 */
public enum Wuxin {
    金,木,水,火,土;
    public static Wuxin get(String str){
        if(金.toString().equals(str)){
            return 金;
        }
        if(木.toString().equals(str)){
            return 木;
        }
        if(水.toString().equals(str)){
            return 水;
        }
        if(火.toString().equals(str)){
            return 火;
        }
        if(土.toString().equals(str)){
            return 土;
        }
        return null;
    }
    public static Wuxin get(char c){
        return get(String.valueOf(c));
    }
}
