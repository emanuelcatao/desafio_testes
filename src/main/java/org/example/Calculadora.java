package org.example;

import java.util.Objects;

public class Calculadora {
    private final String marca;

    public Calculadora(String marca) {
        this.marca = marca;
    }

    public double add(double  a, double b) {
        return a+b;
    }

    public double sub(double  a, double b) {
        return a-b;
    }

    public double mult(double  a, double b) {
        return a*b;
    }

    public double div(double  a, double b) {
        if(b == 0) throw new ArithmeticException("Divisão por zero");
       return a/b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculadora that = (Calculadora) o;
        return Objects.equals(marca, that.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca);
    }
}
