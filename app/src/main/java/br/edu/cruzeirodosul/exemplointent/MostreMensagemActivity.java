package br.edu.cruzeirodosul.exemplointent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MostreMensagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostre_mensagem);

        // Obtém a intent que iniciou esta activity e extrai o string
        Intent intent = getIntent();
        String mensagem = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Captura o TextView do layout e define o string como seu Text.
        TextView textView = findViewById(R.id.textView);
        textView.setText(mensagem);
    }
}

