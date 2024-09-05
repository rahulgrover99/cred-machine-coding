package org.opcode.instructions;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;

/** Adds the content of second register into the first register. **/
public class AddRInstruction implements Instruction{

    private final Register firstRegister;
    private final Register secondRegister;

    public AddRInstruction(Character firstRegister, Character secondRegister,
                          RegisterState registerState) {
        this.firstRegister = registerState.getRegister(firstRegister);
        this.secondRegister = registerState.getRegister(secondRegister);
    }

    @Override
    public void execute() {
        firstRegister.setValue(firstRegister.getValue() + secondRegister.getValue());
    }
}
