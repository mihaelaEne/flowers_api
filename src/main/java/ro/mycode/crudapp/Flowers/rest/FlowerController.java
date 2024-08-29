package ro.mycode.crudapp.Flowers.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.crudapp.Flowers.dtos.*;
import ro.mycode.crudapp.Flowers.models.Flower;
import ro.mycode.crudapp.Flowers.service.FlowerService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/flower")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class FlowerController {


    private FlowerService flowerService;

    @GetMapping("/allFlowers")
    public ResponseEntity<List<Flower>> getAllCats() {
        List<Flower> flower = flowerService.getAllFlowers();
        return   new ResponseEntity<>(flower, HttpStatus.OK);
    }


    @PostMapping("/createFlower")
    public ResponseEntity<CreateResponse>addFlower(@RequestBody CreateRequest createRequest) {
        CreateResponse createResponse = flowerService.addFlower(createRequest);
        return   new ResponseEntity<>(createResponse,HttpStatus.CREATED);
    }
    @PutMapping("/updateFlowerCM")
    public ResponseEntity<UpdateResponse>updated(@RequestBody UpdateRequest updateRequest) {
        UpdateResponse updateResponse = flowerService.updateResponse(updateRequest);
        return new ResponseEntity<>(updateResponse,HttpStatus.ACCEPTED);
    }



    @DeleteMapping("delete")
    public ResponseEntity<Void>getFindById(@RequestParam long id){
        flowerService.deleteFlower(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping("/flowerById")
    public ResponseEntity<Flower> getCatById(@RequestParam long id){
        Optional<Flower> cat = flowerService.getFlowerById(id);
        return cat.map(value->new ResponseEntity<>(value,HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

}
