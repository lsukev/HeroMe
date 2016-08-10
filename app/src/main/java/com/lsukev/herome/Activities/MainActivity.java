package com.lsukev.herome.Activities;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;

import com.lsukev.herome.Fragments.HeroMeFragment;
import com.lsukev.herome.Fragments.MainFragment;
import com.lsukev.herome.Fragments.PickPowerFragment;
import com.lsukev.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListener, HeroMeFragment.HeroMeFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new MainFragment();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.fragment_container, fragment);
            transaction.commit();
        }

    }

    public void loadPickPowerScreen() {

        PickPowerFragment pickPowerFragment = new PickPowerFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();

    }

    public void loadHeroMeScreen(){

        HeroMeFragment heroMeFragment = new HeroMeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, heroMeFragment).addToBackStack(null).commit();

    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickPowerFragmentInteraction(Uri uri) {

    }

    @Override
    public void onHeroMeFragmentInteraction(Uri uri) {

    }
}
