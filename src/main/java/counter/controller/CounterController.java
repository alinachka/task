package counter.controller;

import counter.model.Counter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping
public class CounterController {
    private static Long maxId = 3L;
    private static List<Counter> counter;

    static {
        counter = new ArrayList<>();
        counter.add(Counter.builder().id(1L).name("Book").value(1).build());
        counter.add(Counter.builder().id(2L).name("Computer").value(22).build());
        counter.add(Counter.builder().id(3L).name("Table").value(333).build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Counter create(@RequestBody Counter count) {
        maxId = maxId + 1L;
        count.setId(maxId);
        counter.add(count);
        return count;
    }


    @GetMapping("{id}")
    public Counter getById(@PathVariable Long id) {
        return counter.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @GetMapping
    public boolean removeByName() {
        return counter.removeIf(c -> c.getName().equals("Book"));
    }

    @PostMapping
    public int sum() {
        return counter.stream().mapToInt(Counter::getValue).sum();
    }

    @GetMapping
    public List<Counter> getAll() {
        return counter;
    }

}
