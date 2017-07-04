package com.example.goodbyeda.tabhost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab1Input.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab1Input#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab1Input extends Fragment implements View.OnClickListener, TextWatcher {

    private EditText dgCode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab1_input, container, false);

        Button pickColor = (Button) v.findViewById(R.id.tab1_input_pick_color_btn);
        pickColor.setOnClickListener(this);

        Button submit = (Button) v.findViewById(R.id.tab1_input_submit_btn);
        submit.setOnClickListener(this);

        dgCode = (EditText) v.findViewById(R.id.tab1_input_digit_input);
        dgCode.addTextChangedListener((TextWatcher) this);

        return v;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        String digit = dgCode.getText().toString();
        boolean rst = java.util.regex.Pattern.matches("\\d+", digit);

        if (rst && digit.length() == 4) {
            System.out.println("match digit");
        }
    }

    @Override
    public void onClick(View v) {
        Tab1 tab = (Tab1) getActivity();
        switch (v.getId()) {
            case R.id.tab1_input_pick_color_btn:
                tab.showFgmt(Tab1.FragOrder.Picker.ordinal());
                break;

            case R.id.tab1_input_submit_btn:
                tab.showFgmt(Tab1.FragOrder.List.ordinal());
                break;

            default:
                break;
        }
    }
}
