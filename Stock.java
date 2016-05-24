package Test.JPMorgan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

abstract class Stock implements IStock {
	String symbol;
	BigDecimal lastDividend;
	BigDecimal parValue; //Stated value
	ArrayList<Trade> trades = new ArrayList<Trade>();

	Stock(String symbol, BigDecimal lastDividend, BigDecimal parValue) {
		this.symbol = symbol;
		this.lastDividend = lastDividend;
		this.parValue = parValue;
	}

	@Override
	public BigDecimal CalculateDividendYield(BigDecimal tickerPrice) {
		return BigDecimal.ZERO;
	}

	@Override
	public BigDecimal CalculatePeRatio(BigDecimal tickerPrice) {
		return BigDecimal.ZERO;
	}

	public void NewTrade(Trade trade) {
		trades.add(trade);
		trade.Record();
	}

	//Period in minutes
	public BigDecimal CalculateStockPrice(int period) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		int totalQuantity = 0;
		Date startTime = new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(period));
		for (int i = trades.size() - 1; i >= 0; i--) {
			if (trades.get(i).recordedTimestamp.before(startTime)) {
				break;
			}
			BigDecimal tradeTotal = trades.get(i).price.multiply(new BigDecimal(trades.get(i).quantityOfShares));
			totalPrice = totalPrice.add(tradeTotal);
			totalQuantity = totalQuantity + trades.get(i).quantityOfShares;
		}
		BigDecimal stockPrice = totalPrice.divide(new BigDecimal(totalQuantity));

		return stockPrice;
	}
}
