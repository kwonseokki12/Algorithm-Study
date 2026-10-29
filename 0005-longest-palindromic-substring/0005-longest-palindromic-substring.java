class Solution {
    public String expand(String s, String res, int i, int j) {
        String subStr = "";

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            subStr = subStr.length() > j - 1 ? subStr :  s.substring(i, j + 1);
            i--;
            j++;
        }
        
        return res.length() > subStr.length() ? res :  subStr;
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            result = expand(s, result, i, i);
            result = expand(s, result,  i, i + 1);
        }

        return result;
    }
}