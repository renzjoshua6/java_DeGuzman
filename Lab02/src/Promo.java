import java.time.LocalDateTime;

public class Promo {

    private String promoCode;
    private String details;
    private String shortcode;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Promo(String promoCode, String details, String shortcode, LocalDateTime startDate, LocalDateTime endDate){
        this.promoCode = promoCode;
        this.details = details;
        this. shortcode = shortcode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public String getDetails() {
        return details;
    }

    public String getShortcode() {
        return shortcode;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    // for inserting Promo into DB
    public void insertPromo(){
        String query = "Insert into promo (promo_code, details, shortCode, startDate, endDate) Values ('" + getPromoCode() + "', '"
                + getDetails() + "', '"
                + getShortcode() + "', '"
                + getStartDate() + "', '"
                + getEndDate() + "');";
        DatabaseConnect.insertData(query);
    }

}

