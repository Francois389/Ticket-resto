package com.fsp.ticket_resto_app.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.fsp.ticket_resto_app.databinding.FragmentParametreBinding;

public class Parametre extends Fragment {

    FragmentParametreBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentParametreBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}