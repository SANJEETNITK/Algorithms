// Problem Link -> https://leetcode.com/problems/zigzag-conversion/

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */

class Solution {
    public String convert(String s, int numRows) {

        if(s == "" || numRows<=1)
            return s;

        int n = s.length();
        int len = n;
        int cols = (n / (numRows * 2 - 2)) * (numRows-1);
        n %= (numRows * 2 - 2);


        if(n >= numRows)
        {
            n -= numRows;
            cols++;
        }
        if(n>0)
            cols = cols + n - 1;

        char matrix[][] = new char[numRows][cols+1];
        int r = 0, index = 0, c = 0, k = 0;

        while(index < len){

            for(k = 0;index<len && k < numRows; k++){
                matrix[k][c] = s.charAt(index);
                index++;
            }
            c++;

            if(index < len){
                for(k = numRows-2;index<len && k>0; k--){
                    matrix[k][c] = s.charAt(index);
                    c++;
                    index++;
                }
            }
        }

        String output = "";
        for(r = 0;r<numRows;r++){
            for(c = 0;c<=cols;c++){
                if(matrix[r][c]!=0)
                    output += matrix[r][c];
            }
        }
        return output;
    }
}