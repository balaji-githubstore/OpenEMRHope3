package com.google.openemrtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo1Test {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("src/test/resources/testdata/data.properties"); //new FileNotFoundException()
		
		Properties prop=new Properties();
		prop.load(file);
		
		String value= prop.getProperty("url");
		
		System.out.println(value);

	}

}
