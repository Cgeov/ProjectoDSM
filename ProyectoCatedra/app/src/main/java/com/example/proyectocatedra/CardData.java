package com.example.proyectocatedra;

public class CardData {
    private int id;
    private String netSalary;
    private String deductions;
    private String baseSalary;
    private String area;
    private String tipo;
    private String nombre;


    public CardData() {
    }

    public void setnetSalary(String netSalary) {
        this.netSalary = netSalary;
    }
    public void setdeductions(String deductions) {
        this.deductions = deductions;
    }
    public void setbaseSalary(String baseSalary) {
        this.setBaseSalary(baseSalary);
    }
    public String getNetSalary() {
        return netSalary;
    }

    public String getDeductions() {
        return deductions;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(String baseSalary) {
        this.baseSalary = baseSalary;
    }
}