package com.lsukev.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lsukev.herome.Activities.MainActivity;
import com.lsukev.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btnTurtlePower;
    private Button btnLightning;
    private Button btnFlight;
    private Button btnWebSlinging;
    private Button btnLaserVision;
    private Button btnSuperStrength;
    private Button btnBackStory;


    private PickPowerInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
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

        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);
        btnTurtlePower = (Button)view.findViewById(R.id.btnTurtlePower);
        btnLightning = (Button)view.findViewById(R.id.btnLightning);
        btnFlight = (Button)view.findViewById(R.id.btnFlight);
        btnWebSlinging = (Button)view.findViewById(R.id.btnWebSlinging);
        btnLaserVision = (Button)view.findViewById(R.id.btnLaserVision);
        btnSuperStrength = (Button)view.findViewById(R.id.btnSuperStrength);
        btnBackStory = (Button)view.findViewById(R.id.btnBackStory);

        btnTurtlePower.setOnClickListener(this);
        btnLightning.setOnClickListener(this);
        btnFlight.setOnClickListener(this);
        btnWebSlinging.setOnClickListener(this);
        btnLaserVision.setOnClickListener(this);
        btnSuperStrength.setOnClickListener(this);

        btnBackStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadHeroMeScreen();
            }
        });

        btnBackStory.setEnabled(false);
        btnBackStory.getBackground().setAlpha(128);


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v){
        btnBackStory.setEnabled(true);
        btnBackStory.getBackground().setAlpha(255);

        btnTurtlePower.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtlepower_icon,0,0,0);
        btnLightning.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thorshammer_icon,0,0,0);
        btnFlight.setCompoundDrawablesWithIntrinsicBounds(R.drawable.supermancrest_icon,0,0,0);
        btnWebSlinging.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spiderweb_icon,0,0,0);
        btnLaserVision.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laservision_icon,0,0,0);
        btnSuperStrength.setCompoundDrawablesWithIntrinsicBounds(R.drawable.superstrength_icon,0,0,0);

        Button btn = (Button)v;
        int leftDrawable = 0;

        if (btn == btnTurtlePower){
            leftDrawable = R.drawable.turtlepower_icon;
        } else if (btn == btnLightning){
            leftDrawable = R.drawable.thorshammer_icon;
        }else if (btn == btnFlight){
            leftDrawable = R.drawable.supermancrest_icon;
        }else if (btn == btnWebSlinging){
            leftDrawable = R.drawable.spiderweb_icon;
        }else if (btn == btnLaserVision){
            leftDrawable = R.drawable.laservision_icon;
        }else if (btn == btnSuperStrength){
            leftDrawable = R.drawable.superstrength_icon;
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.item_selected_btn,0);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowerFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowerInteractionListener {
        // TODO: Update argument type and name
        void onPickPowerFragmentInteraction(Uri uri);
    }
}
