package br.edu.cruzeirodosul.exemplointent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MostreMensagemActivity extends AppCompatActivity {

    private String mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostre_mensagem);

        // Obtém a intent que iniciou esta activity e extrai o string
        Intent intent = getIntent();
        mensagem = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Captura o TextView do layout e define o string como seu Text.
        TextView textView = findViewById(R.id.textView);
        textView.setText(mensagem);
    }

    public void procureNaInternet(View view){
        Uri pesquisa = Uri.parse("https://www.google.com/search?q=" + mensagem);
        Intent intentPesquisa = new Intent(Intent.ACTION_VIEW, pesquisa);
        try {
            startActivity(intentPesquisa);
        } catch(ActivityNotFoundException e){
            String erro = getResources().getString(R.string.erroIntent);
            Toast toast = Toast.makeText(this, erro, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void procureUmLocal(View view){
        Uri local = Uri.parse("geo:0,0?q=" + mensagem);
        Intent intentLocal = new Intent(Intent.ACTION_VIEW, local);
        String titulo = getResources().getString(R.string.escolhaApp);
        Intent intentChooser = Intent.createChooser(intentLocal, titulo);
        try {
            startActivity(intentChooser);
        } catch(ActivityNotFoundException e){
            String erro = getResources().getString(R.string.erroIntent);
            Toast toast = Toast.makeText(this, erro, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}

