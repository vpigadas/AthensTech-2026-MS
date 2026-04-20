package gr.athenstech.ms.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import gr.athenstech.ms.databinding.HolderPetSampleBinding;
import gr.athenstech.ms.databinding.HolderPetSampleV2Binding;
import gr.athenstech.ms.network.Pet;

public class PetRecyclerViewHolderV2 extends RecyclerView.ViewHolder {

    private HolderPetSampleV2Binding binding;

    public PetRecyclerViewHolderV2(@NonNull HolderPetSampleV2Binding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Pet pet) {
        binding.holderText.setText(pet.getName());
    }
}
