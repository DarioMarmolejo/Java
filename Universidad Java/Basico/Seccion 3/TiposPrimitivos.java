
public class TiposPrimitivos {
    public static void main(String[] args) {
        /*
         * session 16 tipos primitivos enteros: byte, short, int, long
         */

        byte numeroByte = 10;
        System.out.println("Valor de byte: " + numeroByte);
        System.out.println("Valor minimo del byte: " + Byte.MIN_VALUE);
        System.out.println("Valor maximo del byte: " + Byte.MAX_VALUE);

        /*
         * Session 17 tipo short,in, long
         */
        short numeroShort = 10;
        System.out.println("Valor de short: " + numeroShort);
        System.out.println("Valor minimo del short: " + Short.MIN_VALUE);
        System.out.println("Valor maximo del short: " + Short.MAX_VALUE);

        int numeroInt = 10;
        System.out.println("Valor de int: " + numeroInt);
        System.out.println("Valor minimo del int: " + Integer.MIN_VALUE);
        System.out.println("Valor maximo del int: " + Integer.MAX_VALUE);

        long numeroLong = 10451541545545L;
        System.out.println("Valor de long: " + numeroLong);
        System.out.println("Valor minimo del long: " + Long.MIN_VALUE);
        System.out.println("Valor maximo del long: " + Long.MAX_VALUE);

        /*
         * Session 18 tipos flotantes: Float y double
         */

        float numeroFloat = 10.0F; // Puede ser tipo entero o tipo flotante, es de 32 bits (10, 10F,
                                   // 10f,(float)10.0)
        System.out.println("Valor de float: " + numeroFloat);
        System.out.println("Valor minimo del float: " + Float.MIN_VALUE);
        System.out.println("Valor maximo del float: " + Float.MAX_VALUE);

        double numeroDouble= 10.0F; // Puede ser tipo entero o tipo flotante, es de 32 bits
                                   
        System.out.println("Valor de double: " + numeroDouble);
        System.out.println("Valor minimo del double: " + Double.MIN_VALUE);
        System.out.println("Valor maximo del double: " + Double.MAX_VALUE);

        /*
         * Session 19 Uso palabra reservada Var en java
         */

        var numeroEnteroVar = 10;
        System.out.println("numero entero: "+numeroEnteroVar);

        var numeroDoubleVar = 10.0;
        System.out.println("numero double: "+numeroDoubleVar);

        var numeroFloatVar = 10.0F;
        System.out.println("numero float: "+numeroFloatVar);

        /*
         * Session 20 Uso del tipo char
         */

        //Se caracteriza por utilizar solo un caracter
        char miCaracter = 'a'; //se puede usar el caracter, datos unicode o el decimal
        System.out.println("mi caracter: " + miCaracter);

        char varChar = '\u0021'; //Char con valor unicode
        System.out.println("mi caracter: " + varChar);

        char varcharDecimal = 33; //Char con valor decimal
        System.out.println("mi caracter: " + varcharDecimal);

        var miCaracter2 = 'a'; //se puede usar el caracter, datos unicode o el decimal
        System.out.println("mi caracter: " + miCaracter2);

        var varChar2 = '\u0021'; //Char con valor unicode
        System.out.println("mi caracter: " + varChar2);

        var varcharDecimal2 = 33; //Char con valor decimal
        System.out.println("mi caracter: " + varcharDecimal2);


    }
}
