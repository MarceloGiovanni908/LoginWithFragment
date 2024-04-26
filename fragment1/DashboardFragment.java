package com.example.fragment1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DashboardFragment extends Fragment {

    private TextView textViewEmail;
    private TextView textViewPassword;

    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance(String userEmail, String userPassword) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString("user_email", userEmail);
        args.putString("user_password", userPassword);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        textViewEmail = view.findViewById(R.id.textViewEmail);
        textViewPassword = view.findViewById(R.id.textViewPassword);
        Bundle args = getArguments();
        if (args != null) {
            String userEmail = args.getString("user_email");
            String userPassword = args.getString("user_password");
            textViewEmail.setText(userEmail);
            textViewPassword.setText(userPassword);
        }
        return view;
    }
}
