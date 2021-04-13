package com.gameloft.android.hpk.china.policy.PrivacyPolicy;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gameloft.android.hpk.china.policy.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager2.widget.ViewPager2;

public class PrivacyDialog extends DialogFragment {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 250;

    private Button btnNext;
    private Button btnDecline;
    private TextView tvDesc;

    private ViewPager2 viewPager;
    private ConstraintLayout dialogLayout;
    private TabLayout tabLayout;

    public static int dialogWidth;
    public static int dialogHeight;

    private ArgeementListener argeementListener;

    public void setArgeementListener(ArgeementListener argeementListener) {
        this.argeementListener = argeementListener;
    }

    public static PrivacyDialog newInstance(String data) {
        PrivacyDialog dialog = new PrivacyDialog();
        return dialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.mydialog);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.hpk_privacy_dialog_layout, container);
        dialogLayout = view.findViewById(R.id.hpk_privacy_dialog_layout);
        tvDesc = view.findViewById(R.id.hpk_policy_desc);
        tvDesc.setTextColor(-11776948);
        viewPager = view.findViewById(R.id.vp_hpk_dialog_content);
        tabLayout = view.findViewById(R.id.tl_hpk_privacy);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

//        dialogWidth = (int)(350 * width/WIDTH );
//        dialogHeight = (int)(110 * height/HEIGHT );
        dialogWidth = (int)(width * 0.68 );
        dialogHeight = (int)(height * 0.45 );

        // resize dialog
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(dialogLayout);

        constraintSet.constrainHeight(viewPager.getId(), dialogHeight);
        constraintSet.constrainWidth(viewPager.getId(), dialogWidth);

        constraintSet.constrainWidth(tvDesc.getId(), dialogWidth);
        constraintSet.constrainWidth(tabLayout.getId(), dialogWidth);

        // apply update to layout
        constraintSet.applyTo(dialogLayout);

        viewPager = view.findViewById(R.id.vp_hpk_dialog_content);
        viewPager.setAdapter(new PagerAdapter(this));
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            public void onPageScrollStateChanged(int state) {

            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
            }
        });


        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position){
                            case 0:
                                tab.setText(R.string.hpk_term_of_use_title);
                                break;
                            case 1:
                                tab.setText(R.string.hpk_privacy_policy_title);

                                break;
                            case 2:
                                tab.setText(R.string.hpk_cookies_policy_title);

                                break;
                            case 3:
                                tab.setText(R.string.hpk_eula_title);

                                break;
                        }
                    }
                }
        ).attach();

        btnNext = view.findViewById(R.id.btn_hpk_privacy_next);
        btnNext.setText(R.string.hpk_privacy_button_agree);
        btnNext.setTextColor(Color.BLACK);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                argeementListener.onAgreementResult(true,"Agree");
            }
        });

        btnDecline = view.findViewById(R.id.btn_hpk_privacy_decline);
        btnDecline.setText(R.string.hpk_privacy_button_decline);
        btnDecline.setTextColor(Color.BLACK);
        btnDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                argeementListener.onAgreementResult(false,"Decline");
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}