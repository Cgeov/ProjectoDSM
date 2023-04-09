package com.example.proyectocatedra;

public class CardData {
    private double netSalary;
    private double deductions;
    private double baseSalary;

    public CardData(double netSalary, double deductions, double baseSalary) {
        this.netSalary = netSalary;
        this.deductions = deductions;
        this.baseSalary = baseSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public double getDeductions() {
        return deductions;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}