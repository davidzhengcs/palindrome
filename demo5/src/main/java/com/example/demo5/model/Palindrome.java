package com.example.demo5.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;
@Entity
public class Palindrome {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String original;
    private String palin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getPalin() {
        return palin;
    }



    public void setPalin() {
        this.palin = longestPalindrome(this.original);
    }

    static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] m = new boolean[n][n];
        int start = n - 1;
        int maxLen = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                m[i][j] = ((s.charAt(i) == s.charAt(j)) && (j - i < 3 || m[i + 1][j - 1]));
                if (m[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
