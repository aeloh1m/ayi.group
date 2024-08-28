
/* 
 * Dada la cadena de caracteres:
“El veloz murcielago volaba muy alto durante el día y la noche”
Informar la posición de la letra “g”
 */

class Ejercicio3 {
    public static void main(String[] args) {

        String cadenaDeCaracteres = "El veloz murcielago volaba muy alto durante el día y la noche";

        for (int i = 0; i < cadenaDeCaracteres.length(); i++) {
            if (cadenaDeCaracteres.charAt(i) == 'g') {
                System.out.println("La letra 'g' se encuentra en la posición: " + i);
                break;
            }
        }

    }
}