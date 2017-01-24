package com.tdd;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.utils.FinalConstant;

public class HarryPotterTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public final void basketExample() {
		String test="2HP1+2HP2+2HP3+1HP4+1HP5";
		HarryPotter hp =  new HarryPotter();
		double eur = hp.purchaseBasket(test);
		double pay= FinalConstant.book5+FinalConstant.book3;
		Assert.assertTrue(eur== pay);
		
		System.out.println(test+" -- "+eur+" EUR");
	}
	
	@Test
	public final void basketManyStrings() {
		String test="1HP1+2HP2+2HP3+1HP4+1HP5+1HP1";
		HarryPotter hp =  new HarryPotter();
		double eur = hp.purchaseBasket(test);
		double pay= FinalConstant.book5+FinalConstant.book3;
		Assert.assertTrue(eur== pay);
		
		System.out.println(test+" -- "+eur+" EUR");
	}
	
	@Test
	public final void basketWhitoutNumber() {
		String test="1HP1+2HP2+2HP3+1HP4+1HP5+HP1";
		HarryPotter hp =  new HarryPotter();
		double eur = hp.purchaseBasket(test);
		double pay= FinalConstant.book5+FinalConstant.book3;
		Assert.assertTrue(eur== pay);
		
		System.out.println(test+" -- "+eur+" EUR");
	}
	
	@Test
	public final void basketOneBook() {
		String test="1HP1";
		HarryPotter hp =  new HarryPotter();
		double eur = hp.purchaseBasket(test);
		double pay= FinalConstant.book1;
		Assert.assertTrue(eur== pay);
		
		System.out.println(test+" -- "+eur+" EUR");
	}
	
	@Test
	public final void basketOneBookWhitoutNumber() {
		String test="HP4";
		HarryPotter hp =  new HarryPotter();
		double eur = hp.purchaseBasket(test);
		double pay= FinalConstant.book1;
		Assert.assertTrue(eur== pay);
		
		System.out.println(test+" -- "+eur+" EUR");
	}
	
	@Test
	public final void basketTwoBooks() {
		String test="HP4+2HP5";
		HarryPotter hp =  new HarryPotter();
		double eur = hp.purchaseBasket(test);
		double pay= FinalConstant.book2+FinalConstant.book1;
		Assert.assertTrue(eur== pay);
		
		System.out.println(test+" -- "+eur+" EUR");
	}
	
	@Test
	public final void basketTwoDigits() {
		String test="10HP3";
		HarryPotter hp =  new HarryPotter();
		double eur = hp.purchaseBasket(test);
		double pay= FinalConstant.book1*10;
		Assert.assertTrue(eur== pay);
		
		System.out.println(test+" -- "+eur+" EUR");
	}
	
	@Test
	public final void basketThreeDigits() {
		String test="100HP3";
		HarryPotter hp =  new HarryPotter();
		double eur = hp.purchaseBasket(test);
		double pay= FinalConstant.book1*100;
		Assert.assertTrue(eur== pay);
		
		System.out.println(test+" -- "+eur+" EUR");
	}
	
	@Test
	public final void basketTwoDigitsMore() {
		String test="11HP3+HP4";
		HarryPotter hp =  new HarryPotter();
		double eur = hp.purchaseBasket(test);
		double pay= FinalConstant.book2+(FinalConstant.book1*10);
		Assert.assertTrue(eur== pay);
		
		System.out.println(test+" -- "+eur+" EUR");
	}
	
	@Test
	public final void basketDoubleTwoDigitsMore() {
		String test="12HP3+11HP4+112HP5+HP5";
		HarryPotter hp =  new HarryPotter();
		double eur = hp.purchaseBasket(test);
		double pay= (FinalConstant.book3*11)+(FinalConstant.book2)+(FinalConstant.book1*101);
		Assert.assertTrue(eur== pay);
		
		System.out.println(test+" -- "+eur+" EUR");
	}
	
	@Test
	public final void basketCollection() {
		String test="HP1+HP2+HP3+HP4+HP5+0HP1";
		HarryPotter hp =  new HarryPotter();
		double eur = hp.purchaseBasket(test);
		double pay= FinalConstant.book5;
		Assert.assertTrue(eur== pay);
		
		System.out.println(test+" -- "+eur+" EUR");
	}
	
	@Test
	public final void basketZeroBooks() {
		String test="0HP1+0HP5";
		HarryPotter hp =  new HarryPotter();
		double eur = hp.purchaseBasket(test);
		double pay= FinalConstant.book1*2*0;
		Assert.assertTrue(eur== pay);
		
		System.out.println(test+" -- "+eur+" EUR");
	}
	
	@Test
	public final void basketFail() {
		String test="2HP1+15";
		HarryPotter hp =  new HarryPotter();
		
		System.out.println("-- ExpectedException");
		expectedException.expect(NumberFormatException.class);
		double eur = hp.purchaseBasket(test);
		double pay= FinalConstant.book2+FinalConstant.book1;
		Assert.assertTrue(eur== pay);
		
		System.out.println(test+" -- "+eur+" EUR");
	}
}