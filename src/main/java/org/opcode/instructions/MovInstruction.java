package org.opcode.instructions;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class MovInstruction implements Instruction{

    private final Register firstRegister;
    private final Register secondRegister;

    public MovInstruction(Character firstRegister, Character secondRegister,
                           RegisterState registerState) {
        this.firstRegister = registerState.getRegister(firstRegister);
        this.secondRegister = registerState.getRegister(secondRegister);
    }
    @Override
    public void execute() {
        firstRegister.setValue(secondRegister.getValue());
    }
}
