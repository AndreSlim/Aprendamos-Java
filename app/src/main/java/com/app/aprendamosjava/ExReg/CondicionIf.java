package com.app.aprendamosjava.ExReg;

import java.util.regex.Pattern;

/**
 * Created by andres on 8/10/17.
 */

public class CondicionIf {

    public Boolean CalificarCondicionIf(String respuesta, Boolean calif) {

        String exprecionRegular = "^(\\s+)?if(\\s+)?\\((\\s+)?((?!(" +

                // Palabras reservadas
                "abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while"+
                "))[\\w\\d]+)(\\s+)?(((<=?|>=?|\\|\\||&&|=!|==)(\\s+)?((?!(" +

                // Palabras reservadas x2
                "abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while"+
                "))[\\w\\d]+(\\s+)?))?)+\\)(\\{((.*|\\n*)?)*\\})?(\\s+)?$";

        // Condición para evaluar
        if(Pattern.matches(exprecionRegular, respuesta)){    // Pattern.matches es la clase evaluadora

            calif = true;
            return calif;

        }else {

            calif = false;
            return calif;

        }

    }

}
