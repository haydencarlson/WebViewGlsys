package com.example.hayden.webviewglsys;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(isNetworkStatusAvailable (getApplicationContext())) {
            Toast.makeText(getApplicationContext(), "internet available", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
            String url = "https://portalna.net-cents.com";
            WebView view=(WebView) this.findViewById(R.id.webView);
            view.getSettings().setJavaScriptEnabled(true);
            view.loadUrl(url);
        } else {
            Toast.makeText(getApplicationContext(), "Internet connection required", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.no_internet);

        }

    }

    public static boolean isNetworkStatusAvailable (Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if(netInfos != null)
                if(netInfos.isConnected())
                    return true;
        }
        return false;
    }
}
