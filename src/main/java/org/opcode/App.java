package org.opcode;

import org.opcode.model.Register;
import org.opcode.model.RegisterState;
import org.opcode.service.OpcodeSimulator;
import org.opcode.service.v1.OpcodeSimulatorImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<String> instructions = readFileToList("/Users/rahulgrover/Personal/cred-machine-coding/src/main/java/org/opcode/input.txt");

        OpcodeSimulator simulator = new OpcodeSimulatorImpl();
        RegisterState registerState = simulator.execute(instructions);

        System.out.println(registerState);
    }

    public static List<String> readFileToList(String filePath) {
        // Convert the string path to a Path object
        Path path = Paths.get(filePath);

        // Read all lines from the file into a List of Strings
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
