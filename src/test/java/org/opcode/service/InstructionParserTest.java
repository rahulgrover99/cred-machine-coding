package org.opcode.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opcode.instructions.AddInstruction;
import org.opcode.instructions.Instruction;
import org.opcode.model.Register;
import org.opcode.model.RegisterState;
import org.opcode.service.v1.InstructionParserImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InstructionParserTest {

    InstructionParser instructionParser;
    RegisterState registerState;

    @BeforeEach
    void setUp() {
        Register register = new Register('A');
        List<Register> registers = new ArrayList<>();
        registers.add(register);
        registerState = new RegisterState(registers);
        instructionParser = new InstructionParserImpl(registerState);
    }

    @Test
    void testValid() {
        Instruction instruction = instructionParser.parse("ADD A 1");

        assertEquals(instruction.getClass(), AddInstruction.class);
    }

    @Test
    void testInvalid() {
        assertThrows(IllegalArgumentException.class, () -> instructionParser.parse("FOO A 1"));
    }
}
