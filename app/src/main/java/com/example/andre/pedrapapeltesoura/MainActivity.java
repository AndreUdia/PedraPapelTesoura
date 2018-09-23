package com.example.andre.pedrapapeltesoura;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");
    }
    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imagemResultado = (ImageView) findViewById(R.id.imageResultado);
        TextView exibirResultado = (TextView) findViewById(R.id.textResultado);

        // gerando número aleatório para escolha do App
        String [] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        switch ( escolhaApp ){
            case "pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if (
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura")||
                (escolhaApp == "papel" && escolhaUsuario == "pedra")||
                (escolhaApp == "tesoura" && escolhaUsuario == "papel")
                ) { //app ganha
            exibirResultado.setText("Você perdeu :( ");

        }else if(
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura")||
                (escolhaUsuario == "papel" && escolhaApp == "pedra")||
                (escolhaUsuario == "tesoura" && escolhaApp == "papel")
                ){ // Usuario ganha
            exibirResultado.setText("Você ganhou - Parabéns :) ");

        }else{// empate
            exibirResultado.setText("Houve um empate! ");
        }
    }
}
