
/* 
 * Dada la siguiente cadena de caracteres: “La casa de la esquina es muy grande”
● Eliminar todos los espacios de dicha letra.
● Informar el tamaño de la cadena con espacios y sin espacios.
 */

public class Ejercicio4 {
    public static void main(String[] args) {

        String cadenaDeCaracteres = "La casa de la esquina es muy grande";
        String textoSinEspacios = cadenaDeCaracteres.replace(" ", "");

        System.out.println("Tamaño de la cadena con espacios: " + cadenaDeCaracteres.length() +
                "\n Tamaño de la cadena sin espacios: " + textoSinEspacios.length());

        for (int i = 0; i < cadenaDeCaracteres.length(); i++) {
            if (cadenaDeCaracteres.charAt(i) == 'g') {
                break;
            }
        }

    }
}