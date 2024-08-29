package ro.mycode.crudapp.Flowers.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRequest {
    private String species;
    private String bloomSeason;
    private int heightInCm;
}
