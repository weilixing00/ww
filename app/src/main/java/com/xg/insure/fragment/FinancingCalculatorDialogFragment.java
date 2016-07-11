package com.xg.insure.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xg.insure.R;
import com.xg.insure.common.NoDoubleClickListener;
import com.xg.insure.mvp.Presenter.FinancingCalculatorDialogFragmentPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by server on 2016/6/24.
 */

public class FinancingCalculatorDialogFragment extends DialogFragment {

    @BindView(R.id.iv_dismiss_dialogfragment_financing_calculator)
    ImageView ivDismissDialogfragmentFinancingCalculator;
    @BindView(R.id.et_financing_amount_dialogfragment_financing_calculator)
    EditText etFinancingAmountDialogfragmentFinancingCalculator;
    @BindView(R.id.tv_expect_year_rate_dialogfragment_financing_calculator)
    TextView tvExpectYearRateDialogfragmentFinancingCalculator;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.tv_interest_type_dialogfragment_financing_calculator)
    TextView tvInterestTypeDialogfragmentFinancingCalculator;
    @BindView(R.id.tv_financing_deadtime_dialogfragment_financing_calculator)
    TextView tvFinancingDeadtimeDialogfragmentFinancingCalculator;
    @BindView(R.id.tv_total_capital_interest_dialogfragment_financing_calculator)
    TextView tvTotalCapitalInterestDialogfragmentFinancingCalculator;
    @BindView(R.id.tv_interest_income_dialogfragment_financing_calculator)
    TextView tvInterestIncomeDialogfragmentFinancingCalculator;
    @BindView(R.id.bt_calculator_dialogfragment_financing_calculator)
    Button btCalculatorDialogfragmentFinancingCalculator;
    private FinancingCalculatorDialogFragmentPresenter financingCalculatorDialogFragmentPresenter;

    public static FinancingCalculatorDialogFragment newInstance(Bundle bundle) {
        FinancingCalculatorDialogFragment financingCalculatorDialogFragment = new FinancingCalculatorDialogFragment();


        financingCalculatorDialogFragment.setArguments(bundle);
        return financingCalculatorDialogFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        View view = inflater.inflate(R.layout.dialogfragment_financing_calculator, container, false);
        //设置垂直居中
        WindowManager.LayoutParams mWindowAttributes = getDialog().getWindow().getAttributes();
        mWindowAttributes.gravity = Gravity.CLIP_VERTICAL;
        getDialog().getWindow().setAttributes(mWindowAttributes);
        ButterKnife.bind(this, view);

        initView();
        initData();

        financingCalculatorDialogFragmentPresenter = new FinancingCalculatorDialogFragmentPresenter(this);

        return view;
    }

    private void initView() {
        ivDismissDialogfragmentFinancingCalculator.setOnClickListener(noDoubleClick);
    }

    View.OnClickListener noDoubleClick=new NoDoubleClickListener() {
        @Override
        public void onNoDoubleClick(View v) {
            switch (v.getId()){
                case R.id.iv_dismiss_dialogfragment_financing_calculator:
                    dismiss();
                    break;
                case R.id.bt_calculator_dialogfragment_financing_calculator:
                    // TODO: 2016/6/30 计算  方法里面传入modle
                    financingCalculatorDialogFragmentPresenter.calculator();
                    break;
            }
        }
    };


    private void initData() {
        Bundle arguments = getArguments();

    }

}
