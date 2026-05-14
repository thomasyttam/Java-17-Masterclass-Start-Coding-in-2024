package com.timbuchalka;

/**
 *
 */
public class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;

    public void addChar(StringBuilder sBuilder, char c) {
//        this.sBuilder.append(c); // append char on the instance variable (this)
        sBuilder.append(c); // break point set
        charsAdded++;
    }
}
