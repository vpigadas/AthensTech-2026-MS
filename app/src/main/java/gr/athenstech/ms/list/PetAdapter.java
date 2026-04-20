package gr.athenstech.ms.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.athenstech.ms.R;
import gr.athenstech.ms.databinding.HolderPetSampleBinding;
import gr.athenstech.ms.network.Pet;

public class PetAdapter extends RecyclerView.Adapter<PetRecyclerViewHolder> {

    private List<Pet> dataList;

    public PetAdapter(List<Pet> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public PetRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HolderPetSampleBinding binding = HolderPetSampleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_pet_sample, parent,false);
        return new PetRecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PetRecyclerViewHolder holder, int position) {
        holder.bind(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
