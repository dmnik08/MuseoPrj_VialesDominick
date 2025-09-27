/**
 * Representa a una persona que puede tener asociado un {@link BoletoMuseo}.
 *
 * <p>Implementa una relación de asociación con BoletoMuseo (navegabilidad unidireccional).
 *
 * @author TuNombre
 * @version 1.0
 */
public class Persona {

  /** Nombre de la persona. */
  private String nombre;

  /** Identificación de la persona. */
  private String identificacion;

  /** Rol de la asociación: el boleto asignado a esta persona (puede ser nulo). */
  private BoletoMuseo miBoleto;

  /**
   * Crea una persona con nombre e identificación.
   *
   * @param nombre nombre de la persona
   * @param ident identificación de la persona
   */
  public Persona(String nombre, String ident) {
    this(nombre);
    identificacion = ident;
  }

  /**
   * Crea una persona con nombre.
   *
   * @param nombre nombre de la persona
   */
  public Persona(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Asigna o actualiza la identificación de la persona.
   *
   * @param pIdentificacion identificación a asignar
   */
  public void setIdentificacion(String pIdentificacion) {
    identificacion = pIdentificacion;
  }

  /**
   * Asigna un boleto a la persona. Representa la asociación Persona—BoletoMuseo.
   *
   * @param pMiBoleto boleto a asociar
   */
  public void asignarBoleto(BoletoMuseo pMiBoleto) {
    miBoleto = pMiBoleto;
  }

  /**
   * Consulta el número del boleto asignado.
   *
   * @return número del boleto asociado
   * @throws NullPointerException si la persona no tiene boleto asignado
   */
  public int consultarMiNumeroDeBoleto() {
    return miBoleto.getNumeroBoleto();
  }

  @Override
  public String toString() {
    String msg = "Persona\n";
    msg += "  Nombre: " + nombre + "\n";
    msg += "  Identificacion: " + identificacion + "\n";
    if (miBoleto != null) {
      msg += "  Boleto asignado: #" + miBoleto.getNumeroBoleto() + "\n";
    } else {
      msg += "  Boleto asignado: (ninguno)\n";
    }
    return msg;
  }
}
