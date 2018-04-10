//SDK Version: 6.x 7.x
// Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "YourNumberAccountSid";
    public static final String AUTH_TOKEN =
            "yourNumberAuthToken";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+5599999999"), // to
                        new PhoneNumber("+554199999999"), // from
                        "msg SMS")
                .create();

        System.out.println(message.getSid());
    }
}