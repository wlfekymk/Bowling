/**
 * AUTHOR : Yang Min Kyu
 * DATE   : 2016. 1. 20.
 * TITLE  : 볼링 클레스 구현체
 * MAIL   : wlfekymk@gmail.com
 *
**/
package com.wlfek.bowling.Service;

import java.util.ArrayList;
import java.util.List;

import com.wlfek.bowling.Domain.Score;

public class Bowling extends Common {
	
	
	private List<Score> multi;
	public static int PLAYER_CNT = 2;
	
	
	/**
	 * 초기화 스코어 판, 플레이 방식
	 */
	public void init(){
		// 스코어판을 초기화 한다.
		multi = new ArrayList<Score>(PLAYER_CNT); 
	}
	
	public void singlePlayStart(){
		init();
		multi.add(new Score());
		playBowling();
	}
	
	
	public void multiPlayStart(){
		init();
		for(int i = 0 ; i < PLAYER_CNT ; i++){
			multi.add(new Score());
		}
		playBowling();
	}

	public void playBowling(){
		Frame frames = new Frame(multi);
		// 1~9 프레임 처리
		boolean multiPlayFlag = false;
		
		if(multi.size()>1)
			multiPlayFlag = true;
		
		for(int frame = 0 ; frame < 9 ; frame++){
			// 게임 진행 및 DB 적재
			try {
				// 스코어 계산
				frames.frame1_9(frame, multiPlayFlag);
				new Calculate(multi);
				// 보드 프린팅
				new PrintBoard(multi, frame);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				frame--;
			}
		}
		// 10 프레임 처리
		frames.frame10(multiPlayFlag);
		new Calculate(multi);
		new PrintBoard(multi, 9);
	}
	

}
