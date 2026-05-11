package gr.athenstech.ms.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CustomViewModel extends ViewModel {


    private MutableLiveData<Integer> _numberLiveData = new MutableLiveData<>(0);
    LiveData<Integer> numberLiveData = _numberLiveData;

    void increaseNumber() {
        int number = _numberLiveData.getValue() == null ? 0 : _numberLiveData.getValue();
        number++;
        _numberLiveData.setValue(number);
    }

    void decreaseNumber() {
        int number = _numberLiveData.getValue() == null ? 0 : _numberLiveData.getValue();
        number--;
        _numberLiveData.setValue(number);
    }
}