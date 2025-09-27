import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa un boleto de museo con precio, número consecutivo y fecha de emisión.
 *
 * <p>Ejemplo de uso:
 * <pre>{@code
 * BoletoMuseo b = new BoletoMuseo(4500.0);
 * System.out.println(b.getNumeroBoleto());
 * }</pre>
 *
 * <p>Diseño coherente con el diagrama provisto en la AA5.
 *
 * @author TuNombre
 * @version 1.0
 */
public class BoletoMuseo {

  /** Precio del boleto. */
  private double precio;

  /** Número consecutivo del boleto (1..n). */
  private int numeroBoleto;

  /** Fecha de emisión en formato yyyy-MM-dd. */
  private String fechaEmision;

  /** Contador global de boletos emitidos. */
  private static int contador = 0;

  /**
   * Crea un boleto de museo con el precio indicado.
   *
   * @param precio precio del boleto
   */
  public BoletoMuseo(double precio) {
    this.precio = precio;
    contador++;
    this.numeroBoleto = contador;
    this.fechaEmision = establecerFechaEmisionBoleto();
  }

  /**
   * Devuelve la fecha actual en formato ISO (yyyy-MM-dd) para la emisión del boleto.
   *
   * @return cadena con la fecha de emisión
   */
  private String establecerFechaEmisionBoleto() {
    DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return LocalDate.now().format(f);
  }

  /**
   * Obtiene el contador global de boletos creados.
   *
   * @return cantidad de boletos creados
   */
  public static int getContador() {
    return contador;
  }

  /**
   * Obtiene el número consecutivo de este boleto.
   *
   * @return número del boleto
   */
  public int getNumeroBoleto() {
    return numeroBoleto;
  }

  /**
   * Obtiene el precio del boleto.
   *
   * @return precio
   */
  public double getPrecio() {
    return precio;
  }

  @Override
  public String toString() {
    String msg = "BoletoMuseo\n";
    msg += "  Numero: " + numeroBoleto + "\n";
    msg += "  Precio: " + precio + "\n";
    msg += "  Fecha Emision: " + fechaEmision;
    return msg;
  }
}
