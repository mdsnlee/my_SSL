import java.util.*;


// args=[-l, -a,home,projects]

// flags={l, a}
// args[home, projects]
// //iterate through string until no dash in the beginning
//for each string iterated through (with dash in front):
    //go for the string[1:]
    //add to lookup table (aka make it true)
//return the flags
//remove the flags from args?

class MySystem {

    private String[] args;
    private Map<Character, Boolean> flags = new HashMap<Character, Boolean>();
    int args_start = 0;

    public MySystem (String[] s) { //constructor
        args = s;
    }

    public void getOpts() {

        int i = 0;
        while (i < args.length && args[i].charAt(0) == '-') {
            System.out.println(args[i]);

            for(int k = 1; k < args[i].length(); k++) {
                flags.put(args[i].charAt(k), true);
            }
            i++;
        }
        System.out.println(flags);

        String[] temp = new String[args.length - i];
        System.arraycopy(args, i, temp, 0, args.length - i);
        args = temp;

        for (int k = 0; k < args.length; k++) {
            System.out.println(args[k]);
        }
    }
}

//javac Main.java && java Main -AS -DA hello cow there whoa hello


//java Main -larasd hello cow

// flags['c']
// flags.get('c')


// for (int i = 0; i < args.length; i++) {
//      if(args[i].charAt(0) == '-') {
//          System.out.println("True");
//      }
//      System.out.println(args[i].charAt(0));
// }


//looking how many times it has to loop through
//duplicates don't matter
//add it the map
    //

    