package com.guru99.gurubank.pruebas.steps;

import com.guru99.gurubank.pruebas.models.DataInjection;
import com.guru99.gurubank.pruebas.pageobjects.Guru99BankPageObject;
import com.sqasa.web.demo.utils.KrakenWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import static com.guru99.gurubank.pruebas.utils.SpecialMethods.*;

public class Guru99BankSteps extends KrakenWeb {

    Guru99BankPageObject guru99BankPageObject = new Guru99BankPageObject();
    DataInjection dataInjection = new DataInjection();



    public void openBrowser(){
        configuracionesIniciales();
        abrirNavegadorEn(guru99BankPageObject);
    }

    @Step
    public void loginUser(){
        escribirTexto(guru99BankPageObject.userIDInput , dataInjection.getUserID());
        escribirTexto(guru99BankPageObject.passwordUserInput, dataInjection.getPasswordUser());
        click(guru99BankPageObject.loginBtn);
    }

    @Step
    public void newCustomer(){
        click(guru99BankPageObject.selectNewCustomer);
    }

    @Step
    public void createNewCustomer(){
        escribirTexto(guru99BankPageObject.customerNameInput, dataInjection.getCustomerName());
        escribirTexto(guru99BankPageObject.customerNameInput, dataInjection.getCustomerName());
        escribirTexto(guru99BankPageObject.dateOfBirthInput , dataInjection.getDateOfBirth());
        escribirTexto(guru99BankPageObject.addressInput, dataInjection.getAddress());
        escribirTexto(guru99BankPageObject.cityInput , dataInjection.getCity());
        escribirTexto(guru99BankPageObject.stateInput , dataInjection.getState());
        escribirTexto(guru99BankPageObject.pinInput , dataInjection.getPin());
        escribirTexto(guru99BankPageObject.mobileNumberInput , dataInjection.getMobileNumber());
        escribirTexto(guru99BankPageObject.emailInput , dataInjection.getEmail());
        escribirTexto(guru99BankPageObject.passwordInput , dataInjection.getPassword());
        click(guru99BankPageObject.submitbtn);
    }

    @Step
    public void successfullyCreation()  {
        validarIgual(guru99BankPageObject.customerRegisteredValidation, dataInjection.getRegisteredSuccessfullyText());
    }

    @Step
    public void createNewAccount() {
        String saveCustomerID = guru99BankPageObject.getDriver().findElement(guru99BankPageObject.customerID).getText();
        click(guru99BankPageObject.selectNewAccount);
        escribirTexto(guru99BankPageObject.customerIdInput, saveCustomerID);
        escribirTexto(guru99BankPageObject.initialDepositInput, dataInjection.getInitialDeposit());
        click(guru99BankPageObject.submitBtnAccount);

    }

    @Step
    public void validateNewAccount(){
       validarIgual(guru99BankPageObject.accountGeneratedValidation, dataInjection.getAccountGeneratedSuccessfullyText());
    }







}
