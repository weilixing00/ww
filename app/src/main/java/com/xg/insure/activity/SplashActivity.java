package com.xg.insure.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.xg.insure.R;
import com.xg.insure.base.BaseActivity;
import com.xg.insure.common.NoDoubleClickListener;
import com.xg.insure.fragment.FinancingCalculatorDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/6/13.
 */

public class SplashActivity extends BaseActivity {

    @BindView(R.id.vp_activity_splash)
    ViewPager vpActivitySplash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //透明状态栏
        getWindow()
                .addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        vpActivitySplash.setAdapter(new SplashViewPagerAdapter(SplashActivity.this));

    }

    class SplashViewPagerAdapter extends PagerAdapter {

        private final Activity context;
//    @BindView(R.id.iv_item1_vp_splash)
//    ImageView ivItem1VpSplash;
//    @BindView(R.id.iv_item2_vp_splash)
//    ImageView ivItem2VpSplash;
//    @BindView(R.id.iv_item3_vp_splash)
//    ImageView ivItem3VpSplash;
//    @BindView(R.id.bt_item3_vp_splash)
//    Button btItem3VpSplash;

        public SplashViewPagerAdapter(Activity context) {
            this.context = context;
        }

        private int[] imageIds = new int[3];

        @Override
        public int getCount() {
            return imageIds == null ? 0 : imageIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
//        super.destroyItem(container, position, object);
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            View view = null;
            switch (position) {
                case 0:
                    view = LayoutInflater.from(context).inflate(R.layout.item1_viewpager_activity_splash, container, false);
//                ivItem1VpSplash.setImageResource();
                    break;
                case 1:
                    view = LayoutInflater.from(context).inflate(R.layout.item2_viewpager_activity_splash, container, false);
                    break;
                case 2:
                    view = LayoutInflater.from(context).inflate(R.layout.item3_viewpager_activity_splash, container, false);
                    Button btItem3VpSplash = (Button) view.findViewById(R.id.bt_item3_vp_splash);
                    btItem3VpSplash.setOnClickListener(new NoDoubleClickListener() {
                        @Override
                        public void onNoDoubleClick(View v) {
                            FinancingCalculatorDialogFragment financingCalculatorDialogFragment=new FinancingCalculatorDialogFragment();
                            financingCalculatorDialogFragment.show(getSupportFragmentManager(),null);
//                            context.startActivity(new Intent(context, MainActivity.class));
//                            context.finish();
                        }
                    });
                    break;
            }

            container.addView(view);
            return view;
        }
    }

}
