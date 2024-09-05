package org.opcode.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RegisterState {
    private Map<Character, Register> registers;

    public RegisterState(List<Register> registers) {
        this.registers = registers.stream().collect(Collectors.toMap(Register::getName, r -> r));
    }

    public void updateValue(Register register) {
        if (!registers.containsKey(register.getName())) {
            throw new RuntimeException(String.format("The register %s is not present", register.getName()));
        }
        registers.put(register.getName(), register);
    }

    public Register getRegister(Character registerChar) {
        if (!registers.containsKey(registerChar)) {
            throw new RuntimeException(String.format("The register %s is not present", registerChar));
        }
        return registers.get(registerChar);
    }

    public void reset() {
        registers.replaceAll((k, v) -> {
            v.setValue(0);
            return v;
        });
    }
}
