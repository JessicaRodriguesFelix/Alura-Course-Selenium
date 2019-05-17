package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeiloesSystem {
	
	private WebDriver driver;
	private LeiloesPage leiloes;
	
	@Before
	public void inicializa() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		leiloes = new LeiloesPage(driver);
		
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Fernanda Rodrigues de Souza", "jessicarodrigues_felix@hotmail.com");
				
	}
	
	@Test
	public void deveCadastrarUmLeilao() throws InterruptedException {
		
		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();		
		novoLeilao.preenche("Carro", 50000, "Fernanda Rodrigues de Souza", true);
		
		 Thread.sleep(3000);
		
		assertTrue(leiloes.existe("Carro", 50000, "Fernanda Rodrigues de Souza", true));		
		
	}

}
