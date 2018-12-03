package com.biz.grade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/*
 * 우리말.txt에 있는 내용을 ":"을 기준으로 앞뒤 빈칸을 삭제하는 코드
 */

public class ConvertName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String readFile = "src/com/biz/grade/우리말.txt";
		String saveFile = "src/com/biz/grade/우리말이름.txt";
		
		FileReader fr ;
		BufferedReader br;
		
		FileWriter fw;
		PrintWriter pw;
		
		try {
			fr = new FileReader(readFile);
			br = new BufferedReader(fr);
			
			fw = new FileWriter(saveFile);
			pw = new PrintWriter(fw);
			
			while(true) {
				//1.파일에서 한줄을 읽고
				String reader = br.readLine();
				//2.만약 EOF이면 끝
				if(reader == null) break;
				//3.문자열을 :을 기준으로 분해
				String[] word = reader.split(":");
				//4.분해한 문자열 앞뒤 빈칸(객체[].trim())을 없앤 후 다시 결합
				String writer = word[0].trim() + ":" + word[1].trim();
				
				pw.println(writer);
			}
			pw.close();
			fw.close();
			br.close();
			fr.close();
			
			System.out.println("완료!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
