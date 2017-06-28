package examples.sda.coinmarketcapcalculator;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import examples.sda.coinmarketcapcalculator.model.CoinTable;
import examples.sda.coinmarketcapcalculator.service.CoinProvider;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, CoinProvider.CoinAsyncTaskListener {

		private SwipeRefreshLayout swipeRefreshLayout;
		private CoinAdapter coinAdapter;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);

				swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
				swipeRefreshLayout.setOnRefreshListener(this);
				swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_dark,
								android.R.color.holo_green_dark, android.R.color.holo_orange_dark,
								android.R.color.holo_red_dark);

				RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
				recyclerView.setHasFixedSize(false);
				recyclerView.setLayoutManager(new LinearLayoutManager(this));

				coinAdapter = new CoinAdapter();
				recyclerView.setAdapter(coinAdapter);
				onRefresh();
//				try {
//						getBitmapFromURL("https://files.coinmarketcap.com/static/img/coins/16x16/bitcoin.png");
//				} catch (IOException e) {
//						Log.e("Exception", e.toString());
//				}
		}

		@Override
		public void onRefresh() {
				new CoinProvider(this).execute();
		}

		@Override
		public void onDataLoaded(CoinTable coinTable) {
				coinAdapter.setData(coinTable.getCurrencies());
				swipeRefreshLayout.setRefreshing(false);
		}

		/*public void getBitmapFromURL(String path) throws IOException {
				Bitmap myBitmap = null;
				InputStream inputStream = null;
				ImageView imageView = (ImageView) findViewById(R.id.headerImage);
				int responseCode = -1;


				URL url = new URL(path);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setDoInput(true);
				connection.connect();
				responseCode = connection.getResponseCode();
				if (responseCode == HttpURLConnection.HTTP_OK) {
						inputStream = connection.getInputStream();
						myBitmap = BitmapFactory.decodeStream(inputStream);
						imageView.setImageBitmap(myBitmap);
						inputStream.close();
				}*/
}

