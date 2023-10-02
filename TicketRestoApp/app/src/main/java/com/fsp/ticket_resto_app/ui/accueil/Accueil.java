package com.fsp.ticket_resto_app.ui.accueil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.fsp.ticket_resto_app.databinding.FragmentAccueilBinding;
import com.fsp.ticket_resto_app.injection.ViewModelFactory;

public class Accueil extends Fragment {

    private FragmentAccueilBinding binding;

    private AccueilViewModel accueilViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAccueilBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this, ViewModelFactory.getInstance()).get(AccueilViewModel.class);
    }


}