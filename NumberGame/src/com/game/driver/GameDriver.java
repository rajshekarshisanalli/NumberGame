package com.game.driver;

import java.util.Scanner;

import com.game.constants.UserReply;
import com.game.service.NumberGame;

/**
 * The class is the driver class for the number guessing game.
 * 
 * @author Rajshekar
 *
 */

public class GameDriver {

	static int counter=0;
	public static void main(String[] args) {
		String userInput=null;
		NumberGame numberGame = null;
		Scanner input = new Scanner(System.in);
		if(counter == 0) {
			System.out.println("Choose a range in the format start, end and choose a number for yourself between the range without disclosing it : ");
			userInput = input.nextLine();
			String[] range = userInput.split(",");
			numberGame = new NumberGame(Long.valueOf(range[0].trim()), Long.valueOf(range[1].trim()));
		}
		System.out.println("user : " + userInput);
		while (!userInput.equalsIgnoreCase(UserReply.YES.toString()) || !userInput.equalsIgnoreCase(UserReply.END.toString())) {
			
			if((numberGame.getOutput() == (numberGame.getStartRange() - 1L)) || (numberGame.getOutput() == (numberGame.getEndRange() - 1L))) {
				break;
			}
	    	System.out.println("Is your number : " + numberGame.getOutput() + " If yes type \"yes\" or \"end\" ");
	    	System.out.println("If your number is higher than " + numberGame.getOutput() + " type \"higher\" else type \"lower\" " );
	    	userInput = input.nextLine();
	    	if(!userInput.isEmpty() && (userInput.equalsIgnoreCase("higher") || userInput.equalsIgnoreCase("lower"))) {
	    		if(userInput.equalsIgnoreCase("Yes") || userInput.equalsIgnoreCase("End")) {
	    			break;
	    		}
	    		if(userInput.equalsIgnoreCase("higher")) {
	    			numberGame.guessTheNumber(UserReply.HIGH);
	    		}
	    		else {
	    			numberGame.guessTheNumber(UserReply.LOW);
	    		}
	    	}
	    	else {
	    		System.out.println("Error : Invalid input.");
				continue;
	    	}
	    } 
		System.out.println("This is the number you chose : " + numberGame.getOutput());
	}
}
