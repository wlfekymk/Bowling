/**
 * AUTHOR : Yang Min Kyu
 * DATE   : 2016. 1. 20.
 * TITLE  : 볼링 멀티 플레이 메인 클레스
 * MAIL   : wlfekymk@gmail.com
 *
**/
package com.wlfek.bowling;

import com.wlfek.bowling.Service.Bowling;

public class MainMulti {

	/**
	 * 요구 사항 8. 최종 작성된 프로그램으로 화면에서 입력받는 입력값을 프로그램에서 자동으로 random(0~10)하게
	 * 생성하여 2명이 플레이하는 class를 추가로 작성한다.
	 * @param args
	 */
	public static void main(String[] args) {
		Bowling bow = new Bowling();
		bow.multiPlayStart();

	}

}
