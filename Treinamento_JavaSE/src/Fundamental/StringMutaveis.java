package Fundamental;

import javax.management.MBeanNotificationInfo;
import javax.management.monitor.StringMonitor;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringMutaveis {
    public static void main(String[] args) {


        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        StringJoiner stringJoiner = new StringJoiner(".");
        StringTokenizer stringTokenizer = new StringTokenizer(";");

        StringMonitor stringMonitor = new StringMonitor();

        stringJoiner.add("alexandre");
        stringJoiner.add("tiago");
        stringJoiner.add("ximenes");

        System.out.println(stringJoiner.length());
        System.out.println(stringJoiner.toString());
        System.out.println(stringJoiner.merge(new StringJoiner(",").add("dayane")));

        int i = stringTokenizer.countTokens();
        System.out.println(i);

        int capacity = stringBuffer.capacity();
        System.out.println(capacity);

        stringBuffer.append("alexandre tiago ximenes");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.delete(10, 16).insert(9, " and amanda"));
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.capacity());

        stringBuilder.append(stringBuffer).replace(10, 16, "Arthur").delete(17,20);
        System.out.println(stringBuilder.reverse().toString());




    }
}
