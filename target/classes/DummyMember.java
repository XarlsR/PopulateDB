package com.xarlsr.gestclub.generadores;

import com.xarlsr.gestclub.dataclasses.Member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DummyMember extends Member{

    public int member_id;
    public String name;
    public String surname;
    public String nickname;
    public String dni;
    public String address1;
    public String address2 = "";
    public String city;
    public String province;
    public String country = "ES";
    public String post_code;
    public String telephone;
    public String email;
    public String join_date;
    public String exit_date = "";
    public int status;
    public int patch_rank;
    public int chapter;

    // TODO: en una futura versión pasar los valores de nombre de fichero iniciales mediante un archivo de configuración.
    String nFichNombres = "C:\\Users\\Carlos\\Documents\\GestClub\\Dummys\\NombresH.txt";
    String nFichApellidos = "C:\\Users\\Carlos\\Documents\\GestClub\\Dummys\\Apellidos.txt";
    String nFichNicknames = "C:\\Users\\Carlos\\Documents\\GestClub\\Dummys\\Nicknames.txt";
    String nFichCalles = "C:\\Users\\Carlos\\Documents\\GestClub\\Dummys\\Calles.txt";
    String nFichCiudades = "C:\\Users\\Carlos\\Documents\\GestClub\\Dummys\\Ciudades.txt";
    String nFichEmails = "C:\\Users\\Carlos\\Documents\\GestClub\\Dummys\\Emails.txt";

    public DummyMember(){

    }

    /**
     * Rellena los atributos de los atributos del objeto <b>DummyMember</b> con los valores
     * de los distinto generadores.
     * @param dum Objeto de la clase <b>DummyMember</b>
     * @return Objeto de la clase <b>DummyMember</b> con los atributos rellenados.
     */
    public DummyMember buildDummy(DummyMember dum){
        name = genNombre(nFichNombres);
        surname = genApellidos(nFichApellidos);
        nickname = genNickname(nFichNicknames);
        dni = genDni();
        address1 = genDireccion(nFichCalles);
        genCiudad(nFichCiudades);
        genTelefono();
        genEmail(nFichEmails);
        genDate();
        genStatus();
        genRank();
        genChapter();
        return dum;
    }

    /**
     * Selecciona aleatoriamente una cadena de texto del fichero indicado.<br>
     * Lee las cadenas del fichero secuencialmente y las carga en un array de Strings, desde la cual extrae la cadena seleccionada mediante el procedimiento <tt>Math.random()</tt>.
     * @param nombreFichero: Ruta y nombre del fichero que contiene los nombres.
     * @return Devuelve un <tt>String</tt> con el nombre seleccionado.
     */
    // TODO: En una futura versión añadir un parámetro para indicar cuántos valores deben ser leídos antes de realizar la selección aleatoria. En la v1.0 está fijado a 100.
    private static String genString(String nombreFichero){

        String[] arrStr = new String[100];

        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
            int i = 0;
            do {
               arrStr[i] = br.readLine();
               i++;
            }
            while ((arrStr[i-1] != null) & (i<100));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = (int)(Math.random()*100);
        return arrStr[i];
    }

    /**
     * Incorpora al atributo <b>name</b> un nombre leído del fichero de nobres, utilizando para ello
     * el método <b>genString().</b>
     * @param nFichNombres: ruta y nombre del fichero de nombres.
     */
    private String genNombre(String nFichNombres){
        name = genString(nFichNombres).toUpperCase();
        return name;
    }

    /**
     * Selecciona dos apellidos al azar de entre los incluidos en el fichero de apellidos<br>
     * devolviendo una cadena compuesta por ambos. Reutiliza el método <tt>genNombre()</tt> para tal fin.
     * @param nFichApellidos: Ruta y nombre del fichero con los apellidos.
     */
    private String genApellidos(String nFichApellidos){
        String ap1;
        String ap2;

        ap1 = genString(nFichApellidos);
        ap2 = genString(nFichApellidos);
        surname = (ap1+" "+ap2).toUpperCase();
        return surname;
    }

    /**
     * Selecciona un nickname elegido al azar de entre los incluidos en el fichero
     * correspondiente. <br>
     *
     * Utiliza el método <tt>genNombre()</tt> para tal fin. Devuelve el valor en MAYÚSCULAS.
     * @param nFichNicknames: Ruta y nombre del fichero que contiene los nicks.
     */
    private String genNickname(String nFichNicknames){
        nickname = genString(nFichNicknames).toUpperCase();
        return nickname;
    }

    /** Genera un DNI español con su letra de control.<br>
     * Devuelve un String de 9 caracteres, 8 correspondientes al número<br>
     * y uno adicional correspondiente a la letra, que se presenta en mayúsculas.<br><br>
     * Ejemplo de uso: <TT>String dni = generaDni();</TT><br>
     * @since version 1.0
     */
    private String genDni(){

        char numsDni;
        int rndm;

        String str = "";
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i<8; i++){              //<----------- GENERA EL STRING DE 8 NÚMEROS
            rndm = ((int)(Math.random()*10));
            numsDni = (char)(rndm+'0');
            sb.append(numsDni);
        }
        dni = sb.toString();

        int num = Integer.parseInt(dni);        //<----------- GENERA LA LETRA DE CONTROL
        int resto = num%23;
        char letra = '\0';
        switch(resto){
            case 0 : {
                letra = 'T';
                break;
            }
            case 1 : {
                letra = 'R';
                break;
            }
            case 2 : {
                letra = 'W';
                break;
            }
            case 3 : {
                letra = 'A';
                break;
            }
            case 4 : {
                letra = 'G';
                break;
            }
            case 5 : {
                letra = 'M';
                break;
            }
            case 6 : {
                letra = 'Y';
                break;
            }
            case 7 : {
                letra = 'F';
                break;
            }
            case 8 : {
                letra = 'P';
                break;
            }
            case 9 : {
                letra = 'D';
                break;
            }
            case 10 : {
                letra = 'X';
                break;
            }
            case 11 : {
                letra = 'B';
                break;
            }
            case 12 : {
                letra = 'N';
                break;
            }
            case 13 : {
                letra = 'J';
                break;
            }
            case 14 : {
                letra = 'Z';
                break;
            }
            case 15 : {
                letra = 'S';
                break;
            }
            case 16 : {
                letra = 'Q';
                break;
            }
            case 17 : {
                letra = 'V';
                break;
            }
            case 18 : {
                letra = 'H';
                break;
            }
            case 19 : {
                letra = 'L';
                break;
            }
            case 20 : {
                letra = 'C';
                break;
            }
            case 21 : {
                letra = 'K';
                break;
            }
            case 22 : {
                letra = 'E';
                break;
            }
        }
        dni = dni+letra;
        return dni;
    }

    /**
     * Incorpora al objeto una dirección compuesta de una calle, leída del fichero
     * <b>nFichCalles</b> y un número generado aleatoriamente entre 1 y 300.
     * @param nFichCalles: Ruta y nombre del fichero de calles.
     */
    private String genDireccion(String nFichCalles){

        address1 = genString(nFichCalles);
        int n = (int)(Math.random()*300)+1;
        address1 = (address1 + ", "+ n).toUpperCase();
        return address1;
    }

    /**
     * Carga en el objeto los atributos city, province y post_code.<br>
     * Los datos son leídos de un fichero mediante el método <b>genString()</b>. Las cadenas de datos en el fichero tienen que estar en el formato <b>'city-province-cod_postal'</b> para poder separar los campos adecuadamente.
     * @param nFichCiudades: Fichero que contiene las cadenas "city-province-cod_postal"
     */
    private void genCiudad(String nFichCiudades){
        String cadena;
        String[] parts;

        cadena = genString(nFichCiudades);
        parts = cadena.split("-");
        city = parts[0].toUpperCase();
        province = parts[1].toUpperCase();
        post_code = parts[2];
    }

    /**
     * Carga en el objeto <b>DummyMember</b> el atributo 'telephone'. Lo genera en dos partes:<br>
     * El primer dígito es un 6 o un 9 y el siguiente un String de números aleatorios
     * de 0 a 9.
     */
    private void genTelefono(){
        if (((int)(Math.random()*10) > 4)){
            telephone = "9";
        }
        else{
            telephone = "6";
        }
        String str = "";
        StringBuilder sb = new StringBuilder(str);
        for (int i = 1; i <9; i++){
            String s = Integer.toString((int)(Math.random()*10));
            sb.append(s);
        }
        str = sb.toString();
        telephone = telephone + str;
    }

    /**
     * Carga en el objeto un email aleatorio leido del fichero de emails mediannte
     * <b>genString()</b>
     * @param nFichEmails Ruta y nombre del fichero de emails.
     */
    private void genEmail(String nFichEmails){
        email = genString(nFichEmails);
    }

    /**
     * Genera una fecha aleatoria en el intervalo de años entre 2010 y 2022, con los
     * días ajustados al mes correspondiente y lo carga en el parámetro join_date
     * del objeto <b>DummyMember</b> a través de un String de longitud 8 caracteres.
     */
    private void genDate(){
        String dia;
        String mes;
        String ano;
        int diasMes;
        int rdmm;
        // -------------Genera el MES------------
        rdmm = ((int)(12*Math.random()+1));
        if (rdmm < 10){
            mes = "0"+ rdmm;
        }
        else{
            mes = Integer.toString(rdmm);
        }
        //--------------Genera el DÍA------------
        switch(rdmm){
            case 4 :
            case 6 :
            case 9 :
            case 11 :
                diasMes = 30;
            break;
            case 2 : diasMes = 28;
            break;
            default: diasMes = 31;
            break;
        }
        int rdmd;
        rdmd = ((int)(diasMes*Math.random()+1));
        if (rdmd < 10){
            dia = "0"+ rdmd;
        }
        else{
            dia = Integer.toString(rdmd);
        }
        // Genera el año
        ano = "20"+ (int) (12 * Math.random() + 10);
        // Genera la fecha final
        join_date = ano+mes+dia;
    }

    /**
     * Genera un status aleatorio para el miembro de la clase.
     */
    private void genStatus(){
        status = (int)(Math.random()*4+1);
    }

    /**
     * Genera un rank status aleatorio
     */
    private void genRank(){
        patch_rank = (int)(8*Math.random()+1);
    }

    /**
     * Genera un chapter aleatorio
     */
    private void genChapter(){
        chapter = (int)(5*Math.random()+1);
    }
}









