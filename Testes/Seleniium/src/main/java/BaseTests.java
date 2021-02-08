import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class BaseTests {

    private WebDriver driver;

    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://livecom.livetouchdev.com.br/logon.htm");

        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("form_login"));
        WebElement senha = driver.findElement(By.id("form_senha"));
        WebElement entrar = driver.findElement(By.id("form_logon"));

        File file = new File("resources/credentials.cryp");
        BufferedReader bufferedReader = null;
        FileWriter writer = null;
        FileReader reader = null;

        if(file.exists()){
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            String loginSenha = bufferedReader.readLine();
            if(loginSenha != null){

                String[] split = loginSenha.split(";");
                if(split.length == 2){
                    String loginRec = split[0];
                    String senhaRec = split[1];

                    username.sendKeys(loginRec);
                    senha.sendKeys(senhaRec);
                    entrar.click();
                }

            }else{
                gravarArquivo(username, senha, entrar);
            }

        }else{
            gravarArquivo(username, senha, entrar);
        }
        writer.close();

    }

    private void gravarArquivo(WebElement username, WebElement senha, WebElement entrar) throws IOException {
        FileWriter writer;
        String login = username.getText();
        String password = senha.getText();

        if(login != "" && password != ""){
            writer = new FileWriter(new File("resources/credentials.cryp"));
            writer.write(login + ";" + password);
            writer.close();
        }
    }

    public static void main(String[] args) throws IOException {
        BaseTests tests = new BaseTests();
        tests.setUp();
    }
}
