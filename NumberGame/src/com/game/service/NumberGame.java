package com.game.service;

import com.game.constants.UserReply;


/**
 * This class represents the model of the number game with information about
 * the range and the output.
 * @author Rajshekar 
 *
 */
public class NumberGame {

	private long startRange;
	private long endRange;
	private long output;
	
	public NumberGame(long startRange, long endRange) {
		if(endRange < startRange) {
			this.startRange = endRange;
			this.endRange = startRange;
				
		}
		else {
			this.startRange = startRange;
			this.endRange = endRange;
		}	
		output = Math.round((startRange+endRange)/2L);
	}
	
	
	
	public long getStartRange() {
		return startRange;
	}



	public void setStartRange(long startRange) {
		this.startRange = startRange;
	}



	public long getEndRange() {
		return endRange;
	}



	public void setEndRange(long endRange) {
		this.endRange = endRange;
	}



	public long getOutput() {
		return output;
	}



	public void setOutput(long output) {
		this.output = output;
	}


	/*public void initializeNumberGame(long startRange, long endRange) {
		if(startRange<0 && startRange<endRange) {
			this.startR
		}
	}*/
	
	public void guessTheNumber(UserReply reply) {
		System.out.println("Start : " + this.startRange + " && end : " + this.endRange);
		if(this.startRange == this.endRange) {
			output=this.startRange;
			return;
		}
		
		if(reply.equals(UserReply.HIGH)) {

			if(endRange < 0) {
				endRange -=  Math.round((endRange-startRange)/2L);
				output = endRange + Math.round((startRange - endRange)/2L);
			}
			else {
				startRange += Math.round((endRange-startRange)/2L);
				output = startRange + Math.round((endRange - startRange)/2L);
			}


		}
		if(reply.equals(UserReply.LOW)) {

			if(startRange < 0) {
				endRange -= Math.round((endRange-startRange)/2L);
				output = endRange + Math.round((startRange - endRange)/2L);
			}
			else {
				endRange -= Math.round((endRange-startRange)/2);
				output = startRange + Math.round((endRange - startRange)/2L);
			}
		}

	}
}
