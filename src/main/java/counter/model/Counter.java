package counter.model;

import lombok.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Counter {

    private Long id;
    private String name;
    private Integer value;

}

