package com.example.fragment1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment implements View.OnClickListener {

    public LoginFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Button btnLogin = view.findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(this);
        return view;
    }

    private boolean isLoginValid(String email, String password) {
        // Implementasikan logika untuk memeriksa apakah data yang dimasukkan sesuai dengan data yang terdaftar di register
        // Return true jika login valid, false jika tidak
        return email.equals("saya@gmail.com") && password.equals("heydar");
    }

    private boolean isLoginNotValid() {
        // Implementasikan logika untuk memeriksa apakah data yang dimasukkan sesuai dengan data yang terdaftar di register
        // Return true jika login valid, false jika tidak
        return false;
    }

    private void navigateToDashboardFragment(String userEmail, String userPassword) {
        DashboardFragment dashboardFragment = DashboardFragment.newInstance(userEmail, userPassword);
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container1, dashboardFragment, DashboardFragment.class.getSimpleName());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void showErrorDialog() {
        // Tampilkan pesan kesalahan kepada pengguna
        // Misalnya dengan menampilkan Toast
        Toast.makeText(getContext(), "Data tidak valid", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonLogin) {
            // Dapatkan email dan password yang dimasukkan oleh pengguna
            EditText editTextEmail = getView().findViewById(R.id.editTextEmail);
            EditText editTextPassword = getView().findViewById(R.id.editTextPassword);
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();

            // Cek validitas login
            if (isLoginValid(email, password)) {
                // Jika login valid, lanjutkan ke dashboard
                navigateToDashboardFragment(email, password);
            } else {
                // Jika login tidak valid, tampilkan pesan kesalahan
                showErrorDialog();
            }
        }
    }
}