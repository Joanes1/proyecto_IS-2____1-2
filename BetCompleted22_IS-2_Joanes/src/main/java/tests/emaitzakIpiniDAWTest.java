package tests;

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

import configuration.UtilDate;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.Quote;
import domain.Team;
import configuration.UtilDate;
public class emaitzakIpiniDAWTest {
	static DataAccess sut = new DataAccess();
	
	private Event evento1;
	private Question q1;
	
	private Quote quote1;
	private Quote quote2;

	private Event evento2;
	private Question q2;
	
	@Before
	public void initialize() {
		evento1 = sut.getEventsAll().get(0);
		q1 = evento1.getQuestions().get(0);
		quote1 = q1.getQuotes().get(0);
		
		evento2 = sut.getEventsAll().get(0);
		q2 =  evento2.getQuestions().get(1);		
		quote2 = q2.getQuotes().get(0);
		
		
		
	}
	
	@Test
	public void test1() {
		Date data = evento1.getEventDate();
		evento1.setEventDate(UtilDate.newDate(2025,10,12));
		try {
			sut.EmaitzakIpini(quote1);
		}catch(Exception EventNotFinished) {
			System.out.println("Event not finished");
			assertTrue(true);
		}
		
		try {
			evento1.setEventDate(data);
		} catch (Exception e) {
			fail("Impossible!!");
		}
	}
	
	@Test
	public void test2() {
		Date data = evento2.getEventDate();
		evento2.setEventDate(UtilDate.newDate(2022,9,5));

		try {
			sut.EmaitzakIpini(quote2);
		}catch(Exception EventNotFinished) {
			System.out.println("Event not finished");
			//assertTrue(true);
		}
		
		String expected = quote2.getForecast();
		String obtained = q2.getResult();
		
		assertEquals(expected, obtained);
		
		try {
			evento2.setEventDate(data);
			quote2.getQuestion().setResult("");
		} catch (Exception e) {
			fail("Impossible!!");
		}
	}
	
	
	
	
	
}

