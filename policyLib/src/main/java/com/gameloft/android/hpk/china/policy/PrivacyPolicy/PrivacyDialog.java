package com.gameloft.android.hpk.china.policy.PrivacyPolicy;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gameloft.android.hpk.china.policy.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

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

    private Button btnTerm;
    private Button btnPrivacy;
    private Button btnCookies;
    private Button btnEula;

    private ViewPager2 viewPager;
    private ConstraintLayout dialogLayout;
    private RelativeLayout contentLayout;
    private LinearLayout descLayout;
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

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.hpk_privacy_dialog_layout, container);
        dialogLayout = view.findViewById(R.id.hpk_privacy_dialog_layout);
        contentLayout = view.findViewById(R.id.hpk_privacy_content);
        descLayout = view.findViewById(R.id.hpk_policy_desc_layout);
        tvDesc = view.findViewById(R.id.hpk_policy_desc);
        tvDesc.setTextColor(-11776948);
        viewPager = view.findViewById(R.id.vp_hpk_dialog_content);
//        tabLayout = view.findViewById(R.id.tl_hpk_privacy);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

//        dialogWidth = (int)(350 * width/WIDTH );
//        dialogHeight = (int)(110 * height/HEIGHT );
        dialogWidth = (int)(width * 0.70 );
        dialogHeight = (int)(height * 0.47 );

        // resize dialog
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(dialogLayout);

//        constraintSet.constrainHeight(contentLayout.getId(), dialogHeight);
        constraintSet.constrainWidth(contentLayout.getId(), dialogWidth);

        constraintSet.constrainWidth(descLayout.getId(), dialogWidth);
        //constraintSet.constrainWidth(tabLayout.getId(), dialogWidth);

        // apply update to layout
        constraintSet.applyTo(dialogLayout);

        Log.d("va-test", Color.rgb(56,191,246) + "");
        btnTerm = view.findViewById(R.id.button1);
        btnTerm.setTextColor(-13058058);

        btnTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBars(0);
//                viewPager.setCurrentItem(0);
//                btnTerm.setTypeface(Typeface.DEFAULT_BOLD);
//                btnTerm.setTextColor(-13058058);
//                btnTerm.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
//
//                btnPrivacy.setTypeface(Typeface.DEFAULT);
//                btnPrivacy.setTextColor(Color.BLACK);
//                btnPrivacy.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//
//                btnCookies.setTypeface(Typeface.DEFAULT);
//                btnCookies.setTextColor(Color.BLACK);
//                btnCookies.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//
//                btnEula.setTypeface(Typeface.DEFAULT);
//                btnEula.setTextColor(Color.BLACK);
//                btnEula.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
            }
        });

        btnPrivacy = view.findViewById(R.id.button2);
        btnPrivacy.setTextColor(Color.BLACK);

        btnPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBars(1);
//                viewPager.setCurrentItem(1);
//
//                btnTerm.setTypeface(Typeface.DEFAULT);
//                btnTerm.setTextColor(Color.BLACK);
//                btnTerm.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//
//                btnPrivacy.setTypeface(Typeface.DEFAULT_BOLD);
//                btnPrivacy.setTextColor(-13058058);
//                btnPrivacy.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
//
//                btnCookies.setTypeface(Typeface.DEFAULT);
//                btnCookies.setTextColor(Color.BLACK);
//                btnCookies.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//
//                btnEula.setTypeface(Typeface.DEFAULT);
//                btnEula.setTextColor(Color.BLACK);
//                btnEula.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);


            }
        });

        btnCookies = view.findViewById(R.id.button3);
        btnCookies.setTextColor(Color.BLACK);

        btnCookies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBars(2);
