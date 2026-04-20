package gr.athenstech.ms.list;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import gr.athenstech.ms.databinding.ActivityRecyclerViewBinding;
import gr.athenstech.ms.network.Pet;

public class RecyclerViewActivity extends AppCompatActivity {

    private ActivityRecyclerViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //binding.recyclerView.setAdapter(new PetAdapter(getSampleData()));
        performNetworkOperation();
    }

    private List<Pet> getSampleData() {
        List<Pet> dataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dataList.add(new Pet());
        }
        return dataList;
    }

    private void performNetworkOperation() {
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

                        binding.recyclerView.setAdapter(new PetAdapterV2(List.of(jsonElement)));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}