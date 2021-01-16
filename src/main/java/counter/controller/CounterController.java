package counter.controller;

import counter.model.Counter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class CounterController {
    private static Long maxId = 3L;
    private static List<Counter> counter;

    static {
        counter = new ArrayList<>();
        counter.add(Counter.builder().id(1L).name("Book").build());
        counter.add(Counter.builder().id(2L).name("Computer").build());
        counter.add(Counter.builder().id(3L).name("Table").build());
    }

    @GetMapping("{id}")
    public Counter getById(@PathVariable Long id) {
        return counter.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @GetMapping
    public boolean removeByName() {
        return counter.removeIf(c -> c.getName().equals("Book"));
    }

    @GetMapping
    public List<Counter> getAll() {
        return counter;
    }

    
//    @PostMapping
//    public Counter increment() {
//return
//    }


}
