/**
 * AUTHOR : Yang Min Kyu
 * DATE   : 2016. 1. 20.
 * TITLE  : 볼링 싱글 플레이 메인 클레스
 * MAIL   : wlfekymk@gmail.com
 *
**/
package com.wlfek.bowling;

import com.wlfek.bowling.Service.Bowling;

public class MainSingle {

	/**
	 * 요구 사항 2. 작성된 프로그램의 main class를 실행 시 각 투구 별 쓰러진 핀 갯수를 입력 받아 점수를 계산하여 화면에 표시한다. 
	 * @param args
	 */
	public static void main(String[] args) {
		Bowling bow = new Bowling();
		bow.singlePlayStart();
	}

}
