package com.learning.string;

import java.util.StringTokenizer;

public class DefangingIPAddress {

    public static void main(String[] args) {
        DefangingIPAddress maiin = new DefangingIPAddress();
        String finalAnswer = maiin.defangIPaddr("1.1.1.1");
        System.out.println(finalAnswer);
    }
    public String defangIPaddr(String address) {
        StringTokenizer tokens = new StringTokenizer(address, ".");
        StringBuilder builder = new StringBuilder();
        while(tokens.hasMoreTokens()){
            builder.append(tokens.nextToken());
            if(tokens.hasMoreTokens()){
                builder.append("[.]");
            }
        }
        return builder.toString();
    }
}
