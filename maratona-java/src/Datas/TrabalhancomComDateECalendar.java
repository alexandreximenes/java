package Datas;

import javax.xml.bind.SchemaOutputResolver;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

public class TrabalhancomComDateECalendar {

    public static void main(String[] args) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        System.out.println(System.getenv());
//
//        System.getenv().values().stream().forEach(System.out::println);

        /*//Java 8
        System.out.println("f.format(LocalDate.now() "+f.format(LocalDateTime.now()));

        System.out.println(sf.format(System.currentTimeMillis())) ;

        Date agora = new Date();
        Date dataQualquer = new Date(1_000_000_000_000L);
        System.out.println("System.nanoTime() "+sf.format(System.nanoTime()));

        System.out.println(sf.format(agora.getTime()));
        System.out.println(sf.format(dataQualquer.getTime()));

        System.out.println("agora.compareTo(dataQualquer) -> "+agora.compareTo(dataQualquer));
        System.out.println("dataQualquer.compareTo(dataQualquer) -> "+dataQualquer.compareTo(dataQualquer));
        System.out.println("dataQualquer.compareTo(agora) -> "+dataQualquer.compareTo(agora));


        Calendar c = Calendar.getInstance();
        Calendar g = GregorianCalendar.getInstance();

        System.out.println(c.getTime());
        System.out.println(sf.format(c.getTime()));
        System.out.println(g.getTime());
        System.out.println(sf.format(g.getTime()));

        //alterando a data para 05/06/2001 11:44:00
        c.set(2000, Calendar.DAY_OF_MONTH, 5);
        c.add(Calendar.YEAR, 1);
        c.clear(Calendar.SECOND);

        /**
         * c.add altera tipos maiores como dia, mes ano etc...
         * c.roll não altera tipos maiores, mas altera somente a unidade que esta sendo mudada
         * ex: 15/09/2018 11:38:03
         * c.roll(Calendar.DAY_OF_MONTH, 20) altera para dia 05/09/2018 11:38:03
         * 15/09/2018 11:38:03
         * c.add(Calendar.DAY_OF_MONTH, 20) altera para dia 05/10/2018 11:38:03
        */
        /*
        c.roll(Calendar.DAY_OF_MONTH, 30);
        System.out.println(sf.format(c.getTime()));

        c.add(Calendar.DAY_OF_MONTH, 30);

        System.out.println(sf.format(c.getTime()));

        c.add(Calendar.MINUTE, -10);
        System.out.println(sf.format(c.getTime()));


        System.out.println("--------------------------");

        Calendar ca = Calendar.getInstance();
        Date date = new Date();

        //Formatação de datas e hora padrão
        DateFormat df = DateFormat.getInstance();
        System.out.println(df.format(date));

        //Formatação de datas
        df = DateFormat.getDateInstance();
        System.out.println(df.format(date));

        //Formatação de horas
        df = DateFormat.getTimeInstance();
        System.out.println(df.format(date));

        //Formatação de datas e horas
        df = DateFormat.getDateTimeInstance();
        System.out.println(df.format(date));

        //Formatação de datas com estilos
        df = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("FULL "+df.format(date));

        //Formatação de horas com estilos prontos
        df = DateFormat.getTimeInstance(DateFormat.FULL);
        System.out.println("FULL "+df.format(date));

        //Formatação de datas com estilos
        df = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(df.format(date));

        //Formatação de datas com estilos
        df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println(df.format(date));

        //Formatação de datas com estilos
        df = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(df.format(date));

        //CONVERSÃO DE DATAS COM parse


        DateFormat format = DateFormat.getDateInstance();
        try {
            Date date2 = format.parse("15/09/2018");
            System.out.println(format.format(date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        */

        Calendar c3 = Calendar.getInstance();
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL);

        System.out.println(df2.format(c3.getTime()));

        //Locale conforme localização do Brasil
        Locale locale = Locale.getDefault();
        System.out.println(locale);

        System.out.println(Locale.getISOCountries());
        System.out.println(Locale.getISOLanguages());

        Locale[] locales = Locale.getAvailableLocales();
        for (Locale l: locales) {
            if(l.getCountry() == "BR")
                System.out.println(l.getCountry() +
                        "- "+ l.getDisplayCountry() +
                        " - "+ l.getDisplayName() +
                        " - "+ l.getLanguage() +
                        " - "+ l.getISO3Country() +
                        " - "+ l.getISO3Language());
        }

        //Definir meu propio locale
        Locale us = Locale.US;
        DateFormat dfUS = DateFormat.getDateInstance(DateFormat.MEDIUM, us);
        String data = dfUS.format(c3.getTime());

        System.out.println(data);


    }


}
