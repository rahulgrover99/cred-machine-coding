package org.opcode.service;

import org.opcode.instructions.Instruction;

public interface InstructionParser {
    Instruction parse(String instruction);


}
