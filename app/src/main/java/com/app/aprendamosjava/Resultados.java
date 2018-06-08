package com.app.aprendamosjava;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import harmony.java.awt.Color;

public class Resultados extends AppCompatActivity {

    TextView textoResultados;
    Button botonIntentarDeNuevo, botonInfo, botonPDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        // Casteo
        textoResultados = (TextView) findViewById(R.id.texto_resultados);
        botonIntentarDeNuevo = (Button) findViewById(R.id.boton_intentar_de_nuevo);
        botonInfo = (Button) findViewById(R.id.boton_info);
        botonPDF = (Button) findViewById(R.id.boton_PDF);

        //- - - - - Recibiendo resultados y mostrandolos - - - - - -
        Intent resultados = getIntent();
        Bundle bundle_xd = resultados.getExtras();
        if (bundle_xd!=null){
            String cadena = (String) bundle_xd.get("Etiqueta");
            textoResultados.setText(cadena);
        }
        //- - - - - Recibiendo resultados y mostrandolos - - - - - -






        botonIntentarDeNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        botonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Info.class));
                finish();
            }
        });


        botonPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Resultados.this, "PDF", Toast.LENGTH_SHORT).show();

                createPDF();

            }

        });

    }

    public void createPDF() {
        Document doc = new Document();

        try {
            String path = Environment.getExternalStorageDirectory()
                    .getAbsolutePath();

            File dir = new File(path);
            if (!dir.exists())
                dir.mkdirs();

            Log.d("PDFCreator", "PDF Path: " + path);

            File file = new File(dir, "sample.pdf");
            FileOutputStream fOut = new FileOutputStream(file);

            PdfWriter.getInstance(doc, fOut);

            // open the document
            doc.open();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            Bitmap bitmap = BitmapFactory.decodeResource(getBaseContext()
                    .getResources(), R.raw.logo);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            Image myImg = Image.getInstance(stream.toByteArray());
            myImg.setAlignment(Image.MIDDLE);

            // add image to document
            doc.add(myImg);

            Paragraph p1 = new Paragraph("Generation de fichier PDF ");
            Font paraFont = new Font(Font.COURIER);
            p1.setAlignment(Paragraph.ALIGN_CENTER);
            p1.setFont(paraFont);

            // add paragraph to document
            doc.add(p1);


            stream = new ByteArrayOutputStream();
            bitmap = BitmapFactory.decodeResource(getBaseContext()
                    .getResources(), R.raw.logo);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            myImg = Image.getInstance(stream.toByteArray());
            myImg.setAlignment(Image.MIDDLE);

            // add image to document
            doc.add(myImg);

            // set footer
            Phrase footerText = new Phrase("Pied de page ");
            HeaderFooter pdfFooter = new HeaderFooter(footerText, false);
            doc.setFooter(pdfFooter);

        } catch (DocumentException de) {
            Log.e("PDFCreator", "DocumentException:" + de);
        } catch (IOException e) {
            Log.e("PDFCreator", "ioException:" + e);
        } finally {
            doc.close();
        }
    }

}
