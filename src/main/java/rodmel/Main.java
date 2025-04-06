package rodmel;
import java.util.List;
import java.util.Map;
/**
 * Clase principal que ejecuta la aplicación de procesamiento de transacciones desde un archivo CSV.
 *
 * <p>Esta clase lee la ruta del archivo desde los argumentos de la línea de comandos,
 * valida el archivo, carga las transacciones desde el CSV y genera un reporte con:
 * <ul>
 *   <li>El balance final entre créditos y débitos</li>
 *   <li>La transacción con el mayor monto</li>
 *   <li>El conteo de transacciones por tipo</li>
 * </ul>

 */
public class Main {
    /**
     * Método principal de la aplicación.
     *
     * @param args Argumentos de línea de comandos. Se espera al menos uno: la ruta del archivo CSV.
     */
    public static void main(String[] args) {
        // Validar argumentos
        if(args.length < 1){
            System.out.println("!Uso java app.AppCLI <ruta_del_archivo>");
            return;
        }
        String rutaCvs = args[0];

        // Validar formato del archivo
        if(!rutaCvs.endsWith(".csv")){
            System.out.println("X formato de archivo no válido");
            return;
        }
        // Leer transacciones desde el archivo CSV
        List<Transaccion> transaccions= CsvOperations.ReadCsv(rutaCvs) ;


        // Validar si se encontraron transacciones válidas
        if(transaccions.isEmpty()){
            System.out.println("X no se encontraron transacciones Válidas");
            return;
        }
        // Calcular balance final y otras estadísticas
        Map<String,Object> balance= CsvOperations.balanceFinal(transaccions);

        // Imprimir reporte
        System.out.println("REPORTE DE TRANSACCIONES");
        System.out.println("------------------------------");
        System.out.println("balance Final:" + balance.get("balance"));
        System.out.println("Transaccion de Mayor Monto: "+ CsvOperations.transaccionMayor(transaccions));
        System.out.println("Conteo de transacciones: " + balance.get("conteo"));

    }
}