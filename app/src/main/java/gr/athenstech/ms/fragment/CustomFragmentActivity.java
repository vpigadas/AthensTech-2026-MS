package gr.athenstech.ms.fragment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;

import gr.athenstech.ms.R;
import gr.athenstech.ms.databinding.ActivityCustomFragmentBinding;

public class CustomFragmentActivity extends AppCompatActivity {


    private ActivityCustomFragmentBinding binding;
    public MutableLiveData<String> liveData = new MutableLiveData<>("100");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //transaction.add(binding.fragmentContainer.getId(), BlankFragment.newInstance());
        transaction.replace(binding.fragmentContainerOne.getId(), BlankFragment.newInstance("I am the first half"), BlankFragment.TAG);
//        transaction.replace(binding.fragmentContainerTwo.getId(), BlankFragment.newInstance("I am the last half"), BlankFragment.TAG);
        //transaction.remove(binding.fragmentContainer.getId(), BlankFragment.newInstance());
        transaction.commit();

        FragmentTransaction transaction1= manager.beginTransaction();
        //transaction.add(binding.fragmentContainer.getId(), BlankFragment.newInstance());
        transaction1.replace(binding.fragmentContainerTwo.getId(), SecondFragment.newInstance(), SecondFragment.TAG);
        //transaction.remove(binding.fragmentContainer.getId(), BlankFragment.newInstance());
//        transaction1.addToBackStack(null);
        transaction1.commit();
    }
}