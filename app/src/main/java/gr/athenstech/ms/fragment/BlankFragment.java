package gr.athenstech.ms.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;

import gr.athenstech.ms.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {

    private FragmentBlankBinding binding;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static String TAG = "BlankFragment";

    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }

    public static BlankFragment newInstance(String title) {
        BlankFragment fragment = new BlankFragment();
        Bundle parameters = new Bundle();
        parameters.putString("title", title);
        fragment.setArguments(parameters);
        return fragment;
    }

    public static BlankFragment newInstance(int age) {
        BlankFragment fragment = new BlankFragment();
        Bundle parameters = new Bundle();
        parameters.putInt("age", age);
        fragment.setArguments(parameters);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String title = "This is a blank fragment";
        if (getArguments() != null) {
            title = getArguments().getString("title", "Return default value");
        }

        binding.fragmentBlankTxt.setText(title);

        FragmentActivity activity = getActivity();
        if (activity instanceof CustomFragmentActivity) {
            ((CustomFragmentActivity) activity).liveData.observe(getViewLifecycleOwner(), new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    binding.fragmentBlankTxt.setText(s);
                }
            });
        }
    }
}