package com.app.aprendamosjava.ExReg;

import java.util.regex.Pattern;

/**
 * Created by andres on 8/10/17.
 */

public class Variables {

    public Boolean CalificarVariables(String respuesta, Boolean calif) {


        String exprecionRegular = "^(\\s+)?((public|private|protected)\\s+)?(" +

                // Integer
                "int\\s+((?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(-)?([0-9]){1,9}?(\\s+)?)?)" +
                "((,(\\s+)?(?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(-)?([0-9]){1,9}?(\\s+)?)?)+)?|" +

                // Boolean
                "boolean\\s+((?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(true|false)(\\s+)?)?)" +
                "((,(\\s+)?(?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(true|false)(\\s+)?)?)+)?|" +

                // Short
                "short\\s+((?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(-)?([0-9]){1,4}?(\\s+)?)?)" +
                "((,(\\s+)?(?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(-)?([0-9]){1,4}?(\\s+)?)?)+)?|" +

                // Byte
                "byte\\s+((?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(-)?([0-9]){1,2}?(\\s+)?)?)" +
                "((,(\\s+)?(?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(-)?([0-9]){1,2}?(\\s+)?)?)+)?|" +

                // Long
                "long\\s+((?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(-)?([0-9]){1,18}?(\\s+)?)?)" +
                "((,(\\s+)?(?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(-)?([0-9]){1,18}?(\\s+)?)?)+)?|" +

                // Float
                "float\\s+((?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(-)?([0-9])+((\\.)[0-9]+[f])?(\\s+)?)?)" +
                "((,(\\s+)?(?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(-)?([0-9])+((\\.)[0-9]+[f])?(\\s+)?)?)+)?|" +

                // Double
                "double\\s+((?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(-)?([0-9])+((\\.)[0-9]+[d]?)?(\\s+)?)?)" +
                "((,(\\s+)?(?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(-)?([0-9])+((\\.)[0-9]+[d]?)?(\\s+)?)?)+)?|" +

                // Char
                "char\\s+((?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(['][\\x00-\\xFF]['])(\\s+)?)?)" +
                "((,(\\s+)?(?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?(['][\\x00-\\xFF]['])(\\s+)?)?)+)?|" +

                // String
                "String\\s+((?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?([\"][a-zA-Z0-9\\s]+[\"])(\\s+)?)?)" +
                "((,(\\s+)?(?![0-9])(?!(abstract|assert|boolean|break|byte|case|catch|char|class|const|" +
                "continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|" +
                "implements|import|instanceof|int|interface|long|native|new|package|private|" +
                "protected|public|return|short|static|strictfp|super|switch|synchronized|this|" +
                "throw|throws|transient|try|void|volatile|while))[a-zA-Z0-9_]+(\\s+)?(=(\\s+)?([\"][a-zA-Z0-9\\s]+[\"])(\\s+)?)?)+)?|" +

                ");(\\s+)?$";

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
