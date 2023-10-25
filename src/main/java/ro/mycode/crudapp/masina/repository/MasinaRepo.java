package ro.mycode.crudapp.masina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.mycode.crudapp.masina.models.Masina;

import java.util.List;
import java.util.Optional;


@Repository
    public interface MasinaRepo extends JpaRepository<Masina,Long> {
    @Query("select distinct m.marca from Masina m")
    List<String>getAllMarci();



    @Query("select m from Masina m where m.marca = ?1 and m.model= ?2 ")
    Optional<Masina> findMasinaByMarcaAndModel( String marca, int model);

    @Modifying
    @Query("update Masina m set m.pret = ?3  where m.marca = ?1 and  m.model= ?2")
    void masinaUpdate( String marca, int model,int pret);

    @Query("select m from Masina m where m.pret between :minPret and :maxPret")
    List<Masina> findMasiniByPretRange(int minPret, int maxPret);

    @Query("select m from Masina m order by m.pret asc")
    List<Masina> findAllOrderByPretAsc();

    @Query("select count(m) from Masina m where m.marca = :marca")
    int countMasiniByMarca(String marca);



}
