package com.mahesaiqbal.fragmentcommunication;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {


    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String yourName = getArguments().getString("your_name");
        int yourAge = getArguments().getInt("your_age");

        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvAge = view.findViewById(R.id.tv_age);

        tvName.setText(yourName);
        tvAge.setText(String.valueOf(yourAge));

        Button btnHome = view.findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHomeFragment();
            }
        });
    }

    private void goToHomeFragment() {
        FragmentManager mFragmentManager = getFragmentManager();
        if (mFragmentManager != null) {
            HomeFragment homeFragment = new HomeFragment();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, homeFragment, HomeFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
    }

}
