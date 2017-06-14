package examples.sda.timerservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;

/**
 * Created by angelika on 13.06.17.
 */

public class TimerService extends Service {

		private static final String TAG = "Finished counting";
		private IBinder binder = new LocalBinder();
		private Timer timer = new Timer();
		private CountDownTimer countDownTimer;

		private int seconds;
		private boolean paused;

		public void startTimer(final int seconds, final TimerServiceListener listener) {

				countDownTimer = new CountDownTimer(seconds * 1000, 1000) {
						@Override
						public void onTick(long millisUntilFinished) {
								int counter = (int) millisUntilFinished;
								listener.onCounterUpdate(counter / 1000);
								Log.i("counter", counter + "");
						}

						@Override
						public void onFinish() {
								Log.i(TAG, "Time's up!");
						}
				};

				countDownTimer.start();
		}

		public void pauseTimer(final TimerServiceListener listener) {
		}

		public void stopTimer(final TimerServiceListener listener) {
				if (countDownTimer != null) {
						countDownTimer.cancel();
						countDownTimer = null;
				}
		}

		@Override
		public IBinder onBind(Intent intent) {
				return binder;
		}

		//observer pattern
		public interface TimerServiceListener {
				void onCounterUpdate(int seconds);
		}

		public class LocalBinder extends Binder {
				public TimerService getService() {
						return TimerService.this;
				}
		}
}
