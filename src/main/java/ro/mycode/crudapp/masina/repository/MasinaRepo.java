package ro.mycode.crudapp.masina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.mycode.crudapp.masina.models.Masina;

import java.util.List;

public interface MasinaRepo extends JpaRepository<Masina,Long> {
    @Query("select distinct m.marca from Masina m")
    List<String>getAllMarci();

}
