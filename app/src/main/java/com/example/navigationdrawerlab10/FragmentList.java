package com.example.navigationdrawerlab10; // This line tells Android the package where this fragment belongs.

import android.os.Bundle; // This import gives access to the Bundle object used by fragments.
import android.widget.ArrayAdapter; // This import lets us connect a String array to the ListFragment.

import androidx.annotation.Nullable; // This import marks values that may be null.
import androidx.fragment.app.ListFragment; // This import lets this class display a built-in list.

public class FragmentList extends ListFragment { // This class represents the fragment that displays a list.

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) { // This method runs when the ListFragment is created.
        super.onCreate(savedInstanceState); // This line lets Android do its normal fragment setup first.

        String[] items = { // This array stores the text that will appear in the list.
                "Item 1", // This line adds the first list item.
                "Item 2", // This line adds the second list item.
                "Item 3", // This line adds the third list item.
                "Item 4", // This line adds the fourth list item.
                "Item 5", // This line adds the fifth list item.
                "Item 6", // This line adds the sixth list item.
                "Item 7", // This line adds the seventh list item.
                "Item 8", // This line adds the eighth list item.
                "Item 9", // This line adds the ninth list item.
                "Item 10" // This line adds the tenth list item.
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>( // This adapter prepares the String array for display in the list.
                requireContext(), // This line gives the adapter the current fragment context.
                android.R.layout.simple_list_item_1, // This line uses Android's built-in single-text-row layout.
                items // This line gives the adapter the array of list items.
        );

        setListAdapter(adapter); // This line displays the adapter data inside the ListFragment.
    }
}
