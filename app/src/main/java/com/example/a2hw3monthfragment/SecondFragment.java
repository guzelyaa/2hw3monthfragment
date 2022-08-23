package com.example.a2hw3monthfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SecondFragment extends Fragment {

    private Button btn2;
    private EditText et2;
    public static final String KEY2_FOR_BUNDLE = "key1.bundle";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et2 = view.findViewById(R.id.et2);
        if (getArguments() != null){
            et2.setText(getArguments().getString(FirstFragment.KEY1_FOR_BUNDLE));
        }

        btn2 = view.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle1 = new Bundle();
                bundle1.putString(KEY2_FOR_BUNDLE, et2.getText().toString());
                ThirdFragment thirdFragment = new ThirdFragment();
                thirdFragment.setArguments(bundle1);
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.f1, thirdFragment). addToBackStack(null).commit();
            }
        });
    }
}