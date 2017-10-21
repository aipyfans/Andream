package com.dream.william.component.activity.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dream.william.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment3 extends Fragment {

    private static final String TAG = Fragment3.class.getSimpleName();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;


    public Fragment3() {
        // Required empty public constructor
    }


    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        Log.w(TAG, "[onAttach] Begin");
        super.onAttach(context);
        Log.w(TAG, "[onAttach] End");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.w(TAG, "[onCreate] Begin");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.w(TAG, "[onCreate] End");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.w(TAG, "[onViewCreated] Begin");
        super.onViewCreated(view, savedInstanceState);
        Log.w(TAG, "[onViewCreated] End");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.w(TAG, "[onActivityCreated] Begin");
        super.onActivityCreated(savedInstanceState);
        Log.w(TAG, "[onActivityCreated] End");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.w(TAG, "[onCreateView]");

        View view = inflater.inflate(R.layout.fragment_third, container, false);
        TextView tvPopFirst = (TextView) view.findViewById(R.id.tv_pop_first);
        tvPopFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack(Fragment1.class.getSimpleName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        Log.w(TAG, "[onStart] Begin");
        super.onStart();
        Log.w(TAG, "[onStart] End");
    }

    @Override
    public void onResume() {
        Log.w(TAG, "[onResume] Begin");
        super.onResume();
        Log.w(TAG, "[onResume] End");
    }

    @Override
    public void onPause() {
        Log.w(TAG, "[onPause] Begin");
        super.onPause();
        Log.w(TAG, "[onPause] End");
    }

    @Override
    public void onStop() {
        Log.w(TAG, "[onStop] Begin");
        super.onStop();
        Log.w(TAG, "[onStop] End");
    }

    @Override
    public void onDestroyView() {
        Log.w(TAG, "[onDestroyView] Begin");
        super.onDestroyView();
        Log.w(TAG, "[onDestroyView] End");
    }

    @Override
    public void onDestroy() {
        Log.w(TAG, "[onDestroy] Begin");
        super.onDestroy();
        Log.w(TAG, "[onDestroy] End");
    }

    @Override
    public void onDetach() {
        Log.w(TAG, "[onDetach] Begin");
        super.onDetach();
        Log.w(TAG, "[onDetach] End");
    }

}
