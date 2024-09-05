package org.opcode.instructions;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;

/** Instruction to set a value for a register **/
public class SetInstruction implements Instruction{

    private final Register register;
    private final int value;

    public SetInstruction(Character registerName, int value, RegisterState registerState) {
        this.register = registerState.getRegister(registerName);
        this.value = value;
    }

    @Override
    public void execute() {
        this.register.setValue(value);
    }
}
