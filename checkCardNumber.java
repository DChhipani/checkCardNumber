boolean checkCardNumber(String cardNumber) {
	char[] cardNumberArray = cardNumber.toCharArray();

	//checking if all the characters are numbers
	for(char ch: cardNumberArray) {
		if(!Character.isDigit(ch)) {
				return false;
		}
	}

	//checking that the start digits are valid
	boolean startDigitsValid = false;
	if(String.valueOf(cardNumberArray[0]) == "4")  {
		startDigitsValid = true;
	}
	String first2 = cardNumber.substring(0,2);
	if(first2 == "34" || first2 == "37" || first2 == "51" || first2 == "52" || first2 == "53" || first2 == "54" || first2 == "55" || first2 == "62") {
		startDigitsValid = true;
	}

	for(int i =2221; i <= 2720; i++) {
		if(cardNumber.substring(0,4).equals(String.valueOf(i))) {
			startDigitsValid = true;
		}
	}
	
		if(startDigitsValid == false) {
			return false;
	}

	//checking the cardNumber is a valid length
	boolean validLength = false;
	int cardLen = cardNumber.length();
	if(cardLen == 13 || cardLen == 15 || cardLen == 16 || cardLen == 17 || cardLen == 18 || cardLen == 19) {
		validLength = true;
	}

		if(validLength == false) {
			return false;
	}
	

	//Luhn Algorithm
	boolean LuhnAlg = false;
	int sum = 0;
	boolean isSecond = false;
	int currentDigit;

	//Proceeding from the rightmost digit and moving left
	for(int i = cardLen; i >= 0; i--) {
		currentDigit = Integer.valueOf(cardNumber[i]);

	//double the value of every second digit
		if(isSecond == true) {
			currentDigit *= 2;
		}

	//If the result of this doubling is greater than 9, then subtract 9 from the product	
		if(currentDigit > 9) {
			currentDigit -= 9;
		}

	//Take the sum of the resulting digits
		isSecond = !isSecond;
		sum += currentDigit;

	}	
	
	//verifying Luhn Algorithm
	if(sum % 10 == 0) {
		LuhnAlg = true;
	}
	if(startDigitsValid == true && validLength == true && LunhAlg == true) {
		return true;
	}
	else{
		return false;
	}

}






















