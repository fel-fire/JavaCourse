package edu.baykov.spring.streaming;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 9.2.6 Стриминг платформа. Необходимо разработать и настроить группу бинов, позволяющих выполнить задачу
 * преобразования данных из одной формы в другую, в соответствии со следующими правилами: ...
 * В качестве примера выполните следующее преобразование: из файла читается строка, приводится к верхнему регистру,
 * удаляются все буквы A, после чего слова длиной более четырех символов записываются в новый файл.
 */

@Service("streaming")
@ToString
public class StreamingPlatform {
    private Supplier<DTO> reader;
    private Consumer<DTO> writer;
    private Function<DTO, DTO> starter;

    @Autowired
    public StreamingPlatform(@Qualifier("fileReader") Supplier<DTO> reader,
                             @Qualifier("fileWriter")  Consumer<DTO> writer,
                             @Qualifier("GO") Function<DTO, DTO> starter) {
        this.reader = reader;
        this.writer = writer;
        this.starter = starter;
    }


    public void doActions(){
        DTO dto = reader.get();
        dto = starter.apply(dto);
        writer.accept(dto) ;
    }
}
