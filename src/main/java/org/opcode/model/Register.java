package org.opcode.model;

import java.util.Objects;

public class Register {
    private final Character name;

    private int value;

    public Register(Character name) {
        this.name = name;
        this.value = 0;
    }

    public Character getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Register)) {
            return false;
        }
        Register register = (Register) o;
        return value == register.value && Objects.equals(name, register.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}

