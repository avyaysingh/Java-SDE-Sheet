package com.recursion;

/*
qn:- Given a string s such that every substring of the partition is palindrome,
Return all possible palindrome partitioning of s.

IN:- s = "aab"
OUT:- [["a","a","b"],["aa","b"]]
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {
    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    public static void recPalindrome(int index, String s, List<String> paths, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(paths));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                paths.add(s.substring(index, i + 1));
                recPalindrome(i + 1, s, paths, result);
                paths.remove(paths.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        recPalindrome(0, s, path,result);
        return result;
    }


    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);
        for (List strings:
             result) {
            for (Object string:
                 strings) {
                System.out.println("[" + string.toString() + "]");
            }

        }
    }
}
