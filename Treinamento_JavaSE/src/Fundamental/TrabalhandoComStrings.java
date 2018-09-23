package Fundamental;

import java.util.Arrays;

public class TrabalhandoComStrings {

    public static void main(String[] args) {

        String s = "Texto digitado";
        System.out.println(s);

        char c = s.charAt(0);
        System.out.println(c);

        int i = s.codePointAt(0);
        System.out.println(i);

        int compare = s.compareTo(s);
        System.out.println(compare);

        boolean b = s.contains("x");
        System.out.println(b);

        boolean endsWith = s.endsWith("o");
        System.out.println(endsWith);

        boolean empty = s.isEmpty();
        System.out.println(empty);

        int length = s.length();
        System.out.println(length);

//        int codePointBefore = s.codePointBefore(0);
//        System.out.println(codePointBefore);

        int compareToIgnoreCase = s.compareToIgnoreCase(" para funções em String");
        System.out.println(compareToIgnoreCase);

        String concat = s.concat(" para funções em String");
        System.out.println(s);
        System.out.println(concat);

        byte[] bytes = s.getBytes();
        System.out.println(bytes);

        String toUpperCase = s.toUpperCase();
        System.out.println(toUpperCase);

        boolean equals = s.equals("s");
        System.out.println(equals);
        boolean equals1 = s.equals(s);
        System.out.println(equals1);

        int i1 = s.hashCode();
        System.out.println(i1);

        int indexOf = s.indexOf("o");
        System.out.println(indexOf);


        int lastIndexOf = s.lastIndexOf("o");
        System.out.println(lastIndexOf);

        String intern = s.intern();
        System.out.println(intern);

        String replace = s.replace("o", "ZZZ");
        System.out.println(replace);

        String[] split = s.split(" ");
        System.out.println(Arrays.toString(split));

        CharSequence charSequence = s.subSequence(0, 4);
        System.out.println(charSequence);

        String trim = s.trim();
        System.out.println(trim);

        String replaceFirst = s.replaceFirst("o", "XXX");
        System.out.println(replaceFirst);

        String substring = s.substring(1, 5);
        System.out.println(substring);

        char[] chars = s.toCharArray();
        System.out.println(chars.length);

        //-------------------------------------------
        boolean s1 = s.matches("digitado");
        System.out.println(s1);

        boolean texto = s.regionMatches(true, 0, "texto", 0, 5);
        System.out.println("Texto = "+texto);
        // -------------------------------------------

        boolean contentEquals = s.contentEquals(s);
        System.out.println(contentEquals);


    }
}
