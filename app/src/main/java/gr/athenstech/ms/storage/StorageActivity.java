package gr.athenstech.ms.storage;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import gr.athenstech.ms.databinding.ActivityStorageBinding;

public class StorageActivity extends AppCompatActivity {

    private ActivityStorageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences sharedPreferences = getSharedPreferences("user_data",MODE_PRIVATE);

        sharedPreferences.edit().putString("username","john_doe").apply();
        sharedPreferences.edit().putString("username","john_doe").commit();
    }
}