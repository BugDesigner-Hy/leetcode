package lt3;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class Code3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        int i = solution1(s);
        System.out.println(i);

        int i1 = solution2(s);
        System.out.println(i1);
    }

    private static int solution1(String s){
        char[] chars = s.toCharArray();
        List<String> strList = new ArrayList<>();
        String tmp = "";
        int index = 0;
        while (index < chars.length) {
            for (int i = index; i < chars.length; i++) {
                char c = chars[i];
                String s1 = String.valueOf(c);
                if (tmp.contains(s1)) {
                    strList.add(tmp);
                    tmp = "";
                    index++;
                    break;
                } else {
                    tmp = tmp.concat(s1);
                }
            }
        }
        // System.out.println(strList);
        // strList.sort(Comparator.comparingInt(String::length));
        // System.out.println(strList.get(strList.size()-1));
        return strList.get(strList.size()-1).length();
    }

    private static int solution2(String s){
        char[] chars = s.toCharArray();
        String res = "";
        String tmp = "";
        int index = 0;
        while (index < chars.length) {
            System.out.println(res);
            for (int i = index; i < chars.length; i++) {
                String s1 = String.valueOf(chars[i]);
                if (tmp.contains(s1)) {
                    if(res.length()<tmp.length()){
                        res = tmp;
                    }
                    tmp = "";
                    index++;
                    break;
                } else {
                    tmp = tmp.concat(s1);
                }
            }
        }
        return res.length();
    }

    private static int  solution3(String s){
        return 0;
    }
}
