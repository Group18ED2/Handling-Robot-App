package com.example.handlingrobot.ui.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.material.textfield.TextInputLayout;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Robot Name:");
    }

    public LiveData<String> getText() {
        return mText;
    }
}