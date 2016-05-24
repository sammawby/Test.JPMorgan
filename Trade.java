package Test.JPMorgan;

import java.math.BigDecimal;
import java.util.Date;

enum TypeOfTrade { BUY, SELL };

public class Trade {
	Date recordedTimestamp;
	int quantityOfShares;
	TypeOfTrade typeOfTrade;
	BigDecimal price;
	
	Trade(int quantityOfShares, TypeOfTrade typeOfTrade, BigDecimal price) {
		this.recordedTimestamp = new Date();
		this.quantityOfShares = quantityOfShares;
		this.typeOfTrade = typeOfTrade;
		this.price = price;
	}
	
	public void Record() {
	}
}
