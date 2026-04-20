package gr.athenstech.ms.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.athenstech.ms.databinding.HolderPetSampleBinding;
import gr.athenstech.ms.databinding.HolderPetSampleV2Binding;
import gr.athenstech.ms.network.Pet;

public class PetAdapterV2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Pet> dataList;

    public PetAdapterV2(List<Pet> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            HolderPetSampleBinding binding = HolderPetSampleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_pet_sample, parent,false);
            return new PetRecyclerViewHolder(binding);
        } else {
            HolderPetSampleV2Binding binding = HolderPetSampleV2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_pet_sample, parent,false);
            return new PetRecyclerViewHolderV2(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PetRecyclerViewHolder) {
            PetRecyclerViewHolder sample = (PetRecyclerViewHolder) holder;

            sample.bind(dataList.get(position));
        } else if (holder instanceof PetRecyclerViewHolderV2) {
            PetRecyclerViewHolderV2 sample = (PetRecyclerViewHolderV2) holder;

            sample.bind(dataList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 4 == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
