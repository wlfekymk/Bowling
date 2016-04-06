/**
 * AUTHOR : Yang Min Kyu
 * DATE   : 2016. 1. 20.
 * TITLE  : 프린터를 관리 하는 클레스 
 * MAIL   : wlfekymk@gmail.com
 *
**/
package com.wlfek.bowling.Service;

import java.util.List;

import com.wlfek.bowling.Domain.FrameBoard;
import com.wlfek.bowling.Domain.Score;

public class PrintBoard extends Common {
	
	private Score score;
	
	public PrintBoard(List<Score> multi, int frame){
		this.multi = multi;
		System.out.println("=========================================================================================================================================================================");
		printFrameAll();
		for(int i = 0 ; i < multi.size() ; i++){
			score = this.multi.get(i);
			printFrameScore(frame);
			printFrameTotalScore(frame);
		}
		System.out.println("=========================================================================================================================================================================");
	}
	
	
	/**
	 * 최종 점수 프린트
	 * 요구사항 5. 스페어, 스트라이크, 더블, 터키 처럼 해당 프레임에 최종 점수를 확인 할 수 없을 경우 점수를 display하지 않는다.
	 *	(최종 점수가 확인되는 프레임에 같이 display한다.)
	 * @param frame
	 */
	public void printFrameTotalScore(int frame) {
		FrameBoard frameBoard;
		List<FrameBoard> frameList = score.getFrames();
		if(frameList.get(frame).isStrike()){
			if(frame > 0 && frame < 9 && frameList.get(frame-1).isStrike()){
				frame = frame - 2;	
			} else {
				frame = frame - 1;	
			}
		} else if(frameList.get(frame).isSpair()) {
			frame = frame - 1;
		} 
		
		for (int i = 0; i < frame + 1; i++) {
			frameBoard = frameList.get(i);
			System.out.print("\t" + frameBoard.getTotalScore() + "\t|");
		}
		System.out.println();
	}
	
	/**
	 * 각 프레임 점수 프린트
	 * 요구사항 4. 각 프레임이 끝나면 점수를 display한다.
	 * @param frame
	 */
	public void printFrameScore(int frame){
		
		StringBuffer sb = new StringBuffer();
		FrameBoard frameBoard;
		List<FrameBoard> frameList = score.getFrames();

		for(int i = 0 ; i < frame + 1; i++){
			frameBoard = frameList.get(i);
			// 10 프레임 print board
			if(i==9){
				if(frameBoard.isIs10thFirstStrike()){
					appendTab(sb, "X", frame);
				} else {
					appendTab(sb, frameBoard.getFirst(), frame);
				}
				
				if(frameBoard.isIs10thSecondStrike()){
					appendTab(sb, "X", frame);
				} else if(frameBoard.isIs10thFirstSpair()){
					appendTab(sb, "/", frame);
				} else {
					appendTab(sb, frameBoard.getSecond(), frame);
				}

				if(frameBoard.isIs10thThridStrike()){
					appendTab(sb, "X", frame);
				} else if(frameBoard.isIs10thSecondSpair()){
					appendTab(sb, "/", frame);
				} else {
					appendTab(sb, frameBoard.getThird(), frame);
				}
			} 
			// 1~9 프레임 print board
			else {
				if(frameBoard.isStrike()){
					appendTab(sb, "X", frame);
					appendTab(sb, frame);
				} else if(frameBoard.isSpair()){
					appendTab(sb, frameBoard.getFirst(), frame);
					appendTab(sb, "/", frame);
				} else {
					appendTab(sb, frameBoard.getFirst(), frame);
					appendTab(sb, frameBoard.getSecond(), frame);
				}
			}
		}
		System.out.println(sb.toString());
	}


	public void printFrameAll(){
		for (int i = 1; i < 11; i++) {
			System.out.print("\t" + i + "\t|");
		}
		System.out.println();
	}
	
	private void appendTab(StringBuffer sb, int frame){
		appendTab(sb, null, frame);
	}
	
	private void appendTab(StringBuffer sb, String param, int frame) {
		if( frame < 10 ) {
			if(param!=null){
				sb.append(param);
			}
			sb.append("\t|");
		}
	}  
	
}
