import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        Scanner sc = new Scanner(System.in);

        dict.setfirstHash();

        //The hash function is : f(x) = string.length() or the length of the word

        dict.addWord("Hello", "A greeting");
        dict.addWord("Hi", "A short form of greeting, usually over text");
        dict.addWord("Hilarious", "Funny");

        while (true) {
            System.out.println("\n----INDEX----");
            System.out.println("1. Enter the word");
            System.out.println("2. Search the word");
            System.out.println("3. Update the word");
            System.out.println("4. Delete the word");
            System.out.println("5. Display the entire dictionary");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if(choice == 6){
                break;
            }

            switch(choice){
                case 1: 
                    System.out.print("Enter the word: ");
                    String word = sc.next();
                    System.out.print("Enter the meaning: ");
                    String meaning = sc.nextLine()+sc.nextLine();
                    dict.addWord(word, meaning);
                    break;

                case 2:
                    System.out.print("Enter the word: ");
                    String searchWord = sc.next();
                    dict.searchWord(searchWord);
                    break;

                case 3:
                    System.out.print("Enter the word whose meaning you wish to update: ");
                    String updateWord = sc.next();
                    System.out.print("Enter the meaning: ");
                    String updateMeaning = sc.nextLine()+sc.nextLine();
                    dict.updateWord(updateWord, updateMeaning);       
                    break;

                case 4:
                    System.out.print("Enter the word: ");
                    String deleteWord = sc.next();
                    dict.deleteWord(deleteWord);
                    break;

                case 5:
                    System.out.println("---The Entire Dictionary---");
                    dict.displayEntireDictionary();
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        sc.close();
    }
}