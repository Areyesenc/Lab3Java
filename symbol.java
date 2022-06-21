package org.example;

public class Symbol {
    private final int value;

    /**
     * Crea un nuevo simobolo
     *
     * @param value es el valor de los simbolos
     */
    public Symbol(int value) {
        this.value = value;
    }

    /**
     * Obtiene el valor del simbolo
     *
     * @return el valor del simbolo
     */
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        return value == ((Symbol) obj).value;
    }
}
