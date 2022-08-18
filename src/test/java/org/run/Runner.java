package org.run;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.base.BaseClass;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.pojo.Pojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Runner extends BaseClass {

	@BeforeClass
	private void browserLaunch() {

		launchBrowser();
		maxBrowser();
	}

	@AfterClass
	private void browserClose() {
		closebrowser();

	}

	@BeforeMethod
	public void startstime() {
		passUrl("https://en-gb.facebook.com/");

	}

	@AfterMethod
	public void endsTime() throws InterruptedException {

		Thread.sleep(3000);

	}

	@Test
	private void tc1() {

		Pojo p = new Pojo();

		toInput(p.getTxtuser(), "suresh21gmail.com");
		toInput(p.getTxtpass(), "test@123");
		btnClick(p.getClkbtn());
	}

	@Test
	
	private void Json() throws IOException, ParseException {
		
		JSONParser jsonParser=new JSONParser();
		
		FileReader reader=new FileReader("src\\pageobject.json");
		
		Object obj = jsonParser.parse(reader);
		
		
		JSONArray userslist=(JSONArray) obj;
		
		System.out.println("user List"+userslist);
			
		
			for (int i = 0; i<userslist.size(); i++) {
			
		JSONObject users=(JSONObject)userslist.get(i);
			
		//	System.out.println("user"+users);
			
			JSONObject user=(JSONObject)users.get("users");
			
		//	System.out.println("user"+users);
			
			String username = (String)user.get("username");
			
		
			String password = (String)user.get("password");
			
		//	String result = login(username,password);
//			
//			user.put("result", result)
			
			System.out.println("The username JSON is "+i+ " "+username+"\n");
			
			System.out.println("The password JSON is "+i +" "+password+"\n");
			
			try (FileWriter file =new FileWriter("src\\objectmodel.json")){
			
			file.append(userslist.toJSONString());
			
			file.flush();
				
			} catch (IOException e) {
				
				e.printStackTrace();

		}
			System.out.println(user);


			}
	
			
		}

	
}
