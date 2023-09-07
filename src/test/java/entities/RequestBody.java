package entities;

import lombok.Data;

@Data
public class RequestBody {
    private String email;
    private String password;
    private String category_title;
    private String category_description;
    private Boolean flag;
    private String created;


    // CashwiseSellesTests

    private String company_name;
    private String seller_name;
    private String phone_number;
    private String address;

    private String type_of_pay;
    private int balance;
    private String bank_account_name;
    private String description;

    // products


        private String product_title;
            private String product_price;
            private String product_description;








}
