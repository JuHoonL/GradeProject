package com.biz.grade.Exec;

import java.util.ArrayList;
import java.util.List;

import com.biz.grade.classes.GradeReader01;
import com.biz.grade.vo.StudentVO;

public class GradeExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String korName = "src/com/biz/grade/우리말이름.txt";
		GradeReader01 gr = new GradeReader01(korName);
		
		//파일을 읽어서 List에 저장하는 부분을 실행
		//GradeReader01은 우리말이름.txt 파일에서 내용을 읽어 이름 부분만 추출한 후 stList에 추가
		gr.studentInfoRead();
		
		//stList를 추출해서 사용
		List<StudentVO> stList = gr.getStList();
		
		for(StudentVO v : stList) {
			System.out.println(v);
		}
	}

}
