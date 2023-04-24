package com.example.proyectocatedra;

public class CardData {
    private int id;
    private String netSalary;
    private String deductions;
    private String baseSalary;

    public CardData() {
    }

    public void setnetSalary(String netSalary) {
        this.netSalary = netSalary;
    }
    public void setdeductions(String deductions) {
        this.deductions = deductions;
    }
    public void setbaseSalary(String baseSalary) {
        this.baseSalary = baseSalary;
    }
    public String getNetSalary() {
        return netSalary;
    }

    public String getDeductions() {
        return deductions;
    }

    public String getBaseSalary() {
        return baseSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}