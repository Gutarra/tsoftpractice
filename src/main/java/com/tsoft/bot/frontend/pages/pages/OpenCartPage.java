package com.tsoft.bot.frontend.pages.pages;

import com.tsoft.bot.frontend.base.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.objects.ExcelDataObjects;
import com.tsoft.bot.frontend.pages.objects.McssObjects;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

public class OpenCartPage extends BaseClass
{
    protected WebDriver browser;
    private static GenerateWord generateWord = new GenerateWord();
    private String message;
    public OpenCartPage(WebDriver driver)
    {
        super(driver);
        browser = Hook.getDriver();
    }
    private List<HashMap<String, String>> getDataForSignIn() throws Throwable {
        return ExcelReader.data(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE);
    }
    private List<HashMap<String, String>> getDataForDetails() throws Throwable {
        return ExcelReader.data(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.DETAILS_PAGE);
    }
    public void toSignIn(Integer ncase) throws Throwable {
        message = "Se ingresa a la página de inicio";
        try
        {
            String url = getDataForSignIn().get(ncase - 1).get(ExcelDataObjects.COLUMN_URL);
            this.browser.get(url);
            click(browser,McssObjects.NAV_ACCOUNT);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser, McssObjects.BTN_TOSIGNIN);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void signIn(Integer ncase) throws Throwable {
        message = "Se inicia sesión en la pagina " + this.browser.getTitle();
        try
        {
            String username = getDataForSignIn().get(ncase - 1).get(ExcelDataObjects.COLUMN_USER);
            String password = getDataForSignIn().get(ncase - 1).get(ExcelDataObjects.COLUMN_PASWWORD);
            awaitFor(browser,McssObjects.INPUT_EMAIL);

            clear(browser,McssObjects.INPUT_EMAIL);
            typeText(browser,McssObjects.INPUT_EMAIL,username);
            clear(browser,McssObjects.IMPUT_PSWRD);
            typeText(browser,McssObjects.IMPUT_PSWRD,password);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser, McssObjects.BTN_LOGIN);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void buyLaptops() throws Throwable {
        message = "Ingresando a ver todas las laptos";
        try
        {
            scroll(browser,0,50);
            hover(browser,McssObjects.NVIT_LAPTOPS);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser, McssObjects.SMIT_LAPTOPS_SHOWALL);

            awaitFor(browser,McssObjects.LAPTOPS_AWAIT);
            scroll(browser,0 , -1000);
            scroll(browser,0,520);
            message = "seleccionando laptop HP";
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,McssObjects.LAPTOP_HP);

            message = "agregando laptop HP al carrito";
            click(browser,McssObjects.BTN_ADDCART);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            browser.navigate().back();

            awaitFor(browser,McssObjects.LAPTOPS_AWAIT);
            message = "seleccionando laptop MACK";
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,McssObjects.LAPTOP_MACK);

            message = "agregando laptop MACK al carrito";
            click(browser,McssObjects.BTN_ADDCART);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void buyCamera() throws Throwable {
        message = "Ingresando a la pagina de las camaras";
        try
        {
            browser.navigate().back();
            scroll(browser,0 , -1000);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,McssObjects.NVIT_CAMERAS);

            awaitFor(browser,McssObjects.CAMERAS_AWAIT);
            message = "Seleccionando la camara Nikon";
            scroll(browser,0,190);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,McssObjects.CAMERA_NIKON);

            awaitFor(browser,McssObjects.BTN_ADDCART);
            message = "agregando la camara Nikon al carrito";
            click(browser,McssObjects.BTN_ADDCART);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void toShoppingCart() throws Throwable {
        message = "Ingresando a la pagina del carrito de compras";
        try
        {
            scroll(browser,0 , -1000);
            click(browser,McssObjects.NAV_SHOPPINGCART);
            awaitFor(browser,McssObjects.SHPC_CONTINUE);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);

            message = "Comparando montos finales";
            double total, subtotal;
            total = getTotalOfDetails(browser,McssObjects.SHPC_TOTALITEMS);
            subtotal = getValue(browser,McssObjects.SHPC_SUBTOTAL);
            if (total == subtotal)
            {
                message += "\nCálculo de montos correcto";
                stepPass(browser, message);
                generateWord.sendText(message);
                generateWord.addImageToWord(browser);
            }
            else
            {
                message += "\nError en el cálculo de montos";
                stepFail(browser,message);
                generateWord.sendText(message);
                generateWord.addImageToWord(browser);
            }
            click(browser,McssObjects.SHPC_CONTINUE);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void continueOnBilling(Integer ncase) throws Throwable {
        message = "Ingresando a los detalles de facturación, se ingresa nueva dirección";
        try
        {
            awaitFor(browser,McssObjects.BILLING_CONTINUE);
            click(browser,McssObjects.BILLING_NEWADDRESS);
            scroll(browser,0,-1000);
            scroll(browser,0,360);

            String firstname,lastname,address,city,postcode;
            firstname = getDataForDetails().get(ncase - 1).get(ExcelDataObjects.COLUMN_FIRSTNAME);
            lastname = getDataForDetails().get(ncase - 1).get(ExcelDataObjects.COLUMN_LASTNAME);
            address = getDataForDetails().get(ncase - 1).get(ExcelDataObjects.COLUMN_ADDRESS);
            city = getDataForDetails().get(ncase - 1).get(ExcelDataObjects.COLUMN_CITY);
            postcode = getDataForDetails().get(ncase - 1).get(ExcelDataObjects.COLUMN_POSTCODE);

            clear(browser,McssObjects.BILLING_FIRSTNAME);
            typeText(browser,McssObjects.BILLING_FIRSTNAME,firstname);
            clear(browser,McssObjects.BILLING_LASTNAME);
            typeText(browser,McssObjects.BILLING_LASTNAME,lastname);
            clear(browser,McssObjects.BILLING_ADDRESS);
            typeText(browser,McssObjects.BILLING_ADDRESS,address);
            clear(browser,McssObjects.BILLING_CITY);
            typeText(browser,McssObjects.BILLING_CITY,city);
            clear(browser,McssObjects.BILLING_POSTCODE);
            typeText(browser,McssObjects.BILLING_POSTCODE,postcode);

            awaitFor(browser,McssObjects.BILLING_COUNTRY_SELECT);
            click(browser,McssObjects.BILLING_COUNTRY);
            click(browser,McssObjects.BILLING_COUNTRY_SELECT);

            awaitFor(browser,McssObjects.BILLING_ZONE_SELECT);
            click(browser,McssObjects.BILLING_ZONE);
            click(browser,McssObjects.BILLING_ZONE_SELECT);

            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,McssObjects.BILLING_CONTINUE);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void continueOnDelivery() throws Throwable {
        message = "Ingresando a los detalles de envio";
        try
        {
            awaitFor(browser,McssObjects.DELIVERY_DETAILS_CONTINUE);
            scroll(browser,0,-1000);
            scroll(browser,0,190);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,McssObjects.DELIVERY_DETAILS_CONTINUE);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void continueOnDeliveryMethod() throws Throwable {
        message = "Ingresando a los metodos de envio";
        try
        {
            awaitFor(browser,McssObjects.DELIVERY_METHOD_CONTINUE);
            scroll(browser,0,-1000);
            scroll(browser,0,190);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,McssObjects.DELIVERY_METHOD_CONTINUE);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void continueOnPaymentMethod() throws Throwable {
        message = "Ingresando a los metodos de pago";
        try
        {
            awaitFor(browser,McssObjects.PAYMENT_CONTINUE);
            click(browser,McssObjects.PAYMENT_AGREE);
            scroll(browser,0,-1000);
            scroll(browser,0,190);
            click(browser,McssObjects.PAYMENT_CONTINUE);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void confirmOrder() throws Throwable {
        message = "Confirmando orden...";
        try
        {
            awaitFor(browser,McssObjects.CONFIRM_ORDER);
            scroll(browser,0 , -1000);
            scroll(browser,0 , 250);

            message = "Comparando montos finales";
            double total, subtotal, flatShipping;
            total = getValue(browser,McssObjects.ORDER_TOTAL);System.out.println("step here passed 1");
            subtotal = getValue(browser,McssObjects.ORDER_SUBTOTAL);System.out.println("step here passed 2");
            flatShipping = getValue(browser,McssObjects.ORDER_SHIPPINGRATE);System.out.println("step here passed 3");

            if (total == ( subtotal + flatShipping))
            {
                message += "\nCálculo de montos correcto";
                stepPass(browser, message);
                generateWord.sendText(message);
                generateWord.addImageToWord(browser);
            }
            else
            {
                message += "\nError en el cálculo de montos";
                stepFail(browser,message);
                generateWord.sendText(message);
                generateWord.addImageToWord(browser);
            }
            click(browser,McssObjects.CONFIRM_ORDER);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void compareResult() throws Throwable {
        message = "Buscando mensaje";
        try
        {
            scroll(browser,0 , -1000);
            scroll(browser,0 , 250);
            if (isDisplayed(browser,McssObjects.SUCCESS_STATE))
            {
                message += "\nSe encontro el mensaje esperado";
                stepPass(browser, message);
                generateWord.sendText(message);
                generateWord.addImageToWord(browser);
                click(browser,McssObjects.CONTINUE_HOME);
                this.browser.quit();
            }
            else
            {
                message += "\nError no se encontro el mensaje esperado";
                stepFail(browser,message);
                generateWord.sendText(message);
                generateWord.addImageToWord(browser);
                this.browser.quit();
            }
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    protected Double getTotalOfDetails(WebDriver driver, By selectors)
    {
        Double total = 0.0;
        int cnt = 0, max = driver.findElements(selectors).size();
        while (cnt < max)
        {
            String number =  driver.findElements(selectors).get(cnt).getText().substring(1);
            Double val = Double.parseDouble(number);
            total += val;
            cnt++;
        }
        return total;
    }
    protected Double getValue(WebDriver driver, By selector)
    {
        Double subtotal = 0.0;
        subtotal = Double.parseDouble(driver.findElement(selector).getText().substring(1));
        return subtotal;
    }
}
