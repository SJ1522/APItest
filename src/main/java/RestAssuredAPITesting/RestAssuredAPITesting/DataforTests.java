package RestAssuredAPITesting.RestAssuredAPITesting;

import org.testng.annotations.DataProvider;

public class DataforTests {
  
	@DataProvider(name="fetchdata")
	public Object[][] dataForPost(){
//	   Object[][] data = new Object[2][3];	
//	   data[0][0]="Lalitha";
//	   data[0][1]="Viswanathan";
//	   data[0][2]="4";
//	   
//	   data[1][0]="Sidhaan";
//	   data[1][1]="Karthic";
//	   data[1][2]="5";
	   return 	new Object[][] {
			   {"Aadhira","Karthic",1},
			   {"Priyanka","Karthic",2}
	   };
	
	}
	
	@DataProvider(name="deleteData")
	public Object[] dataforDelete(){
		return new Object[]{
			9,10,11	
	           };
	}
}
