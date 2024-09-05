package org.opcode.instructions;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class DcrInstruction implements Instruction{
    private final Register register;

    public DcrInstruction(Character register, RegisterState registerState) {
        this.register = registerState.getRegister(register);
    }

    @Override
    public void execute() {
        register.setValue(register.getValue() - 1);
    }
}
