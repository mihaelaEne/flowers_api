package ro.mycode.crudapp.Flowers.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.crudapp.Flowers.dtos.CreateResponse;
import ro.mycode.crudapp.Flowers.dtos.CreateRequest;
import ro.mycode.crudapp.Flowers.dtos.UpdateRequest;
import ro.mycode.crudapp.Flowers.dtos.UpdateResponse;
import ro.mycode.crudapp.Flowers.exceptions.FlowerDoesntExist;
import ro.mycode.crudapp.Flowers.exceptions.FlowerExist;
import ro.mycode.crudapp.Flowers.exceptions.FlowerListEmpty;
import ro.mycode.crudapp.Flowers.exceptions.NoUpdate;
import ro.mycode.crudapp.Flowers.models.Flower;
import ro.mycode.crudapp.Flowers.repository.FlowerRepo;

import java.util.List;
import java.util.Optional;

@Service
public class FlowerService {

    private FlowerRepo flowerRepo;




    public FlowerService(FlowerRepo flowerRepo) {
        this.flowerRepo = flowerRepo;
    }

    public List<Flower> getAllFlowers() {
        List<Flower> all = flowerRepo.findAll();
        if (all.size() == 0) {
            throw new FlowerListEmpty();
        }
        return all;
    }



    @Transactional
    public CreateResponse addFlower(CreateRequest createRequest) {

        Optional<Flower> flowerBySpecies = flowerRepo.findFlowerBySpecies(createRequest.getSpecies());
        if (flowerBySpecies.isPresent()) {

            throw new FlowerExist();
        }
         Flower flower = Flower.builder()
                 .species(createRequest.getSpecies())
                 .bloomSeason(createRequest.getBloomSeason())
                 .heightInCm(createRequest.getHeightInCm())
                .build();
        Flower flower1 =  flowerRepo.saveAndFlush(flower);

        return CreateResponse.builder().flower(flower1).build();

    }

    @Transactional
    public void deleteFlower(long id) {
        Optional<Flower> flower = flowerRepo.findById(id);
        if (flower.isPresent()) {
            flowerRepo.delete(flower.get());
        } else {
            throw new FlowerDoesntExist();
        }
    }


    @Transactional
    public UpdateResponse updateResponse(UpdateRequest updateRequest) {
        Optional<Flower>flowerOptional= flowerRepo.findFlowerById(updateRequest.getId());
        if(flowerOptional.isPresent()){

            Flower flower = flowerOptional.get();


            if(updateRequest.getHeightInCm()!=0){
                flower.setHeightInCm(updateRequest.getHeightInCm());
                flowerRepo.saveAndFlush(flower);
            }
            return UpdateResponse.builder().flower(flower).build();


        }else{
            throw new NoUpdate();
        }


    }

    public Optional<Flower> getFlowerById(long id) {
        return flowerRepo.findById(id);
    }

}
