
package dominio;

public class UsuarioDTO {
    private int Id;
    private String nombre;
    private String correo;
    private String contrasenia;
    
        public UsuarioDTO() {
    }

    public UsuarioDTO(int Id) {
        this.Id = Id;
    }
    
    public UsuarioDTO(String nombre, String correo, String contrasenia) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    
    public UsuarioDTO(int Id, String nombre, String correo, String contrasenia) {
        this.Id = Id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    
    

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
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
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
}

    @Override
    public String toString() {
        return "UsuarioDTO{" + "Id=" + Id + ", nombre=" + nombre + ", correo=" + correo + ", contrasenia=" + contrasenia + '}';
    }



}
