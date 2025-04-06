package rodmel;
/**
 * La clase {@code Transaccion} representa una operación financiera que puede ser de tipo ingreso, egreso u otro.
 * Contiene información como el ID de la transacción, el monto y el tipo de transacción.

 */
public class Transaccion {
    /**
     * Identificador único de la transacción.
     */

    private int id;
    /**
     * Monto involucrado en la transacción.
     */
    private double monto;
    /**
     * Tipo de la transacción (por ejemplo: "débito", "crédito").
     */
    private String tipo;


    /**
     * Obtiene el ID de la transacción.
     *
     * @return el ID de la transacción.
     */
    public int getId() {
        return id;
    }
    /**
     * Obtiene el monto de la transacción.
     *
     * @return el monto de la transacción.
     */
    public double getMonto() {
        return monto;
    }
    /**
     * Obtiene el tipo de la transacción.
     *
     * @return el tipo de la transacción.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Constructor que inicializa todos los campos de la transacción.
     *
     * @param id    Identificador único de la transacción.
     * @param monto Monto de la transacción.
     * @param tipo  Tipo de la transacción.
     */
    public Transaccion(int id, double monto, String tipo) {
        this.id = id;
        this.monto = monto;
        this.tipo = tipo;
    }


}
