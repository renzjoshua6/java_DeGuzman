import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SMS implements SMSManager {
    final private static Logger logger = Logger.getLogger(SMS.class.getName());
    protected String recipient;
    protected String sender;
    protected String shortcode;
    protected String transactionId;
    protected LocalDateTime timestamp;
    protected String status;
    protected String message;

    public SMS() {

    }

    // instantiate variables
    public SMS(String recipient, String sender,
               String transactionId,
               LocalDateTime timestamp, String message) {
        this.recipient = recipient;
        this.sender = sender;
        this.transactionId = transactionId;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }

    public String getShortcode() {
        return shortcode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void insertSMS() {
        String insertQuery = "INSERT INTO sms (recipient, shortCode, timestamp, transactionID, sender, status, message) " +
                "VALUES ('" +
                getRecipient() + "', '" +
                getShortcode() + "', '" +
                getTimestamp() + "', '" +
                getTransactionId() + "', '" +
                getSender() + "', '" +
                getStatus() + "', '" +
                getMessage() + "');";
        DatabaseConnect.insertData(insertQuery);
    }

    // 2. Retrieve SMS Given a Start Date and End Date
    @Override
    public ArrayList<String> retrieveSMSByDate(LocalDateTime startDate, LocalDateTime endDate) {
        String selectQuery = "SELECT * FROM sms " +
                "WHERE timestamp BETWEEN '" + startDate + "' AND '" + endDate + "' " +
                "ORDER BY timestamp;";

        return DatabaseConnect.retrieveSMSData(selectQuery);
    }

    // 3. Retrieve SMS Given a Promo Code
    @Override
    public ArrayList<String> retrieveSMSByPromoCode(String promoCode) {
        String selectQueryPromo = "SELECT short_code FROM promo WHERE promo_code='" + promoCode + "';";
        ArrayList<String> shortCode = DatabaseConnect.retrievePromoList(selectQueryPromo);
        String selectQuerySMS = "SELECT * FROM sms " +
                "WHERE recipient='" + shortCode.get(0) + "' OR sender='" + shortCode.get(0) + "' " +
                "ORDER BY timestamp;";

        return DatabaseConnect.retrieveSMSData(selectQuerySMS);
    }

    // 4. Retrieve SMS Given an MSISDN
    @Override
    public ArrayList<String> retrieveSMSByMsisdn(String msisdn) {
        String selectQuery = "SELECT * FROM sms " +
                "WHERE sender ='" + msisdn + "' " +
                "ORDER BY timestamp;";

        return DatabaseConnect.retrieveSMSData(selectQuery);
    }


    // 5. Retrieve SMS Sent By the System
    @Override
    public ArrayList<String> retrieveSMSSentBySystem() {
        String selectQueryPromo = "SELECT short_code FROM promo;";
        ArrayList<String> shortCode = DatabaseConnect.retrievePromoList(selectQueryPromo);
        StringBuilder selectQuerySMS = new StringBuilder("SELECT * FROM sms " +
                "WHERE sender IN (");
        for (String str : shortCode) {
            selectQuerySMS.append("'").append(str).append("', ");
        }
        selectQuerySMS = new StringBuilder(selectQuerySMS.substring(0, selectQuerySMS.length() - 2) + ") ORDER BY timestamp;");

        return DatabaseConnect.retrieveSMSData(selectQuerySMS.toString());
    }

    // 6. Retrieve SMS Received By the System
    @Override
    public ArrayList<String> retrieveSMSReceivedBySystem() {
        String selectQueryPromo = "SELECT short_code FROM promo;";
        ArrayList<String> shortCode = DatabaseConnect.retrievePromoList(selectQueryPromo);
        StringBuilder selectQuerySMS = new StringBuilder("SELECT * FROM sms " +
                "WHERE recipient IN (");
        for (String str : shortCode) {
            selectQuerySMS.append("'").append(str).append("', ");
        }
        selectQuerySMS = new StringBuilder(selectQuerySMS.substring(0, selectQuerySMS.length() - 2) + ") ORDER BY timestamp;");

        return DatabaseConnect.retrieveSMSData(selectQuerySMS.toString());
    }

    // 7. Retrieve SMS Given Several MSISDN
    @Override
    public ArrayList<String> retrieveSMSBySeveralMsisdn(String... msisdn) {
        StringBuilder selectQuery = new StringBuilder("SELECT * FROM sms " +
                "WHERE sender IN (");
        for (String str : msisdn) {
            selectQuery.append("'").append(str).append("',");
        }
        selectQuery = new StringBuilder(selectQuery.substring(0, selectQuery.length() - 2) + "') ORDER BY timestamp;");

        return DatabaseConnect.retrieveSMSData(selectQuery.toString());
    }

    // Some Function for Data Generation
    // 1. Total Count of SMS Received By the System
    public static void retrieveSMSCountReceivedBySystem() {
        SMS report = new SMS();
        ArrayList<String> list = report.retrieveSMSReceivedBySystem();
        Integer count = 0;
        for(String str : list) {
            count++;
        }
        logger.log(Level.INFO, "Total Count of SMS Received By The System: {0}", count);
    }

    // 2. Total Count of SMS Sent By the System
    public static void retrieveSMSCountSentBySystem() {
        SMS report = new SMS();
        ArrayList<String> list = report.retrieveSMSSentBySystem();
        Integer count = 0;
        for(String str : list) {
            count++;
        }
        logger.log(Level.INFO, "Total Count of SMS Sent By The System: {0}", count);
    }
}