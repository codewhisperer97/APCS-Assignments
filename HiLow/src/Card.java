public class Card 
{
	public static final String[] cards = {
		" Two",
		" Three",
		" Four",
		" Five",
		" Six",
		" Seven",
		"n Eight",
		" Nine",
		" Ten",
		" Jack",
		" Queen",
		" King",
		"n Ace"
	};
	
	public static final String[] cardAbbreviations = {
		"2",
		"3",
		"4",
		"5",
		"6",
		"7",
		"8",
		"9",
		"10",
		"J",
		"Q",
		"K",
		"A"
	};
	
	public static final String[] suits = {
		" Diamond",
		" Heart",
		" Spade",
		" Club"
	};
	
	public static final String[] suitAbbreviations = {
		"D",
		"H",
		"S",
		"C"
	};
	
	private String card;
	private int cardNum;
	private int cardSuit;
	
	/**
	 * Constructor is empty.  Instead of importing the card name when it is
	 * constructed, I found it easier to have the 'getDescription' method
	 * take a parameter of the card abbreviation.  That way, 'getDescription'
	 * can be called in a loop with a different parameter each time in order to 
	 * repeat if an invalid input is made.
	 */
	public Card()
	{
	}
	
	/**
	 * Breaks the card input down to return the full name of the card, in the
	 * format of "a(n) {card} of {suit}s"
	 * @return
	 */
	public String getDescription(String c) 
	{
		this.card = c;
		StringBuffer response = new StringBuffer("");
		
		/*
		 * The length of the card's abbreviation should not be less than 1 in 
		 * length or greater than 3 in length.
		 */
		if(card.length() < 1 || card.length() > 3)
		{
			return null;
		}
		
		/*
		 * If the length of the card input is only 1 character long, then it has
		 * to be either a single-digit card or a stand-alone suit.
		 */
		if(card.length() == 1)
		{
			if(isCard(card))
			{
				response.append("a").append(getCardName(card));
				return response.toString();
			}
			else if(isSuit(card))
			{
				response.append("a").append(getSuitName(card));
				return response.toString();
			}
			return null;
		}
		
		/*
		 * If the card length is 2, then either it is a pairing of a single-
		 * digit card plus a suit, or it's a '10' with no suit.
		 */
		else if(card.length() == 2)
		{
			String firstChar = card.substring(0, 1);
			String secondChar = card.substring(1, 2);
			
			/*
			 * If the first character represents a card and the second character
			 * represents a suit...
			 */
			if(isCard(firstChar) && isSuit(secondChar))
			{
				response.append("a").append(getCardName(firstChar)).append(" of")
						.append(getSuitName(secondChar)).append("s");
				return response.toString();
			}
			
			/*
			 * If the first character represents a suit and the second character
			 * represents a card...
			 */
			else if(isSuit(firstChar) && isCard(secondChar))
			{
				response.append("a").append(getCardName(secondChar)).append(" of")
						.append(getSuitName(firstChar)).append("s");
				return response.toString();
			}
			
			/*
			 * If the full card name is a card number, then since it's two digits
			 * it should be 10.
			 */
			else if(isCard(card))
			{
				response.append("a").append(getCardName(card));
				return response.toString();
			}
			return null;
		}
		
		/*
		 * If the card length is 3, then we know that it must be a suit plus
		 * the card '10'.  We still do logic checks to make sure of this, but
		 * the logic breaks the card input into chunks that must be possible
		 * from combinations of 10 and a suit letter.
		 */
		else if(card.length() == 3)
		{
			String firstChar = card.substring(0, 1);   //First character
			String firstChunk = card.substring(0, 2);  //First two characters
			String lastChar = card.substring(2, 3);    //Last character
			String lastChunk = card.substring(1, 3);   //Last two characters
			
			if(isSuit(firstChar) && isCard(lastChunk))
			{
				response.append("a").append(getCardName(lastChunk)).append(" of")
						.append(getSuitName(firstChar)).append("s");
				return response.toString();
			}
			else if(isCard(firstChunk) && isSuit(lastChar))
			{
				response.append("a").append(getCardName(firstChunk)).append(" of")
						.append(getSuitName(lastChar)).append("s");
				return response.toString();
			}
			return null;
		}
		return null;
	}
	
	/**
	 * Takes an abbreviation and tests to see if it has a matching card name.
	 * @param abbreviation The abbreviation to find a name for.
	 * @return The full name for the card.
	 */
	private String getCardName(String abb)
	{
		/*
		 * If the abbreviation of the card passed in at construction is only 1 
		 * character long, then we're going to check to see if the character
		 * matches an abbreviation of any card, and then simply return 
		 * the name of that card.
		 */
		if(abb.length() == 1)
		{
			for(int i = 0; i < cardAbbreviations.length; i++)
			{
				/*
				 * If there is a match for the card name in the card abbreviations,
				 * return the name of the card by querying from the full card
				 * names constant array at the same index, since the constant
				 * array for abbreviations and for full names align.
				 */
				if(abb.equalsIgnoreCase(cardAbbreviations[i]))
				{
					return cards[i];
				}
			}
		}
		else if(abb.length() == 2)
		{
			/*
			 * If the card is a 10, handle it in a special little case and 
			 * return quickly.
			 */
			if(abb.equals("10"))
			{
				return cards[8];
			}
		}
		
		/*
		 * If the logic above did not return by this point, then no proper
		 * response was detected and therefore a null value is returned to 
		 * notify upper execution of an error.
		 */
		return null;
	}
	
	/**
	 * Takes an abbreviation and tests to see if it has a matching suit name.
	 * @param abbreviation The abbreviation to find a name for.
	 * @return The full name for the suit.
	 */
	private String getSuitName(String abb)
	{
		if(abb.length() == 1)
		{
			for(int i = 0; i < suitAbbreviations.length; i++)
			{
				if(abb.equalsIgnoreCase(suitAbbreviations[i]))
				{
					return suits[i];
				}
			}
		}
		
		/*
		 * If the logic above did not return by this point, then no proper
		 * response was detected and therefore a null value is returned to 
		 * notify upper execution of an error.
		 */
		return null;
	}
	
	/**
	 * Simple function that will cycle through the card abbreviations list to
	 * determine if the abbreviation parameter matches an actual abbreviation
	 * in the constant list.
	 * @param abbreviation The abbreviation to compare with the constant list.
	 * @return True if there is a match in the cards abbreviation list, false
	 * otherwise.
	 */
	private boolean isCard(String abb)
	{
		for(int i = 0; i < cardAbbreviations.length; i++)
		{
			if(abb.equalsIgnoreCase(cardAbbreviations[i]))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Simple function that will cycle through the suits abbreviations list to
	 * determine if the abbreviation parameter matches an actual abbreviation
	 * in the constant list.
	 * @param abbreviation The abbreviation to compare with the constant list.
	 * @return True if there is a match in the suits abbreviation list, false
	 * otherwise.
	 */
	private boolean isSuit(String abb)
	{
		for(int i = 0; i < suitAbbreviations.length; i++)
		{
			if(abb.equalsIgnoreCase(suitAbbreviations[i]))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public String getCardAbb(int num)
	{
		if(num == 1)
		{
			return "2";
		}
		else if(num == 2)
		{
			return "3";
		}
		else if(num == 3)
		{
			return "4";
		}
		else if(num == 4)
		{
			return "5";
		}
		else if(num == 5)
		{
			return "6";
		}
		else if(num == 6)
		{
			return "7";
		}
		else if(num == 7)
		{
			return "8";
		}
		else if(num == 8)
		{
			return "9";
		}
		else if(num == 9)
		{
			return "10";
		}
		else if(num == 10)
		{
			return "J";
		}
		else if(num == 11)
		{
			return "Q";
		}
		else if(num == 12)
		{
			return "K";
		}
		else if(num == 13)
		{
			return "A";
		}
		return null;
	}
	
	/**
	 * Returns the String abbreviation for a number of a suit.  These are in
	 * reverse order of suit representation in the rest of the class because the
	 * number of the suit is also used in the calculation of dominance.  Therefore,
	 * 1 is the weakest suit and 4 is the strongest.
	 * @param num The number of the suit to return an abbreviation of.
	 * @return The String abbreviation of the suit.
	 */
	public String getSuitAbb(int num)
	{
		if(num == 1) 
		{
			return "C";
		}
		else if(num == 2)
		{
			return "S";
		}
		else if(num == 3)
		{
			return "H";
		}
		else if(num == 4)
		{
			return "D";
		}
		return null;
	}
}
