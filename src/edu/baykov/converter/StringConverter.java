package edu.baykov.converter;

public class StringConverter extends Converter<String>{

    public StringConverter(Convertable<String> conv) {
        super(conv);
    }

    @Override
    void save(String data, String filename) {
        // сюда пишем необходимую реализацию
    }

    @Override
    String open(String fileName) {
        // сюда пишем необходимую реализацию
        return "что-нибудь";
    }
}
