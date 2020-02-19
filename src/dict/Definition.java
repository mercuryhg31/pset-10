package dict;

import java.util.List;

public class Definition {
    private String def;
    private String pos;

    public Definition(String def, String pos) {
        this.def = def;
        this.pos = pos;
    }

    public String getDefinition() {
        return def;
    }

    public String getPOS() {
        return pos;
    }
}