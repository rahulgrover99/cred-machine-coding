package org.opcode.service.v1;

import org.opcode.instructions.Instruction;
import org.opcode.model.Register;
import org.opcode.model.RegisterState;
import org.opcode.service.InstructionParser;
import org.opcode.service.OpcodeSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OpcodeSimulatorImpl implements OpcodeSimulator {
    @Override
    public RegisterState execute(List<String> instructions) {
        RegisterState registerState = setUpMicroprocessor();
        InstructionParser instructionParser = new InstructionParserImpl(registerState);

        for (String instructionString: instructions) {
            Instruction instruction = instructionParser.parse(instructionString);
            instruction.execute();
        }


        return registerState;
    }

    public static RegisterState setUpMicroprocessor() {
        List<Register> registers = new ArrayList<>();
        registers.add(new Register('A'));
        registers.add(new Register('B'));
        registers.add(new Register('C'));
        registers.add(new Register('D'));

        return new RegisterState(registers);
    }
}
