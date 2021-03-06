package com.example.spacefarming.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.spacefarming.R;
import com.example.spacefarming.entidades.Botijao;


public class InfoBotijao extends Fragment {
    private Botijao botijao;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InfoBotijao() {
        // Required empty public constructor
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
        View v = inflater.inflate(R.layout.frag_info_botijao, container, false);
        SeekBar sb_regua = v.findViewById(R.id.sb_regua);
        TextView tvIdBotijao = v.findViewById(R.id.tvIdBotijao);
        tvIdBotijao.setText(botijao.getId());
        sb_regua.setEnabled(false);
        sb_regua.setProgress((int) Math.round(botijao.getNivelAtual()));
        CardView cvRegua = v.findViewById(R.id.cvRegua);
        cvRegua.setOnClickListener(reguaOnClick());

        return v;
    }

    public void setBotijao(Botijao botijao) {
        this.botijao = botijao;
    }

    protected View.OnClickListener reguaOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ControleNivel controleNivel = new ControleNivel();
                controleNivel.setBotijao(botijao);
                ft.replace(R.id.main_frame2, controleNivel);
                ft.addToBackStack(null);
                ft.commit();
            }
        };
    }
}