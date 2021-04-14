package com.onestep.mall.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. 根据字符出现频率排序
 *
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class aa {
    public static void  main(String[] args){
        String a = "aBBAsawqeqdadaa";
        char[] chars = a.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c:chars) {
            map.merge(c, 1, Integer::sum);
        }
        System.out.println(map);

        StringBuilder res = new StringBuilder();
        Map<Character, Integer> tmp = new HashMap<>(map);
        for (int i = 0; i < a.length(); i++) {
            for (char c: tmp.keySet()) {
                tmp.put(c, tmp.get(c) - 1);
                if (tmp.get(c) == 0) {
                    for (int j = 0; j < map.get(c); j++) {
                        res.append(c);
                    }
                }
            }
        }

        System.out.println(res.reverse().toString());

        PriorityQueue<Character> queue = new PriorityQueue<>((c, b)->(map.get(b)-map.get(c)));
        queue.addAll(map.keySet());
        StringBuilder str=new StringBuilder();
        while(!queue.isEmpty()){
            char c=queue.poll();
            int count=map.get(c);
            for(int i=0;i<count;i++)
                str.append(c);
        }
        System.out.println(str);

    }
}
