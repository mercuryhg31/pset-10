package dict;

public class Word {
    private String word;
    private Definition[] definitions;
    private String[] synonyms;
    private String[] antonyms;

    public Word(String word, Definition[] definitions, String[] synonyms, String[] antonyms) {
        this.word = word;
        this.definitions = definitions;
        this.synonyms = synonyms;
        this.antonyms = antonyms;
    }
}