/**
 * AUTHOR : Yang Min Kyu
 * DATE   : 2016. 1. 20.
 * TITLE  : 볼링 각 플레임 처리 클레스
 * MAIL   : wlfekymk@gmail.com
 *
**/
package com.wlfek.bowling.Service;

import java.util.List;
import java.util.Scanner;

import com.wlfek.bowling.Domain.FrameBoard;
import com.wlfek.bowling.Domain.Score;

public class Frame extends Common {

	private Scanner sc = new Scanner(System.in);
	public Frame(List<Score> multi){
		this.multi = multi;
	}
	
	/**
	 * 요구사항 2. 작성된 프로그램의 main class를 실행 시 각 투구 별 쓰러진 핀 갯수를 입력 받아 점수를 계산하여 화면에 표시한다.
	 * 1~9 프레임 로직
	 * @param frame
	 */
	public void frame1_9(int frame, boolean multiPlayFlag){
		System.out.println(frame + 1 + " 프레임 입니다.");
		System.out.println("플레이 인원  :" + multi.size() );
		for(int i = 0 ; i < multi.size() ; i++){
			FrameBoard frameBoard = multi.get(i).getFrames().get(frame);
			System.out.println("===== " + (i + 1) + " 번째 플레이어 첫번째 투구 점수 입력 =====");
			String inputData = null; 
			inputData = inputDataCheck(multiPlayFlag);
			frameBoard.setFirst(inputData);
			// 첫투구가 스트라이크 이면 스트라이크 설정 하고 종료
			if(frameBoard.getFirstNum()==10){
				frameBoard.setStrike(true);
				
			} else{
				System.out.println("===== " + (i + 1) + " 번째 플레이어  두번째 투구 점수 입력 =====");
				inputData = inputDataCheck(multiPlayFlag);
				frameBoard.setSecond(inputData);
				check10ScoreOver(frameBoard);
				
				if(frameBoard.getFirstNum() + frameBoard.getSecondNum()==10)
					frameBoard.setSpair(true);
			}
		}
	}

	/**
	 *  요구사항 2. 작성된 프로그램의 main class를 실행 시 각 투구 별 쓰러진 핀 갯수를 입력 받아 점수를 계산하여 화면에 표시한다.
	 *  10 프레임 로직
	 * @param frame
	 */
	public void frame10(boolean multiPlayFlag){
		System.out.println("10 프레임 입니다.");
		for(int i = 0 ; i < multi.size() ; i++){
			FrameBoard frameBoard = multi.get(i).getFrames().get(9);
			System.out.println("===== " + (i + 1) + " 번째 플레이어 첫번째 투구 점수 입력 =====");
			String inputData = inputDataCheck(multiPlayFlag);
			frameBoard.setFirst(inputData);
			// 10프레임 1구 스트라이크 처리시
			if(frameBoard.getFirstNum()==10){
				frameBoard.setIs10thFirstStrike(true);
			}
			
			System.out.println("===== " + (i + 1) + " 번째 플레이어  두번째 투구 점수 입력 =====");
			inputData = inputDataCheck(multiPlayFlag);
			frameBoard.setSecond(inputData);

			// 처음이 스트라이크 일경우
			if(frameBoard.isIs10thFirstStrike()){
				if(frameBoard.getSecondNum()==10){
					frameBoard.setIs10thSecondStrike(true);
				} 
				System.out.println("===== " + (i + 1) + " 번째 플레이어 세번째 투구 점수 입력 =====");
				inputData = inputDataCheck(multiPlayFlag);
				frameBoard.setThird(inputData);
				if(frameBoard.isIs10thFirstStrike() && frameBoard.isIs10thSecondStrike() && frameBoard.getThirdNum() == 10)
					frameBoard.setIs10thThridStrike(true);
				if(frameBoard.getSecondNum() + frameBoard.getThirdNum() >= 10 && !frameBoard.isIs10thSecondStrike()){
					check10ScoreOverFor10Frame(frameBoard);
					frameBoard.setIs10thSecondSpair(true);
				}
			// 스페어 처리일경우	
			} else if(frameBoard.getFirstNum() + frameBoard.getSecondNum() >= 10) {
				check10ScoreOver(frameBoard);
				frameBoard.setIs10thFirstSpair(true);
				System.out.println("===== " + (i + 1) + " 번째 플레이어  세번째 투구 점수 입력 =====");
				inputData = inputDataCheck(multiPlayFlag);
				frameBoard.setThird(inputData);
				if(frameBoard.getThirdNum()==10){
					frameBoard.setIs10thThridStrike(true);
				}
			} 
		}
		
	}
	
	public String inputDataCheck(boolean multiPlayFlag){
		if(multiPlayFlag){
			String result = null;
			int random  = (int) (Math.random() * 11) + 1;
			if(random == 11)
				result = "F";
			else
				result = String.valueOf(random);
			return result;
		}else 
			return sc.nextLine();
	}
	
	/**
	 * 1~10프레임 점수 보정 1구 + 2구 값이 10이 오버 될경우 
	 * @param frameBoard
	 */
	public void check10ScoreOver(FrameBoard frameBoard){
		int revisionScore = revisionScoreCalculate(frameBoard.getFirstNum(), frameBoard.getSecondNum());
		frameBoard.setSecond(String.valueOf(revisionScore));
	}
	
	/**
	 * 10 프레임 점수 보정 2구 + 3구 값이 10이 오버 될경우 
	 * @param frameBoard
	 */
	public void check10ScoreOverFor10Frame(FrameBoard frameBoard){
		int revisionScore = revisionScoreCalculate(frameBoard.getSecondNum(), frameBoard.getThirdNum());
		frameBoard.setThird(String.valueOf(revisionScore));
	}
	
	public int revisionScoreCalculate(int param1, int param2){
		int revisionScore = param2;
		if(param1 + param2 > 10){
			revisionScore = 10 - param1;
			System.out.println("합계가 10점이 넘어 두번째 값이 [" + revisionScore + "] 점으로 보정 되었습니다!!");
		}
		return revisionScore;
	}
}
