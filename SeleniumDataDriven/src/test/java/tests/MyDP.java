package tests;

import org.testng.annotations.DataProvider;

public class MyDP {
	@DataProvider(name = "dp1")
	public Object[][] createData()
	{
		Object[][] obj= {
				{"kim","mskim"},
				{"lee","mslee"},
				{"park","mspark"}
				};
		return obj;
	}
	@DataProvider(name="dp2")
	public Object[][] createDataFromExcel()
	{
		return ReadExcelData.
				readDataFromExcel("Sheet1");
	}

}
