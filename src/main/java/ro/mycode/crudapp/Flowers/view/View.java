package ro.mycode.crudapp.Flowers.view;


import org.springframework.stereotype.Service;
import ro.mycode.crudapp.Flowers.exceptions.FlowerListEmpty;
import ro.mycode.crudapp.Flowers.models.Flower;
import ro.mycode.crudapp.Flowers.service.FlowerService;

import java.util.List;
import java.util.Scanner;

@Service
public class View {

    private Scanner scanner;
private FlowerService flowerService;
private Flower flower;

    public View(FlowerService flowerService){
        this.flowerService = flowerService;
        this.scanner= new Scanner(System.in);
    }

    public void meniu(){
        System.out.println("Apasa tasta 1 pen6tru a afisa toate produsele");
        System.out.println("Apasa tasta 2 pentru a adauga un produs");
        System.out.println("Apasa tasta 3 pentru a sterge un produs");
        System.out.println("Apasa tasta 4 pentru a actualiza marca  produsului ");
    }


    public void play(){
        int alegere=0;
        boolean running =true;


        while (running){
            meniu();
            alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                //afisare
                case 1:afisare();
                    break;
                    // adaugare
                case 2://adaugaremakeup();
                    break;
                    //stergere
                case 3:// stergeremakeup();
                    break;
                case 4: //updatemakeup();
                break;

                default:
                    System.out.println("Alegerea este gresita");
                    break;
            }

        }
    }
    private  void  afisare(){
        try {
            List<Flower> flower = flowerService.getAllFlowers();
            flower.forEach(masian -> {
                System.out.println(masian);
            });
        } catch (FlowerListEmpty flowerListEmpty) {
            System.out.println(flowerListEmpty.getMessage());
        }
    }




}
