package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;

public class SortOrdersByDateHour implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1= LocalDate.parse(o1.getDate(), formatter);
		LocalDate date2= LocalDate.parse(o2.getDate(), formatter);
		System.out.println("FECHA: "+date1+" CODIGO: "+o1.getCode());
		
		try {
		DateFormat dateFormat = new SimpleDateFormat ("hh:mm:ss");
		Date hora1 = dateFormat.parse(o1.getHour());
		Date hora2 = dateFormat.parse(o2.getHour());
			 if(date1.compareTo(date2)<0) {
				 return -1;
			 }
			 else if(date1.compareTo(date2)>0){
				 return 1;	 
			 }
			 else{
				 if(hora1.compareTo(hora2)<0) {
					 return -1;
				 }
				 else if(hora1.compareTo(hora2)>0) {
					 return 1;
				 }
				 else {
					 return 0;
				 }	 
			 }
			 
		}catch(ParseException e) {
			System.out.println("ERROR AL PARSEAR");
			return 0;
			
		}

		
		
	}

}
