

class ROT13 {

    public static String encode(String line) {
        char[] array = line.toCharArray();


        for(int i = 0; i < array.length; i++) {
            if(array[i] >= 'a' && array[i] <= 'z'){
                array[i] = (char)((array[i] - 'a' + 13) % 26 + 'a');
            }
            else if (array[i] >= 'A' && array[i] <= 'Z'){
                array[i] = (char)((array[i] - 'A' + 13) % 26 + 'A');
            }
        }

        return String.valueOf(array);
    }

    public static String decode(String line) {
        char[] array = line.toCharArray();

        for(int i = 0; i < array.length; i++) {
            if(array[i] >= 'a' && array[i] <= 'z'){
                array[i] = (char)((array[i] - 'a' - 13 + 26) % 26 + 'a');
            }
            else if (array[i] >= 'A' && array[i] <= 'Z'){
                array[i] = (char)((array[i] - 'A' - 13 + 26) % 26 + 'A');
            }
        }
        return String.valueOf(array);

    }

}