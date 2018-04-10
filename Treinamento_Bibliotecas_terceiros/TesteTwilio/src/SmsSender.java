SDK Version: 6.x 7.x
// Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC109189a10859648f3b07841e59b02876";
    public static final String AUTH_TOKEN =
            "a6d72e9901e1a72f016a7b2bdedb2396";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+5599999999"), // to
                        new PhoneNumber("+554199999999"), // from
                        "Alexandre Ximenes, estamos felizes em conhecer seu codigo hehehe")
                .create();

        System.out.println(message.getSid());
    }
}