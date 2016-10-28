package br.com.marina.feiradosimportados.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.marina.feiradosimportados.R;

public class MainActivity extends AppCompatActivity {

    private EditText txtEmail;
    private EditText txtSenha;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);

        mAuth = FirebaseAuth.getInstance();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mAuth.signInWithEmailAndPassword(txtEmail.getText().toString(), txtSenha.getText().toString())
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, R.string.error_login, Toast.LENGTH_LONG).show();
                                } else {
                                    FirebaseUser user = task.getResult().getUser();
                                    if (user != null) {
                                        Intent it = new Intent(MainActivity.this, Cadastro.class);
                                        startActivity(it);
                                        finish();
                                    }
                                }
                            }
                        });
            }
        });
    }

}
