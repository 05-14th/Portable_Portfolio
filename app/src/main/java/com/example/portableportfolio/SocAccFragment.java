package com.example.portableportfolio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SocAccFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SocAccFragment extends Fragment implements SocAccFragment_ {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Intent fb_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/gerryvien.flores.1"));
    Intent insta_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/itsgerrykun/"));
    Intent git_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/05-14th"));

    public SocAccFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SocAccFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SocAccFragment newInstance(String param1, String param2) {
        SocAccFragment fragment = new SocAccFragment();
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
        View viewRoot = inflater.inflate(R.layout.fragment_soc_acc, container, false);
        ImageButton back_button = (ImageButton) viewRoot.findViewById(R.id.backButton);
        Button facebook_button = (Button) viewRoot.findViewById(R.id.facebook);
        Button instagram_button = (Button) viewRoot.findViewById(R.id.instagram);
        Button github_button = (Button) viewRoot.findViewById(R.id.github);

        back_button.setOnClickListener(this::onClick);
        facebook_button.setOnClickListener(this::onClick);
        instagram_button.setOnClickListener(this::onClick);
        github_button.setOnClickListener(this::onClick);

        return viewRoot;
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        if (view.getId() == R.id.backButton) {
            fragment = new MainFragment();
            replaceFragment(fragment);
        } else if(view.getId() == R.id.facebook){
            if (fb_intent.resolveActivity(getContext().getPackageManager()) != null) {
                startActivity(fb_intent);
            } else {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/gerryvien.flores.1"));
                startActivity(webIntent);
            }
        } else if(view.getId() == R.id.instagram){
            if (insta_intent.resolveActivity(getContext().getPackageManager()) != null) {
                startActivity(insta_intent);
            } else {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/itsgerrykun/"));
                startActivity(webIntent);
            }
        } else if(view.getId() == R.id.github){
            if (git_intent.resolveActivity(getContext().getPackageManager()) != null) {
                startActivity(git_intent);
            } else {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/05-14th"));
                startActivity(webIntent);
            }
        }
    }

    private void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}