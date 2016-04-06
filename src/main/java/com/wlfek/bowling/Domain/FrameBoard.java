/**
 * AUTHOR : Yang Min Kyu
 * DATE   : 2016. 1. 20.
 * TITLE  : 각 프레임에 대한 정보가 저장 되는 domain 클레스
 * MAIL   : wlfekymk@gmail.com
 *
**/
package com.wlfek.bowling.Domain;

public class FrameBoard {
	
	private Pin pin;
	public FrameBoard(){
		setFirst("0");
		setSecond("0");
		setThird("0");
		setBonus(0);
		setSpair(false);
		setStrike(false);
		setIs10thFirstSpair(false);
		setIs10thSecondSpair(false);
		setIs10thFirstStrike(false);
		setIs10thSecondStrike(false);
		setIs10thThridStrike(false);
	}
	
	private int firstNum;
	private int secondNum;
	private int thirdNum; 
	private int bonus;
	private int totalScore;
	
	private String first;
	private String second;
	private String third;
	
	private boolean isStrike;
	private boolean isSpair;
	
	private boolean is10thFirstStrike;
	private boolean is10thSecondStrike;
	private boolean is10thThridStrike;
	
	private boolean is10thFirstSpair;
	private boolean is10thSecondSpair;

	public boolean isIs10thFirstSpair() {
		return is10thFirstSpair;
	}

	public void setIs10thFirstSpair(boolean is10thFirstSpair) {
		this.is10thFirstSpair = is10thFirstSpair;
	}

	public boolean isIs10thSecondSpair() {
		return is10thSecondSpair;
	}

	public void setIs10thSecondSpair(boolean is10thSecondSpair) {
		this.is10thSecondSpair = is10thSecondSpair;
	}

	public boolean isIs10thFirstStrike() {
		return is10thFirstStrike;
	}

	public void setIs10thFirstStrike(boolean is10thFirstStrike) {
		this.is10thFirstStrike = is10thFirstStrike;
	}

	public boolean isIs10thSecondStrike() {
		return is10thSecondStrike;
	}

	public void setIs10thSecondStrike(boolean is10thSecondStrike) {
		this.is10thSecondStrike = is10thSecondStrike;
	}

	public boolean isIs10thThridStrike() {
		return is10thThridStrike;
	}

	public void setIs10thThridStrike(boolean is10thThridStrike) {
		this.is10thThridStrike = is10thThridStrike;
	}

	public boolean isStrike() {
		return isStrike;
	}
	
	public void setStrike(boolean isStrike) {
		this.isStrike = isStrike;
	}
	
	public String getFirst() {
		return first;
	}
	
	public void setFirst(String first) {
		this.first = first;
		pin = new Pin(first);
		this.firstNum = pin.getScore();
	}
	
	public String getSecond() {
		return second;
	}
	
	public void setSecond(String second) {
		this.second = second;
		pin = new Pin(second);
		this.secondNum = pin.getScore();
	}
	
	public String getThird() {
		return third;
	}
	
	public void setThird(String third) {
		this.third = third;
		pin = new Pin(third);
		this.thirdNum = pin.getScore();
	}
	
	public boolean isSpair() {
		return isSpair;
	}
	
	public void setSpair(boolean isSpair) {
		this.isSpair = isSpair;
	}
	
	public int getFirstNum() {
		return firstNum;
	}
	
	public int getSecondNum() {
		return secondNum;
	}
	
	public int getThirdNum() {
		return thirdNum;
	}
	
	
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	
	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Frame [pin=" + pin + ", firstNum=" + firstNum + ", secondNum=" + secondNum + ", thirdNum=" + thirdNum
				+ ", totalScore=" + totalScore + ", first=" + first + ", second=" + second + ", third=" + third
				+ ", isStrike=" + isStrike + ", isSpair=" + isSpair + "]";
	}
	
	
}
