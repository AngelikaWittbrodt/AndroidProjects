package examples.sda.coinmarketcapcalculator.model;

/**
 * Created by angelika on 08.06.17.
 */

public class CoinModel {

		private String id;
		private String name;
		private String symbol;
		private int rank;
		private double priceUsd;
		private double priceBtc;
		private long hVolumeUsd;
		private long marketCapUsd;
		private long AvailableSupply;
		private long TotalSupply;
		private double percentChange1h;
		private double percentChange24h;
		private double percentChange7d;
		private long lastUpdated;

		public String getId() {
				return id;
		}

		public void setId(String id) {
				this.id = id;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public String getSymbol() {
				return symbol;
		}

		public void setSymbol(String symbol) {
				this.symbol = symbol;
		}

		public int getRank() {
				return rank;
		}

		public void setRank(int rank) {
				this.rank = rank;
		}

		public double getPriceUsd() {
				return priceUsd;
		}

		public void setPriceUsd(double priceUsd) {
				this.priceUsd = priceUsd;
		}

		public double getPriceBtc() {
				return priceBtc;
		}

		public void setPriceBtc(double priceBtc) {
				this.priceBtc = priceBtc;
		}

		public long gethVolumeUsd() {
				return hVolumeUsd;
		}

		public void sethVolumeUsd(long hVolumeUsd) {
				this.hVolumeUsd = hVolumeUsd;
		}

		public long getMarketCapUsd() {
				return marketCapUsd;
		}

		public void setMarketCapUsd(long marketCapUsd) {
				this.marketCapUsd = marketCapUsd;
		}

		public long getAvailableSupply() {
				return AvailableSupply;
		}

		public void setAvailableSupply(long availableSupply) {
				AvailableSupply = availableSupply;
		}

		public long getTotalSupply() {
				return TotalSupply;
		}

		public void setTotalSupply(long totalSupply) {
				TotalSupply = totalSupply;
		}

		public double getPercentChange1h() {
				return percentChange1h;
		}

		public void setPercentChange1h(double percentChange1h) {
				this.percentChange1h = percentChange1h;
		}

		public double getPercentChange24h() {
				return percentChange24h;
		}

		public void setPercentChange24h(double percentChange24h) {
				this.percentChange24h = percentChange24h;
		}

		public double getPercentChange7d() {
				return percentChange7d;
		}

		public void setPercentChange7d(double percentChange7d) {
				this.percentChange7d = percentChange7d;
		}

		public long getLastUpdated() {
				return lastUpdated;
		}

		public void setLastUpdated(long lastUpdated) {
				this.lastUpdated = lastUpdated;
		}
}
