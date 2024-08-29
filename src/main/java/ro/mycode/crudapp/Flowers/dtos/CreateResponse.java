package ro.mycode.crudapp.Flowers.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.mycode.crudapp.Flowers.models.Flower;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateResponse {

    private Flower flower;
    @Builder.Default
    private String message="The flower has been successfully created.";
}
