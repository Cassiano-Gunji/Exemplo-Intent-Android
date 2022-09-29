package br.edu.cruzeirodosul.exemplointent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "br.edu.cruzeirodosul.exemplointent.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Chamado quando o usuário clica no botão Enviar */
    public void envieMensagem(View view){
        Intent intent = new Intent(this, MostreMensagemActivity.class);
        EditText editText = findViewById(R.id.editTextTextPersonName);
        String mensagem = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, mensagem);
        startActivity(intent);
    }
}

