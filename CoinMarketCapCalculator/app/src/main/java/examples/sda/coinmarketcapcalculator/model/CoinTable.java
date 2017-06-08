package examples.sda.coinmarketcapcalculator.model;

import java.util.List;

/**
 * Created by angelika on 08.06.17.
 */

public class CoinTable {

		private List<CoinModel> currencies;

		public List<CoinModel> getCurrencies() {
				return currencies;
		}

		public void setCurrencies(List<CoinModel> currencies) {
				this.currencies = currencies;
		}
}
