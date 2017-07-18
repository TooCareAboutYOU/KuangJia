package com.cnlive.meplusd.kuangjia_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    View parent;
    @Bind(R.id.btn_test1)
    Button mBtnTest1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parent = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, parent);
        mBtnTest1.setOnClickListener(this);

        return parent;
    }

    @Override
    public void onClick(View view) {
        MainActivity main = (MainActivity) getActivity();
        main.ToastInfo("碎片一");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