//                viewPager.setCurrentItem(2);
//
//                btnTerm.setTypeface(Typeface.DEFAULT);
//                btnTerm.setTextColor(Color.BLACK);
//                btnTerm.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//
//                btnPrivacy.setTypeface(Typeface.DEFAULT);
//                btnPrivacy.setTextColor(Color.BLACK);
//                btnPrivacy.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//
//                btnCookies.setTypeface(Typeface.DEFAULT_BOLD);
//                btnCookies.setTextColor(-13058058);
//                btnCookies.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
//
//                btnEula.setTypeface(Typeface.DEFAULT);
//                btnEula.setTextColor(Color.BLACK);
//                btnEula.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);

            }
        });

        btnEula = view.findViewById(R.id.button4);
        btnEula.setTextColor(Color.BLACK);

        btnEula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBars(3);
//                viewPager.setCurrentItem(3);
//
//                btnTerm.setTypeface(Typeface.DEFAULT);
//                btnTerm.setTextColor(Color.BLACK);
//                btnTerm.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//
//                btnPrivacy.setTypeface(Typeface.DEFAULT);
//                btnPrivacy.setTextColor(Color.BLACK);
//                btnPrivacy.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//
//                btnCookies.setTypeface(Typeface.DEFAULT);
//                btnCookies.setTextColor(Color.BLACK);
//                btnCookies.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
//
//                btnEula.setTypeface(Typeface.DEFAULT_BOLD);
//                btnEula.setTextColor(-13058058);
//                btnEula.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            }
        });

        viewPager = view.findViewById(R.id.vp_hpk_dialog_content);
        viewPager.setAdapter(new PagerAdapter(this));
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            public void onPageScrollStateChanged(int state) {

            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            public void onPageSelected(int position) {
                Log.d("va-test", " onPageSelected pos = " + position);
//                viewPager.setCurrentItem(position);
                updateBars(position);
            }
        });


//        new TabLayoutMediator(tabLayout, viewPager,
//                new TabLayoutMediator.TabConfigurationStrategy() {
//                    @Override
//                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                        switch (position){
//                            case 0:
//                                tab.setText(R.string.hpk_term_of_use_title);
//                                break;
//                            case 1:
//                                tab.setText(R.string.hpk_privacy_policy_title);
//
//                                break;
//                            case 2:
//                                tab.setText(R.string.hpk_cookies_policy_title);
//
//                                break;
//                            case 3:
//                                tab.setText(R.string.hpk_eula_title);
//
//                                break;
//                        }
//                    }
//                }
//        ).attach();

        btnNext = view.findViewById(R.id.btn_hpk_privacy_next);
        btnNext.setText(R.string.hpk_privacy_button_agree);
        btnNext.setTextColor(-13058058);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                argeementListener.onAgreementResult(true,"Agree");
            }
        });

        btnNext.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnNext.setBackgroundResource(R.drawable.hpk_privacy_layout_btn_pressed);
                    btnNext.setTextColor(-1);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnNext.setBackgroundResource(R.drawable.hpk_privacy_layout_btn);
                    btnNext.setTextColor(-13058058);
                }
                return false;
            }
        });

        btnDecline = view.findViewById(R.id.btn_hpk_privacy_decline);
        btnDecline.setText(R.string.hpk_privacy_button_decline);
        btnDecline.setTextColor(-13058058);
        btnDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                argeementListener.onAgreementResult(false,"Decline");
            }
        });



        btnDecline.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnDecline.setBackgroundResource(R.drawable.hpk_privacy_layout_btn_pressed);
                    btnDecline.setTextColor(-1);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnDecline.setBackgroundResource(R.drawable.hpk_privacy_layout_btn);
                    btnDecline.setTextColor(-13058058);
                }
                return false;
            }
        });



        return view;
    }

    private void updateBars(int pos) {
        Button[] btns = {btnTerm, btnPrivacy, btnCookies, btnEula};

        int index = 0;
        for(Button btn : btns) {
            if(pos == index) {
                viewPager.setCurrentItem(pos);
                btn.setTypeface(Typeface.DEFAULT_BOLD);
                btn.setTextColor(-13058058);
                btn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            } else {
                btn.setTypeface(Typeface.DEFAULT);
                btn.setTextColor(Color.BLACK);
                btn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
            }
            index++;
        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}