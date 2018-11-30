package com.biz.grade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GradeExec05 {

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
		// =================================================================================================
		// names 배열의 임의의 위치에 있는 문자열을 :을 기준으로 잘라서 우리말 이름을 보여주고 영어 이름을 입력받아  맞추는 코드를 작성하시오
		// names 배열에는 영어이름들 200개가 담겨 있다.
		int namest = names.length;
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			int intIndex = (int)(Math.random()*namest);
//			System.out.println(names[intIndex]);
			String[] strEngN = names[intIndex].split(":");
			String strEng = strEngN[1];
			String strKor = strEngN[2];
		
			System.out.println("다음 제시된 단어를 입력하시오");
			System.out.println(strKor);
			System.out.print(">> ");
			String inputName = scanner.nextLine();
		
			if(names[intIndex].contains(inputName)) {
				System.out.println("맞았습니다.");
			} else {
				System.out.println("틀렸습니다.");
			}
						
		}
		
	}

}
