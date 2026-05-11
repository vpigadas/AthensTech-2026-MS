package gr.athenstech.ms.viewmodel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import gr.athenstech.ms.databinding.ActivityCustomViewModelBinding;

public class CustomViewModelActivity extends AppCompatActivity {

    private ActivityCustomViewModelBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomViewModelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(binding.fragmentContainerOne.getId(), FirstFragment.newInstance(), "FirstFragment");
        transaction.commit();

        FragmentTransaction transaction1 = manager.beginTransaction();
        transaction1.replace(binding.fragmentContainerTwo.getId(), SecondFragment.newInstance(), "SecondFragment");
        transaction1.commit();
    }
}