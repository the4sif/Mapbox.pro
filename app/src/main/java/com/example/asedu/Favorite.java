package com.example.asedu;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asedu.R;
import com.example.asedu.Universitysel;

public class Favorite extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Handle the back button press to navigate back to the previous activity
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
                // Handle the back press here
                goBackToPreviousActivity();
                return true;
            }
            return false;
        });
    }

    private void goBackToPreviousActivity() {
        // Create an Intent to navigate back to the desired previous activity
        Intent intent = new Intent(getActivity(), Universitysel.class);
        startActivity(intent);

        // Finish the current activity to remove it from the back stack (optional)
        if (getActivity() != null) {
            getActivity().finish();
        }
    }
}
