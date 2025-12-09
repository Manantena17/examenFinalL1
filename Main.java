
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        System.out.println("Projet de Manantena");
        System.out.println("Gestion des etudients  inferieur ou egale à 100");
        Scanner sc = new Scanner(System.in);

        String[] cours = {"Francais", "Math", "Malagasy", "Philo", "HG"};
        int coefcours = cours.length;


        int totalEt =100 ;

        String[] nom = new String[totalEt];
        float[][] studentNotes = new float[totalEt][coefcours];
        int[] coef = new int[coefcours];
        float[] moyenne = new float[totalEt];
        String[] studentMentions = new String[totalEt];

        int nombre;

        System.out.println("--- Saisie des Coefficients des Matières ---");
        for (int a = 0; a < coefcours; a++) {
            System.out.print("Entrez le coefficient de la matière " + cours[a] + ": ");
            coef[a] = sc.nextInt();
        }

        System.out.print("\nEntrez le nombre d'étudiants: ");
        nombre = sc.nextInt();
        sc.nextLine();

        if (nombre > totalEt) {
            System.out.println("Le nombre d'étudiants dépasse la capacité maximale (" + totalEt + ").");
            System.out.println("Veuillez relancer le programme avec un nombre d'étudiants inférieur ou égal à " + totalEt + ".");
            sc.close();
            return;
        }

        System.out.println("\n--- Saisie des Notes des Étudiants ---");
        for (int i = 0; i < nombre; i++) {
            System.out.print("Entrez le nom de l'étudiant " + (i + 1) + ": ");
            nom[i] = sc.nextLine();

            for (int j = 0; j < coefcours; j++) {
                System.out.print("Entrez la note de " + cours[j] + " pour " + nom[i] + ": ");
                studentNotes[i][j] = sc.nextFloat();
            }
            sc.nextLine();
            float totalPoints = 0;
            int totalCoeff = 0;
            for (int k = 0; k < coefcours; k++) {
                totalPoints =(totalPoints+ studentNotes[i][k] * coef[k]);
                totalCoeff = totalCoeff+coef[k];
            }

            if (totalCoeff > 0) {
                moyenne[i] = totalPoints / totalCoeff;
            } else {
                moyenne[i] = 0;
            }


            if (moyenne[i] >= 16) {
                studentMentions[i] = "Très Bien";
            } else if (moyenne[i] >= 14) {
                studentMentions[i] = "Bien";
            } else if (moyenne[i] >= 12) {
                studentMentions[i] = "Assez Bien";
            } else if (moyenne[i] >= 10) {
                studentMentions[i] = "Passable";
            } else {
                studentMentions[i] = "Ajourné";
            }

        }



        for (int i = 0; i < nombre - 1; i++) {
            for (int j = 0; j < nombre - 1 - i; j++) {
                if (moyenne[j] < moyenne[j + 1]) {

                    float tempmoyen = moyenne[j];
                    moyenne[j] = moyenne[j + 1];
                    moyenne[j + 1] = tempmoyen;


                    String tempName = nom[j];
                    nom[j] = nom[j + 1];
                    nom[j + 1] = tempName;


                    String tempMention = studentMentions[j];
                    studentMentions[j] = studentMentions[j + 1];
                    studentMentions[j + 1] = tempMention;


                    float[] tempNotes = studentNotes[j];
                    studentNotes[j] = studentNotes[j + 1];
                    studentNotes[j + 1] = tempNotes;
                }
            }
        }


        System.out.println("\n--- Résultats  ---");
        System.out.println("+------+--------------------+--------+------------+");
        System.out.printf("| %-4s | %-18s | %-6s | %-10s |\n", "Rang", "Nom", "Moyenne", "Mention");
        System.out.println("+------+--------------------+--------+------------+");

        for (int i = 0; i < nombre; i++) {
            System.out.printf("| %-4d | %-18s | %-6.2f | %-10s |\n", (i + 1),nom[i], moyenne[i], studentMentions[i]);
        }
        System.out.println("+------+--------------------+--------+------------+");

        sc.close();
    }
}
