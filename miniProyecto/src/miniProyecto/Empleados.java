package miniProyecto;

public class Empleados {


	    private String nombre;
	    private int edad;
	    private double salario;
	    
	    public Empleados(String nombre, int edad, double salario) {
	        this.nombre = nombre;
	        this.edad = edad;
	        this.salario = salario;
	    }
	    
	    public String getNombre() {
	        return nombre;
	    }
	    
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	    
	    public int getEdad() {
	        return edad;
	    }
	    
	    public void setEdad(int edad) {
	        this.edad = edad;
	    }
	    public double getSalario() {
	        return salario;
	    }
	    
	    public void setSalario(double salario) {
	        this.salario = salario;
	    }
	    
	    public String toString() {
	        return "Nombre: " + nombre + ", Edad: " + edad+ ", Salario: " +salario;
	    }
	}
