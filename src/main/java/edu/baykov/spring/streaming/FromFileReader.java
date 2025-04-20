package edu.baykov.spring.streaming;


import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Supplier;

/**
 * 9.2.6 Стриминг платформа. Класс получения данных из файла
 */

@Component("fileReader")
public class FromFileReader implements Supplier<DTO> {

    BufferedReader reader = new BufferedReader(new FileReader("src/main/java/source.txt"));

    public FromFileReader() throws FileNotFoundException {
    }

    @Override
    public DTO get() {
        DTO dto = new DTO();
        String result = "";
        try {
            while (reader.ready()) result += reader.readLine() + " \n";
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dto.setName(result);
        return dto;
    }
}
