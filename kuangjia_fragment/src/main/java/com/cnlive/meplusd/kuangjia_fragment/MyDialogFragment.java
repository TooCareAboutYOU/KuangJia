package com.cnlive.meplusd.kuangjia_fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.ButterKnife;

/**
 * Created by zhangshuai on 2017-01-20.
 */

public class MyDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    public static MyDialogFragment newInstance(String str){
        MyDialogFragment fd=new MyDialogFragment();
        Bundle budle=new Bundle();
        budle.putString("hehe",str);
        fd.setArguments(budle);
        return fd;
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this.setCancelable(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_dialog, null);
        Button mBtnDismiss = (Button) view.findViewById(R.id.btn_dismiss);
        Bundle b=getArguments();
        mBtnDismiss.setText(b.getString("hehe"));

        mBtnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dismiss();   //关闭对话框，并触发onDismiss()回调函数。
            }
        });

        builder.setView(view)   //自定义布局
                .setMessage("MyDialogFragment")
                .setPositiveButton("OK", this)
                .setNegativeButton("CANCEL", this);
        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int pid) {
        MainActivity main = (MainActivity) getActivity();
        switch (pid) {
            case AlertDialog.BUTTON_NEGATIVE:
                main.refresh("取消");
                dismiss();
                break;
            case AlertDialog.BUTTON_POSITIVE:
                main.refresh("确认");
                dismiss();
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
