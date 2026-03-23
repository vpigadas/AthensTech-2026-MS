package gr.athenstech.ms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import gr.athenstech.ms.databinding.ActivityLoginScreenBinding;

public class LoginScreen extends AppCompatActivity {

    private ActivityLoginScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        Button button = findViewById(R.id.login_btn_login);

        binding.loginBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("LoginScreen", "Login button clicked!");
                Log.w("LoginScreen", "Login button clicked!!");
                Log.e("LoginScreen", "Login button clicked!!!");
                Log.d("LoginScreen", "Login button clicked!!!!");
                Log.i("LoginScreen", "Login button clicked!!!!!");
                Log.wtf("LoginScreen", "Login button clicked!!!!!!");

                Snackbar.make(v, "Login button clicked!", Snackbar.LENGTH_SHORT).show();

                String username = String.valueOf(binding.loginEditEmailValue.getText());
                String password = String.valueOf(binding.loginEditPassValue.getText());

                Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                intent.putExtra("age", 30);
                //startActivity(intent);
                startActivityForResult(intent, 1000);
            }
        });

        binding.loginBtnLogin.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("LoginScreen", "Login button long clicked!");

                Snackbar.make(v, "Login button long clicked!", Snackbar.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("LoginScreen", "onActivityResult called with requestCode: " + requestCode + ", resultCode: " + resultCode);
    }
}