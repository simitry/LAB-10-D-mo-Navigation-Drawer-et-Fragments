package com.example.navigationdrawerlab10; // This line tells Android the package where this fragment belongs.

import android.os.Bundle; // This import gives access to the Bundle object used by fragments.
import android.view.LayoutInflater; // This import lets the fragment create its XML layout.
import android.view.View; // This import gives access to the View object returned by the fragment.
import android.view.ViewGroup; // This import gives access to the parent layout container.

import androidx.annotation.NonNull; // This import marks parameters that should not be null.
import androidx.annotation.Nullable; // This import marks values that may be null.
import androidx.fragment.app.Fragment; // This import lets this class behave as a Fragment.

public class BlankFragment2 extends Fragment { // This class represents Fragment 2.

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { // This method creates the fragment screen.
        return inflater.inflate(R.layout.fragment_blank2, container, false); // This line loads the XML layout for Fragment 2.
    }
}
