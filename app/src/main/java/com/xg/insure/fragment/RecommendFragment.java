package com.xg.insure.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.xg.insure.R;
import com.xg.insure.base.BaseFragment;
import com.xg.insure.bean.RecommendResponse;
import com.xg.insure.mvp.Presenter.RecommendPresenter;
import com.xg.insure.mvp.view.IRecommendView;
import com.xg.insure.net.retrofit.MyRetrofit;
import com.xg.insure.net.service.RequestService;
import com.xg.insure.net.service.TestResponse;
import com.xg.insure.ui.AutoRollLayout;
import com.xg.insure.ui.WaveHelper;
import com.xg.insure.ui.WaveView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by admin on 2016/6/7.
 */
public class RecommendFragment extends BaseFragment implements IRecommendView{


    @BindView(R.id.banner_fragment_bottom_tab1)
    AutoRollLayout bannerFragmentBottomTab1;
    @BindView(R.id.iv_affiche_fragment_bottom_tab1)
    ImageView ivAfficheFragmentBottomTab1;

    @BindView(R.id.waveview_fragment_bottom_tab1)
    WaveView waveviewFragmentBottomTab1;
    @BindView(R.id.textView2)
    TextView textView2;
    private WaveHelper waveHelper;
    private ArrayList<Integer> localImages = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1_bottom, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;

    }


    private void initView() {
        RecommendPresenter recommendPresenter=new RecommendPresenter(this);
        recommendPresenter.loadData();

        initWaveView();
        initBanner();



    }

    private void initWaveView() {
        //设置边框颜色和宽度
        waveviewFragmentBottomTab1.setBorder(10, Color.parseColor("#44FFFFFF"));
        waveHelper = new WaveHelper(waveviewFragmentBottomTab1, 0.9f);
        //设置波浪颜色 post 传值是解决一个宽高必须大于0的bug
        waveviewFragmentBottomTab1.post(new Runnable() {
            @Override
            public void run() {
                waveviewFragmentBottomTab1.setWaveColor(Color.parseColor("#ffefd0"),
                        Color.parseColor("#ffefd0"));
            }
        });

        //设置形状
        waveviewFragmentBottomTab1.setShapeType(WaveView.ShapeType.CIRCLE);
        waveviewFragmentBottomTab1.setBorder(10, Color.parseColor("#FFAE00"));
    }

    private void initBanner() {
        localImages.clear();
        localImages.add(R.mipmap.banner_img2x);
        localImages.add(R.mipmap.banner_img2x);
        localImages.add(R.mipmap.banner_img2x);
        localImages.add(R.mipmap.banner_img2x);

        List<AutoRollLayout.RollItem> items=new ArrayList<>();
        items.add(new AutoRollLayout.RollItem(null,R.mipmap.banner_img2x));
        items.add(new AutoRollLayout.RollItem(null,R.mipmap.banner_img2x));
        items.add(new AutoRollLayout.RollItem(null,R.mipmap.banner_img2x));
        items.add(new AutoRollLayout.RollItem(null,R.mipmap.banner_img2x));
        bannerFragmentBottomTab1.setItems(items);
        bannerFragmentBottomTab1.setAutoRoll(true);

    }

    @Override
    public void onPause() {
        super.onPause();

        waveHelper.cancel();
    }

    @Override
    public void onResume() {
        super.onStart();

        waveHelper.start();
    }

    // TODO: 2016/7/12 显示网络请求获取成功的数据
    @Override
    public void showData(RecommendResponse recommendResponse) {

    }

    @Override
    public void showError() {

    }

    private class LocalImageHolderView implements Holder<Integer> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, final int position, Integer data) {
            imageView.setImageResource(data);
        }
    }
}
