package ro.mycode.crudapp.masina.view;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.mycode.crudapp.masina.models.Masina;
import ro.mycode.crudapp.masina.repository.MasinaRepo;

import java.util.Optional;
import java.util.Scanner;

@Service
public class View {

    private Scanner scanner;
    private MasinaRepo masinaRepo;

    public View(MasinaRepo masinaRepo){
        this.masinaRepo=masinaRepo;
        this.scanner= new Scanner(System.in);
    }

    public void meniu(){
        System.out.println("Apasa tasta 1 pentru a afisa toate masinile");
        System.out.println("Apasa tasta 2 pentru a adauga o masina");
        System.out.println("Apasa tasta 3 pentru a sterge o masina");
        System.out.println("Apasa tasta 4 pentru a actualiza pretul masinii");
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
                case 2:adaugareMasina();
                    break;
                    //stergere
                case 3: stergereMasina();
                    break;
                case 4: updateMasina();
                break;

                default:
                    System.out.println("Alegerea este gresita");
                    break;
            }

        }
    }
    private  void  afisare(){
        this.masinaRepo.findAll().forEach(masina->{
            System.out.println(masina);
        });
    }
    @Transactional
    public void adaugareMasina(){
        System.out.println("Marca");
        String marca=scanner.nextLine();
        System.out.println("Model (anul)");
        int model=Integer.parseInt(scanner.nextLine());
        System.out.println("Pret: ");
        int pret=Integer.parseInt(scanner.nextLine());

        Masina masina=Masina.builder()
                .marca(marca)
                .model(model)
                .pret(pret)
                .build();

        masinaRepo.saveAndFlush(masina);

        System.out.println("Masina a fost adaugata cu succes");

    }

    @Transactional
    public void stergereMasina(){
        System.out.println("Introduceti marca si modelul (anul): ");
        System.out.println("marca= ");
        String marca=scanner.nextLine();
        System.out.println("modelul(anul)=");
        int model=Integer.parseInt(scanner.nextLine());
        Optional<Masina> masina=masinaRepo.findMasinaByMarcaAndModel(marca,model);
        if(masina.isPresent()){
            masinaRepo.delete(masina.get());
            System.out.println("MAsina a fost stearsa");
        }else{
            System.out.println("Masina nu exista");
        }

    }

    @Transactional
    public void updateMasina(){
        System.out.println("Introduceti marca si modelul (anul): ");
        System.out.println("marca= ");
        String marca=scanner.nextLine();
        System.out.println("modelul(anul)=");
        int model=Integer.parseInt(scanner.nextLine());
        Optional<Masina> masina=masinaRepo.findMasinaByMarcaAndModel(marca,model);
        if(masina.isPresent()){
            System.out.println("Introduceti noul pret: ");
            int pretNou=Integer.parseInt(scanner.nextLine());


            Masina masina1 = masina.get();

            masina1.setPret(pretNou);

            masinaRepo.saveAndFlush(masina1);
            System.out.println("S-a updatat");
        }else{
            System.out.println("Masina nu exista");
        }

    }

}
