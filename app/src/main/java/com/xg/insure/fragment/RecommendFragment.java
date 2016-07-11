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
import com.xg.insure.net.retrofit.MyRetrofit;
import com.xg.insure.net.service.RequestService;
import com.xg.insure.net.service.TestResponse;
import com.xg.insure.ui.WaveHelper;
import com.xg.insure.ui.WaveView;

import java.util.ArrayList;
import java.util.HashMap;
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
public class RecommendFragment extends BaseFragment {


    @BindView(R.id.banner_fragment_bottom_tab1)
    ConvenientBanner bannerFragmentBottomTab1;
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
        initWaveView();
        initBanner();

        Retrofit retrofit = MyRetrofit.retrofit();

        RequestService requestService = retrofit.create(RequestService.class);

        Map<String, String> map=new HashMap<>();
        map.put("pageIndex","1");
        map.put("pageSize","5");
        Call<TestResponse> test = requestService.test(map);
        test.enqueue(new Callback<TestResponse>() {
            @Override
            public void onResponse(Call<TestResponse> call, Response<TestResponse> response) {
                TestResponse body = response.body();
                Toast.makeText(getContext(), "body"+body.count, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<TestResponse> call, Throwable t) {

            }
        });

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

        bannerFragmentBottomTab1.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, localImages)
                .setPointViewVisible(true)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL).setCanLoop(true);
        //设置翻页的效果，不需要翻页效果可用不设
        //.setPageTransformer(Transformer.DefaultTransformer);    集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
//        convenientBanner.setManualPageable(false);//设置不能手动影响
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
