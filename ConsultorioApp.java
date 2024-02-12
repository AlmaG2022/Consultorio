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

    public void agregarDoctor(Doctor doctor) {
        this.doctores.add(doctor);
    }

    public void agregarPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }

    public void crearCita(Cita cita) {
        this.citas.add(cita);
    }

    public void relacionarCita(Doctor doctor, Paciente paciente, Cita cita) {
        doctor.agregarCita(cita);
        paciente.agregarCita(cita);
    }

    public void guardarDatosEnCSV() {
        try {
            FileWriter writer = new FileWriter("datos.csv");
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

        // Ejemplo de cómo agregar algunos datos para probar
        Doctor doctor1 = new Doctor("1", "Dr. Juan Pérez", "Cardiología");
        Doctor doctor2 = new Doctor("2", "Dra. María Gómez", "Neurología");
        Paciente paciente1 = new Paciente("101", "Ana García");
        Paciente paciente2 = new Paciente("102", "Luis Rodríguez");
        Cita cita1 = new Cita("1001", "2023-11-25 10:00", "Consulta de rutina");

        consultorio.agregarDoctor(doctor1);
        consultorio.agregarDoctor(doctor2);
        consultorio.agregarPaciente(paciente1);
        consultorio.agregarPaciente(paciente2);
        consultorio.crearCita(cita1);

        // Guardar los datos en el archivo CSV
        consultorio.guardarDatosEnCSV();
    }
}

class Doctor {
    private String id;
    private String nombreCompleto;
    private String especialidad;
    private List<Cita> citas;

    public Doctor(String id, String nombreCompleto, String especialidad) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
        this.citas = new ArrayList<>();
    }

    public void agregarCita(Cita cita) {
        this.citas.add(cita);
    }

    @Override
    public String toString() {
        return id + "," + nombreCompleto + "," + especialidad;
    }
}

class Paciente {
    private String id;
    private String nombreCompleto;
    private List<Cita> citas;

    public Paciente(String id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.citas = new ArrayList<>();
    }

    public void agregarCita(Cita cita) {
        this.citas.add(cita);
    }

    @Override
    public String toString() {
        return id + "," + nombreCompleto;
    }
}

class Cita {
    private String id;
    private String fechaHora;
    private String motivo;

    public Cita(String id, String fechaHora, String motivo) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return id + "," + fechaHora + "," + motivo;
    }
}
