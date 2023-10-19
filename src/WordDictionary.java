public class WordDictionary {

    class Hash{

        private String word;
        private String meaning;
        private Hash next;

        public Hash(String word, String meaning) {
            this.word = word;
            this.meaning = meaning;
            this.next = null;
        }

    }

    private Hash[] firstHash = new Hash[26]; 

    void setfirstHash(){
        for(int i = 0; i < 26; i++){
            firstHash[i] = null;
        }
    }

    public void addWord(String word, String meaning) {
        int index = hashFunction(word);
        Hash h = new Hash(word, meaning);
        if(firstHash[index] == null){
            firstHash[index] = h;
        }
        else{
            Hash temp = firstHash[index];
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = h;
        }


    }

    public void searchWord(String searchWord) {
        boolean matchFound = false;
        int index = hashFunction(searchWord);
        Hash temp = firstHash[index];
        while(temp != null){
            if(temp.word.equalsIgnoreCase(searchWord)){
                matchFound = true;
                System.out.println("The meaning of your word is : "+temp.meaning);
            }
            temp = temp.next;
        }

        if(!matchFound){
            System.out.println("Your word wasn't found, please add it to the dictionary!");
        }

    }

    public void updateWord(String updateWord, String updateMeaning) {
        boolean matchFound = false;
        int index = hashFunction(updateWord);
        Hash temp = firstHash[index];

        while(temp != null){
            if((temp.word).equalsIgnoreCase(updateWord)){
                matchFound = true;
                System.out.println("Found Word and updated the meaning!");
                temp.meaning = updateMeaning;
                break;
            }
            temp = temp.next;
        }

        if(!matchFound){
            System.out.println("Your word wasn't found, please add it to the dictionary!");
        }


    }

    public void deleteWord(String deleteWord) {

        int index = hashFunction(deleteWord);
        
        Hash temp = firstHash[index], beforeTemp = firstHash[index];
        Boolean matchFound = false;

        if (temp.word.equals(deleteWord)){
            firstHash[index] = firstHash[index].next;
            System.out.println("Element Deleted!");
            matchFound=true;
            temp=null;

        }

        while (temp != null && !(matchFound)) {
            if (temp.word == deleteWord) {
                beforeTemp.next=temp.next;
                System.out.println("Element Deleted!");
                matchFound = true;
                break;

            } else {              
                beforeTemp = temp;
                temp = temp.next;

            }

        }

        if (matchFound == false) {
            System.out.println("Match Not Found!");
        }

    }

    public void displayEntireDictionary() {
        for(int i = 0; i < 26; i++){
            Hash temp = firstHash[i];
            if(temp == null){
                continue;
            }
            while(temp != null){
                System.out.print(temp.word +" : "+temp.meaning+" ---> ");
                temp = temp.next;
            }
            System.out.print("null");
            System.out.println();
        }
    }

    public int hashFunction(String word){
        return word.length();
    }
}

