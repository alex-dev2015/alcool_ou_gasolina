package gas.curso.com.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button   botaoVerficar;
    private TextView textoResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool     = (EditText) findViewById(R.id.precoAlcoolId);
        precoGasolina   = (EditText) findViewById(R.id.precoGasolinaId);
        botaoVerficar   = (Button)   findViewById(R.id.botaoVerificarId);
        textoResultado  = (TextView) findViewById(R.id.textoResultadoId);

        botaoVerficar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Recupera valores digitados
                String txtPrecoAlcool = precoAlcool     .getText().toString();
                String txtPrecoGas    = precoGasolina   .getText().toString();



                if(!txtPrecoAlcool.equals("") && (!txtPrecoGas.equals("")))
                {
                    //Converter as Strings para números;
                    Double valorAlcool = Double.parseDouble(txtPrecoAlcool);
                    Double valorGas    = Double.parseDouble(txtPrecoGas);
                    Double resultado = valorAlcool / valorGas;

                    if (resultado >= 0.7)
                    {
                        textoResultado.setText("Melhor usar Gasolina!");
                    }else
                        {
                           textoResultado.setText("Melhor usar Álcool!");
                        }
                }else
                    {
                        Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}
