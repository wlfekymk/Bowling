/**
 * AUTHOR : Yang Min Kyu
 * DATE   : 2016. 1. 20.
 * TITLE  : 각 프레임의 점수를 보여주는 Score
 * MAIL   : wlfekymk@gmail.com
 *
**/
package com.wlfek.bowling.Domain;

import java.util.ArrayList;
import java.util.List;

public class Score {
	private List<FrameBoard> frames = new ArrayList<FrameBoard>(10);

	public Score(){
		//10프레임까지 스코어를 초기화
		for(int i=0; i<10; i++)
			frames.add(new FrameBoard());
	}
	
	public List<FrameBoard> getFrames() {
		return frames;
	}

	public void setFrames(List<FrameBoard> frames) {
		this.frames = frames;
	}

}