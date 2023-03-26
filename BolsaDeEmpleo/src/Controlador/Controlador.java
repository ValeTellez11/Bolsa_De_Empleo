package Controlador;
import java.util.ArrayList;
import java.util.List;
import BolsaDeEmpleo.Aspirante;
import Vista.Vista;

public class Controlador {
    private Vista Vista;
    private List<Aspirante> aspirantes;

    public Controlador() {
        Vista = new Vista();
        aspirantes = new ArrayList<>();
    }

    public void agregarAspirante() {
        Aspirante aspirante = Vista.crearAspirante();
        aspirantes.add(aspirante);
        Vista.mostrarMensaje("El aspirante ha sido registrado.");
    }

    public void contratarAspirante(Aspirante aspirante) {
        aspirantes.remove(aspirante);
        Vista.mostrarMensaje("El aspirante ha sido contratado.");
    }

    public void eliminarAspirantesConPocaExperiencia(int aniosExperienciaMinimos) {
        List<Aspirante> aspirantesAEliminar = new ArrayList<>();

        for (Aspirante aspirante : aspirantes) {
            if (aspirante.getAnosExperiencia() < aniosExperienciaMinimos) {
                aspirantesAEliminar.add(aspirante);
            }
        }

        aspirantes.removeAll(aspirantesAEliminar);

        Vista.mostrarMensaje("Se han eliminado " + aspirantesAEliminar.size() + " aspirantes con poca experiencia.");
}
}