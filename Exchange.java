package Test.JPMorgan;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Exchange {
	Map<String, Stock> stocks = new HashMap<String, Stock>();

	public Stock FindStock(String symbol) {
		return stocks.get(symbol);
	}

	public void NewStock(Stock stock) {
		stocks.put(stock.symbol, stock);
	}
	
	public double CalculateAllShareIndex() {
		BigDecimal stocksProduct = BigDecimal.ONE;
		for (Stock stock : stocks.values()) {
			BigDecimal stockPrice = stock.CalculateStockPrice(15);
			stocksProduct = stockPrice.multiply(stocksProduct);
		}

		Double stocksProductWithoutPrecission = stocksProduct.doubleValue();//Remove precision for simple ln solution
		double geometricMean = Math.pow(stocksProductWithoutPrecission.doubleValue(), 1.0 / (double)stocks.size());

		return geometricMean;
	}
}
