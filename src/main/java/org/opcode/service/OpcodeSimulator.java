package org.opcode.service;

import java.util.List;
import org.opcode.model.RegisterState;

public interface OpcodeSimulator {
    RegisterState execute(List<String> instructions);
}
