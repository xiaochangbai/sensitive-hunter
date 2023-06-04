package io.xiaochangbai.sensitive.common.utils;

/**
 * @author xiaochangbai
 * @date 2023-06-04 17:28
 */
public class CharUtil {

    private CharUtil() {
    }

    public static boolean isEmpty(Character character) {
        return character == null;
    }



    public static char toHalfWidth(char c) {
        char resultChar = c;
        if (c == 12288) {
            resultChar = ' ';
        } else if (c > '\uff00' && c < '｟') {
            resultChar = (char)(c - 'ﻠ');
        }

        return resultChar;
    }




    public static boolean isDigitOrLetter(char c) {
        return Character.isDigit(c) || Character.isLowerCase(c) || Character.isUpperCase(c);
    }

    public static boolean isEmilChar(char c) {
        return isDigitOrLetter(c) || '_' == c || '-' == c || c == '.' || c == '@';
    }

    public static boolean isWebSiteChar(char c) {
        return isDigitOrLetter(c) || '-' == c || '.' == c;
    }



    public static String repeat(char replaceChar, int wordLength) {
        if (!isEmpty(replaceChar) && wordLength > 0) {
            StringBuilder stringBuffer = new StringBuilder();

            for(int i = 0; i < wordLength; ++i) {
                stringBuffer.append(replaceChar);
            }

            return stringBuffer.toString();
        } else {
            return "";
        }
    }
}

