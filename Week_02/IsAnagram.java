package Week_02;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    //HashMap用起来
    //时间复杂度为O(m+n)。空间复杂度为O(m+n)
    public static boolean isAnagram01(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> charMap1 = new HashMap<>((int) (s.length() / 0.75F + 1.0F));
        Map<Character, Integer> charMap2 = new HashMap<>((int) (s.length() / 0.75F + 1.0F));
        for (char c : s.toCharArray())
            charMap1.put(c, charMap1.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray())
            charMap2.put(c, charMap2.getOrDefault(c, 0) + 1);
        if (charMap1.size() != charMap2.size())
            return false;
        for (char c : s.toCharArray()) {
            if (!charMap1.get(c).equals(charMap2.getOrDefault(c, 0))) {
                return false;
            }
        }
        return true;
    }

    //数组代替HashMap的解法
    //时间复杂度为O(m+n)。空间复杂度为O(1)
    public static boolean isAnagram02(String s, String t) {
        //26个字母
        int[] count1 = new int[26];
        for(char c : s.toCharArray())
            count1[c - 97] += 1;
        for(char c : t.toCharArray())
            count1[c - 97] -= 1;
        for(int i = 0; i < 26; i++){
            if(count1[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram";
        String s2 = "rat", t2 = "car";
        System.out.println(isAnagram01(s1, t1));
        System.out.println(isAnagram02(s2, t2));
    }

}