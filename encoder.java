import java.util.*;

public class encoder{
    private ArrayList<Character> copy = new ArrayList<Character>(){{
        add('a');add('b');add('c');add('d');add('e');add('f');add('g');add('h');
        add('i');add('j');add('k');add('l');add('m');add('n');add('o');add('p');
        add('q');add('r');add('s');add('t');add('u');add('v');add('w');add('x');
        add('y');add('z');}};
    private Map<Character,Character> map = new HashMap<Character,Character>();
    private ArrayList<Character> encryptedQuote = new ArrayList<Character>();
    private ArrayList<Character> mapped = new ArrayList<Character>();
    private boolean showKey;
    public encoder(String quote, boolean showKey){
        int random;
        ArrayList<Character> start = new ArrayList<Character>(){{
        add('a');add('b');add('c');add('d');add('e');add('f');add('g');add('h');
        add('i');add('j');add('k');add('l');add('m');add('n');add('o');add('p');
        add('q');add('r');add('s');add('t');add('u');add('v');add('w');add('x');
        add('y');add('z');}};
        do{
            random = (int)(Math.random()*start.size());
            mapped.add(start.remove(random));
        } while(start.size()>0);
        for(int i=0;i<26;i++)map.put(copy.get(i),mapped.get(i));
        encryptedQuote = encrypt(convToChar(quote.toLowerCase()));
        this.showKey=showKey;
    }
    public ArrayList<Character> convToChar(String str){
        ArrayList<Character> conv = new ArrayList<Character>();
        for(int i=0;i<str.length();i++){
            if(!str.substring(i,i+1).equals(" ") && !str.substring(i,i+1).equals(".") && !str.substring(i,i+1).equals(",") && !str.substring(i,i+1).equals("\'")) conv.add(str.charAt(i));
        }
        return conv;
    }
    public ArrayList<Character> encrypt(ArrayList<Character> list){
        ArrayList<Character> encryptedQuote = new ArrayList<Character>();
        for (int i=0;i<list.size();i++)encryptedQuote.add(map.get(list.get(i)));
        return encryptedQuote;
    }
    @Override
    public String toString(){
        String ret = "",key;
        int count=0;
        for(int i=0;i<encryptedQuote.size();i++){
            if((i)%5==0&&!(i==0))ret+=" ";
            ret+=encryptedQuote.get(i);
        }
        if(showKey) ret += "\n\n" + "Key:\n" + copy + "\n" + mapped;
        return ret;
    }
}