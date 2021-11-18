package go.guideapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import go.guideapp.Articles.Article_1;
import go.guideapp.Articles.Article_2;
import go.guideapp.Articles.Article_3;
import go.guideapp.Articles.Article_4;
import go.guideapp.Articles.Article_5;
import go.guideapp.Articles.Article_6;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });
    }

    public void onClick(View view) {
        switch  (view.getId()){
            case R.id.btn1:
                Intent intent = new Intent(MainActivity.this, Article_1.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                }
                break;
            case  R.id.btn2:
                intent = new Intent(MainActivity.this, Article_2.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                }
                break;
            case  R.id.btn3:
                intent = new Intent(MainActivity.this, Article_3.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                }
                break;
            case  R.id.btn4:
                intent = new Intent(MainActivity.this, Article_4.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                }
                break;
            case  R.id.btn5:
                intent = new Intent(MainActivity.this, Article_5.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                }
                break;
            case  R.id.btn6:
                intent = new Intent(MainActivity.this, Article_6.class);
                startActivity(intent);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                }
        }
    }

}