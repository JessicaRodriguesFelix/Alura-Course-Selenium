package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {
	
	@Test
	
	public void deveAdicionarUmUsuario() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/usuarios/new");
		
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));
		
		nome.sendKeys("Jessica Rodrigues de Souza");
		email.sendKeys("jessicarodrigues_felix@hotmail.com");
		
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		//garantir que a Jessica foi adicionada
		
		boolean achouNome = driver.getPageSource().contains("Jessica Rodrigues de Souza");
		boolean achouEmail = driver.getPageSource().contains("jessicarodrigues_felix@hotmail.com");
		
		assertTrue(achouNome);
		assertTrue(achouEmail);
		
		driver.close();
		
	}

}
