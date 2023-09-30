package com.fsp.ticket_resto_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.fsp.ticket_resto_app.controlleur.Controlleur;
import com.fsp.ticket_resto_app.ui.Accueil;
import com.fsp.ticket_resto_app.ui.Parametre;
import com.fsp.ticket_resto_app.ui.VPAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    /** Le controlleur de l'application */
    public Controlleur controlleur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        Accueil accueil = new Accueil();
        Parametre parametre = new Parametre();

        vpAdapter.addFragment(accueil, "Accueil");
        vpAdapter.addFragment(parametre, "Paramètre");

        viewPager.setAdapter(vpAdapter);

        controlleur = new Controlleur(accueil, parametre);
    }

    public Controlleur getControlleur() {
        return controlleur;
    }
}