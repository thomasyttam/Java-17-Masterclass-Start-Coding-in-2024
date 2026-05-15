package com.timbuchalka;

/**
 *
 */
public class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0; // add watch point when modify

    public void addChar(StringBuilder sBuilder, char c) {
//        this.sBuilder.append(c); // append char on the instance variable (this)
        sBuilder.append(c); // break point set
        charsAdded++;
    }

    public String upperAndPrefix(String str) {
        String upper = str.toUpperCase();
        return "Prefix_" + upper;
    }

    public String addSuffix(String str) {
        return str + "__Suffix";
    }
}
