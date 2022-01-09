package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.excelCodes;

public class MethodsUsedMultipleTimes {

	
	public static RequestSpecification req;
	public static Response response;
	public static WebDriver drivers;
	public static Logger log=LogManager.getLogger("Rest-Assured-DATA-DRIVEN-TESTING");

	@BeforeClass
	public void logMaker() {
		log.debug("this is degugging"); 
		log.info("this is infor"); 
		log.fatal("this is fatal"); 
		log.error("this is error"); 

	}
	/*
	 * static File screen; public static Object screenShots() throws IOException {
	 * 
	 * TakesScreenshot shot=((TakesScreenshot) drivers); File
	 * screen=shot.getScreenshotAs(OutputType.FILE); FileUtils.copyFile(screen, new
	 * File("./Rest-Assured-DATA-DRIVEN-TESTING/ScreenShotsTaken/shot.png")); //
	 * FileUtils.copyFile(screen, new File("C:/selenium/error.png")); return
	 * screenShots() ; }
	 */

	static String str;
	static String str1;
	static String str3;
	protected static String[] strArr = null;
	static JSONObject objec;

	@DataProvider(name = "Jps")
	public static String[] json() throws ParseException, FileNotFoundException, IOException {
		JSONParser parse = new JSONParser();
		FileReader reader=new FileReader("./DataFile.json");
		Object obj = parse.parse(reader);
		JSONObject obje = (JSONObject) obj;
		JSONArray arr = (JSONArray) obje.get("data");
		strArr = new String[arr.size()];
		for (int i = 0; i <= arr.size() - 1; i++) {
			JSONObject objec = (JSONObject) arr.get(i);
		//	System.out.println();
			str = (String) objec.get("userName");
		//	System.out.println(str);
			str1 = (String) objec.get("jobTitle");
			str3=(String)objec.get("age");
		//	System.out.println(str1);
			strArr[i] = (str + "," + str1+","+str3);
			System.out.println(strArr[i]);
	
			
		}
		return strArr;

	}
	@DataProvider(name="empChange")
	public static String[][] excel() throws IOException{
		
		String path="C:\\Users\\rastt\\Desktop\\Selenium-Files\\REST-ASSURED-API\\Rest-Assured-DATA-DRIVEN-TESTING\\EXCEL.xlsx";
		int row=excelCodes.getRowCount(path, "PrettyPost");
		int col=excelCodes.getCellCount(path, "PrettyPost", 1);
		String[][] emp=new String[row][col];
		for(int i=1;i<=row;i++) {
			for(int j=0;j<col;j++) {
				emp[i-1][j]=excelCodes.getCellData(path,"PrettyPost", i, j);
				
			}
		}
		return emp;
	}
	
	
//	public static String rando;
//	//static RandomStringUtils util;
//	public static String randomStuff() {
////		Random ran=new Random();
////		int r=ran.nextInt(5);
////		String s=String.valueOf(r);
////		System.out.println(s);
//		//int g=Integer.parseInt(s); OR
//		
//	//	util=new RandomStringUtils();
//		RandomStringUtils.randomAlphabetic(1, 4);
//	//	System.out.println(rando);
//		return randomStuff();
//		
//	} 
}
