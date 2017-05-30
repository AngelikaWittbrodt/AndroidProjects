package examples.sda.todoapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.nfc.Tag;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import examples.sda.todoapp.R;
import examples.sda.todoapp.data.TaskEntity;

/**
 * Created by angelika on 24.05.17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
		private List<TaskEntity> tasks;


		public MyAdapter(List<TaskEntity> tasks) {
				this.tasks = tasks;
		}

		@Override
		public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
				Context context = parent.getContext();
				LayoutInflater inflater = LayoutInflater.from(context);
				View listView = inflater.inflate(R.layout.single_task_item, parent, false);

				return new ViewHolder(listView);
		}

		@Override
		public void onBindViewHolder(final ViewHolder viewHolder, int position) {
				final TaskEntity taskEntity = tasks.get(position);
				final String tilte = taskEntity.getTitle();
				final String description = taskEntity.getDescription();

				viewHolder.mTitle.setText(tilte);
				viewHolder.mDescription.setText(description);
				viewHolder.mCardView.setOnClickListener(new View.OnClickListener() {

						@Override
						public void onClick(final View v) {
								Snackbar.make(viewHolder.mCardView, "Error occurred during saving the task", Snackbar.LENGTH_LONG)
												.show();
						}
				});
		}

		@Override
		public int getItemCount() {
				if(tasks == null) {
						return 0;
				}
						return tasks.size();
		}

		public void setData(final List<TaskEntity> tasks) {
				this.tasks = tasks;
		}

		public static class ViewHolder extends RecyclerView.ViewHolder {
				public TextView mTitle;
				public TextView mDescription;
				public CardView mCardView;

				public ViewHolder(View itemView) {
						super(itemView);
						mCardView = (CardView) itemView.findViewById(R.id.card_view);
						mTitle = (TextView) itemView.findViewById(R.id.task_title);
						mDescription = (TextView) itemView.findViewById(R.id.task_description);
				}
		}
}
