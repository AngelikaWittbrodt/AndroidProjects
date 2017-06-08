package examples.sda.coinmarketcapcalculator.service;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import examples.sda.coinmarketcapcalculator.model.CoinTable;

/**
 * Created by angelika on 08.06.17.
 */

public class CoinProvider extends AsyncTask<String, Void, CoinTable> {

		private final static String CMC_API_URL = "https://api.coinmarketcap.com/v1/ticker/?format=json";
		private CoinParser coinParser;
		private CoinAsyncTaskListener listener;

		public CoinProvider(CoinAsyncTaskListener listener) {
				this.listener = listener;
				this.coinParser = new CoinParser();
		}

		@Override
		protected CoinTable doInBackground(String... params) {
				try{
						String json = getJson();
						return coinParser.parseCoinTable(json);
				} catch (JSONException | IOException e) {
						e.printStackTrace();
				}
				return null;
		}

		@Override
		protected void onPostExecute(CoinTable result) {
				listener.onDataLoaded(result);
		}

		private String getJson() throws IOException {
				String urlString = CMC_API_URL;
				URL url = new URL(urlString);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				InputStream inputStream = new BufferedInputStream(connection.getInputStream());

				StringBuilder sb = new StringBuilder();
				Reader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));

				int charCode;

				while ((charCode = reader.read()) != -1) {
						char character = (char) charCode;
						sb.append(character);
				}

				connection.disconnect();

				return sb.toString();
		}

		public interface CoinAsyncTaskListener {
				void onDataLoaded(CoinTable coinTable);
		}

}
