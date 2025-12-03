public class PuertasInsuficientesException extends Exception {

  /**
   * Constructor que recibe un mensaje personalizado
   * 
   * @param mensaje El mensaje descriptivo del error
   */
  public PuertasInsuficientesException(String mensaje) {
    super(mensaje);
  }

  /**
   * Constructor por defecto con mensaje predeterminado
   */
  public PuertasInsuficientesException() {
    super("Error: Un auto debe tener al menos 3 puertas");
  }
    
}
