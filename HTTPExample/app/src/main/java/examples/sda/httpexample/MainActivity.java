package examples.sda.httpexample;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
    private Button buttonBack;
    private Button buttonForward;
    private EditText editText;
    private WebView webView;
    private IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);

    NetworkStateReceiver networkStateReceiver = new NetworkStateReceiver();

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(networkStateReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkStateReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBack = (Button) findViewById(R.id.button);
        buttonForward = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText);
        webView = (WebView) findViewById(R.id.webview);

        WebViewClient webViewClient = new WebViewClient();
        webView.setWebViewClient(webViewClient);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("http://www.google.com");
            }
        });

    }
}
