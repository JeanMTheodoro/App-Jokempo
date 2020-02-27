package com.example.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView title, tiltleUser, score, machine, machineScore, user, userScore;
    ImageView imageSorteio, imagePedra, imagePapel, imageTesoura;
    Button bntReset;
    String optionSelected;
    boolean actived = false;
    int scoreMachine = 0;
    int scoreUser = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        tiltleUser = findViewById(R.id.tilte_user);
        score = findViewById(R.id.score);
        machine = findViewById(R.id.machine);
        machineScore = findViewById(R.id.machine_score);
        user = findViewById(R.id.user);
        userScore =findViewById(R.id.user_score);
        imageSorteio = findViewById(R.id.imagem_sorteio);
        imagePedra = findViewById(R.id.imagem_pedra);
        imagePapel = findViewById(R.id.imagem_papel);
        imageTesoura = findViewById(R.id.imagem_tesoura);
        bntReset= findViewById(R.id.bntReset);




        bntReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!actived){


                    start();

                }else{

                    end();

                }


            }
        });


    }

    private void end() {

        bntReset.setText(R.string.name_bnt_Reset);
        bntReset.setBackgroundResource(R.color.colorAccent);
        score.setVisibility(View.INVISIBLE);
        machine.setVisibility(View.INVISIBLE);
        machineScore.setVisibility(View.INVISIBLE);
        user.setVisibility(View.INVISIBLE);
        userScore.setVisibility(View.INVISIBLE);
        tiltleUser.setText(R.string.informatioUser);

        actived = false;

    }

    private void start() {

        bntReset.setText("RESET");
        bntReset.setBackgroundColor(Color.GRAY);
        score.setVisibility(View.VISIBLE);
        machine.setVisibility(View.VISIBLE);
        machineScore.setVisibility(View.VISIBLE);
        user.setVisibility(View.VISIBLE);
        userScore.setVisibility(View.VISIBLE);

        scoreMachine = 0;
        scoreUser = 0;

        actived = true;
        optionSelected();

    }

    private void optionSelected() {

        imagePedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawApp("pedra");

            }
        });

        imagePapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawApp("papel");
            }
        });


        imageTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawApp("tesoura");
            }
        });



        }


        private void drawApp (String optionUser){


            int number = 0;
            number = new Random().nextInt(3);
            String[] options = {"pedra","papel","tesoura"};
            String optionApp = options[number];

            switch(optionApp){

                case "pedra":
                    imageSorteio.setImageResource(R.drawable.pedra);
                    break;

                case "papel":
                    imageSorteio.setImageResource(R.drawable.papel);
                    break;

                case "tesoura":
                    imageSorteio.setImageResource(R.drawable.tesoura);
                    break;

        }

            //checkSelected(optionApp, optionUser );


            if(
                    (optionApp == "tesoura" && optionUser == "papel") ||
                            (optionApp == "papel" && optionUser == "pedra" )||
                            (optionApp == "pedra" && optionUser == "tesoura")



            ) {

                scoreMachine += 1;
                tiltleUser.setText(" :( você perdeu");
                machineScore.setText(String.valueOf(scoreMachine));

            }else if(
                    (optionUser == "tesoura" && optionApp == "papel") ||
                            (optionUser == "papel" && optionApp == "pedra" )||
                            (optionUser == "pedra" && optionApp == "tesoura")

            ) {

                scoreUser += 1;
                tiltleUser.setText(":) Você ganhou");
                userScore.setText(String.valueOf(scoreUser));


            } else{
                tiltleUser.setText("Empate");

            }


    }




}