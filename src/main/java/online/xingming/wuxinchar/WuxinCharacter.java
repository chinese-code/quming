package online.xingming.wuxinchar;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by tumingjian on 2017/12/23.
 */
public class WuxinCharacter extends HashMap<Wuxin, LinkedHashMap<Integer, List<String>>> {
    public WuxinCharacter() {
        InputStream wuxinhanzi = this.getClass().getResourceAsStream("/wuxinhanzi");
        try {
            List<String> haziList = IOUtils.readLines(wuxinhanzi, "utf-8");
            Map<Wuxin, List<String>> collect = haziList.stream().parallel()..collect(Collectors.groupingBy(i->Wuxin.get(i.charAt(0))));
            System.out.println(collect);
        } catch (Exception e) {

        }
    }

    public Map<Integer, List<String>> map(Integer key, String value) {
//LinkedHashMap<Integer,List<String>> map=new LinkedHashMap<Integer,List<String>>();
//List<String> collect = Stream.of(value.split("")).map(i -> i.toString()).collect(Collectors.toList());
//map.put(key,collect);
//return map;
        return null;
    }
}
