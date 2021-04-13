package com.gameloft.android.hpk.china.policy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.gameloft.android.hpk.china.policy.PrivacyPolicy.ArgeementListener;
import com.gameloft.android.hpk.china.policy.PrivacyPolicy.PrivacyDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class PrivacyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        final SharedPreferences sp = getSharedPreferences("userAgreementResult", 0);
        boolean agreed = sp.getBoolean("userAgreementResult", false);
        if (agreed) {
            finishActivity(agreed);
            return;
        }

        FragmentManager fm = getSupportFragmentManager();
        PrivacyDialog privacyDialog = new PrivacyDialog();
        privacyDialog.setCancelable(false);

        privacyDialog.setArgeementListener(new ArgeementListener() {
            @Override
            public void onAgreementResult(boolean isAgree, String msg) {
                    android.util.Log.e("va-test", "user agree -> start login activity");
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("userAgreementResult", isAgree);
                    editor.apply();

                    finishActivity(isAgree);
            }
        });
        privacyDialog.show(fm, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.util.Log.e("va-test", "PrivacyActivity onDestroy");
    }

    private void startLoginActivity() {
        try {
            android.util.Log.e("va-test", "PrivacyActivity start LoginActivity");

            Class loginActivityClass = Class.forName("com.gameloft.android.anmp.myapplication.LoginActivity");
            Intent intent = new Intent(PrivacyActivity.this, loginActivityClass);

            startActivity(intent);
            finish();
        } catch (ClassNotFoundException ex) {
            android.util.Log.e("va-test", "PrivacyActivity start LoginActivity failed ex=" + ex);
        }
    }

    private void finishActivity(boolean agreed) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", agreed);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}