package com.hackathon.macroeconomicsfoodsecurityanalysis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;


public class macro extends Fragment implements View.OnClickListener {

    String[] countries = { "India","China","USA"};

    private String fromYear="1960";
    private String toYear="2020";

    private String country = "India";
    private String gdp = "No";
    private String fdiinflows ="No";
    private String fdioutflows = "No";
    private String ieflow = "No";

    Button showMacroData;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    public macro() {
        // Required empty public constructor
    }


    public static macro newInstance(String param1, String param2) {
        macro fragment = new macro();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_macro, container, false);
        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner_country);

        ArrayAdapter ad = new ArrayAdapter(
                getContext(),
                android.R.layout.simple_spinner_item,
                countries);

        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        spinner.setAdapter(ad);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                switch (position) {
                    case 1:
                        Log.d("Macro","China");
                        country = "China";
                        break;
                    case 0:
                        Log.d("Macro","India");
                        country = "India";
                        break;
                    case 2:
                        Log.d("Macro","USA");
                        country = "USA";
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub

            }
        });

        CheckBox c_gdp = (CheckBox) rootView.findViewById(R.id.GDP);
        c_gdp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    gdp = "Yes";
                } else {
                    gdp = "No";
                }
            }
        });

        CheckBox c_in_flow = (CheckBox) rootView.findViewById(R.id.FDI_inflows);
        c_in_flow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fdiinflows = "Yes";
                } else {
                    fdiinflows = "No";
                }
            }
        });

        CheckBox c_out_flow = (CheckBox) rootView.findViewById(R.id.FDI_Outflows);
        c_out_flow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fdioutflows = "Yes";
                } else {
                    fdioutflows = "No";
                }
            }
        });

        CheckBox c_ie_flow = (CheckBox) rootView.findViewById(R.id.IE_Flows);
        c_ie_flow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ieflow = "Yes";
                } else {
                    ieflow = "No";
                }
            }
        });

        showMacroData = (Button) rootView.findViewById(R.id.macroShow);
        showMacroData.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        // implements your things

        Intent intent = new Intent(getActivity(), MacroResult.class);

        intent.putExtra("country", country);
        intent.putExtra("fromYear", fromYear);
        intent.putExtra("toYear", toYear);
        intent.putExtra("gdp", gdp);
        intent.putExtra("fdiinflow", fdiinflows);
        intent.putExtra("fdioutflow", fdioutflows);
        intent.putExtra("ieFlow", ieflow);

        startActivity(intent);
        ((Activity) getActivity()).overridePendingTransition(0, 0);

    }


}