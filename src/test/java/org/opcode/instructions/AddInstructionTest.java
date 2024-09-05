package org.opcode.instructions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opcode.model.Register;
import org.opcode.model.RegisterState;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddInstructionTest {
    AddInstruction addInstruction;
    RegisterState registerState;

    @BeforeEach
    void setUp() {
        Register register = new Register('A');
        List<Register> registers = new ArrayList<>();
        registers.add(register);
        registerState = new RegisterState(registers);
        addInstruction = new AddInstruction('A', 1, registerState);
    }

    @Test
    void testAdd() {
        addInstruction.execute();

        assertEquals(1, registerState.getRegister('A').getValue());
    }

}