package examples.sda.coinmarketcapcalculator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import examples.sda.coinmarketcapcalculator.model.CoinModel;

/**
 * Created by angelika on 08.06.17.
 */

public class CoinAdapter extends RecyclerView.Adapter<CoinViewHolder> {
		private List<CoinModel> currencies = Collections.emptyList();

		@Override
		public CoinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
				View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coin, parent, false);
				return new CoinViewHolder(view);
		}

		@Override
		public void onBindViewHolder(CoinViewHolder holder, int position) {
				CoinModel coinModel = currencies.get(position);
				holder.setNameText(coinModel.getName());
				holder.setSymbolText(coinModel.getSymbol());
				holder.setPriceUsdText(String.valueOf(coinModel.getPriceUsd()));
				holder.setPriceBtcText(String.valueOf(coinModel.getPriceBtc()));
		}

		@Override
		public int getItemCount() {
				return currencies.size();
		}

		public void setData(List<CoinModel> data) {
				this.currencies = data;
				notifyDataSetChanged();
		}
}
