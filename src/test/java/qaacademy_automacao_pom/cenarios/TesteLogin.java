package qaacademy_automacao_pom.cenarios;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import qaacademy_automacao_pom.pages.HomePage;
import qaacademy_automacao_pom.pages.LoginPage;

public class TesteLogin {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    String email = "teste1@gmail.com";
    String senha = "teste";

    @Before
    public void setup() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/");
        cadastrarUsuario();

    }

    @Test
    public void testeLoginComSucesso() {
        String msgValidacao = "bem vindo ao BugBank :)";
        loginPage.preencherEmail(email);
        loginPage.preencherSenha(senha);
        loginPage.clicarAcessar();
        validarMensagem(msgValidacao);
        validarUrl("/home");

    }

    public void validarMensagem(String msg) {
        Assert.assertTrue(driver.getPageSource().contains(msg));
    }
    public void validarUrl(String pagina) {
        Assert.assertTrue(driver.getCurrentUrl().contains(pagina));
    }

    @After
    public void finalizar() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public void cadastrarUsuario() {
        homePage.clicarRegistrar();
        homePage.preencherEmail(email);
        homePage.preencherNome("QA Academy");
        homePage.preencherSenha("teste");
        homePage.preencherConfirmacaoSenha("teste");
        homePage.clicarEmCriarComSaldo();
        homePage.clicarCadastrar();
        validarMensagem("foi criada com sucesso");
        homePage.clicarFechar();
    }

}
