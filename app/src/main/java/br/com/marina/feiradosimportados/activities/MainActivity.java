package br.com.marina.feiradosimportados.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.marina.feiradosimportados.R;
import br.com.marina.feiradosimportados.activities.Cadastro;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View v) {

        Intent i = new Intent();
        i.setClass(this, Cadastro.class);
        startActivity(i);

    }
}
