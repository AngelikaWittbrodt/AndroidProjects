package examples.sda.coinmarketcapcalculator.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import examples.sda.coinmarketcapcalculator.model.CoinModel;
import examples.sda.coinmarketcapcalculator.model.CoinTable;

/**
 * Created by angelika on 08.06.17.
 */

public class CoinParser {

		public CoinTable parseCoinTable(String string) throws JSONException {

				CoinTable coinTable = new CoinTable();
				List<CoinModel> currencies = parseCoinArray(string);
				coinTable.setCurrencies(currencies);
				return coinTable;
		}

		public List<CoinModel> parseCoinArray(String string) throws JSONException {
				List<CoinModel> coins = new ArrayList<>();
				JSONArray array = new JSONArray(string);

				for (int i = 0; i < array.length(); i++) {
						JSONObject jsonCoin = array.getJSONObject(i);

						String id = jsonCoin.optString("id");
						String name = jsonCoin.optString("name");
						String symbol = jsonCoin.optString("symbol");
						int rank = jsonCoin.optInt("rank");
						double priceUsd = jsonCoin.optDouble("price_usd");
						double priceBtc = jsonCoin.optDouble("price_btc");
						long hVolumeUsd = jsonCoin.optLong("24h_volume_usd");
						long marketCupUsd = jsonCoin.optLong("market_cap_usd");
						long avalibleSupply = jsonCoin.optLong("available_supply");
						long totalSupply = jsonCoin.optLong("total_supply");
						double percentChange1h = jsonCoin.optDouble("percent_change_1h");
						double percentChange24h = jsonCoin.optDouble("percent_change_24h");
						double percentChange7d = jsonCoin.getDouble("percent_change_7d");
						long lastUpdate = jsonCoin.optLong("last_updated");

						CoinModel coinModel = new CoinModel();
						coinModel.setId(id);
						coinModel.setName(name);
						coinModel.setSymbol(symbol);
						coinModel.setRank(rank);
						coinModel.setPriceUsd(priceUsd);
						coinModel.setPriceBtc(priceBtc);
						coinModel.sethVolumeUsd(hVolumeUsd);
						coinModel.setMarketCapUsd(marketCupUsd);
						coinModel.setAvailableSupply(avalibleSupply);
						coinModel.setTotalSupply(totalSupply);
						coinModel.setPercentChange1h(percentChange1h);
						coinModel.setPercentChange24h(percentChange24h);
						coinModel.setPercentChange7d(percentChange7d);
						coinModel.setLastUpdated(lastUpdate);

						coins.add(coinModel);
				}

				return coins;
		}
}
