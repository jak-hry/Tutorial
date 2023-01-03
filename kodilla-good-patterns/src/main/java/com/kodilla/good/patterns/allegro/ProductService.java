package com.kodilla.good.patterns.allegro;

import static com.kodilla.good.patterns.allegro.MailService.sendMail;

public class ProductService implements ProductList {

    public void productCheck(final User user, String product, int quantity) {
        purchased(user, product, quantity);
    }

    private boolean sold(final User user, String productName, int quantity) {

        boolean check = productCheck(productName);

        if (check) {
            if (quantity == 0) {
                System.out.println("Product: " + productName + " for " + user.getUserName() + " is sold");
            } else {
                return purchased(user, productName, quantity);
            }
        }

        return true;
    }

    private boolean purchased(final User user, String productName, int quantity) {

        boolean check = productCheck(productName);

        if (check) {
            if (quantity != 0) {
                System.out.println("Product \"" + productName + "\"" + " for " + user.getUserName() + " is in stock");
                sendMail(user);
            } else {
                return sold(user, productName, quantity);
            }
        }

        return true;
    }

    private static boolean productCheck(String productName) {

        if (productList.contains(productName)) {
            return true;
        } else {
            System.out.println("this product is not for sale");
            return false;
        }
    }

}
