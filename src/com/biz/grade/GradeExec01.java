package com.biz.grade;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GradeExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nameFile = "src/com/biz/grade/영어인물이름.txt";
		
		FileReader fr;
		
		try {
			fr = new FileReader(nameFile);
			while(true) {
				int intRead = fr.read();		// 파일의 내용을 아스키(ASCII)코드 형식으로 읽어서 그 값을 10진수 정수로  return
				System.out.print((char)intRead);
				if(intRead < 0) break;			// 파일 내용을 읽되 EOF 신호가 나타나면 읽는 것을 멈춰라
				
			}
		} catch (FileNotFoundException e) { 	// 파일을 읽기위해 open하는 과정에서 발생하는 Exception을 처리하는 부분
			// TODO Auto-generated catch block
			e.printStackTrace();			// 자바에서 기본으로 제공하는 Exception 메시지를 콘솔에 보여주는 메서드
		} catch (IOException e) {			// 파일로부터 데이터(문자, 문자열)을 읽는 중에 발생하는 Exception을 처리하는 부분
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
		
	}

}
