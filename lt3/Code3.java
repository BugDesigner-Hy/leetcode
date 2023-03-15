package lt3;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class Code3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        // int i = solution1(s);
        // System.out.println(i);
        //
        // int i1 = solution2(s);
        // System.out.println(i1);

        // int i2 = solution3(s);
        // System.out.println(i2);

        int i3 = solution4WithQueue(s);
        System.out.println(i3);
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

    /**
     * 	执行耗时:234 ms,击败了5.01% 的Java用户
     * 	内存消耗:42.4 MB,击败了5.09% 的Java用户
     * @param s
     * @return
     */
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

    /**
     * 滑动窗口
     * 	执行耗时:6 ms,击败了42.21% 的Java用户
     * 	内存消耗:41.3 MB,击败了86.95% 的Java用户
     * @param s
     * @return
     */
    private static int  solution3(String s){
        if(s.length()<2){
            return s.length();
        }
        HashSet<Character> container = new HashSet<>();
        int left = -1 , max = 0;
        for (int right = 0; right < s.length(); right++) {
            if(!container.isEmpty()){
                container.remove(s.charAt(right-1));
            }
            while (left + 1 < s.length() && !container.contains(s.charAt(left +1))){
                container.add(s.charAt(left+1));
                left++;
            }
            max = Math.max(max, container.size());
        }

        return max;
    }

    /**
     * 	执行耗时:27 ms,击败了14.87% 的Java用户
     * 	内存消耗:41.5 MB,击败了63.14% 的Java用户
     * @param s
     * @return
     */
    private static int  solution4WithQueue(String s){
        if(s.length()<2){
            return s.length();
        }
        Queue<Character> queue = new LinkedBlockingQueue<>(s.length());
        int left = -1 , max = 0;
        for (int right = 0; right < s.length(); right++) {
            if(!queue.isEmpty()){
                queue.poll();
            }
            while (left + 1 < s.length() && !queue.contains(s.charAt(left +1))){
                queue.offer(s.charAt(left+1));
                left++;
            }
            max = Math.max(max, queue.size());
        }

        return max;
    }

}
