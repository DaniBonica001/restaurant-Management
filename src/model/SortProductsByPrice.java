package model;

import java.util.Comparator;

public class SortProductsByPrice implements Comparator<Product> {

	@Override
	public int compare( Product o1,  Product o2) {
		
		return (int)Double.parseDouble(o1.getPrice()) - (int)Double.parseDouble(o2.getPrice());
	}

}
