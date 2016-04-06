/**
 * AUTHOR : Yang Min Kyu
 * DATE   : 2016. 1. 20.
 * TITLE  : 계산을  관리 하는 클레스 
 * MAIL   : wlfekymk@gmail.com
 *
**/
package com.wlfek.bowling.Service;

import java.util.List;

import com.wlfek.bowling.Domain.FrameBoard;
import com.wlfek.bowling.Domain.Score;

public class Calculate extends Common {
	
	public Calculate(List<Score> multi){
		this.multi = multi;
		scoreCalculate();
	}
	
	public void scoreCalculate(){
		for(int i = 0 ; i < multi.size() ; i++){
			// 프레임 보너스 점수 셋팅
			// frameBoard.setBonus();
			bonusScoreCalculate(i);
			// 프레임 점수 합산
			for(int frame = 0; frame < 10; frame ++){
				FrameBoard frameBoard = multi.get(i).getFrames().get(frame);
				int total = frameBoard.getFirstNum() + frameBoard.getSecondNum() + frameBoard.getBonus() + frameBoard.getThirdNum();
				
				// 토탈 점수 합산법 2종류
				// 1. 1프레임 전라운드가 없음.
				if(frame==0){
					frameBoard.setTotalScore(total);
				// 2. 2~10 프레임 전 점수에 지금 점수를 합산 해야함
				} else {
					FrameBoard previousFrameBoard = multi.get(i).getFrames().get(frame - 1);
					frameBoard.setTotalScore(previousFrameBoard.getTotalScore() + total);;
				}
			}
		}
	}
	
	
	public void bonusScoreCalculate(int i){
		// 프레임 보너스는 1프레임은 없음 2프레임부터 가능
		// 프레임 보너스는 3종류 
		// 1. 2프레임 은 최대 더블
		// 2. 3~9 프레임 3프레임부터 터키 처리 필요
		// 3. 10프레임 10프레임도 터키 처리가 있으나 점수 합산이 틀림
		
		for(int frame = 1; frame < 10; frame ++){
			FrameBoard frameBoard = multi.get(i).getFrames().get(frame);
			FrameBoard previousFrameBoard = multi.get(i).getFrames().get(frame-1);
			// 스트라이크 일 경우 2번이 보너스
			if(previousFrameBoard.isStrike()){
				if(frame>1 && frame<10 && multi.get(i).getFrames().get(frame-2).isStrike()){
					multi.get(i).getFrames().get(frame-2).setBonus(previousFrameBoard.getFirstNum()+ frameBoard.getFirstNum());
				}
				previousFrameBoard.setBonus(frameBoard.getFirstNum() + frameBoard.getSecondNum());
			// 스페어 처리시 다음 점수 가 보너스
			} else if(previousFrameBoard.isSpair()){
				previousFrameBoard.setBonus(frameBoard.getFirstNum());
			// 아무것도 아닐경우 보너스 없음
			} else {
				previousFrameBoard.setBonus(0);
			}
		}
	}
}
