import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Agregador de boletos vendidos en una fecha específica (relación de agregación).
 *
 * <p>Modela la relación TODO–PARTE: VentaDelDia (TODO) agrega múltiples {@link BoletoMuseo}
 * (PARTE).
 *
 * <p>El total de la venta se calcula sumando el precio de cada boleto registrado.
 *
 * @author TuNombre
 * @version 1.0
 */
public class VentaDelDia {

  /** Fecha de la venta en formato yyyy-MM-dd. */
  private String fechaDeLaVenta;

  /** Colección de boletos vendidos durante esta fecha (agregación). */
  private List<BoletoMuseo> boletosVendidos;

  /** Crea una venta del día con fecha actual y lista vacía de boletos. */
  public VentaDelDia() {
    fechaDeLaVenta = establecerFechaDeLaVenta();
    boletosVendidos = new ArrayList<>();
  }

  /**
   * Registra un boleto vendido agregándolo a la colección.
   *
   * @param boleto boleto vendido
   */
  public void registrarVentaBoleto(BoletoMuseo boleto) {
    boletosVendidos.add(boleto);
  }

  /**
   * Calcula el total vendido en el día sumando el precio de cada boleto.
   *
   * @return total de la venta del día
   */
  public double calcularTotalVentaDelDia() {
    double total = 0.0;
    for (BoletoMuseo b : boletosVendidos) {
      total += b.getPrecio();
    }
    return total;
  }

  /**
   * Devuelve la fecha actual en formato ISO (yyyy-MM-dd) para esta venta.
   *
   * @return cadena con la fecha de la venta
   */
  private String establecerFechaDeLaVenta() {
    DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return LocalDate.now().format(f);
  }

  @Override
  public String toString() {
    String msg = "VentaDelDia\n";
    msg += "  Fecha: " + fechaDeLaVenta + "\n";
    msg += "  Cantidad de boletos: " + boletosVendidos.size() + "\n";
    msg += "  Detalle:\n";
    for (BoletoMuseo b : boletosVendidos) {
      msg += "    - Boleto #" + b.getNumeroBoleto() + " | " + b.getPrecio() + "\n";
    }
    msg += "  Total: " + calcularTotalVentaDelDia();
    return msg;
  }
}
