package org.opcode.instructions;

import org.opcode.model.RegisterState;

public class RstInstruction implements Instruction{

    private final RegisterState registerState;

    public RstInstruction(RegisterState registerState) {
        this.registerState = registerState;
    }

    @Override
    public void execute() {
        registerState.reset();
    }
}
