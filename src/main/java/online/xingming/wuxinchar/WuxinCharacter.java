package online.xingming.wuxinchar;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by tumingjian on 2017/12/23.
 */
public class WuxinCharacter {
    private static Map<Wuxin, Map<Integer, String>> collect = new HashMap<Wuxin, Map<Integer, String>>();
    private static List<String> charList = new ArrayList<>();

    static {
        loadData();
    }

    /**
     * 载入数据.
     */
    private static void loadData() {
        InputStream inputStream = WuxinCharacter.class.getResourceAsStream("/wuxinhanzi");
        try {
            charList = IOUtils.readLines(inputStream, "utf-8");
            collect = charList.parallelStream().map(i -> i.replaceAll("(^[\\S]{1})", "$1:").split(":"))
                    .sequential().collect(Collectors.groupingBy(i -> Wuxin.get(i[0]),
                                    Collectors.groupingBy(i -> Integer.valueOf(i[1]),
                                            Collectors.mapping(i -> i[2], Collectors.joining()))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getWuxinHanzi(Wuxin wuxin, Integer huashu) {
        return collect.get(wuxin).get(huashu);
    }

    public static List<String> getWuxinHanziToList(Wuxin wuxin, Integer huashu) {
        String s = collect.get(wuxin).get(huashu);
        if (s != null) {
            return Stream.of(s.split("")).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    public static String getWuxinHanzi(Wuxin wuxin, Integer huashu, Integer index) {
        List<String> wuxinHanziToList = getWuxinHanziToList(wuxin, huashu);
        return wuxinHanziToList != null && wuxinHanziToList.size() > index ? wuxinHanziToList.get(index) : null;
    }

    public static String getWuxinHanziRandom(Wuxin wuxin, Integer huashu) {
        List<String> wuxinHanziToList = getWuxinHanziToList(wuxin, huashu);
        if (wuxinHanziToList != null) {
            Random random = new Random(System.currentTimeMillis());
            int size = wuxinHanziToList.size();
            int index = random.nextInt(size) % (size + 1);
            return wuxinHanziToList.get(index);
        }
        return null;
    }

    public static WuxinProperty findHanzi(String str) {
        List<WuxinProperty> result = charList.parallelStream()
                .filter(i -> i.contains(str)).map(i -> i.split(":")[0])
                .map(i -> new WuxinProperty(str,Wuxin.get(i.charAt(0)), Integer.valueOf(i.replaceAll("[\\S](\\d*)", "$1"))))
                .collect(Collectors.toList());
        return result != null && result.size() > 0 ? result.get(0) : null;
    }
}
