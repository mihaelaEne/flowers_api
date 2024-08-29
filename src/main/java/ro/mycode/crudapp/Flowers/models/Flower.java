package ro.mycode.crudapp.Flowers.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name="flower")
@Data
@AllArgsConstructor
@SuperBuilder
@ToString
@NoArgsConstructor
public class Flower implements Comparable<Flower> {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String species;
    private String bloomSeason;
    private int heightInCm;


    @Override
    public int compareTo(Flower o) {
        return 0;
    }
}
