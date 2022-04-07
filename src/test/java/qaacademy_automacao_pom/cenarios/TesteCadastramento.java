package qaacademy_automacao_pom.cenarios;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import qaacademy_automacao_pom.pages.HomePage;
/*
- Os campos Nome, Email, Senha e Confirmação de senha são de preenchimento obrigatório

Erro: Nome não pode ser vazio


*/
public class TesteCadastramento {
    WebDriver driver;
    HomePage homePage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/");

    }

    
    @Test
    public void testePositivoCadastro() {
        homePage.clicarRegistrar();
        homePage.preencherEmail("teste1@gmail.com");
        homePage.preencherNome("QA Academy");
        homePage.preencherSenha("teste");
        homePage.preencherConfirmacaoSenha("teste");
        homePage.clicarEmCriarComSaldo();
        homePage.clicarCadastrar();
        validarMensagem("foi criada com sucesso");

    }

    @Test
    public void testeCadastroVazio() {
        homePage.clicarRegistrar();
        homePage.clicarCadastrar();
        validarMensagem("Nome não pode ser vazio");

    }


    public void validarMensagem(String msg) {
        Assert.assertTrue(driver.getPageSource().contains(msg));
    }
        
    @After
    public void finalizar() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
