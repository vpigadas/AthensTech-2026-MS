package gr.athenstech.ms.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import gr.athenstech.ms.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    public SecondFragment() {
        // Required empty public constructor
    }

    public static String TAG = "SecondFragment";

    public static SecondFragment newInstance() {
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fragmentSecondBtnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity activity = getActivity();
                if (activity instanceof CustomFragmentActivity) {
                    CustomFragmentActivity customFragmentActivity = (CustomFragmentActivity) activity;
                    int value = Integer.parseInt(customFragmentActivity.liveData.getValue());
                    value -= 1;
                    customFragmentActivity.liveData.postValue(String.valueOf(value));
                }
            }
        });

        binding.fragmentSecondBtnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity activity = getActivity();
                if (activity instanceof CustomFragmentActivity) {
                    CustomFragmentActivity customFragmentActivity = (CustomFragmentActivity) activity;
                    int value = Integer.parseInt(customFragmentActivity.liveData.getValue());
                    value += 1;
                    customFragmentActivity.liveData.postValue(String.valueOf(value));
                }
            }
        });

    }
}