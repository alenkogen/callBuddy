package com.example.callbuddy;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class change_call_number extends Fragment {
    TextView phoneNum;
    TextView message;
    Button btnNumber;
    Button btnMessage;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View v= inflater.inflate(R.layout.fragment_change_call_number, container, false);
        phoneNum=v.findViewById(R.id.editPhone);
        message=v.findViewById(R.id.editMessage);
        btnMessage=v.findViewById(R.id.BtnMessage);
        btnNumber=v.findViewById(R.id.BtnMum);
        MainActivity mainActivity=(MainActivity) getActivity();
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.setText(message.getText().toString());
                mainActivity.setNum(phoneNum.getText().toString());
                mainActivity.smser2.setClickable(true);
                mainActivity.smser2.setTextColor(Color.rgb(255,255,255));
                mainActivity.smser2.setBackgroundColor(Color.rgb(87,59,214));
            }
        });
        btnNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.setNum(phoneNum.getText().toString());
                mainActivity.smser2.setClickable(true);
                mainActivity.smser2.setTextColor(Color.rgb(255,255,255));
                mainActivity.smser2.setBackgroundColor(Color.rgb(87,59,214));
            }
        });



        return v;
    }
}