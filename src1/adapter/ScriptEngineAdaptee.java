package adapter;

import javax.script.*;
import java.io.FileReader;

public class ScriptEngineAdaptee {
    private final ScriptEngine engine;

    public ScriptEngineAdaptee() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName("nashorn"); // Java 8

        if (engine == null) {
            throw new RuntimeException("JS engine not found! Use Java 8.");
        }

        engine.eval(new FileReader("src/lightning.js"));
    }

    public String callCharge() throws Exception {
        Object phone = engine.get("LightningPhone");
        Invocable inv = (Invocable) engine;
        return (String) inv.invokeMethod(phone, "charge");
    }
}
