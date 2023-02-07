// Problem Link -> https://leetcode.com/problems/fruit-into-baskets/

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 *
 *
 *
 * Example 1:
 *
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * Example 2:
 *
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * Example 3:
 *
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 *
 *
 * Constraints:
 *
 * 1 <= fruits.length <= 105
 * 0 <= fruits[i] < fruits.length
 */


// Solution 1 -> Time Complexity - O(n), Space Complexity - O(1)
// Approach used -> Sliding window + HashMap
/*
class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap();
        int finalAns = 0;
        int indexToRemove = fruits.length-1;
        for(int i = fruits.length-1; i >= 0; i--) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while(map.size() > 2) {
                int count = map.get(fruits[indexToRemove]);
                if(count == 1)
                    map.remove(fruits[indexToRemove]);
                else
                    map.put(fruits[indexToRemove], count-1);
                indexToRemove--;
            }
            int currAns = 0;
            for(int val : map.values()){
                currAns += val;
            }
            finalAns = Math.max(finalAns, currAns);
        }

        return finalAns;
    }
}
*/


// Solution 2 -> Time Complexity - O(n), Space Complexity - O(1)
// Approach used -> Sliding window
class Solution {
    public int totalFruit(int[] fruits) {

        int left = 0, right = 0, ans = 0;
        int n = fruits.length;
        int firstCount = 0, secondCount = 0;
        int first = -1, second = -1;

        while(right < n) {
            int f = fruits[right];
            if(f == first) {
                ++firstCount;
            } else if(f == second) {
                ++secondCount;
            } else if(first == -1) {
                firstCount = 1;
                first = f;
            } else if(second == -1) {
                secondCount = 1;
                second = f;
            } else {

                while(firstCount > 0 && secondCount > 0) {
                    if(first == fruits[left]) {
                        --firstCount;
                    } else if(second == fruits[left]) {
                        --secondCount;
                    }
                    ++left;
                }

                if(firstCount == 0) {
                    first = f;
                    ++firstCount;
                } else if(secondCount == 0) {
                    second = f;
                    ++secondCount;
                }
            }

            ans = Math.max(ans, firstCount + secondCount);
            ++right;
        }

        return ans;
    }
}