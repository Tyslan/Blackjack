package com.philihp.bj;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.philihp.bj.Card.*;
import static com.philihp.bj.Response.*;

public class ZeroMemoryPlayer implements Player {

	private static final Response[][] HARD_RESPONSE = {
		{ H, H, H, H, H, H, H, H, H, H }, //4
		{ H, H, H, H, H, H, H, H, H, H }, //5
		{ H, H, H, H, H, H, H, H, H, H }, //6
		{ H, H, H, H, H, H, H, H, H, H }, //7
		{ H, H, H, H, H, H, H, H, H, H }, //8
		{ H,DH,DH,DH,DH, H, H, H, H, H }, //9
		{DH,DH,DH,DH,DH,DH,DH,DH, H, H }, //10
		{DH,DH,DH,DH,DH,DH,DH,DH,DH,DH }, //11
		{ H, H, S, S, S, H, H, H, H, H }, //12
		{ S, S, S, S, S, H, H, H, H, H }, //13
		{ S, S, S, S, S, H, H, H, H, H }, //14
		{ S, S, S, S, S, H, H, H, H, H }, //15
		{ S, S, S, S, S, H, H, H, H, H }, //16
		{ S, S, S, S, S, S, S, S, S, S }, //17
		{ S, S, S, S, S, S, S, S, S, S }, //18
		{ S, S, S, S, S, S, S, S, S, S }, //19
		{ S, S, S, S, S, S, S, S, S, S }, //20
		{ S, S, S, S, S, S, S, S, S, S }  //21
	};
	private static final Response[][] SOFT_RESPONSE = {
		{ H, H, H,DH,DH, H, H, H, H, H }, //13
		{ H, H, H,DH,DH, H, H, H, H, H }, //14
		{ H, H,DH,DH,DH, H, H, H, H, H }, //15
		{ H, H,DH,DH,DH, H, H, H, H, H }, //16
		{ H,DH,DH,DH,DH, H, H, H, H, H }, //17
		{DS,DS,DS,DS,DS, S, S, H, H, H }, //18
		{ S, S, S, S,DS, S, S, S, S, S }, //19
		{ S, S, S, S, S, S, S, S, S, S }, //20
		{ S, S, S, S, S, S, S, S, S, S }  //21
	};
	private static final Response[][] PAIR_RESPONSE = {
		{ H, H, P, P, P, P, H, H, H, H }, //2
		{ H, H, P, P, P, P, H, H, H, H }, //3
		{ H, H, H, H, H, H, H, H, H, H }, //4
		{DH,DH,DH,DH,DH,DH,DH,DH, H, H }, //5
		{ H, P, P, P, P, H, H, H, H, H }, //6
		{ P, P, P, P, P, P, H, H, H, H }, //7
		{ P, P, P, P, P, P, P, P, P, P }, //8
		{ P, P, P, P, P, S, P, P, S, S }, //9
		{ S, S, S, S, S, S, S, S, S, S }, //T
		{ P, P, P, P, P, P, P, P, P, P }  //A
	};
	
	public ZeroMemoryPlayer() {
	}

	public int bet() {
		return Blackjack.MIN_BET*1; // 15
		//max is 2000
	}
	
	public Response prompt(Hand playerHand, Hand dealerHand, boolean canSplit) {
		if(playerHand.isPair()) {
			if(canSplit) {
				return PAIR_RESPONSE
						[playerHand.getShowCard().getTableOrdinal()]
						[dealerHand.getShowCard().getTableOrdinal()];
			}
			else {
				//if we can't split because of a limit on resplitting,
				//treat the hand as a hard total
				try {
				return HARD_RESPONSE
						[playerHand.getValue()-4]
						[dealerHand.getShowCard().getTableOrdinal()];
				}catch(ArrayIndexOutOfBoundsException e) {
					throw new RuntimeException(playerHand.toString() + " - " +playerHand.getValue());
				}
			}
		}
		else if(playerHand.isSoft()) {
			return SOFT_RESPONSE
					[playerHand.getValue()-13]
					[dealerHand.getShowCard().getTableOrdinal()];
		}
		else {
			if(playerHand.getValue()-4 == 30) System.out.println(playerHand);
			return HARD_RESPONSE
					[playerHand.getValue()-4]
					[dealerHand.getShowCard().getTableOrdinal()];
		}
	}
	
	public void notify(Card card) {
	}
	
	public void resetCount(int decks) {
	}
	
}