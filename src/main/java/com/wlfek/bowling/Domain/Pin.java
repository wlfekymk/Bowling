/**
 * AUTHOR : Yang Min Kyu
 * DATE   : 2016. 1. 20.
 * TITLE  : 핀 처리 클레스
 * MAIL   : wlfekymk@gmail.com
 *
**/
package com.wlfek.bowling.Domain;

enum Status { 
	STRIKE, SPARE, DEFAULT, GUTTER, EMPTY;
}

public class Pin {
	
	private String inputData;
	
	/**
	 * 요구 사항 3. 입력값은 0~9, F로 입력된다. (10점도 입력 가능 하게 해야함)
	 * (foul : 라인을 넘었거나 기타 규정을 위반 한 경우 쓰러트린 핀이 있더라도 점수계산은 되지 않으며투구횟수는 인정된다.)
	 * @param inputData
	 */
	public Pin(String inputData){
		if(inputData.matches("^([0-9])$")||  inputData.equals("F") || inputData.equals("10")){
			this.inputData = inputData;			
		} else {
			throw new IllegalArgumentException("입력 값은 0~10 또는 F만 가능합니다.");
		}		
	}
	
	public String getInputData(){
		return this.inputData;
	}
	
	public int getScore(){
		if(this.inputData.equals("F"))
			return 0;
		else		
			return Integer.valueOf(this.inputData);
	}
	
}
