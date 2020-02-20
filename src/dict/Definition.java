package dict;

public class Definition {
    private String definition;
    private String partOfSpeech;

    public Definition(String def, String pos) {
        this.definition = def;
        this.partOfSpeech = pos;
    }

    public String getDefinition() {
        return definition;
    }

    public String getPOS() {
        return partOfSpeech;
    }
}