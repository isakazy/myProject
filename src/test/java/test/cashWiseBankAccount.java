package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.CashwiseAuthorization;
import utilities.Config;

public class cashWiseBankAccount {

    @Test
    public void getAllBankAccounts() {
        String token = CashwiseAuthorization.getToken();
        String url = Config.getValue("cashWiseApi") + "/api/myaccount/bankaccount ";
        Response response = RestAssured.given().auth().oauth2(token).get(url);
        // response.prettyPrint();
        // Assert.assertEquals(200, response.statusCode());

        int size = response.jsonPath().getList("JSON").size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            String bankAccountName = response.jsonPath().getString("[" + i + "].bank_account_name");
            System.out.println(bankAccountName);
            String accountType = response.jsonPath().getString("[" + i + "].type_of_pay");
            System.out.println(accountType);
            String balance = response.jsonPath().getString("[" + i + "].balance");
            System.out.println(balance);
            System.out.println("=============================================");

        }
/*
 String bankAccountName2 = response.jsonPath().getString("[1].bank_account_name");
    String accountType2= response.jsonPath().getString("[1].type_of_pay");
    String balance2 = response.jsonPath().getString("[1].balance");

    String bankAccountName3 = response.jsonPath().getString("[2].bank_account_name");
    String accountType3 = response.jsonPath().getString("[2].type_of_pay");
    String balance3 = response.jsonPath().getString("[2].balance");
}
 */


    }
}