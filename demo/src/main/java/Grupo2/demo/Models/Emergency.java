package Grupo2.demo.Models;

public class Emergency {
    private Integer id_emergency;
    private boolean status;
    private Integer id_institution;

    public Integer getId() {
        return id_emergency;
    }

    public void setId(Integer id) {
        this.id_emergency = id;
    }

    public boolean status() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId_institucion() {
        return id_institution;
    }
    
}   