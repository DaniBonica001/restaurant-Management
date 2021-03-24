package model;

import java.util.Comparator;

public class SortProductsByPrice implements Comparator<Product> {

	@Override
	public int compare( Product o1,  Product o2) {
		
		return Integer.parseInt(o1.getPrice()) - Integer.parseInt(o2.getPrice());
	}

}
