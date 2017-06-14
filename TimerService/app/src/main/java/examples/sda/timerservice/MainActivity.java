package examples.sda.timerservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements TimerService.TimerServiceListener {

		private static final int DEFAULT_TIMER = 10;

		@BindView(R.id.textView_time)
		protected TextView textTime;

		@BindView(R.id.timer_text)
		protected EditText textTimer;

		@BindView(R.id.button_play)
		protected Button buttonPlay;

		@BindView(R.id.button_pause)
		protected Button buttonPause;

		@BindView(R.id.button_stop)
		protected Button buttonStop;

		private TimerService timerService;

		private ServiceConnection serviceConnection = new ServiceConnection() {
				@Override
				public void onServiceConnected(ComponentName name, IBinder service) {
						timerService = ((TimerService.LocalBinder) service).getService();
				}

				@Override
				public void onServiceDisconnected(ComponentName name) {
						timerService = null;
				}
		};

		@OnClick({R.id.button_play, R.id.button_pause, R.id.button_stop})
		public void setButtonClick(View v) {
				int time = Integer.parseInt(textTimer.getText().toString());
				switch (v.getId()) {
						case R.id.button_play:
								timerService.startTimer(time, MainActivity.this);
								break;
						case R.id.button_pause:
								timerService.pauseTimer(MainActivity.this);
								break;
						case R.id.button_stop:
								timerService.stopTimer(MainActivity.this);
								break;
				}
		}

		@Override
		protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
				ButterKnife.bind(this);

				textTimer.setText(String.valueOf(DEFAULT_TIMER));
				textTimer.getText().toString();

				bindTimerService();

		}

		private void bindTimerService() {
				Intent intent = new Intent(this, TimerService.class);
				bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
		}

		@Override
		protected void onDestroy() {
				super.onDestroy();
				unbindService(serviceConnection);
		}


		@Override
		public void onCounterUpdate(int seconds) {
				textTime.setText(Integer.valueOf(seconds).toString());
		}
}
