package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import domain.Article;
import domain.Purchase;
import exceptions.PurchaseException;

public class PurchaseTest {
	// Variables comunes para los casos de prueba.
		private Purchase basket= new Purchase();
		private double price;
		private int quantity=1;
		private Article article;

		// Inicialización a realizar antes de nada cuando se van a ejecutar los casos 	// de prueba de la clase
		@Before
		public void initialize() {
			System.out.println("Inicializo y compruebo ...");
			assertNull(basket.getDate());
			assertEquals(basket.getCost(), 0, 0);
			price= 0;	// 234.99 real value
			quantity = 1;
			article = new Article("404", "MASK PINK", price, false, quantity);
		} 

		@Test
		public void testAddBasket1() {
			quantity = 1;
			price = 234.99;

			//1. expected value
			double expected = quantity*price;

			//2. invoke the method and get the result
			double obtained = basket.addBasket(article, quantity);
			
			//3. check
			assertEquals(expected, obtained,0); //expected always 1st param
			    
	                       
	        //4. stablish the initial state 
			try {
				basket.removeBasket(article, quantity);
				assertTrue(true);
			} catch (PurchaseException e) {
				fail("Impossible!!");
			}
		}

		@Test
		public void testAddBasket2() {
			
			quantity = 3;
			price = 234.99;
			double expected = quantity*price;

			double obtained = basket.addBasket(article, quantity);
			assertEquals(expected, obtained, 0);
			try {
				basket.removeBasket(article, quantity);
			} catch (PurchaseException e) {
				fail("Impossible!!");
			}
		}
		
		@Test
		public void testAddBasket3() {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date date = format.parse("23/12/2020");
				basket.buy(date);
				assertNotNull(basket.getDate());
				
				quantity = 3;
				double expected= quantity*article.getPrice();
				
				double cost= basket.addBasket(article, quantity);
				
				assertEquals(expected, cost, 0);
				
			} catch (ParseException e) {
				fail("The date 23/12/2020 is correct");
			}
		}


}
