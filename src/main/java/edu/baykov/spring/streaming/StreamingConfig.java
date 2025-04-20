package edu.baykov.spring.streaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 9.2.6 Стриминг платформа. Конфигурационный класс
 */

@Configuration
@ComponentScan(basePackages = "com.apress.prospring5.ch2.Tasks.streaming")
public class StreamingConfig {

    /**
     * Первый бин типа Function<DTO, DTO> в последовательности действий. Отмечаем его именем "GO" для наглядности.
     * В качестве входного параметра метод должен принимать ссылку на следующий бин nextAction. Если ссылка
     * на nextAction будет равна null, это будет означать окончание последовательности.
     */
    @Bean("GO")
    public Function<DTO, DTO> toUpperCase(
            @Autowired(required = false) @Qualifier("removeA") Function<DTO,DTO> nextAction) {

        return (x) -> {
            String data = x.getName();
            x.setName(data.toUpperCase());
            if (nextAction != null) x = nextAction.apply(x);
            return x;
        };
    }

    @Bean
    public Function<DTO, DTO> removeA(
            @Autowired(required = false) @Qualifier("filterByMoreThan4SymbolsWords") Function<DTO,DTO> nextAction) {

        return (x) -> {
            String data = x.getName();
            x.setName(data.replace("A", ""));
            if (nextAction != null) x = nextAction.apply(x);
            return x;
        };
    }

    /**
     * Последний бин типа Function<DTO, DTO> в последовательности действий.
     * Отмечаем nextAction именем "" для получения null.
     */
    @Bean
    public Function<DTO, DTO> filterByMoreThan4SymbolsWords(
            @Autowired(required = false) @Qualifier("") Function<DTO,DTO> nextAction) {

        return (x) -> {
            String data = x.getName();
            String[] words = data.split(" ");
            data = Arrays.stream(words).filter(s -> s.length()> 4).collect(Collectors.joining(" "));
            x.setName(data);
            if (nextAction != null) x = nextAction.apply(x);
            return x;
        };
    }

    /**
     * Как вариант можно создать такую заглушку, которая будет подтягиваться спрингом в последний из методов
     * последовательности по имени "finish"
     */
    @Bean
    public Function<DTO, DTO> finish(){
        return x -> x;
    }
}
