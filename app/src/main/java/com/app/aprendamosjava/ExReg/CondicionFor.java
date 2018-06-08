package com.app.aprendamosjava.ExReg;

import java.util.regex.Pattern;

/**
 * Created by andres on 8/10/17.
 */

public class CondicionFor {


    public Boolean CalificarCondicionFor(String respuesta, Boolean calif) {

        String exprecionRegular = "^(\\s+)?for(\\s+)?[(](\\s+)?(((byte|short|int|long|float|double)(\\s+)((?!(" +

                // Palabras Reservadas
                "abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while"+
                "))[a-zA-Z]+)(\\s+)?=(\\s+)?[a-zA-Z0-9]+)|(((?!(" +

                // Palabras Reservadas x2
                "abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while"+
                "))[a-zA-Z]+)(\\s+)?=(\\s+)?[0-9]+(\\s+)?))(\\s+)?;(\\s+)?((?!(" +

                // Palabras Reservadas x3
                "abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while"+
                "))[a-zA-Z]+)(\\s+)?(((<=|>|<|>=)(\\s+)?([0-9]+|((?!(" +

                // Palabras Reservadas x4
                "abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while"+
                "))[a-zA-Z]+)))|(\\.length\\(\\)))(\\s+)?;(\\s+)?((?!(" +

                // Palabras Reservadas x5
                "abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while"+
                "))[a-zA-Z]+)(\\s+)?((\\+\\+)|((\\+=)(\\s+)?[0-9]+)|(--))(\\s+)?[)]" +
                "(\\s+)?(\\{((.*|\\n*)?)*\\})?(\\s+)?$";


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
