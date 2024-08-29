package ro.mycode.crudapp.Flowers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.crudapp.Flowers.models.Flower;

import java.util.List;
import java.util.Optional;


@Repository
    public interface FlowerRepo extends JpaRepository<Flower,Long> {
    @Query("select distinct f.species from Flower f")
    List<String>getAllFlowers();


    @Query("select f from Flower f where f.species = ?1 and f.bloomSeason= ?2 ")
    Optional<Flower> findFlowerBySpeciesAndBloomSeason(String species, String bloomSeason);

    @Query("select f from Flower f where f.species = ?1 ")
    Optional<Flower> findFlowerBySpecies(String species);

    @Query("select f from Flower f where f.id = ?1 ")
    Optional<Flower> findFlowerById(int id);






}
