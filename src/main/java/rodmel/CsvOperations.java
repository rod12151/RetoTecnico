package rodmel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
/**
 * La clase {@code CsvOperations} proporciona utilidades para leer transacciones desde un archivo CSV
 * y realizar operaciones como calcular el balance final, contar transacciones por tipo
 * y obtener la transacción con el monto más alto.
 *
 * El archivo CSV debe tener el siguiente formato (con encabezado en la primera línea):
 * <pre>
 * id,tipo,monto
 * 1,crédito,100.5
 * 2,débito,50.0
 * </pre>
 *
 * Los tipos de transacción válidos se normalizan a "crdito" y "dbito" eliminando caracteres no alfabéticos.
 *
 *
 */
public class CsvOperations {

    /**
     * Lee un archivo CSV con transacciones y devuelve una lista de objetos {@code Transaccion}.
     *
     * @param filePath Ruta del archivo CSV a leer.
     * @return Lista de transacciones leídas desde el archivo. Si ocurre un error, se devuelve una lista vacía.
     */
public static List<Transaccion>  ReadCsv(String filePath) {
    List<Transaccion> lista = new ArrayList<>();
  try (BufferedReader br= new BufferedReader(new FileReader(filePath))){
      String linea;
      boolean esPrimera=true;
      while((linea = br.readLine())!=null){
          if(esPrimera){
              esPrimera=false;
              continue;
          }
          String[] datos = linea.split(",");
          if(datos.length<3)continue;
          int id = Integer.parseInt(datos[0].trim());
          String tipoRaw = datos[1].trim().toLowerCase();
          String tipo = normalizarTipo(tipoRaw);
          if (tipo==null){
              continue;
          }
          double monto = Double.parseDouble(datos[2].trim());

          lista.add(new Transaccion(id,monto,tipo));
      }
  }catch (IOException | NumberFormatException e){
      System.out.println("X Error al Leer Archivo: "+ e.getMessage());
  }
  return lista;

}
    /**
     * Calcula el balance final entre créditos y débitos, y cuenta la cantidad de cada tipo.
     *
     * @param transaccions Lista de transacciones a analizar.
     * @return Un mapa con:
     *         <ul>
     *           <li><b>"balance"</b>: Diferencia entre créditos y débitos.</li>
     *           <li><b>"conteo"</b>: Cadena con la cantidad de créditos y débitos.</li>
     *         </ul>
     */
public static Map<String, Object> balanceFinal(List<Transaccion> transaccions){
    Map<String,Object> response = new HashMap<>();
    double sumaDebito=0;
    double sumaCredito=0;
    int totaldebito=0;
    int totalCredito=0;
    for(Transaccion t: transaccions){
        if(t.getTipo().equals("debito")){
            sumaDebito += t.getMonto();
            totaldebito +=1;
        } else if (t.getTipo().equals("credito")) {
            sumaCredito += t.getMonto();
            totalCredito +=1;

        }
    }

    response.put("balance",sumaCredito-sumaDebito);
    response.put("conteo","Credito: "+ totalCredito+ " Debito: "+ totaldebito);
    return response;
}
    /**
     * Busca la o las transacciones con el monto más alto.
     *
     * @param transaccions Lista de transacciones a analizar.
     * @return Cadena con los ID y montos de las transacciones con el monto más alto.
     */
public static  String transaccionMayor(List<Transaccion> transaccions){
        double maxMonto = transaccions.stream()
                .mapToDouble(Transaccion::getMonto)
                .max()
                .orElse(Double.NaN);
        List<Transaccion> maxTransaccions = transaccions.stream()
                .filter(t->t.getMonto()==maxMonto)
                .toList();
        return maxTransaccions.stream()
               .map(t-> "ID: "+ t.getId() + " | Monto: "+t.getMonto())
               .collect(Collectors.joining("\n"));
}
    /**
     * Intenta identificar el tipo de transacción basándose en las últimas sílabas.
     *
     * @param tipoRaw Tipo original leído del archivo.
     * @return "credito" si es crédito, "debito" si es débito, o null si no se puede identificar.
     */
    private static String normalizarTipo(String tipoRaw) {
        tipoRaw = tipoRaw.replaceAll("[^a-z]", ""); // Eliminar caracteres no alfabéticos
        if (tipoRaw.length() < 3) return null;
        if (tipoRaw.endsWith("dito")) {
            return "credito"; // Crédito
        } else if (tipoRaw.endsWith("bito")){
            return "debito"; // Débito
        }

        return null; // No se pudo determinar
    }
}

