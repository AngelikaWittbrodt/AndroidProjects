package examples.sda.coinmarketcapcalculator;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by angelika on 08.06.17.
 */

public class CoinViewHolder extends RecyclerView.ViewHolder {

		private TextView symbolText;
		private TextView nameText;
		private TextView priceUsdText;
		private TextView priceBtcText;

		public CoinViewHolder(View itemView) {
				super(itemView);
				symbolText = (TextView) itemView.findViewById(R.id.symbol);
				nameText = (TextView) itemView.findViewById(R.id.name);
				priceUsdText = (TextView) itemView.findViewById(R.id.price_usd);
				priceBtcText = (TextView) itemView.findViewById(R.id.price_btc);
		}

		public void setSymbolText(String symbol) {
				symbolText.setText(symbol);
		}

		public void setNameText(String name) {
				nameText.setText(name);
		}

		public void setPriceUsdText(String priceUsd) {
				priceUsdText.setText(priceUsd);
		}

		public void setPriceBtcText(String priceBtc) {
				priceBtcText.setText(priceBtc);
		}
}
