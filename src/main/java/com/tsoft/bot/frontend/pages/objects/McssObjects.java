package com.tsoft.bot.frontend.pages.objects;

import org.openqa.selenium.By;

public class McssObjects {
    private McssObjects() {
    }

    //Home
    public static final By NAV_ACCOUNT = By.cssSelector("a[title=\"My Account\"]");
    public static final By BTN_TOSIGNIN = By.cssSelector("ul.dropdown-menu li:last-child a");
    public static final By NAV_SHOPPINGCART = By.cssSelector("a[title=\"Shopping Cart\"]");
        /*components*/
    public static final By NVIT_LAPTOPS = By.cssSelector("nav#menu div ul li.dropdown:nth-child(2) a");
    public static final By SMIT_LAPTOPS_SHOWALL = By.cssSelector("nav#menu div ul li.dropdown:nth-child(2) a.see-all");
    public static final By NVIT_CAMERAS = By.cssSelector("nav#menu div ul li:nth-child(7) a");


    //Sign in
    public static final By INPUT_EMAIL = By.id("input-email");
    public static final By IMPUT_PSWRD = By.id("input-password");
    public static final By BTN_LOGIN = By.cssSelector("input[value=\"Login\"]");

    //Products
    public static final By LAPTOPS_AWAIT = By.cssSelector("a[class=\"list-group-item active\"]");
    public static final By LAPTOP_HP = By.cssSelector("div.product-layout:nth-child(1) div div.image a");
    public static final By LAPTOP_MACK = By.cssSelector("div.product-layout:nth-child(2) div div.image a");
    public static final By CAMERAS_AWAIT = By.cssSelector("a[class=\"list-group-item active\"]");
    public static final By CAMERA_NIKON = By.cssSelector("div.product-layout:nth-child(2) div div.image a");
    public static final By BTN_ADDCART = By.id("button-cart");

    //Shopping cart
    public static final By SHPC_CONTINUE = By.cssSelector("div.clearfix div:last-child a");
    public static final By SHPC_TOTALITEMS = By.cssSelector("#content form table tbody tr td:last-child");
    public static final By SHPC_SUBTOTAL = By.cssSelector("#content .row table tbody tr:nth-child(1) td:last-child");

    //Billung details
    public static final By BILLING_NEWADDRESS = By.cssSelector("input[value=\"new\"]");
    public static final By BILLING_FIRSTNAME = By.id("input-payment-firstname");
    public static final By BILLING_LASTNAME = By.id("input-payment-lastname");
    public static final By BILLING_ADDRESS = By.id("input-payment-address-1");
    public static final By BILLING_CITY = By.id("input-payment-city");
    public static final By BILLING_POSTCODE = By.id("input-payment-postcode");
    public static final By BILLING_COUNTRY = By.id("input-payment-country");
    public static final By BILLING_COUNTRY_SELECT = By.cssSelector("#input-payment-country option[value=\"167\"]");
    public static final By BILLING_ZONE = By.id("input-payment-zone");
    public static final By BILLING_ZONE_SELECT = By.cssSelector("#input-payment-zone option[value=\"2541\"]");
    public static final By BILLING_CONTINUE = By.id("button-payment-address");

    //Delivery
    public static final By DELIVERY_DETAILS_CONTINUE = By.id("button-shipping-address");
    public static final By DELIVERY_METHOD_CONTINUE = By.id("button-shipping-method");

    //Payment
    public static final By PAYMENT_AGREE = By.name("agree");
    public static final By PAYMENT_CONTINUE = By.id("button-payment-method");

    //Confirm order
    public static final By ORDER_SUBTOTAL = By.cssSelector("tfoot tr:nth-child(1) td:last-child");
    public static final By ORDER_SHIPPINGRATE = By.cssSelector("tfoot tr:nth-child(2) td:last-child");
    public static final By ORDER_TOTAL = By.cssSelector("tfoot tr:nth-child(3) td:last-child");
    public static final By CONFIRM_ORDER = By.id("button-confirm");

    //Order successfully
    public static final By SUCCESS_STATE = By.cssSelector(".breadcrumb li:nth-child(4)");
    public static final By CONTINUE_HOME = By.cssSelector(".buttons div a");
}