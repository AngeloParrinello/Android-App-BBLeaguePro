package com.example.bbleaguepro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Utilities {

    static void insertFragment(AppCompatActivity activity, Fragment fragment, String tag){

        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container_view, fragment, tag);

        //con addToBackStack, aggiungo la transizione al backstack e quindi se prendo il tasto
        //back, <,  non torna indietro in un'altra activity quindi schermata ma torna indietro
        // sulla vecchia visualizzazione
        transaction.addToBackStack(null);

        transaction.commit();

    }

    static void insertFragmentWithoutBackStack(AppCompatActivity activity, Fragment fragment, String tag){

        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container_view, fragment, tag);

        transaction.commit();

    }

}
