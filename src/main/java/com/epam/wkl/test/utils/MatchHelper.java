package com.epam.wkl.test.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
MatchHelper .
@author Dmytro Korytov
Created Date: 9/26/2019
*/
public class MatchHelper {

    private Pattern pattern;
    private Matcher matcher;

    public MatchHelper setPattern(String regex) {
        this.pattern =  Pattern.compile(regex);
        return this;
    }

    public MatchHelper matchExpression(String expression) {
        this.matcher = this.pattern.matcher(expression);
        return this;
    }

    public Boolean getMatch() {
        return this.matcher.matches();
    }
}