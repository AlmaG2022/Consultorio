// ConsultorioApp.java

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConsultorioApp {
    private List<Doctor> doctores;
    private List<Paciente> pacientes;
    private List<Cita> citas;

    public ConsultorioApp() {
        this.doctores = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
    }

    // Métodos para agregar doctores, pacientes, crear citas, etc.

    public void guardarDatosEnCSV() {
        try {
            FileWriter writer = new FileWriter("db/datos.csv");
            writer.write("Doctores\n");
            for (Doctor doctor : doctores) {
                writer.write(doctor.toString() + "\n");
            }
            writer.write("Pacientes\n");
            for (Paciente paciente : pacientes) {
                writer.write(paciente.toString() + "\n");
            }
            writer.write("Citas\n");
            for (Cita cita : citas) {
                writer.write(cita.toString() + "\n");
            }
            writer.close();
            System.out.println("Datos guardados en archivo CSV correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ConsultorioApp consultorio = new ConsultorioApp();

        // Lógica para dar de alta doctores, pacientes, crear citas, etc.
        
        // Ejemplo de cómo guardar los datos en un archivo CSV
        consultorio.guardarDatosEnCSV();
    }
}

class Doctor {
    // Implementación de la clase Doctor
}

class Paciente {
    // Implementación de la clase Paciente
}

class Cita {
    // Implementación de la clase Cita
}
