package Java8;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TrabalhandoComDatas {

    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();
        Date date = Calendar.getInstance().getTime();
        System.out.println(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(hoje.getTime()));
        System.out.println(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date));


        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);


        System.out.println(localDate.getEra());
        System.out.println(localDate.getChronology());

        System.out.println(localTime.getNano());

        LocalDate copa = LocalDate.of(2022, 12, 22);

        int anos = copa.getYear() - localDate.getYear() ;
        int dias = copa.getDayOfYear() - localDate.getDayOfYear() ;

        System.out.println(dias);
        System.out.println(anos);

        Period p = Period.between(localDate, copa);
        System.out.println(p);

        System.out.println(copa.plusYears(4));

        LocalDateTime localDateTime1 = LocalDateTime.now(Clock.systemDefaultZone());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String saida = localDateTime1.format(formatter);
        System.out.println(saida);


        boolean after = localDate.isAfter(copa);
        System.out.println(after);
        boolean before = localDate.isBefore(copa);
        System.out.println(before);

        boolean equal = localDate.isEqual(copa);
        boolean equal2 = localDate.isEqual(LocalDate.now());
        System.out.println(equal);
        System.out.println(equal2);


        boolean leapYear = localDate.isLeapYear();
        System.out.println(leapYear);

        Date date2 = new Date();

        LocalDate localDate2 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); //date.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();

        System.out.println( localDate2 );

        Date saida2 = date2.from( localDate.atStartOfDay( ZoneId.systemDefault() ).toInstant() );

        System.out.println( saida );
    }
}
