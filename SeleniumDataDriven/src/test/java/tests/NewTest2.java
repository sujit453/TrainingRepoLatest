package tests;

import org.testng.annotations.Test;

public class NewTest2 {
	
	@Test(groups = "dry")
	public void test1()
	{
		
	}
	@Test(groups = {"dry","smoke"})
	public void test2()
	{
		
	}
	@Test(groups = "smoke")
	public void test3()
	{
		
	}
	@Test(groups = "smoke")
	public void test4()
	{
		
	}
	@Test(groups = "sanity",dependsOnGroups = "dry")
	public void test0()
	{
		
	}
}
