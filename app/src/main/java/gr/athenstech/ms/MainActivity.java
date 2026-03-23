package gr.athenstech.ms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import gr.athenstech.ms.databinding.ActivityMainBinding;
import gr.athenstech.ms.network.NetworkActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent().getExtras() != null) {
            String username = getIntent().getExtras().getString("username");
            String password = getIntent().getExtras().getString("password");
            int age = getIntent().getExtras().getInt("age");

            Log.d("MainActivity", "Received username: " + username);
            Log.d("MainActivity", "Received password: " + password);
            Log.d("MainActivity", "Received age: " + age);
        }

        binding.mainBtnNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NetworkActivity.class);
                startActivity(intent);
            }
        });

        binding.mainBtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Close button clicked!");

                Intent intent = new Intent();
                intent.putExtra("result", "This is the result from MainActivity");

                setResult(3000, intent);
                finish();
            }
        });
    }
}