package gr.athenstech.ms.sample;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import gr.athenstech.ms.R;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        Log.d("SampleActivity", "onCreate called!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SampleActivity", "onStart called!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SampleActivity", "onResume called!");
    }

    @Override
    protected void onPause() {
        Log.d("SampleActivity", "onPause called!");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("SampleActivity", "onStop called!");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("SampleActivity", "onDestroy called!");
        super.onDestroy();
    }
}