package BolsaDeEmpleo;
import co.j256.ormlite.field.DatabaseField;
import co.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "aspirantes")
public class Aspirante {

    @DatabaseField(id = true)
    private String cedula;
    @DatabaseField
    private String nombreCompleto;
    @DatabaseField
    private int edad;
    @DatabaseField
    private int anosExperiencia;
    @DatabaseField
    private String profesion;
    @DatabaseField
    private String telefono;

    //Constructor vacio para OMRlite
    public Aspirante() {
    }

    //Constructor que inicializa la informacion
    public Aspirante(String cedula, String nombreCompleto, int edad, int anosExperiencia, String profesion, String telefono) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.anosExperiencia = anosExperiencia;
        this.profesion = profesion;
        this.telefono = telefono;
    }

    // get nos da el numero de la cedula
    public String getCedula() {
        return cedula;
    }

    // set permite cambiar el numero de cedula
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }
}
