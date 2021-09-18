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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HappyTest {

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
		campoNome.sendKeys("Ruan Lee");
		Thread.sleep(1000);

		WebElement campoCPF = driver.findElement(By.xpath("//*[@id='cpf']"));
		campoCPF.clear();
		campoCPF.sendKeys("1223121232");
		Thread.sleep(1000);

		WebElement campoAnoDeNascimento = driver.findElement(By.xpath("//*[@id='birth_date']"));
		campoAnoDeNascimento.clear();
		campoAnoDeNascimento.sendKeys("17041999");
		Thread.sleep(1000);

		WebElement campoTelefone = driver.findElement(By.xpath("//*[@id='phone']"));
		campoTelefone.clear();
		campoTelefone.sendKeys("11940028922");
		Thread.sleep(1000);

		WebElement campoEmail = driver.findElement(By.xpath("//*[@id='email']"));
		campoEmail.clear();
		campoEmail.sendKeys("ruanlee@gmail.com");
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
		Thread.sleep(1000);

		WebElement loginInput = driver.findElement(By.xpath("//*[@id='inputLogin']"));
		loginInput.clear();
		loginInput.sendKeys("ruanlee@gmail.com");
		Thread.sleep(1000);

		WebElement passInput  = driver.findElement(By.xpath("//*[@id='inputPassword']"));
		passInput.clear();
		passInput.sendKeys("12345");
		Thread.sleep(1000);
			
		WebElement loginBotao = driver.findElement(By.xpath("//*[@id='myButton']"));
		System.out.println("O título da página é: " + driver.getTitle());
		loginBotao.click();

		WebElement perfilUser  = driver.findElement(By.xpath("//*[@id='perfil']"));
		perfilUser.click();
		
		WebElement perfilDados = driver.findElement(By.xpath("//*[@id='informationChange']"));
		System.out.println("O título da página é: " + driver.getTitle());
		perfilDados.click();
		Thread.sleep(1000);
		
		
		// atualização de dados cliente
		WebElement editarPerfil = driver.findElement(By.xpath("//*[@id='modalClique']"));
		System.out.println("O título da página é: " + driver.getTitle());
		editarPerfil.click();
		Thread.sleep(1000);
		
		WebElement campoNomeEditar = driver.findElement(By.xpath("//*[@id='nome']"));
		campoNomeEditar.clear();
		campoNomeEditar.sendKeys("Ruan Bobby Lee");
		Thread.sleep(1000);

		WebElement campoCPFEditar = driver.findElement(By.xpath("//*[@id='cpf']"));
		campoCPFEditar.clear();
		campoCPFEditar.sendKeys("2222221112");
		Thread.sleep(1000);

		WebElement campoAnoDeNascimentoEditar = driver.findElement(By.xpath("//*[@id='birth_date']"));
		campoAnoDeNascimentoEditar.clear();
		campoAnoDeNascimentoEditar.sendKeys("22111999");
		Thread.sleep(1000);

		WebElement campoTelefoneEditar = driver.findElement(By.xpath("//*[@id='phone']"));
		campoTelefoneEditar.clear();
		campoTelefoneEditar.sendKeys("82222222");
		Thread.sleep(1000);

		WebElement campoEmailEditar = driver.findElement(By.xpath("//*[@id='email']"));
		campoEmailEditar.clear();
		campoEmailEditar.sendKeys("ruanbobbylee@gmail.com");
		Thread.sleep(1000);

		WebElement campoSenhaEditar = driver.findElement(By.xpath("//*[@id='password']"));
		campoSenhaEditar.clear();
		campoSenhaEditar.sendKeys("12345");
		Thread.sleep(1000);

		WebElement campoRepetirSenhaEditar = driver.findElement(By.xpath("//*[@id='re_password']"));
		campoRepetirSenhaEditar.clear();
		campoRepetirSenhaEditar.sendKeys("12345");
		Thread.sleep(1000);

		WebElement finalizarEdicao = driver.findElement(By.xpath("//*[@id='cadastrarEndereco']"));
		finalizarEdicao.click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		//volta para o perfil
		WebElement voltarPerfil = driver.findElement(By.xpath("//*[@id='perfil']"));
		voltarPerfil.click();
		Thread.sleep(1000);
		
		//cadastro de endereço	
		WebElement acessarEnderecos = driver.findElement(By.xpath("//*[@id='addresssChange']"));
		acessarEnderecos.click();
		Thread.sleep(1000);
		
		WebElement adicionarEndereco = driver.findElement(By.xpath("//*[@id='cadAddress']"));
		adicionarEndereco.click();
		Thread.sleep(1000);

		WebElement campoCEP = driver.findElement(By.xpath("//*[@id='cep']"));
		campoCEP.clear();
		campoCEP.sendKeys("08451111");
		Thread.sleep(1000);

		WebElement campoLOG = driver.findElement(By.xpath("//*[@id='log']"));
		campoLOG.clear();
		campoLOG.sendKeys("rua fatec");
		Thread.sleep(1000);

		WebElement campoComplemento = driver.findElement(By.xpath("//*[@id='complement']"));
		campoComplemento.clear();
		campoComplemento.sendKeys("casa sogra");
		Thread.sleep(1000);

		WebElement campoNumeroCasa = driver.findElement(By.xpath("//*[@id='num']"));
		campoNumeroCasa.clear();
		campoNumeroCasa.sendKeys("22");
		Thread.sleep(1000);

		WebElement campoBairro = driver.findElement(By.xpath("//*[@id='distr']"));
		campoBairro.clear();
		campoBairro.sendKeys("Mogi das Cruzes");
		Thread.sleep(1000);

		WebElement campoCidade = driver.findElement(By.xpath("//*[@id='city']"));
		campoCidade.clear();
		campoCidade.sendKeys("Mogi das Cruzes");
		Thread.sleep(1000);
		
		WebElement campoEstado = driver.findElement(By.xpath("//*[@id='state']"));
		campoEstado.clear();
		campoEstado.sendKeys("São Paulo");
		Thread.sleep(1000);

		WebElement campoCadastrarEndereco = driver.findElement(By.xpath("//*[@id='addAddress']"));
		campoCadastrarEndereco.click();
		driver.switchTo().alert().accept();
		
		Thread.sleep(1000);
		

		// editar endereco
		
		WebElement editEndereco = driver.findElement(By.xpath("//*[@id='editarEnd']"));
		editEndereco.click();
		Thread.sleep(1000);

		WebElement campoEditCadastrarEndereco = driver.findElement(By.xpath("//*[@id='cadastrarEndereco']"));
		campoEditCadastrarEndereco.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		WebElement campoDeletCadastrarEndereco = driver.findElement(By.xpath("//*[@id='excluirCad']"));
		campoDeletCadastrarEndereco.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		Thread.sleep(2000);
		
		//volta para o perfil
		WebElement voltarPerfil2 = driver.findElement(By.xpath("//*[@id='perfil']"));
		voltarPerfil2.click();
		Thread.sleep(1000);		
		
		
		
				
		// clique em cartao
		WebElement editarCartao = driver.findElement(By.xpath("//*[@id='paymentChange']"));
		editarCartao.click();
		Thread.sleep(1000);
		
		// cadastro de cartao
		
		WebElement adicionarCartao = driver.findElement(By.xpath("//*[@id='cadNewCartao']"));
		adicionarCartao.click();
		Thread.sleep(1000);
		
		WebElement campoCartaoNome = driver.findElement(By.xpath("//*[@id='nomeCartao']"));
		campoCartaoNome.clear();
		campoCartaoNome.sendKeys("RUAN LEE");
		Thread.sleep(1000);
		
		WebElement campoCartaoNumero = driver.findElement(By.xpath("//*[@id='num']"));
		campoCartaoNumero.clear();
		campoCartaoNumero.sendKeys("1111 1112 2222 4588");
		Thread.sleep(1000);
		
		WebElement campoCartaoCVV = driver.findElement(By.xpath("//*[@id='cvv']"));
		campoCartaoCVV.clear();
		campoCartaoCVV.sendKeys("123");
		Thread.sleep(1000);
		
		WebElement campoCartaoCadastro = driver.findElement(By.xpath("//*[@id='cadCartao']"));
		campoCartaoCadastro.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		

		//Editar Cartão
		 WebElement botaoEditarCartao = driver.findElement(By.xpath("//*[@id='editarCartao']"));
		 botaoEditarCartao.click();
		 Thread.sleep(1000);
		 
		 WebElement botaoFechar = driver.findElement(By.xpath("//*[@id='fechar']"));
		 botaoFechar.click();
		 Thread.sleep(1000);
		
		WebElement botaoExcluirCartao = driver.findElement(By.xpath("//*[@id='excluirCartao']"));
		botaoExcluirCartao.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		driver.quit();
	}

	@Test
	public void testeCliqueCadastro() throws InterruptedException {
		clicarCadastro();
	}

}
