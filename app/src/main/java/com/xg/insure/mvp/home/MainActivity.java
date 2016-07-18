package com.xg.insure.mvp.home;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xg.insure.R;
import com.xg.insure.constant.KeyConstant;
import com.xg.insure.fragment.RecommendFragment;
import com.xg.insure.fragment.FinancingFragment;
import com.xg.insure.fragment.MoreFragment;
import com.xg.insure.fragment.RichesFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页
 * 实现功能  沉浸式状态栏 听诊器模式
 */
//public class MainActivity extends BaseActivity {
public class MainActivity extends FragmentActivity {


    @BindView(R.id.main_content)
    FrameLayout mainContent;
    @BindView(R.id.iv_tab1_bottom_activity_main)
    ImageView ivTab1BottomActivityMain;
    @BindView(R.id.tv_tab1_bottom_activity_main)
    TextView tvTab1BottomActivityMain;
    @BindView(R.id.ll_tab1_bottom_activity_main)
    LinearLayout llTab1BottomActivityMain;
    @BindView(R.id.iv_tab2_bottom_activity_main)
    ImageView ivTab2BottomActivityMain;
    @BindView(R.id.tv_tab2_bottom_activity_main)
    TextView tvTab2BottomActivityMain;
    @BindView(R.id.ll_tab2_bottom_activity_main)
    LinearLayout llTab2BottomActivityMain;
    @BindView(R.id.iv_tab3_bottom_activity_main)
    ImageView ivTab3BottomActivityMain;
    @BindView(R.id.tv_tab3_bottom_activity_main)
    TextView tvTab3BottomActivityMain;
    @BindView(R.id.ll_tab3_bottom_activity_main)
    LinearLayout llTab3BottomActivityMain;
    @BindView(R.id.iv_tab4_bottom_activity_main)
    ImageView ivTab4BottomActivityMain;
    @BindView(R.id.tv_tab4_bottom_activity_main)
    TextView tvTab4BottomActivityMain;
    @BindView(R.id.ll_tab4_bottom_activity_main)
    LinearLayout llTab4BottomActivityMain;
    private RecommendFragment recommendFragment;
    private FinancingFragment houseCollectFragment;
    private RichesFragment richesFragment;
    private MoreFragment moreFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // TODO: 2016/6/7 设置沉浸式状态栏颜色

        llTab1BottomActivityMain.setOnClickListener(clickListener);
        llTab2BottomActivityMain.setOnClickListener(clickListener);
        llTab3BottomActivityMain.setOnClickListener(clickListener);
        llTab4BottomActivityMain.setOnClickListener(clickListener);


        // 这里一定要在save为null时才加载Fragment，Fragment中onCreateView等生命周里加载根子Fragment同理
        // 因为在页面重启时，Fragment会被保存恢复，而此时再加载Fragment会重复加载，导致重叠
        if(savedInstanceState == null){
            // 这里加载根Fragment
            //默认选择第一个
            setSelect(0);
        }




    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            int index = intent.getIntExtra(KeyConstant.IntentKeyConstant.MAINACTIIVTY_INDEX, 0);
            setSelect(index);
        }

        super.onNewIntent(intent);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_tab1_bottom_activity_main:
                    setSelect(0);
                    break;
                case R.id.ll_tab2_bottom_activity_main:
                    setSelect(1);

                    break;
                case R.id.ll_tab3_bottom_activity_main:
                    setSelect(2);

                    break;
                case R.id.ll_tab4_bottom_activity_main:
                    setSelect(3);
                    break;
            }
        }
    };

    public void setSelect(int i) {
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        resetTabs();
        hide(ft);
        switch (i) {
            case 0:
                if (recommendFragment == null) {
                    recommendFragment = new RecommendFragment();
                    ft.add(R.id.main_content, recommendFragment);
                }

                ft.show(recommendFragment);
                ivTab1BottomActivityMain.setImageResource(R.mipmap.select1_img2x);
                tvTab1BottomActivityMain.setTextColor(getResources().getColor(R.color.btColorLikeRede93030));

                //推荐页面的时候设置状态栏透明
//                StatusBarUtil.setTranslucent(this);



                break;
            case 1:
                if (houseCollectFragment == null) {
                    houseCollectFragment = new FinancingFragment();
                    ft.add(R.id.main_content, houseCollectFragment);
                }
                ft.show(houseCollectFragment);
                ivTab2BottomActivityMain.setImageResource(R.mipmap.select2_img2x);
                tvTab2BottomActivityMain.setTextColor(getResources().getColor(R.color.btColorLikeRede93030));
//                StatusBarUtil.setColor(MainActivity.this, getResources().getColor(R.color.btColorLikeRede93030));
                break;

            case 2:
                if (richesFragment == null) {
                    richesFragment = new RichesFragment();
                    ft.add(R.id.main_content, richesFragment);
                }
                ft.show(richesFragment);
                ivTab3BottomActivityMain.setImageResource(R.mipmap.select3_img2x);
                tvTab3BottomActivityMain.setTextColor(getResources().getColor(R.color.btColorLikeRede93030));
//                StatusBarUtil.setColor(MainActivity.this, getResources().getColor(R.color.btColorLikeRede93030));
                break;
            case 3:
                if (moreFragment == null) {
                    moreFragment = new MoreFragment();
                    ft.add(R.id.main_content, moreFragment);
                }
                ft.show(moreFragment);
                ivTab4BottomActivityMain.setImageResource(R.mipmap.select4_img2x);
                tvTab4BottomActivityMain.setTextColor(getResources().getColor(R.color.btColorLikeRede93030));
//                StatusBarUtil.setColor(MainActivity.this, getResources().getColor(R.color.btColorLikeRede93030));
                break;

            default:
                throw new IllegalArgumentException("超出tab范围");
        }
        ft.commit();
    }

    /**
     * show之前隐藏所有被add进去的fragment对象
     *
     * @param ft
     */
    private void hide(FragmentTransaction ft) {
        if (recommendFragment != null) {
            ft.hide(recommendFragment);
        }
        if (houseCollectFragment != null) {
            ft.hide(houseCollectFragment);
        }
        if (richesFragment != null) {
            ft.hide(richesFragment);
        }
        if (moreFragment != null) {
            ft.hide(moreFragment);
        }
    }


    private void resetTabs() {
        ivTab1BottomActivityMain.setImageResource(R.mipmap.unselect1_img2x);
        ivTab2BottomActivityMain.setImageResource(R.mipmap.unselect2_img_2x);
        ivTab3BottomActivityMain.setImageResource(R.mipmap.unselect3_img2x);
        ivTab4BottomActivityMain.setImageResource(R.mipmap.unselect4_img2x);
        tvTab1BottomActivityMain.setTextColor(getResources().getColor(R.color.textColorGray555555));
        tvTab2BottomActivityMain.setTextColor(getResources().getColor(R.color.textColorGray555555));
        tvTab3BottomActivityMain.setTextColor(getResources().getColor(R.color.textColorGray555555));
        tvTab4BottomActivityMain.setTextColor(getResources().getColor(R.color.textColorGray555555));
    }


    long timeMillis = 2000;

    //连续点击两次退出应用
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - timeMillis) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出住家金融", Toast.LENGTH_SHORT).show();
                timeMillis = System.currentTimeMillis();
            } else {
                ActivityManager activityMgr = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
                activityMgr.restartPackage(getApplicationContext().getPackageName());
//                moveTaskToBack(false);
                System.exit(0);
                finish();

            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
