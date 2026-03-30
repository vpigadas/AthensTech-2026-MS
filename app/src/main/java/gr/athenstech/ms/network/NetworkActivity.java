package gr.athenstech.ms.network;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import gr.athenstech.ms.databinding.ActivityNetworkBinding;

public class NetworkActivity extends AppCompatActivity {

    private ActivityNetworkBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNetworkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //performNetworkOperation(0);
    }

    @Override
    protected void onResume() {
        super.onResume();

        performNetworkOperation(0);
    }

    private void performNetworkOperation(int round) {
        binding.progressBar.setVisibility(View.VISIBLE);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Pet[] jsonElement = new Gson().fromJson(response, Pet[].class);

                        binding.networkMessage.setText("Response is: " + response.substring(0, 500));
                        binding.progressBar.setVisibility(View.GONE);

                        //performNetworkOperation(round + 1);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                binding.networkMessage.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);


        binding.networkMessage.setText("Performing network operation... (" + String.valueOf(round) + ")");
    }
}