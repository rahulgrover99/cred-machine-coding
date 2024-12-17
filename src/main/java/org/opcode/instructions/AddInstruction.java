package org.opcode.instructions;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;

import java.util.List;

public class AddInstruction implements Instruction{

    private final Register register;
    private final int value;

    public AddInstruction(Character register, int value, RegisterState registerState) {
        this.register = registerState.getRegister(register);
        this.value = value;
    }

    @Override
    public void execute() {
        register.setValue(register.getValue() + value);
    }
}
