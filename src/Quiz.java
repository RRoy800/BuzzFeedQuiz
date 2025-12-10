
/*
 * Irene Feng Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;

public class Quiz {
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) throws Exception {
                // Create Categories
                Category tesla = new Category("Tesla Model Y",
                                "MUST BE FILLED IN");
                Category ford = new Category("Ford F-150", "You are very competitive "
                                + "MUST BE FILLED IN");
                Category merc = new Category("Mercedes Maybach 600",
                                "MUST BE FILLED IN");
                Category lambo = new Category("Lamborghini Aventador SVJ", "MUST BE FILLED IN");
                // Create Questions
                Question q1 = new Question("Which of these shoes are you wearing on a given day?");
                // Attach Answers to Questions
                q1.possibleAnswers[0] = new Answer("Boots", ford);
                q1.possibleAnswers[1] = new Answer("Slip-ons" ,tesla);
                q1.possibleAnswers[2] = new Answer("Sneakers", lambo);
                q1.possibleAnswers[3] = new Answer("Loafers", merc);

                Question q2 = new Question("What is your ideal pet of these options?");
                // Attach Answers to Questions
                q2.possibleAnswers[0] = new Answer("Horse", ford);
                q2.possibleAnswers[1] = new Answer("Rottweiler" ,merc);
                q2.possibleAnswers[2] = new Answer("Shark", lambo);
                q2.possibleAnswers[3] = new Answer("No pets", tesla);
               
                Question q3 = new Question("How would your friends describe you?");
                // Attach Answers to Questions
                q3.possibleAnswers[0] = new Answer("Smart" ,merc);
                q3.possibleAnswers[1] = new Answer("Fun", lambo);
                q3.possibleAnswers[2] = new Answer("Tough guy", ford);
                q3.possibleAnswers[3] = new Answer("Tech-savvy", tesla);

                 Question q4 = new Question("Choose a road trip snack and drink.");
                // Attach Answers to Questions
                q4.possibleAnswers[0] = new Answer("Energy Drink + Protein Bar", lambo);
                q4.possibleAnswers[1] = new Answer("Coke + Beef Jerky", ford);
                q4.possibleAnswers[2] = new Answer("Coffer + Croissant" ,merc);
                q4.possibleAnswers[3] = new Answer("Soy Late + Trail Mix", tesla);

                Question q5 = new Question("What music are you listening to?");
                // Attach Answers to Questions
                q5.possibleAnswers[0] = new Answer("Country", ford);
                q5.possibleAnswers[1] = new Answer("Pop" ,tesla);
                q5.possibleAnswers[2] = new Answer("Classical", merc);
                q5.possibleAnswers[3] = new Answer("Rock", lambo);

                Question q6 = new Question("Which of these if your favotie sport?");
                // Attach Answers to Questions
                q6.possibleAnswers[0] = new Answer("Formula 1", lambo);
                q6.possibleAnswers[1] = new Answer("Football", ford);
                q6.possibleAnswers[2] = new Answer("Hiking", tesla);
                q6.possibleAnswers[3] = new Answer("Golf" ,merc);

                Question q7 = new Question("What is closest to your typical weekend activity?");
                // Attach Answers to Questions
                q7.possibleAnswers[0] = new Answer("Going to a party", lambo);
                q7.possibleAnswers[1] = new Answer("Hosting a dinner" ,merc);
                q7.possibleAnswers[2] = new Answer("Binging a TV show", tesla);
                q7.possibleAnswers[3] = new Answer("BBQing", ford);

                Question q8 = new Question("Which of these is your favorite holiday?");
                // Attach Answers to Questions
                q8.possibleAnswers[0] = new Answer("4th of July", ford);
                q8.possibleAnswers[1] = new Answer("Thanksgiving" ,merc);
                q8.possibleAnswers[2] = new Answer("Haloween", tesla);
                q8.possibleAnswers[3] = new Answer("Your Birthday", lambo);

                Question q9 = new Question("Which of these books do you most like?"); //MAKE TIEBRAKER
                // Attach Answers to Questions
                q9.possibleAnswers[0] = new Answer("The Hunt for Red October", ford);
                q9.possibleAnswers[1] = new Answer("The Godfather" ,merc);
                q9.possibleAnswers[2] = new Answer("To Kill a Mockingbird", tesla);
                q9.possibleAnswers[3] = new Answer("Moneyball1", lambo);
                // ... more questions here

                // For each question, ask, read input, store answer.
                gameIntro();
                Question[] qList = { q1, q2, q3, q4, q5, q6, q7, q8, q9};
                for (Question q : qList) {
                        Category c = q.ask(sc);
                        c.points++;
                }
                // Get most common category from the questions asked
                // Return Category
                Category[] cList = { tesla, ford, merc, lambo };
                // these need to be in the same order or the points will be incorrect!
                int index = getMostPopularCatIndex(cList);
                System.out.println("The car that best suits you is The " + cList[index].label + ". ");
                System.out.println(cList[index].description);

        }

        public static void gameIntro() {
                // requires 1 to keep going
                System.out.println("Which Car Best Suits You?");
                System.out.println("You get to choose numbers 1-4 for every question. Enter '1' to play!");
                int play = sc.nextInt();
                if (play != 1) {
                        System.out.println("Unidentifiable input. Please enter '1' to play"); //USE THIS CODE TO FIX ERRORS DURING GAME
                        gameIntro();
                }
        }

        // returns the index that is the max
        // the tie breaker is the first Category that has the count is the "max" :/ 
        public static int getMostPopularCatIndex(Category[] counts) {
                int maxCount = 0;
                int maxIndex = 0;
                for (int i = 0; i < counts.length; i++) {
                        if (counts[i].points > maxCount) {
                                maxCount = counts[i].points;
                                maxIndex = i;
                        }
                }
                return maxIndex;
        }
}
