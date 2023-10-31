
package dominio;

public class SerieDTO {
    private int id_serie;
    private String nombre;
    private int anio;
    private String genero;
    private int episodios;
    private String act1;
    private String act2;
    private String act3;
    private String act4;

    /**
     * @return the id_serie
     */
    public int getId_serie() {
        return id_serie;
    }

    /**
     * @param id_serie the id_serie to set
     */
    public void setId_serie(int id_serie) {
        this.id_serie = id_serie;
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
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the episodios
     */
    public int getEpisodios() {
        return episodios;
    }

    /**
     * @param episodios the episodios to set
     */
    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    /**
     * @return the act1
     */
    public String getAct1() {
        return act1;
    }

    /**
     * @param act1 the act1 to set
     */
    public void setAct1(String act1) {
        this.act1 = act1;
    }

    /**
     * @return the act2
     */
    public String getAct2() {
        return act2;
    }

    /**
     * @param act2 the act2 to set
     */
    public void setAct2(String act2) {
        this.act2 = act2;
    }

    /**
     * @return the act3
     */
    public String getAct3() {
        return act3;
    }

    /**
     * @param act3 the act3 to set
     */
    public void setAct3(String act3) {
        this.act3 = act3;
    }

    /**
     * @return the act4
     */
    public String getAct4() {
        return act4;
    }

    /**
     * @param act4 the act4 to set
     */
    public void setAct4(String act4) {
        this.act4 = act4;
    }

    @Override
    public String toString() {
        return "SerieDTO{" + "id_serie=" + id_serie + ", nombre=" + nombre + ", anio=" + anio + ", genero=" + genero + ", episodios=" + episodios + ", act1=" + act1 + ", act2=" + act2 + ", act3=" + act3 + ", act4=" + act4 + '}';
    }
    
    
    
}
