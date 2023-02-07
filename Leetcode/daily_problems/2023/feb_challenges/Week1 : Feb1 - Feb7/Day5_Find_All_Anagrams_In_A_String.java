// Problem Link -> https://leetcode.com/problems/find-all-anagrams-in-a-string/

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList();

        if(p.length() == 0 || s.length() == 0)
            return res;
        if(s.length() < p.length())
            return res;

        int p_arr[] = new int[26];
        int s_arr[] = new int[26];

        for(int i = 0; i<p.length();i++){
            p_arr[p.charAt(i)-'a']++;
            s_arr[s.charAt(i)-'a']++;
        }

        int i = p.length();
        for(; i < s.length(); i++){

            if(Arrays.equals(p_arr, s_arr)){
                res.add(i-p.length());
            }

            s_arr[s.charAt(i)-'a']++;
            s_arr[s.charAt(i-p.length())-'a']--;
        }

        if(Arrays.equals(p_arr, s_arr)){
            res.add(i-p.length());
        }

        return res;
    }
}