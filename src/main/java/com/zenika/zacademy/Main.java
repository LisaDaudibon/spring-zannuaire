package com.zenika.zacademy;

import com.zenika.zacademy.display.Displayer;
import com.zenika.zacademy.display.TerminalDisplayer;
import com.zenika.zacademy.exception.NotFoundException;
import com.zenika.zacademy.repository.InMemoryRepository;
import com.zenika.zacademy.service.PersonService;
import com.zenika.zacademy.service.PromotionService;

import java.util.Scanner;

public class Main {

    private static final InMemoryRepository repository = new InMemoryRepository();

    private static final PersonService personService = new PersonService(repository);

    private static final PromotionService promotionService = new PromotionService(repository);

    private static final Displayer displayer = new TerminalDisplayer();

    public static void main(String[] args) throws InterruptedException {

        // Début du programme
        displayer.print("""
                Vous pouvez rechercher:
                  - Un formateur ou un élève via un nom et / ou prénom (insensible à la casse)
                  - Une promotion via un numéro de promotion
                  - La liste des promotions en tapant promotions
                    """);

        try (Scanner scanner = new Scanner(System.in)) {
            boolean isRunning = true;
            while (isRunning) {
                Thread.sleep(1000);
                String userSearch = null;
                displayer.print("Veuillez taper votre recherche ou q pour sortir:");

                // Cas d'une recherche par numéro de promotion
                if (scanner.hasNextInt()) {
                    displayer.print(promotionService.findById(scanner.nextInt()));
                    continue;
                }

                userSearch = scanner.nextLine();

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
            }
        } catch (NotFoundException exception) {
            System.out.printf("Aucune donnée trouvée pour %s %n", exception.className);
        } catch (Exception exception) {
            displayer.print("Il semble y avoir un souci, veuillez réessayer. :/");
        }
    }
}
