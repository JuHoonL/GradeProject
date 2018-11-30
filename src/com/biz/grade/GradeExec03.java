package com.biz.grade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GradeExec03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = new String[200];
		
		String nameFile = "src/com/biz/grade/영어인물이름.txt";
		
		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader(nameFile);
			br = new BufferedReader(fr);
			
			for(int i = 0 ; i < names.length ; i ++) {
				String nameLine = br.readLine();
				if(nameLine == null) break;
				names[i] = nameLine; 		// 읽은 파일을 배열에 담음
			}
			br.close(); 			// 파일읽기를 하고 다른 코드를 계속 실행해야 할 경우 가급적(원칙적으로) br와 fr을 close()해줘야 한다.
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// names 배열에는 영어이름들 200개가 담겨 있다.
		for(String name : names) {
			System.out.println(name);
		}
		
		String s1 = names[150];
		System.out.println(s1);
		
		System.out.println(names[122]);
		
		//Aldrik
		//Albertine
		//Akacia
		
		//위에서 만든 names 배열에 찾고자 하는 이름이 있는지?
		//이름이 있으면 몇번째 배열에 있는지 ?
		//순차검색(제일 단순한 검색)을 이용
		
		for(int i = 0 ; i < names.length ; i ++) {
			boolean okM = names[i].contains("Albertine"); 	// contains - 문자열에 해당문자열이 포함되어 있는지 물어보는 명령어
			if(okM) {  		// okM == true 와 같음
				System.out.println((i+1) + " 번째에서 찾음");
				System.out.println(names[i]);
				break;
			}
		}
	}

}
