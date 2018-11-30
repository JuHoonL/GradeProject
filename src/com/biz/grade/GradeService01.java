package com.biz.grade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.grade.vo.ScoreVO;
import com.biz.grade.vo.StudentVO;

public class GradeService01 {

	
		String nameFile;
		List<StudentVO> stList;
		List<ScoreVO> scoreVO;
		
		String scoreFile;
		
	public GradeService01() {
		nameFile = "src/com/biz/grade/영어인물이름.txt";
		stList = new ArrayList();
		scoreVO = new ArrayList();
		scoreFile = "src/com/biz/grade/성적표.txt";
	}
		
	
	public void makeStList() {
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
	}
		
	public void makescoreVO() {
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
	}
	
		
	public void printWriter01() {
		PrintWriter pw;
		try {
			pw = new PrintWriter(scoreFile);
			for(StudentVO vo : stList) {
				pw.print(vo.getStrNum() + ":");
				pw.print(vo.getStrEngName() + ":");
				pw.print(vo.getStrKorName() + ":");
				for(ScoreVO sc : scoreVO) {
					if(vo.getStrNum().equals(sc.getStrNum())) {
						pw.print(sc.getIntKor() + ":");
						pw.print(sc.getIntEng() + ":");
						pw.print(sc.getIntMth() + ":");
						pw.print(sc.getIntSum() + ":");
						pw.printf("%3.2f", sc.getFloatAvg());
					}
				}
				pw.println();
			} 
			pw.close();
			System.out.println("성적 처리 완료!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
