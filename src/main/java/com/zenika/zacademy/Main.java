package com.zenika.zacademy;

import com.zenika.zacademy.display.Displayer;
import com.zenika.zacademy.display.TerminalDisplayer;
import com.zenika.zacademy.exception.NotFoundException;
import com.zenika.zacademy.repository.InMemoryPersonRepository;
import com.zenika.zacademy.repository.InMemoryPromotionRepository;
import com.zenika.zacademy.repository.PersonRepository;
import com.zenika.zacademy.repository.PromotionRepository;
import com.zenika.zacademy.service.PersonService;
import com.zenika.zacademy.service.PromotionService;

import java.util.Scanner;

public class Main {

    private static final PersonRepository personRepository = new InMemoryPersonRepository();
    private static final PromotionRepository promotionRepository = new InMemoryPromotionRepository(personRepository);
    private static final PromotionService promotionService = new PromotionService(promotionRepository);
    private static final PersonService personService = new PersonService(personRepository);
    private static final Displayer displayer = new TerminalDisplayer();

    public static void main(String[] args) {

        // Début du programme
        displayer.print("""
                Vous pouvez rechercher:
                  - Un formateur ou un élève via un nom et / ou prénom (insensible à la casse)
                  - Une promotion via un numéro de promotion
                  - La liste des promotions en tapant promotions
                    """);

        String userSearch = null;
        try (Scanner scanner = new Scanner(System.in)) {
            boolean isRunning = true;
            while (isRunning) {
                Thread.sleep(1000);
                displayer.print("Veuillez taper votre recherche ou q pour sortir:");

                try {
                    // Cas d'une recherche par numéro de promotion
                    if (scanner.hasNextInt()) {
                        userSearch = String.valueOf(scanner.nextInt());
                        displayer.print(promotionService.findById(Integer.parseInt(userSearch)));
                        continue;
                    }

                    userSearch = scanner.nextLine();

                    // Permet de corriger les soucis de lignes vides
                    // Exemple tapez 90, puis q. Vous verrez que la prochaine ligne vaudra une chaîne de caractères vide ...
                    if (userSearch.equals("")) {
                        userSearch = scanner.nextLine();
                    }

                    if (userSearch.equals("q")) {
                        displayer.print("Merci d'avoir utilisé le service zAcademyAnnuaire. Des bsx");
                        isRunning = false;
                        continue;
                    }

                    // Cas d'affichage des promotions
                    if (userSearch.equals("promotions")) {
                        displayer.print(promotionService.findAll());
                        continue;
                    }

                    // cas d'affichage d'une personne par nom
                    displayer.print(personService.findByName(userSearch));
                } catch (NotFoundException exception) {
                    System.out.printf("Aucune donnée trouvée dans les données %s avec la recherche %s %n", exception.className, userSearch);
                }
            }
        } catch (Exception exception) {
            displayer.print("Il semble y avoir un souci, arrêt du programme. :/");
        }
    }
}
