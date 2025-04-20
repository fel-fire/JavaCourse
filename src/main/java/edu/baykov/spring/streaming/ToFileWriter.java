package edu.baykov.spring.streaming;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * 9.2.6 Стриминг платформа. Класс записи данных в файл
 */

@Component("fileWriter")
public class ToFileWriter implements Consumer<DTO> {

    FileWriter writer = new FileWriter("src/main/java/out.txt", true);

    public ToFileWriter() throws IOException {
    }

    @Override
    public void accept(DTO dto) {
        try {
            writer.write(dto.getName());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
