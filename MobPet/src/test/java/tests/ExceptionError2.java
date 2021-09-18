package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExceptionError2 {

	private WebDriver driver;


	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\DriverChrome\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}


	private void clicarCadastro() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:6191/MobPet/ecommerce/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// clicando no botão de cadastro no form de login
		WebElement loginButtonId = driver.findElement(By.xpath("//*[@id='cadButton']"));
		System.out.println("O título da página é: " + driver.getTitle());
		Thread.sleep(1000);
		loginButtonId.click();

		WebElement campoNome = driver.findElement(By.xpath("//*[@id='nome']"));
		campoNome.clear();
		campoNome.sendKeys(" ");
		Thread.sleep(1000);

		WebElement campoCPF = driver.findElement(By.xpath("//*[@id='cpf']"));
		campoCPF.clear();
		campoCPF.sendKeys("15531212330");
		Thread.sleep(1000);

		WebElement campoAnoDeNascimento = driver.findElement(By.xpath("//*[@id='birth_date']"));
		campoAnoDeNascimento.clear();
		campoAnoDeNascimento.sendKeys("17041999");
		Thread.sleep(1000);

		WebElement campoTelefone = driver.findElement(By.xpath("//*[@id='phone']"));
		campoTelefone.clear();
		campoTelefone.sendKeys(" ");
		Thread.sleep(1000);

		WebElement campoEmail = driver.findElement(By.xpath("//*[@id='email']"));
		campoEmail.clear();
		campoEmail.sendKeys(" ");
		Thread.sleep(1000);
		

		WebElement campoSenha = driver.findElement(By.xpath("//*[@id='password']"));
		campoSenha.clear();
		campoSenha.sendKeys("12345");
		Thread.sleep(1000);

		WebElement campoRepetirSenha = driver.findElement(By.xpath("//*[@id='re_password']"));
		campoRepetirSenha.clear();
		campoRepetirSenha.sendKeys("12345");
		Thread.sleep(1000);
				
		WebElement cadastrarBotao = driver.findElement(By.xpath("//*[@id='enviar']"));
		cadastrarBotao.click();
		driver.quit();
		Thread.sleep(1000);
		
	}

	@Test
	public void emptyFieldsTest()throws InterruptedException {
		clicarCadastro();
		fail("Campos Vazios");
	}
}