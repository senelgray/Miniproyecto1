package miniProyecto;
import java.util.Scanner;


public class MenuEmpleados {

    private static final int MAX_USUARIOS = 20;
    private static Empleados[] empleados = new Empleados[MAX_USUARIOS];
    private static int cantidadEmpleados = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean ejecutar = true;
        while (ejecutar) {
            System.out.println("1. Registrar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Actualizar salario");
            System.out.println("4. Borrar un empleado");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    registrarEmpleado(scanner);
                    break;
                case 2:
                    listarEmpleados();
                    break;
                case 3:
                    actualizarSalarioEmpleado(scanner);
                    break;
                case 4:
                    borrarEmpleado(scanner);
                    break;
                case 5:
                    ejecutar = false;
                    System.out.println("Gracias por su visita.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    private static void registrarEmpleado(Scanner scanner) {
        if (cantidadEmpleados >= MAX_USUARIOS) {
            System.out.println("No se pueden registrar más usuarios.");
            return;
        }
        
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la edad del empleado: ");
        int edad = scanner.nextInt();
        System.out.print("Ingrese el salario del empleado: ");
        double salario = scanner.nextDouble();
        
        Empleados empleado = new Empleados(nombre, edad, salario);
        empleados[cantidadEmpleados] = empleado;
        cantidadEmpleados++;
        
        System.out.println("Empleado registrado.");
    }
    
    private static void listarEmpleados() {
        if (cantidadEmpleados == 0) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        
        System.out.println("Listado de empleados:");
        for (int i = 0; i < cantidadEmpleados; i++) {
            System.out.println(empleados[i]);
        }
    }
    
    private static void actualizarSalarioEmpleado(Scanner scanner) {
        if (cantidadEmpleados == 0) {
            System.out.println("No hay empleados resgistrados.");
            return;
        }
        
        System.out.print("Ingrese el nombre del empleado a actualizar: ");
        String nombre = scanner.next();
        
        boolean encontrado = false;
        for (int i = 0; i < cantidadEmpleados; i++) {
        if (empleados[i].getNombre().equals(nombre)) {
            System.out.print("Ingrese el nuevo salario del empleado: ");
            double nuevoSalario = scanner.nextDouble();
            
            empleados[i].setSalario(nuevoSalario);
            encontrado = true;
            
            System.out.println("Salario actualizado.");
            break;
        }
        }
        
        if (!encontrado) {
            System.out.println("Empleado no encontrado.");
        }
    }
    
    private static void borrarEmpleado(Scanner scanner) {
        if (cantidadEmpleados == 0) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        
        System.out.print("Ingrese el nombre del empleado que se da de baja: ");
        String nombreElim = scanner.next();
        
        boolean encontrado = false;
        
        for (int i = 0; i < cantidadEmpleados; i++) {
        	if(empleados[i].getNombre().equals(nombreElim)) {
        		 for (int j = i; j < cantidadEmpleados - 1; j++) {
                     empleados[j] = empleados[j + 1];
                 }
            
            empleados[cantidadEmpleados - 1] = null; 
            cantidadEmpleados--;
            
            System.out.println("Empleado eliminado exitosamente.");
            encontrado = true;
            break;
        	}
        }
        if (!encontrado) {
            System.out.println("Usuario no encontrado.");
        }
    }
}
