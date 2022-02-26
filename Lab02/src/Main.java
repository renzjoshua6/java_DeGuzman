import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    final private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        DatabaseConnect.connect();
/*
        Promo promo1 = new Promo("PISOPIZZA",
                "Send PISOPIZZA to 123455 and Get one Pizza for 1 Peso Only",
                "123455",
                LocalDateTime.parse("2022-02-01 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                LocalDateTime.parse("2022-06-30 23:59:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        promo1.insertPromo();

        Promo promo2 = new Promo("FREEDEL",
                "Send FREEDEL to 87000 to get the Free Delivery voucher",
                "87000",
                LocalDateTime.parse("2022-03-01 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                LocalDateTime.parse("2022-10-31 23:59:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        promo2.insertPromo();

        Promo promo3 = new Promo("HASH",
                "Send HASH to 123456 to get a Free Hash Brown",
                "8888-6236",
                LocalDateTime.parse("2022-03-01 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                LocalDateTime.parse("2022-10-31 23:59:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        promo3.insertPromo();
 */

        Scanner input = new Scanner(System.in);
        boolean programLoop = true;
        String sender = "";
        String recipient = "";
        Map<String, String> sms = new HashMap<>();
        Integer step = 1;

        while (programLoop) {
            logger.log(Level.INFO, "Start");

            if (step == 1) {
                sender = "";
                recipient = "";
            }

            while (sender.isEmpty()) {
                System.out.println("Enter your mobile number: ");
                sender = input.nextLine();
                sms.put("sender", sender);
            }

            System.out.println("Enter message: ");
            String message = input.nextLine();
            sms.put("message", message);

            while (recipient.isEmpty()) {
                System.out.println("Send to: ");
                recipient = input.nextLine();
                sms.put("recipient", recipient);
            }
        }

        DatabaseConnect.disconnect();
    }
}


       // step = SMSChecker.smsChecker(sms, step);
