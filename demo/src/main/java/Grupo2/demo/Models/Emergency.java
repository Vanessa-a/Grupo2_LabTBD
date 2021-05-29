package Grupo2.demo.Models;

public class Emergency {
    private Integer id_emergency;
    private String name;
    private boolean estado;
    private Integer id_institution;

    public Integer getId() {
        return id_emergency;
    }
    
    public String getName() {
		return this.name;
	}

    public void setId(Integer id) {
        this.id_emergency = id;
    }

    public boolean status() {
        return estado;
    }

    public void setStatus(boolean status) {
        this.estado = status;
    }

    public Integer getId_institucion() {
        return id_institution;
    }
    
}   