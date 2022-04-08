package qaacademy_automacao_pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

//Variavel maiuscula quer Final. Uma variavel que muda pouco ou nunca o seu valor. 
    String REGISTRAR = "//button[contains(text(),'Registrar')]"; 
    String EMAIL = "//input[@id='inputEmail']";
    String NOME = "//input[@id='inputName']";
    String SENHA = "//input[@id='inputPassword']";
    String CONFIRM_SENHA = "//input[@id='inputPasswordConfirmation']";
    String CRIAR_SALDO = "//span[@type='checkbox']";
    String CADASTRAR = "//a[@id='btnRegister']";
    String FECHAR = "//a[contains(text(),'Fechar')]"; 

    public HomePage(WebDriver driverParametro) {//Metodo construtor
        this.driver = driverParametro;

    }

    public void clicarRegistrar() {
        driver.findElement(By.xpath(REGISTRAR)).click();

    }

    public void preencherEmail(String email) {
        driver.findElement(By.xpath(EMAIL)).sendKeys(email);

    }

    public void preencherNome(String nome) {
        driver.findElement(By.xpath(NOME)).sendKeys(nome);
    }

    public void preencherSenha(String senha) {
        driver.findElement(By.xpath(SENHA)).sendKeys(senha);
    }

    public void preencherConfirmacaoSenha(String confirmacao) {
        driver.findElement(By.xpath(CONFIRM_SENHA)).sendKeys(confirmacao);

    }

    public void clicarEmCriarComSaldo() {
        driver.findElement(By.xpath(CRIAR_SALDO)).click();
    }

    public void clicarCadastrar() {
        driver.findElement(By.xpath(CADASTRAR)).click();
    }

    public void clicarFechar() {
        driver.findElement(By.xpath(FECHAR)).click();
    }

}
