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


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnAccount = view.findViewById(R.id.btn_account);
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAccountFragment();
            }
        });
    }

    private void goToAccountFragment() {
        AccountFragment accountFragment = new AccountFragment();

        Bundle mBundle = new Bundle();
        mBundle.putString("your_name", "Mahesa Iqbal");
        mBundle.putInt("your_age", 20);
        accountFragment.setArguments(mBundle);

        FragmentManager mFragmentManager = getFragmentManager();
        if (mFragmentManager != null) {
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, accountFragment, AccountFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
    }
}
