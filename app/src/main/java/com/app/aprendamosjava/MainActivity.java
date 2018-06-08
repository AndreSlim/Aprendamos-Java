package com.app.aprendamosjava;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.aprendamosjava.ExReg.CondicionFor;
import com.app.aprendamosjava.ExReg.CondicionIf;
import com.app.aprendamosjava.ExReg.Variables;

public class MainActivity extends AppCompatActivity {

    Button botonGenerarPregunta;
    TextView texto;

    EditText respuesta;
    TextInputLayout respuestaMat;

    // Clases
    Variables califVar;
    CondicionIf califConIf;
    CondicionFor califConFor;

    // Contadores
    Boolean calif;
    int numPregunta = 0, aciertos = 0;

    // Strings
    String respuestasIngresadas = "";

    // Array de posibles preguntas
    final String preguntas [] = {
            "Escribe una declaración de variables",
            "Escribe una declaración de un ciclo for",
            "Escribe una declaración de condición if"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // casteo
        botonGenerarPregunta = (Button) findViewById(R.id.boton_nueva_pregunta);
        texto = (TextView) findViewById(R.id.texto_pregunta);
        respuesta = (EditText) findViewById(R.id.texto_respuesta);
        respuestaMat = (TextInputLayout) findViewById(R.id.texto_respuesta_mat);


        // Objetos
        califVar = new Variables();
        califConIf = new CondicionIf();
        califConFor = new CondicionFor();

        // Acción del botón
        botonGenerarPregunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Generar la primera pregunta
                if(botonGenerarPregunta.getText().equals("Iniciar")){

                    // Contador de pregunta
                    numPregunta++;

                    // Inician las preguntas
                    int x  = (int)(Math.random()*3);
                    texto.setText(preguntas[x]);
                    botonGenerarPregunta.setText(R.string.boton_siguiente_pregunta);
                    respuestaMat.setHint("Escrite tu respuesta");   // Muestra el Hint
                    respuesta.setText("");

                }else{  // Continuan las preguntas

                    validarTextoInsertado();    // Valida campos no vacíos
                    String textoRespuesta = respuesta.getText().toString();
                    respuestaMat.setHint("Escrite tu respuesta");   // Muestra el Hint
                    respuesta.setText("");

                    if (!textoRespuesta.isEmpty()){ // If para comenzar a calificar - - - # # #

                        if(Calificar(textoRespuesta, texto.getText().toString())){

                            Toast.makeText(MainActivity.this, "Bien", Toast.LENGTH_SHORT).show();
                            respuestasIngresadas += numPregunta+") "+texto.getText().toString()+"\nTu respuesta fue:\n\n"+
                                    textoRespuesta+"\n\nCORRECTO\n\n\n\n\n";
                            aciertos++;


                        }else{

                            Toast.makeText(MainActivity.this, "Mal", Toast.LENGTH_SHORT).show();
                            respuestasIngresadas += numPregunta+") "+texto.getText().toString()+"\nTu respuesta fue:\n\n"+
                                    textoRespuesta+"\n\nINCORRECTO\n\n\n\n\n";
                        }

                        // Contador de pregunta
                        numPregunta++;

                        // Generación de pregunta aleatoria
                        int x  = (int)(Math.random()*3);
                        texto.setText(preguntas[x]);

                        if(numPregunta == 5){
                            botonGenerarPregunta.setText(R.string.boton_finalizar_preguntas);
                        }else if(numPregunta == 6){

                            aciertos = aciertos*2;

                            // - - - - - - - - - - - - - ( Asignando calificación ) - - - - - - - - - - - - -
                            switch (aciertos){

                                case 0:
                                    respuestasIngresadas += "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n" +
                                            "TU CALIFICACIÓN ES CERO\n\nSin conocimientos";
                                    break;

                                case 2:
                                    respuestasIngresadas += "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n" +
                                            "TU CALIFICACIÓN ES VEINTE\n\nDeficiente";
                                    break;

                                case 4:
                                    respuestasIngresadas += "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n" +
                                            "TU CALIFICACIÓN ES CUARENTA\n\nEstudia más";
                                    break;

                                case 6:
                                    respuestasIngresadas += "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n" +
                                            "TU CALIFICACIÓN ES SESENTA\n\nPoco conocimiento";
                                    break;

                                case 8:
                                    respuestasIngresadas += "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n" +
                                            "TU CALIFICACIÓN ES OCHENTA\n\nMuy bien";
                                    break;

                                case 10:
                                    respuestasIngresadas += "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n" +
                                            "TU CALIFICACIÓN ES CIEN\n\nExcelente";
                                    break;

                            }
                            // - - - - - - - - - - - - - ( Asignando calificación ) - - - - - - - - - - - - -

                            //- - - - - - - - Mandando resultados a la siguiente actividad - - - - - - - -
                            Intent intent = new Intent(MainActivity.this, Resultados.class);
                            String dato = respuestasIngresadas;
                            intent.putExtra("Etiqueta",dato); //mandando el dato a Resultados, a travez del intent
                            //- - - - - - - - Mandando resultados a la siguiente actividad - - - - - - - -

                            startActivity(intent);
                            finish();

                        }

                    }
                }
            }
        });
    }

    // Metodo que califica
    private boolean Calificar(String textoRespuesta, String pregunta) {

        Boolean califA;

        // Variables
        if(pregunta.equals("Escribe una declaración de variables")){

            //Toast.makeText(this, "Callo Variables", Toast.LENGTH_SHORT).show();

            califA = califVar.CalificarVariables(textoRespuesta, calif);
            Log.e("RESULTADO", "El booleano en "+pregunta+" es "+califA);
            return califA;

        // Condición If
        }else if(pregunta.equals("Escribe una declaración de condición if")){

            //Toast.makeText(this, "Callo condición if", Toast.LENGTH_SHORT).show();

            califA = califConIf.CalificarCondicionIf(textoRespuesta, calif);
            Log.e("RESULTADO", "El booleano en "+pregunta+" es "+califA);
            return califA;

        }else{

            //Toast.makeText(this, "Callo condición for", Toast.LENGTH_SHORT).show();

            califA = califConFor.CalificarCondicionFor(textoRespuesta, calif);
            Log.e("RESULTADO", "El booleano en "+pregunta+" es "+califA);
            return califA;
        }



    }


    // - - - - - - - - - - - - < VALIDAR CAMPOS VACIOS starts > - - - - - - - - - - - - -
    private void validarTextoInsertado(){
        boolean esValido = true;
        if(respuesta.getText().toString().isEmpty()) {         // Validar titulo
            respuestaMat.setError(getString(R.string.campoVacio));
            esValido = false;
        }else {
            respuestaMat.setErrorEnabled(false);
        }
    }// - - - - - - - - - - - - < VALIDAR CAMPOS VACIOS ENDS > - - - - - - - - - - - - -

}
