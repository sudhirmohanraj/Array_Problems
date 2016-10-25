package string.internal.impl;

import string.internal.StringProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wyh669 on 10/10/16.
 */
public class StringProblemsImpl implements StringProblems{

    @Override
    public String convertToCamelCase(String input) {
        Integer intInput = Integer.parseInt(input);
        StringBuilder stringBuilder = new StringBuilder();
        do {
            if (intInput < 10) {
                stringBuilder.append(map(intInput));
            }
            if(intInput/100 < 10 && intInput/100 > 0 ) {
                stringBuilder.append(map(intInput/100));
                stringBuilder.append("Hundred");
                intInput = intInput % 100;
            }
        } while (intInput >= 10);
        return stringBuilder.toString();
    }

    private String map(Integer intInput) {
        if(intInput == 1){
            return "One";
        } else if(intInput == 2) {
            return "Two";
        } else if(intInput == 3) {
            return "Three";
        } else if(intInput == 4) {
            return "Four";
        } else if(intInput == 5) {
            return "Five";
        } else if(intInput == 6) {
            return "Six";
        } else if(intInput == 7) {
            return "Seven";
        } else if(intInput == 8) {
            return "Eight";
        } else if(intInput == 9) {
            return "Nine";
        } else if (intInput == 0) {
            return "Ten";
         } else {
            return null;
        }
    }

}
