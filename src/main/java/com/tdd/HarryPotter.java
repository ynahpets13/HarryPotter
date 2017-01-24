package com.tdd;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.utils.FinalConstant;

public class HarryPotter {
	public Double purchaseBasket(String purchase) throws NumberFormatException {
		StringTokenizer token = new StringTokenizer(purchase, "+");
		Map<String, Double> booksHP = new HashMap<String, Double>();
		booksHP = initialize(booksHP);
		Double value= 0.0;
		String book= "";

		while (token.hasMoreElements()) {
			String buy= token.nextElement().toString();
			buy = validbuy(buy);
			int size = buy.length();
			
			value = Double.valueOf(buy.substring(0,size-3));
			book= buy.substring(--size).toString();
			
			switch (book) {
			case "1":
				value = value + booksHP.get(FinalConstant.HP1);
				booksHP.put(FinalConstant.HP1, value);
				break;
			case "2":
				value = value + booksHP.get(FinalConstant.HP2);
				booksHP.put(FinalConstant.HP2, value);
				break;
			case "3":
				value = value + booksHP.get(FinalConstant.HP3);
				booksHP.put(FinalConstant.HP3, value);
				break;
			case "4":
				value = value + booksHP.get(FinalConstant.HP4);
				booksHP.put(FinalConstant.HP4, value);
				break;
			case "5":
				value = value + booksHP.get(FinalConstant.HP5);
				booksHP.put(FinalConstant.HP5, value);
				break;
			default:
				break;
			}
		}
		booksHP = getTotalCostBooksHP(booksHP);
		
		return booksHP.get(FinalConstant.totalCost);
	}
	
	public Map<String, Double> initialize(Map<String, Double> booksHP) {
		double value = 0.0;
		booksHP.put(FinalConstant.HP1, value);
		booksHP.put(FinalConstant.HP2, value);
		booksHP.put(FinalConstant.HP3, value);
		booksHP.put(FinalConstant.HP4, value);
		booksHP.put(FinalConstant.HP5, value);
		
		return booksHP;
	}
	
	public String validbuy(String buy) {
		if ( buy.length() < 4 ) {
			StringBuffer sb = new StringBuffer();
			sb.append("1");
			sb.append(buy);
			buy = sb.toString();
		}
		return buy;
	}
	
	public Map<String, Double> getTotalCostBooksHP(Map<String, Double> booksHP){
		boolean cycle=true;
		
		booksHP.put(FinalConstant.countBooks1, booksHP.get(FinalConstant.HP1));
		booksHP.put(FinalConstant.countBooks2, booksHP.get(FinalConstant.HP2));
		booksHP.put(FinalConstant.countBooks3, booksHP.get(FinalConstant.HP3));
		booksHP.put(FinalConstant.countBooks4, booksHP.get(FinalConstant.HP4));
		booksHP.put(FinalConstant.countBooks5, booksHP.get(FinalConstant.HP5));
		
		int books1 = booksHP.get(FinalConstant.countBooks1).intValue();
		int books2 = booksHP.get(FinalConstant.countBooks2).intValue();
		int books3 = booksHP.get(FinalConstant.countBooks3).intValue();
		int books4 = booksHP.get(FinalConstant.countBooks4).intValue();
		int books5 = booksHP.get(FinalConstant.countBooks5).intValue();
		
		booksHP.put(FinalConstant.totalCost, 0.0);
		
		while (cycle) {
			booksHP.put(FinalConstant.purchase, 0.0);
			
			if( books1 == 0 && books2 == 0 && books3 == 0 &&
					books4 == 0 && books5 == 0
			) {
				cycle=false;
			}
			else {
				booksHP = getTotalCost(booksHP);
				
				books1 = booksHP.get(FinalConstant.countBooks1).intValue();
				books2 = booksHP.get(FinalConstant.countBooks2).intValue();
				books3 = booksHP.get(FinalConstant.countBooks3).intValue();
				books4 = booksHP.get(FinalConstant.countBooks4).intValue();
				books5 = booksHP.get(FinalConstant.countBooks5).intValue();
			}
		}
		
		return booksHP;
	}
	
	public Map<String, Double> getTotalCost(Map<String, Double> booksHP) {
		for(int cycle=1; cycle<6; cycle++) {
			booksHP = booksPurchases(booksHP, cycle);
		}
		
		booksHP = sumTotalCost(booksHP);
		
		return booksHP;
	}
	
	public Map<String, Double> booksPurchases(Map<String, Double> booksHP, int cycle) {
		int books = 0;
		double purchase = 0.0;
		int sumBin = 0;
		String keyBook = "";
		
		switch (cycle) {
		case 1:
			keyBook = FinalConstant.countBooks1;
			break;
		case 2:
			keyBook = FinalConstant.countBooks2;
			break;
		case 3:
			keyBook = FinalConstant.countBooks3;
			break;
		case 4:
			keyBook = FinalConstant.countBooks4;
			break;
		case 5:
			keyBook = FinalConstant.countBooks5;
			break;
		default:
			break;
		}
		
		books = booksHP.get(keyBook).intValue();
		
		if (books > 0) {
			books = books-1;
			double dBooks = books;
			booksHP.put(keyBook, dBooks);
			
			sumBin=1;
		} else {
			sumBin=0;
		}
		
		purchase = booksHP.get(FinalConstant.purchase).intValue();
		purchase = purchase + sumBin;
		booksHP.put(FinalConstant.purchase, purchase);
		
		return booksHP; 
	}
	
	public Map<String, Double> sumTotalCost(Map<String, Double> booksHP) {
		int cost = booksHP.get(FinalConstant.purchase).intValue();
		double counting = booksHP.get(FinalConstant.totalCost);
		
		switch (cost) {
		case 1:
			counting = counting + FinalConstant.book1; 
			break;
		case 2:
			counting = counting + FinalConstant.book2;
			break;
		case 3:
			counting = counting + FinalConstant.book3;
			break;
		case 4:
			counting = counting + FinalConstant.book4;
			break;
		case 5:
			counting = counting + FinalConstant.book5;
			break;
		default:
			break;
		}
		
		booksHP.put(FinalConstant.totalCost,counting);
		
		return booksHP;
	}
}