import java.util.ArrayList;
import java.util.Scanner;

class Empleado {

    int cedula;
    String nombreEmpleado;
    int sueldo;
    double aporteSeguroSocial;
    double impuestoRenta;

    public Empleado(int cedula, String nombreEmpleado, int sueldo) {
        this.cedula = cedula;
        this.nombreEmpleado = nombreEmpleado;
        this.sueldo = sueldo;
        this.aporteSeguroSocial = calcularAporteSeguroSocial();
        this.impuestoRenta = calcularImpuestoRenta();
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
        this.aporteSeguroSocial = calcularAporteSeguroSocial();
        this.impuestoRenta = calcularImpuestoRenta();
    }

    public double getAporteSeguroSocial() {
        return aporteSeguroSocial;
    }

    public double getImpuestoRenta() {
        return impuestoRenta;
    }

    private double calcularAporteSeguroSocial() {
        return this.sueldo * 0.0935;
    }

    private double calcularImpuestoRenta() {
        int sueldoAnual = this.sueldo * 12;
        if (sueldoAnual <= 5000) {
            return 0;
        } else if (sueldoAnual <= 10000) {
            return (sueldoAnual - 5000) * 0.10;
        } else if (sueldoAnual <= 18000) {
            return 500 + (sueldoAnual - 10000) * 0.20;
        } else {
            return 2100 + (sueldoAnual - 18000) * 0.30;
        }
    }

    public double getSueldoRecibir() {
        return this.sueldo - this.aporteSeguroSocial - (this.impuestoRenta / 12);
    }
}
