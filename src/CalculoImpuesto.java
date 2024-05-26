import java.util.ArrayList;
import java.util.Scanner;

public class CalculoImpuesto {

    private ArrayList<Empleado> empleados;
    private Scanner scanner;

    public CalculoImpuesto() {
        empleados = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        CalculoImpuesto calculoImpuesto = new CalculoImpuesto();
        calculoImpuesto.menu();
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Registrar Empleado");
            System.out.println("2. Modificar Empleado");
            System.out.println("3. Listar Empleados");
            System.out.println("4. Calcular y Mostrar Impuestos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarEmpleado();
                    break;
                case 2:
                    buscarYmodificar();
                    break;
                case 3:
                    mostrarLista();
                    break;
                case 4:
                    mostarListaValores();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 5);
    }

    public void registrarEmpleado() {
        System.out.print("Ingrese la cédula del empleado: ");
        int cedula = scanner.nextInt();
        scanner.nextLine(); // Consumir el newline
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el sueldo mensual del empleado: ");
        int sueldo = scanner.nextInt();

        Empleado empleado = new Empleado(cedula, nombre, sueldo);
        empleados.add(empleado);
        System.out.println("Empleado registrado exitosamente.");
    }

    public void buscarYmodificar() {
        System.out.print("Ingrese la cédula del empleado a modificar: ");
        int cedula = scanner.nextInt();

        for (Empleado empleado : empleados) {
            if (empleado.getCedula() == cedula) {
                scanner.nextLine(); // Consumir el newline
                System.out.print("Ingrese el nuevo nombre del empleado: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el nuevo sueldo mensual del empleado: ");
                int sueldo = scanner.nextInt();

                empleado.setNombreEmpleado(nombre);
                empleado.setSueldo(sueldo);
                System.out.println("Empleado modificado exitosamente.");
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    public void mostrarLista() {
        System.out.println("Lista de Empleados:");
        for (Empleado empleado : empleados) {
            System.out.println("Cédula: " + empleado.getCedula() + ", Nombre: " + empleado.getNombreEmpleado() + ", Sueldo: " + empleado.getSueldo());
        }
    }

    public void mostarListaValores() {
        System.out.println("Listado de Empleados con Valores Calculados:");
        System.out.printf("%-15s %-10s %-15s %-20s %-15s\n", "Nombre", "Sueldo", "Aporte Seguro", "Impuesto Renta", "Sueldo a Recibir");
        for (Empleado empleado : empleados) {
            System.out.printf("%-15s %-10d %-15.2f %-20.2f %-15.2f\n", empleado.getNombreEmpleado(), empleado.getSueldo(), empleado.getAporteSeguroSocial(), empleado.getImpuestoRenta(), empleado.getSueldoRecibir());
        }
    }
}