package br.com.alexandre.app.javaClient;

import com.sun.xml.internal.messaging.saaj.util.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JavaClientTest {
    public static void main(String[] args) {

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL("http://localhost:9000/student/1");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            String username = "alexandre";
            String password = "alexandre";
            connection.addRequestProperty("Authorization", "Basic "+encodeUserNameAndPassword(username, password));
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuffer jsonSB = new StringBuffer();

            String line = null;

            while((line = reader.readLine()) != null){
                jsonSB.append(line);
            }

            System.out.println(jsonSB.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(reader);
            if(connection != null) connection.disconnect();
        }
    }

    public static String encodeUserNameAndPassword(String username, String password){
        String userNameAndPassword = username + ":" + password;
        return new String(org.apache.tomcat.util.codec.binary.Base64.encodeBase64(userNameAndPassword.getBytes()));
    }
}
