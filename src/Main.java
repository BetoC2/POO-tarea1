import javax.swing.JOptionPane;

/**
 * Esta clase contiene las tres prácticas de la tarea 1.
 * @author Alberto
 */
public class Main {
    /**
     *
     * Este metodo se encarga de determinar en cuál estación se encuentra a partir de un día y mes.
     */
    public static void estacion() {

        // Se obtiene el int del día (Se asume que no van a poner días incorrectos)
        String dia_str = JOptionPane.showInputDialog("Escriba el día (1-31):");
        int dia = Integer.parseInt(dia_str);

        //Se obtiene el mes y revisa si el string no es igual a null para continuar
        String mes = JOptionPane.showInputDialog("Escriba el mes (Con palabra):");
        mes = mes == null? "" : mes.toLowerCase().trim();

        String estacion = "";
        String mensaje = null;

        // Se verifica con ayuda del día y el mes la estación en la que se encuentra
        switch (mes) {
            case "diciembre": estacion = dia < 21 ? "otoño" : "invierno"; break;
            case "enero", "febrero": estacion = "invierno"; break;
            case "marzo": estacion = dia < 20 ? "invierno" : "primavera"; break;
            case "abril", "mayo": estacion = "primavera"; break;
            case "junio": estacion = dia < 21 ? "primavera" : "verano"; break;
            case "julio", "agosto": estacion = "verano"; break;
            case "septiembre": estacion = dia < 23? "verano": "otoño"; break;
            case "octubre", "noviembre": estacion = "otoño"; break;

            // Si el mes no existe, se hace el mensaje para informarle al usuario
            default: mensaje = String.format("El mes \"%s\" no existe", mes);
        }

        // Si el mensaje contiene algo, es porque el mes es incorrecto
        if (mensaje != null) {
            JOptionPane.showMessageDialog(null, mensaje, "Resultado", JOptionPane.ERROR_MESSAGE);
        } else{
            mensaje = String.format("El %2d de %s es en %s",dia,mes,estacion);
            JOptionPane.showMessageDialog(null, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * Este método calcula la inflación tomando como referencia el UMA en dos años consecutivos
     *
     */
    public static void inflacion() {
        // Se obtiene el UMA de los dos años
        String str_past_index = JOptionPane.showInputDialog("Escriba el UMA del año anterior");
        String str_actual_index = JOptionPane.showInputDialog("Escriba el UMA del año actual");

        // Se utiliza double por precisión y conveniencia
        double past_index = Double.parseDouble(str_past_index);
        double actual_index = Double.parseDouble(str_actual_index);

        // Diferencia entre los 2 UMAs dividido entre el UMA pasado, por cien
        double inflacion = ((actual_index - past_index) / past_index) * 100;
        String mensaje = String.format("La inflación fue de %.1f%%", inflacion);

        JOptionPane.showMessageDialog(null, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Este método busca el estado de origen de un télefono conforme a su lada.
     */
    public static void telefono(){

        String original_number = JOptionPane.showInputDialog("Escriba un número telefónico");

        // Se crea una copia del número pero ahora sin caracteres distintos a los que se piden
        String number = original_number.replace(" ","");
        number = number.replace("-","").replace("(","").replace(")","");

        String mensaje = null;

        //El número solo es válido si tiene 10 caracteres.
        if (number.length() == 10){
            String lada = String.format("%c%c", number.charAt(0), number.charAt(1));
            if (lada.equals("33")){
                mensaje = String.format("El teléfono %s es de Guadalajara",original_number);
            }
            else if (lada.equals("55")){
                mensaje = String.format("El teléfono %s es de Ciudad de México",original_number);
            }
            else if (lada.equals("81")){
                mensaje = String.format("El teléfono %s es de Monterrey",original_number);
            }
        }
        else {
            mensaje = String.format("El teléfono %s no es válido",original_number);
        }

        //El mensaje es null únicamente cuando no se reconoce la lada.
        if (mensaje != null){
            JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args){
        estacion();
        inflacion();
        telefono();
    }
}