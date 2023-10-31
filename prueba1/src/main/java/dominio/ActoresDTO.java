
package dominio;


public class ActoresDTO {
    private int id_actor;
    private String nombre;
    private int anios;
    private String nacionalidad;
    private int altura;
    private String ocupacion;

    /**
     * @return the id_actor
     */
    public int getId_actor() {
        return id_actor;
    }

    /**
     * @param id_actor the id_actor to set
     */
    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the anios
     */
    public int getAnios() {
        return anios;
    }

    /**
     * @param anios the anios to set
     */
    public void setAnios(int anios) {
        this.anios = anios;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * @return the ocupacion
     */
    public String getOcupacion() {
        return ocupacion;
    }

    /**
     * @param ocupacion the ocupacion to set
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return "ActoresDTO{" + "id_actor=" + id_actor + ", nombre=" + nombre + ", anios=" + anios + ", nacionalidad=" + nacionalidad + ", altura=" + altura + ", ocupacion=" + ocupacion + '}';
    }
    
    
}
