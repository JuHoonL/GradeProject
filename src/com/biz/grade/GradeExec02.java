package com.biz.grade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GradeExec02 {

	public static void main(String[] args) {
		
		String nameFile = "src/com/biz/grade/영어인물이름.txt";
		
		FileReader fr ;
		BufferedReader br;
		
		
			try {
				fr = new FileReader(nameFile);
				br = new BufferedReader(fr);
				
				while(true) {
					String strLine = br.readLine();
					if(strLine == null) break;
					System.out.println(strLine);
				}
				br.close(); 	// 따로 클로즈로 닫지 않아도 됌(코드가 끝났기 때문에)
				fr.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
}
