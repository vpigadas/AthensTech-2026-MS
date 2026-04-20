package gr.athenstech.ms.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import gr.athenstech.ms.databinding.HolderPetSampleBinding;
import gr.athenstech.ms.network.Pet;

public class PetRecyclerViewHolder extends RecyclerView.ViewHolder {

    private HolderPetSampleBinding binding;

    public PetRecyclerViewHolder(@NonNull HolderPetSampleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Pet pet) {
        binding.holderText.setText(pet.getName());
    }
}
