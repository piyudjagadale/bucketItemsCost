package com.cognizant.item.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ProcessItemsImplTest 
{
	
	private ProcessItemsImpl processItems;
	
	private List<String> items;
	
	@Before
	public void setUp(){
		
		processItems = new ProcessItemsImpl();
		items = new ArrayList<String>();
	}
   
    @Test
    public void processItemsTest()
    {
    	items.add("Banana");
    	items.add("Apple");
    	items.add("Asdf");
    	items.add("Banana");
    	
		Integer actualCost = processItems.processItems(items);
		Assert.assertNotNull(actualCost);
		Assert.assertEquals(new Integer(22), actualCost);
    }
    
    @Test(expected=Exception.class)
    public void processNullItemsTest()
    {
		processItems.processItems(null);
    }
    
    @Test(expected=Exception.class)
    public void processBlankItemsTest()
    {
    	items.add("");
		processItems.processItems(items);
    }
}
