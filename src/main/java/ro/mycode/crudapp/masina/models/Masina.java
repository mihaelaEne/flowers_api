package ro.mycode.crudapp.masina.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name="masini")
@Data
@AllArgsConstructor
@SuperBuilder
@ToString
@NoArgsConstructor
public class Masina implements Comparable<Masina> {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String marca;
    private int model;
    private int pret;
    @Override
    public int compareTo(Masina o) {
        return 0;
    }
}
