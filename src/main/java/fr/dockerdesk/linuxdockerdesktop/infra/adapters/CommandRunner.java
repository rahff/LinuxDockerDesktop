package fr.dockerdesk.linuxdockerdesktop.infra.adapters;

import fr.dockerdesk.linuxdockerdesktop.core.ports.out.CommandRunnerAdapter;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CommandRunner implements CommandRunnerAdapter {


    public String run(String command) {
        InputStream commandStream = getCommandStream(command);
        return getCommandOutput(commandStream);
    }

    private InputStream getCommandStream(String command) {
        try{
            Process process = new ProcessBuilder(getCommandAndArgs(command)).start();
            return process.getInputStream();
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static String[] getCommandAndArgs(String command) {
        String[] commandAndArgs = command.split(" ");
        return commandAndArgs;
    }

    private String getCommandOutput(InputStream commandStreamOutput) {
            try (Reader reader = new BufferedReader(new InputStreamReader
                    (commandStreamOutput, StandardCharsets.UTF_8))) {
                return buildTextOutput(reader);
            }catch (IOException e){
                throw new RuntimeException(e.getMessage());
            }
    }

    private String buildTextOutput(Reader reader) throws IOException {
        StringBuilder textBuilder = new StringBuilder();
        int c = 0;
        while ((c = reader.read()) != -1) {
            textBuilder.append((char) c);
        }
        return textBuilder.toString();
    }

}
