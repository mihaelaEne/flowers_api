package ro.mycode.crudapp.Flowers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateRequest {
    private int id;
    private String species="";
    private String bloomSeason="";
    private int heightInCm=0;
}
