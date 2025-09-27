package adapter;

import target.Device;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JSLightningAdapter implements Device {
    private final String scriptPath;

    public JSLightningAdapter(String scriptPath) {
        this.scriptPath = scriptPath;
    }

    @Override
    public String charge() {
        try {
            Process process = new ProcessBuilder("node", scriptPath)
                    .redirectErrorStream(true)
                    .start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            process.waitFor();
            return output.toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}

