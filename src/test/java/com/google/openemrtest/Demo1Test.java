package com.google.openemrtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo1Test {

	public static void main(String[] args) throws IOException {
		
		try
		{
			int a=10;
			int b=0;
			System.out.println(a/b); //new ArithmeticException()
			
			int[] arr=new int[2];
			System.out.println(arr[5]); //new ArrayIndexOutOfBoundsException()
			
			FileInputStream file=new FileInputStream("src/test/resources/testdata/data.properties1"); //new FileNotFoundException()
			
			Properties prop=new Properties();
			prop.load(file);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
//			e.printStackTrace();
			
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
//			e.printStackTrace();
			
		}
		finally {
			System.out.println("alway runs");
		}
		

	}

}
