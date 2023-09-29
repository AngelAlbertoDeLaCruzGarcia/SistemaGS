package com.example.sistemags.service;

import java.util.Random;
import org.apache.commons.lang.StringUtils;

public class Curp {
    private static char[] VOCALES = {'A', 'E', 'I', 'O', 'U'};
    private static Random random = new Random();
    StringBuilder curp = new StringBuilder();
    StringBuilder rfc = new StringBuilder();

    public void calculaCurp() {}
    public void calculaCurp(String nombres, String apellidoPaterno, String apellidoMaterno, String fechaDeNacimiento,
                            String entidadDeNacimiento, String genero, String ultimosDigitos)
    {
        apellidoPaterno = apellidoPaterno.replaceAll("^[Dd][Ee] [Ll][Aa]", "");
        apellidoMaterno = apellidoMaterno.replaceAll("^[Dd][Ee] [Ll][Aa]", "");
        apellidoPaterno = trim( apellidoPaterno );
        apellidoMaterno = trim( apellidoMaterno );
        nombres = trim( nombres );
        genero = trim( genero );
        entidadDeNacimiento = trim( entidadDeNacimiento );

        System.out.println(apellidoPaterno);
        System.out.println( apellidoPaterno.charAt( 0 ) );
        rfc.append( apellidoPaterno.charAt( 0 ) );
        rfc.append( primeraVocal( apellidoPaterno.substring( 1 ) ) );
        rfc.append( apellidoMaterno.charAt( 0 ) );
        rfc.append( nombres.charAt( 0 ) );
        rfc.append( fechaDeNacimiento.substring( 2, 4 ) );
        rfc.append( fechaDeNacimiento.substring( 5, 7 ) );
        rfc.append( fechaDeNacimiento.substring( 8, 10 ) );
        curp.append(rfc);
        curp.append( genero );
        curp.append( entidadDeNacimiento );
        curp.append( primeraLetra( apellidoPaterno.substring( 1 ) ) );
        curp.append( primeraLetra( apellidoMaterno.substring( 1 ) ) );
        curp.append( primeraLetra( nombres.substring( 1 ) ) );
        if(ultimosDigitos.isEmpty()) {
            curp.append(random.nextInt(10));
            curp.append(random.nextInt(10));
        }else {
            curp.append(ultimosDigitos);
        }
    }

    private static String trim( String s )
    {
        return StringUtils.trimToEmpty(s).toUpperCase();
    }

    private static char primeraLetra( String s )
    {
        int i = StringUtils.indexOfAnyBut( s, VOCALES );
        if ( i >= 0 )
        {
            return s.charAt( i );
        }
        return 'A';
    }

    private static char primeraVocal( String s )
    {
        int i = StringUtils.indexOfAny( s, VOCALES );
        if ( i >= 0 )
        {
            return s.charAt( i );
        }
        return 'A';
    }

    public StringBuilder getCurp() {
        return curp;
    }

    public StringBuilder getRfc() {
        return rfc;
    }
}
