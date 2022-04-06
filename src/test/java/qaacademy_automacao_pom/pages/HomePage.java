package qaacademy_automacao_pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;


    String REGISTRAR = "//a[@id='btnRegister']"; 
    String EMAIL = "//input[@id='inputEmail']";
    String NOME = "//input[@id='inputName']";
    String SENHA = "//input[@id='inputPassword']";
    String CONFIRM_SENHA = "//input[@id='inputPasswordConfirmation']";
    String CRIAR_SALDO = "//span[@id='toggleAddBalance']";
    String CADASTRAR = "//a[@id='btnRegister']";

    public HomePage(WebDriver driverParametro) {
        this.driver = driverParametro;

    }

    public void clicarRegistrar() {
        driver.findElement(By.xpath(REGISTRAR)).click();

    }

    public void preencherEmail() {
        driver.findElement(By.xpath(EMAIL)).sendKeys("teste1@gmail.com");

    }

    public void preencherNome() {
        driver.findElement(By.xpath(NOME)).sendKeys("QA Academy");

    }

    public void preencherSenha() {
        driver.findElement(By.xpath(SENHA)).sendKeys("teste");

    }

    public void preencherConfirmacaoSenha() {
        driver.findElement(By.xpath(CONFIRM_SENHA)).sendKeys("teste");

    }

    public void clicarEmCriarComSaldo() {
        driver.findElement(By.xpath(CRIAR_SALDO)).click();
    }

    public void clicarCadastrar() {
        driver.findElement(By.xpath(CADASTRAR)).click();
    }

}
