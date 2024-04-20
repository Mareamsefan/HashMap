import java.util.*;

public class WordHash {

/*** Oppdaterte versjon av WordBST/WordHash som benytter heller javas bibliotek for HashMap-datastrukturen***/
    HashMap<String, Integer> H;

    public WordHash()
    {
       H = new HashMap<>();
    }

    public int size()
    {
       return H.size();
    }


    /*** oppgave 2 ***/
    private void insert(String ord) {
        H.put(ord, H.getOrDefault(ord, 0) + 1);
    }



    public void search(String ord)
    {
        /*** oppgave 3 ***/
      if(H.containsKey(ord)){
          System.out.println(ord + " :" + H.get(ord));
      }
      else {
          System.out.println("The tree does not contain the word");
      }

    }

    // kan løse det med sortering av verdiene på to måter:
    // legge til nøkler i en liste:
   /* public void print() {

        List<String> wordList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : H.entrySet()) {
            wordList.add(entry.getKey());
        }
        Collections.sort(wordList);
        for(String word: wordList){
            System.out.println(word + ": " + H.get(word));
        }
    }*/
    // legge inn verdier og nøkler i en treemap:
    //Valgte denne metoden, fordi dette er en mer effektiv måte for sortering
    //dersom verdiene med data øker.
    public void print() {
        TreeMap<String, Integer> sortedMap = new TreeMap<>(H);
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey()+ ": " + entry.getValue());
        }
    }

    // main(): Testprogram
    public static void main (String argv[])
    {

        Scanner scan = new Scanner(System.in);
        System.out.print("File? ");
        String fileName = scan.next();


        WordReader wR = new WordReader(fileName);
        WordHash wBST = new WordHash();

        String ord = wR.nextWord();
        while (ord != null)
        {
            wBST.insert(ord);
            ord = wR.nextWord();
        }

        System.out.println(wBST.size() + " unique words " +
                "read from file " + fileName);

        int valg = 0;
        while(valg != 3)
        {
            System.out.print("\n1:Search, 2:Print, 3:Quit ? ");
            valg = scan.nextInt();
            if (valg == 1)
            {
                System.out.print("Search for? ");
                ord = scan.next();
                wBST.search(ord.toLowerCase());
            }
            else if (valg == 2)
                wBST.print();
        }
    }
}
