package com.tining.littleone.tools;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by a1755057 on 26/09/19.
 */
public class RegexTools {

    public static ArrayList<String> matchIP(String str){
        String prefix = "((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d))";
        return matchRegex(prefix,str);
    }

    public static ArrayList<String> matchChinese(String str){
        String prefix = "[\\u4e00-\\u9fa5]+";
        return matchRegex(prefix,str);
    }

    public static ArrayList<String> matchDate(String str){
        String prefix = "\\d{4}-\\d{1,2}-\\d{1,2}";
        ArrayList<String> get = matchRegex(prefix,str);
        if(get.size() == 0)
        {
            prefix = "\\d{4}/\\d{1,2}/\\d{1,2}";
            get = matchRegex(prefix,str);
        }
        if(get.size() == 0)
        {
            prefix = "\\d{1,2}/\\d{1,2}/\\d{4}";
            get = matchRegex(prefix,str);
        }
        if(get.size() == 0)
        {
            prefix = "\\d{1,2}-\\d{1,2}-\\d{4}";
            get = matchRegex(prefix,str);
        }
        return get;
    }


    //强密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间)
    public static ArrayList<String> matchLegalStrongPassword(String str){
        String prefix = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}";
        return matchRegex(prefix,str);
    }

    //密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)
    public static ArrayList<String> matchLegalPassword(String str){
        String prefix = "[a-zA-Z]\\w{6,18}";
        return matchRegex(prefix,str);
    }

    //帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
    public static ArrayList<String> matchLegalAccount(String str){
        String prefix = "[a-zA-Z][a-zA-Z0-9_]{4,15}";
        return matchRegex(prefix,str);
    }

    public static ArrayList<String> matchDomain(String str){
        String prefix = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(/.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+/.?";
        return matchRegex(prefix,str);
    }

    public static ArrayList<String> matchUrl(String str){
        String prefix = "[a-zA-z]+://[^\\s]* 或 ^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?";
        return matchRegex(prefix,str);
    }

    public static ArrayList<String> matchEmail(String str){
        String prefix = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        return matchRegex(prefix,str);
    }

    public static ArrayList<String> matchUpWord(String str){
        String prefix = "[A-Z]+";
        return matchRegex(prefix,str);
    }

    public static ArrayList<String> matchLowWord(String str){
        String prefix = "[a-z]+";
        return matchRegex(prefix,str);
    }

    public static ArrayList<String> matchNonBlank(String str){
        String prefix = "\\S+";
        return matchRegex(prefix,str);
    }

    public static ArrayList<String> matchSpecialSymbol(String str){
        String prefix = "\\W+";
        return matchRegex(prefix,str);
    }

    public static ArrayList<String> matchWords(String str){
        String prefix = "[a-zA-Z]+";
        return matchRegex(prefix,str);
    }

    public static ArrayList<String>  matchNumber(String str){
        String prefix = "-?\\d+(\\.\\d+)?";
        return matchRegex(prefix,str);
    }

    public static ArrayList<String> matchInner(String begin,String end,String str){
        String prefix = "(?<=" + begin + ").*?(?=" + end + ")";
        return matchRegex(prefix,str);
    }

    public static ArrayList<String> matchRegex(String patten,String str){
        Pattern pattern = Pattern.compile(patten);
        Matcher matcher = pattern.matcher(str);
        ArrayList<String> list = new ArrayList<>();
        while (matcher.find())
            list.add(matcher.group());
        return list;
    }
}
