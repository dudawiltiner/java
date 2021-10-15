package challenge;

import java.util.*;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        if(texto.length() == 0){
            throw new IllegalArgumentException("texto invalido, ele não pode ser vazio");
        }
        char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s', 't', 'u','v','w','x','y','z'};

        List<Character> letras = new ArrayList<>();
        for (char i : alfabeto) {
            letras.add(i);
        }

        String codigo = texto.toLowerCase();
        int i = 0;
        char[] arrayLetras = codigo.toCharArray();

        while(i <= codigo.length() - 1) {
            char letra = codigo.charAt(i);
            int verify = letras.indexOf(letra);
            if(letra == 'x') {
                arrayLetras[i] = 'a';
            } else if(letra == 'y') {
                arrayLetras[i] = 'b';
            } else if(letra == 'z') {
                arrayLetras[i] = 'c';
            } else if(verify >= 0) {
                int position = letras.indexOf(letra) + 3;
                arrayLetras[i] = alfabeto[position];
            }
            i++;
        }

        codigo = new String(arrayLetras);
        return codigo;
    }

    @Override
    public String descriptografar(String texto) {
        if(texto.length() == 0){
            throw new IllegalArgumentException("texto invalido, ele não pode ser vazio");
        }
        char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s', 't', 'u','v','w','x','y','z'};

        List<Character> letras = new ArrayList<>();
        for (char i : alfabeto) {
            letras.add(i);
        }

        String codigo = texto.toLowerCase();
        int i = 0;
        char[] arrayLetras = codigo.toCharArray();

        while(i <= codigo.length() - 1) {
            char letra = codigo.charAt(i);
            int verify = letras.indexOf(letra);
            if(letra == 'a') {
                arrayLetras[i] = 'x';
            } else if(letra == 'b') {
                arrayLetras[i] = 'y';
            } else if(letra == 'c') {
                arrayLetras[i] = 'z';
            } else if(verify >= 0) {
                int position = letras.indexOf(letra) - 3;
                arrayLetras[i] = alfabeto[position];
            }
            i++;
        }

        codigo = new String(arrayLetras);
        return codigo;
    }
}

// CLASSE QUE CRIEI PARA TESTAR TUDO
//class cesariana{
//
//    public static void main(String[] args) throws Exception { // ponto de entrada
//        System.out.println(criptografar("")); //a ligeira12 1 raposa marrox saltou sobre o cachorro cansado
//    }
//    // d oljhlvd12 1 vdsrwd pdvvra wdotrx wrevh r fdfkrvvr fdqwdgr
//    private static String criptografar(String texto) throws Exception {
//        System.out.println(texto.length());
//        if(texto.length() == 0){
//            throw new IllegalArgumentException("texto invalido, ele não pode ser vazio");
//        }
//        char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//
//        List<Character> letras = new ArrayList<>();
//        for (char i : alfabeto) {
//            letras.add(i);
//        }
//
//        String codigo = texto.toLowerCase();
//        int i = 0;
//        char[] arrayLetras = codigo.toCharArray();
//
//        while(i <= codigo.length() - 1) {
//            char letra = codigo.charAt(i);
//            int verify = letras.indexOf(letra);
//            if(letra == 'x') {
//                arrayLetras[i] = 'a';
//            } else if(letra == 'y') {
//                arrayLetras[i] = 'b';
//            } else if(letra == 'z') {
//                arrayLetras[i] = 'c';
//            } else if(verify >= 0) {
//                int position = letras.indexOf(letra) + 3;
//                arrayLetras[i] = alfabeto[position];
//            }
//            i++;
//        }
//
//        codigo = new String(arrayLetras);
//        return codigo;
//    }
//
//}



