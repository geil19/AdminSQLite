package com.aplica.andres.adminsqlite;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Frag_Historial.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Frag_Historial#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag_Historial extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },4000);
        return inflater.inflate(R.layout.fragment_frag__historial, container, false);
    }
}
