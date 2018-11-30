package com.biz.grade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.biz.grade.vo.ScoreVO;
import com.biz.grade.vo.StudentVO;

public class GradeExec07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nameFile = "src/com/biz/grade/영어인물이름.txt";
		List<StudentVO> stList = new ArrayList();
		List<ScoreVO> scoreVO = new ArrayList();
		
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
					stList.add(vo);
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
		
		for(StudentVO sv : stList) {
			ScoreVO scV = new ScoreVO();
			scV.setStrNum(sv.getStrNum());
			int intKor = (int)(Math.random() * (100 - 50 + 1)) + 50;
			int intEng = (int)(Math.random() * (100 - 50 + 1)) + 50;
			int intMth = (int)(Math.random() * (100 - 50 + 1)) + 50;
			
			scV.setIntKor(intKor);
			scV.setIntEng(intEng);
			scV.setIntMth(intMth);
			
			int intSum = intKor + intEng + intMth ;
			float floatAvg = intSum / 3.0f ;
			scV.setIntSum(intSum);
			scV.setFloatAvg(floatAvg);
			
			scoreVO.add(scV);
		}
		System.out.println("=================================================================");
		System.out.println("학번\t영어이름\t한글이름\t국어점수\t영어점수\t수학점수\t총점\t평균");
		for(StudentVO vo : stList) {
			System.out.print(vo.getStrNum() + "\t");
			System.out.print(vo.getStrEngName() + "\t");
			System.out.print(vo.getStrKorName().substring(0, 5) + "\t");
			for(ScoreVO sc : scoreVO) {
				if(vo.getStrNum().equals(sc.getStrNum())) {
					System.out.print(sc.getIntKor() + "\t");
					System.out.print(sc.getIntEng() + "\t");
					System.out.print(sc.getIntMth() + "\t");
					System.out.print(sc.getIntSum() + "\t");
					System.out.println(sc.getFloatAvg());
				}
			}
		}
	}

}
