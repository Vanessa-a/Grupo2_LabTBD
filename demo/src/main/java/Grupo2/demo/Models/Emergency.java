package Grupo2.demo.Models;

public class Emergency {
    private Integer id_emergency;
    private String name;
    private boolean estado;
    private Integer id_institution;

    public Integer getId_emergency() {
        return this.id_emergency;
    }

    public void setId_emergency(Integer id_emergency) {
        this.id_emergency = id_emergency;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getId_institution() {
        return this.id_institution;
    }

    public void setId_institution(Integer id_institution) {
        this.id_institution = id_institution;
    }

    
}   