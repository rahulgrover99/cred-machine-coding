package org.opcode.service.v1;

import org.opcode.instructions.*;
import org.opcode.model.RegisterState;
import org.opcode.service.InstructionParser;

import java.util.Arrays;
import java.util.List;

public class InstructionParserImpl implements InstructionParser {
    private final RegisterState registerState;

    public InstructionParserImpl(RegisterState registerState) {
        this.registerState = registerState;
    }

    @Override
    public Instruction parse(String instruction) {
        List<String> params = Arrays.asList(instruction.split(" "));
        switch (params.get(0)) {
            case "ADD": {
                Character register = params.get(1).charAt(0);
                int value = Integer.parseInt(params.get(2));
                return new AddInstruction(register, value, registerState);
            }
            case "ADR": {
                Character fRegister = params.get(1).charAt(0);
                Character sRegister = params.get(2).charAt(0);
                return new AddRInstruction(fRegister, sRegister, registerState);
            }
            case "DCR": {
                Character register = params.get(1).charAt(0);
                return new DcrInstruction(register, registerState);
            }
            case "INR": {
                Character register = params.get(1).charAt(0);
                return new InrInstruction(register, registerState);
            }
            case "MOV": {
                Character fRegister = params.get(1).charAt(0);
                Character sRegister = params.get(2).charAt(0);
                return new MovInstruction(fRegister, sRegister, registerState);
            }
            case "RST": {
                return new RstInstruction(registerState);
            }
            case "SET": {
                Character register = params.get(1).charAt(0);
                int value = Integer.parseInt(params.get(2));
                return new SetInstruction(register, value, registerState);
            }
            default:
                throw new IllegalArgumentException("Invalid Instruction: " + params.get(0));
        }
    }
}
