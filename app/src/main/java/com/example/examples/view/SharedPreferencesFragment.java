package com.example.examples.view;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.examples.R;

public class SharedPreferencesFragment extends PreferenceFragment {

    public SharedPreferencesFragment() {
        // Required empty public constructor
    }

    public static SharedPreferencesFragment newInstance() {
        SharedPreferencesFragment fragment = new SharedPreferencesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.sharedpred);
    }

}
