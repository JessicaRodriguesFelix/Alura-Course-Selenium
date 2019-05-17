package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {
	
	
	private FirefoxDriver driver;
	
	
	@Before	
	public void inicializa() {	
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		this.driver = new FirefoxDriver();
		
	}
	
	@Test
	
	public void deveAdicionarUmUsuario() throws Exception {
		
		UsuariosPage usuarios = new UsuariosPage(driver);
		

		usuarios.visita();
		Thread.sleep(3000);
        usuarios.novo().cadastra("Jessica Rodrigues de Souza", "jessicarodrigues_felix@hotmail.com");

        Thread.sleep(3000);
        
        assertTrue(usuarios.existeNaListagem("Jessica Rodrigues de Souza", "jessicarodrigues_felix@hotmail.com"));	
		}
	
	@After 
	public void finaliza() {
		driver.close();	
	}	
}



