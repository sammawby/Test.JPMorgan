package Test.JPMorgan;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {

		//Current share price
		BigDecimal tickerPrice = BigDecimal.TEN;

		//Load stock data
		Trade trade1 = new Trade(1, TypeOfTrade.SELL, tickerPrice);
		Trade trade2 = new Trade(1, TypeOfTrade.SELL, tickerPrice);
		Trade trade3 = new Trade(1, TypeOfTrade.BUY, tickerPrice);
		Trade trade4 = new Trade(1, TypeOfTrade.BUY, tickerPrice);
		Trade trade5 = new Trade(1, TypeOfTrade.BUY, tickerPrice);
		Stock stock1 = new CommonStock("TEA", BigDecimal.ZERO, new BigDecimal("100"));
		Stock stock2 = new CommonStock("POP", new BigDecimal("8"), new BigDecimal("100"));
		Stock stock3 = new CommonStock("ALE", new BigDecimal("23"), new BigDecimal("60"));
		Stock stock4 = new PreferredStock("GIN", new BigDecimal("8"), new BigDecimal("100"), new BigDecimal("0.02"));
		Stock stock5 = new CommonStock("JOE", new BigDecimal("13"), new BigDecimal("250"));
		stock1.NewTrade(trade1);
		stock2.NewTrade(trade2);
		stock3.NewTrade(trade3);
		stock4.NewTrade(trade4);
		stock5.NewTrade(trade5);
		Exchange exchange = new Exchange();
		exchange.NewStock(stock1);
		exchange.NewStock(stock2);
		exchange.NewStock(stock3);
		exchange.NewStock(stock4);
		exchange.NewStock(stock5);

		//1.a.i
		Stock stockAi = exchange.FindStock("TEA");
		BigDecimal dividendYield = stockAi.CalculateDividendYield(tickerPrice);
		System.out.println("Dividend yield: " + dividendYield);

		//1.a.ii
		Stock stockAii = exchange.FindStock("POP");
		BigDecimal peRatio = stockAii.CalculatePeRatio(BigDecimal.TEN);
		System.out.println("P/E ration: " + peRatio);

		//1.a.iii
		Trade tradeAiii = new Trade(1, TypeOfTrade.BUY, tickerPrice);
		Stock stockAiii = exchange.FindStock("ALE");
		stockAiii.NewTrade(tradeAiii);
		System.out.println("New trade");

		//1.a.iv
		Stock stockAiv = exchange.FindStock("JOE");
		stockAiv.NewTrade(new Trade(1, TypeOfTrade.SELL, tickerPrice));
		BigDecimal stockPrice = stockAiv.CalculateStockPrice(15);
		System.out.println("Stock price: " + stockPrice);
		
		//1.a.v
		double allShareindex = exchange.CalculateAllShareIndex();
		System.out.println("All share index: " + allShareindex);
	}

}
