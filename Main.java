// import java.util.Scanner;

class Main {
    public static void main(String[] args) {


        // MySystem system = new MySystem(args);
        // system.getOpts();

        // //args=arrray of strings
        // //if not enough arguments, print out error message, print instructions (usage)

        // // Scanner sc = new Scanner(System.in);
        // // String line = sc.nextLine();

        // String line = "";

        // if(args[0].charAt(1) == 'e') {
        //     line = ROT13.encode(args[1]);
        // }
        // else if(args[0].charAt(1) == 'd') {
        //     line = ROT13.decode(args[1]);
        // }
        
        //for example...
        // if (args[0] == "rot13") {
        //     line = ROT13(args[1], system.flags);
        // }

        // // String line = ROT13.encode(args[0]);
        // // String line2 = ROT13.decode(line);

        // //prints line
        // System.out.println(line);
        // // System.out.println(line2);
        


        //how you would share the arguments
        // ROT13.setFlags(system.flags);
        MD5 md5 = new MD5();
        md5.test();
    }
}


//message digest - md5
//memory digest

//lookup table

//for(char c : line.toCharArray())
//iterate through each letter
//if capital
//else if lower clase
//else (it's a symbol)
// a = 97
//(char - 'a' + 13) % 26 + 'a'

//IMPORTANT
//array[i] = (char)((array[i] - 'A' + 13) % 26 + 'A');

            // array[i] = 'x';
            
            // int asciiLetter = array[i];
            // System.out.println((int)array[i]); //explicit casting
            
            // System.out.println(asciiLetter);   //implicit casting
            
            // if((int)array[i] >= 97) {
            //     asciiLetter = (char)((array[i] - 'A' + 13) % 26 + 'A');
            // }


            // //lowercase
            
            // int rotLetter = ((asciiLetter - (int)'a' + 13) % 26 + (int)'a'); //can change if i want to do other rot

            // //uppercase
            // int rotLetter = ((asciiLetter - (int)'A' + 13) % 26 + (int)'A'); 

            // else:
            //     int(asciiLetter)

            // char rotChar = rotLetter;

            //check number of flags
            //excess input?
            //