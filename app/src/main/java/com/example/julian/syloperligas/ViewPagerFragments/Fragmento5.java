package com.example.julian.syloperligas.ViewPagerFragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.julian.syloperligas.ActividadesClubes.Club1;
import com.example.julian.syloperligas.ActividadesClubes.Club2;
import com.example.julian.syloperligas.ActividadesClubes.Club3;
import com.example.julian.syloperligas.ActividadesClubes.Club4;
import com.example.julian.syloperligas.ActividadesClubes.Club5;
import com.example.julian.syloperligas.ActividadesClubes.Club6;
import com.example.julian.syloperligas.AnimationUtils;
import com.example.julian.syloperligas.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragmento5.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragmento5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento5 extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragmento5() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmento5.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmento5 newInstance(String param1, String param2) {
        Fragmento5 fragment = new Fragmento5();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento5, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //***Aca Tengo Asignados Los 6 ImageButton de los equipos cargados hasta el momento***

        ImageView germany = view.findViewById(R.id.germany);
        ImageView barcelona = view.findViewById(R.id.brc);
        ImageView city = view.findViewById(R.id.city);
        ImageView brazil = view.findViewById(R.id.br);
        ImageView psg = view.findViewById(R.id.psg);
        ImageView manchester = view.findViewById(R.id.united);

        AnimationUtils.enterTop(germany, 1000);
        AnimationUtils.landMe(germany, 1500);
        AnimationUtils.landMeX(germany, 2000);
        AnimationUtils.landMeY(germany, 2500);

        AnimationUtils.enterTop(barcelona, 1000);
        AnimationUtils.landMe(barcelona, 1500);
        AnimationUtils.landMeX(barcelona, 2000);
        AnimationUtils.landMeY(barcelona, 2500);

        AnimationUtils.enterTop(city, 1000);
        AnimationUtils.landMe(city, 1500);
        AnimationUtils.landMeX(city, 2000);
        AnimationUtils.landMeY(city, 2500);

        AnimationUtils.enterTop(brazil, 1000);
        AnimationUtils.landMe(brazil, 1500);
        AnimationUtils.landMeX(brazil, 2000);
        AnimationUtils.landMeY(brazil, 2500);

        AnimationUtils.enterTop(psg, 1000);
        AnimationUtils.landMe(psg, 1500);
        AnimationUtils.landMeX(psg, 2000);
        AnimationUtils.landMeY(psg, 2500);

        AnimationUtils.enterTop(manchester, 1000);
        AnimationUtils.landMe(manchester, 1500);
        AnimationUtils.landMeX(manchester, 2000);
        AnimationUtils.landMeY(manchester, 2500);


        germany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Club1.class);
                startActivity(i);
            }
        });

        barcelona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Club2.class);
                startActivity(i);
            }
        });

        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Club3.class);
                startActivity(i);
            }
        });

        brazil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Club4.class);
                startActivity(i);
            }

        });

        psg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Club5.class);
                startActivity(i);
            }
        });

        manchester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Club6.class);
                startActivity(i);
            }
        });

    }
    //***Aca Termina El onViewCreated (Para declarar algun objeto, hacerlo aca)***


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
