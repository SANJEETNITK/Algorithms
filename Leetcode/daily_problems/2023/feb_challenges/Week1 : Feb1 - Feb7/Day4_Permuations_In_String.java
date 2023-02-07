// Problem Link -> https://leetcode.com/problems/permutation-in-string/

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length())
            return false;

        int s1_arr[] = new int[128];
        int s2_arr[] = new int[128];

        for(int i=0;i<s1.length();i++) {
            s1_arr[s1.charAt(i)]++;
            s2_arr[s2.charAt(i)]++;
        }

        int i = s1.length();
        while(i < s2.length()){
            if(Arrays.equals(s1_arr, s2_arr))
                return true;
            s2_arr[s2.charAt(i)]++;
            s2_arr[s2.charAt(i - s1.length())]--;
            i++;
        }

        return Arrays.equals(s1_arr, s2_arr);
    }
}