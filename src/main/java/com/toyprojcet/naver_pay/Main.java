package com.toyprojcet.naver_pay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                solution(1,13,1)
        );
    }

    public static int solution(int i, int j, int k) {
        int count=0;
        String temp="";
        for(int a=i; a<j+1; a++){
            temp+=String.valueOf(a);
        }
        System.out.println(temp);
        for(int a=0; a<temp.length(); a++){
            if((Integer.parseInt(temp.charAt(a)+""))==k){
                count++;
            }
        }
        return count;
    }
}
