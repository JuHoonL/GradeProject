package com.biz.grade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.biz.grade.vo.StudentVO;

public class GradeExec06 {
	/*
	 * 영어이름들.txt 파일을 읽어서 각 라인을 ":"을 기준으로 자른 후 sVO리스트에 추가하시오
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nameFile = "src/com/biz/grade/영어인물이름.txt";
		List<StudentVO> sVO = new ArrayList();
		
		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader(nameFile);
			br = new BufferedReader(fr);
			
			while(true) {
				String strList = br.readLine();
				if(strList == null) break;
				String[] sList = strList.split(":");
				
				if(sList.length > 2) {
					StudentVO vo = new StudentVO();
					vo.setStrNum(sList[0]);
					vo.setStrEngName(sList[1]);
					vo.setStrKorName(sList[2]);
					sVO.add(vo);
				}
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(StudentVO vo : sVO) {
			System.out.println(vo);
		}
	}

}
