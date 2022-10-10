package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.junit.Test;

import dataAccess.DataAccess;
import domain.Event;

public class gertaeraSortuDABTest {
	//sut:system under test
		 static DataAccess sut=new DataAccess();
		 
		 //additional operations needed to execute the test 
		 static TestDataAccess testDA=new TestDataAccess();

		private Event ev;
		
		@Test
		public void test1() {
			
			try{
				String dep ="Futbol";
				String desc = "Levante-PSG";
				 
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date fecha = null;
				try {
					fecha=sdf.parse("12/12/2022");
				}catch(ParseException e) {
					e.printStackTrace();
				}
				boolean emaitza = sut.gertaerakSortu(desc, fecha, dep);
				
				Vector<Event> ebentos =sut.getEvents(fecha);
				boolean a=false;
				Event ebento = null;
				int i =0;
				while(!a && i<ebentos.size()) {
					if(ebentos.get(i).getDescription() == desc) {
						ebento = ebentos.get(i);
						a = true;
					}
				}
				sut.gertaeraEzabatu(ebento);
				assertEquals(emaitza,true);
			}catch(Exception e) {
				fail();
				
			}
		}
		
		@Test
		public void test2() {
			boolean b=true;
			try{
				String dep ="Futbol";
				String desc = "Levante-PSG";
				 
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date fecha = null;
				
					fecha=sdf.parse("12/12/2012");
				
					
				
				sut.gertaerakSortu(desc, fecha, dep);
				
				Vector<Event> ebentos =sut.getEvents(fecha);
				boolean a=false;
				Event ebento = null;
				int i =0;
				while(!a && i<ebentos.size()) {
					if(ebentos.get(i).getDescription() == desc) {
						ebento = ebentos.get(i);
						a = true;
					}
				}
				sut.gertaeraEzabatu(ebento);
			}catch(Exception e) {
				b=false;
				
			}
			assertEquals(b,true);
		}
		
		@Test
		public void test3() {
			boolean b=true;
			try{
				String dep ="Futbol";
				String desc = "Levante contra PSG";
				 
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date fecha = null;
				
					fecha=sdf.parse("12/12/2023");
				
					
				
				sut.gertaerakSortu(desc, fecha, dep);
				
				Vector<Event> ebentos =sut.getEvents(fecha);
				boolean a=false;
				Event ebento = null;
				int i =0;
				while(!a && i<ebentos.size()) {
					if(ebentos.get(i).getDescription() == desc) {
						ebento = ebentos.get(i);
						a = true;
					}
				}
				sut.gertaeraEzabatu(ebento);
			}catch(Exception e) {
				b=false;
				
			}
			assertEquals(b,false);
		}
		
}
