class MD5 {
    // initializing static tables
    private int [] s = new int[] {
        7, 12, 17, 22,  7, 12, 17, 22,  7, 12, 17, 22,  7, 12, 17, 22,
        5,  9, 14, 20,  5,  9, 14, 20,  5,  9, 14, 20,  5,  9, 14, 20, 
        4, 11, 16, 23,  4, 11, 16, 23,  4, 11, 16, 23,  4, 11, 16, 23,
        6, 10, 15, 21,  6, 10, 15, 21,  6, 10, 15, 21,  6, 10, 15, 21 
    };

    private int [] k = new int[] {
        0xd76aa478, 0xe8c7b756, 0x242070db, 0xc1bdceee,
        0xf57c0faf, 0x4787c62a, 0xa8304613, 0xfd469501,
        0x698098d8, 0x8b44f7af, 0xffff5bb1, 0x895cd7be,
        0x6b901122, 0xfd987193, 0xa679438e, 0x49b40821,
        0xf61e2562, 0xc040b340, 0x265e5a51, 0xe9b6c7aa,
        0xd62f105d, 0x02441453, 0xd8a1e681, 0xe7d3fbc8,
        0x21e1cde6, 0xc33707d6, 0xf4d50d87, 0x455a14ed,
        0xa9e3e905, 0xfcefa3f8, 0x676f02d9, 0x8d2a4c8a,
        0xfffa3942, 0x8771f681, 0x6d9d6122, 0xfde5380c,
        0xa4beea44, 0x4bdecfa9, 0xf6bb4b60, 0xbebfbc70,
        0x289b7ec6, 0xeaa127fa, 0xd4ef3085, 0x04881d05,
        0xd9d4d039, 0xe6db99e5, 0x1fa27cf8, 0xc4ac5665,
        0xf4292244, 0x432aff97, 0xab9423a7, 0xfc93a039,
        0x655b59c3, 0x8f0ccc92, 0xffeff47d, 0x85845dd1,
        0x6fa87e4f, 0xfe2ce6e0, 0xa3014314, 0x4e0811a1,
        0xf7537e82, 0xbd3af235, 0x2ad7d2bb, 0xeb86d391
    };

    // c++ version 
    // initialize variables, reset for same result
    int a0;
    int b0;
    int c0;
    int d0;
    byte [] chunk;
    //uint8_t -> unsigned char (c++)
    //uint8_t = byte

    private void initialize() {
        a0 = 0x67452301;
        b0 = 0xefcdab89;
        c0 = 0x98badcfe;
        d0 = 0x10325476;
    }

    // Main function
    public String digest(String line) { //FILE IS TOO BIG!!!! STARWARS!!!!!!
        
        initialize();
        
        //loop:
        getNextChunk(line);
        //chop message into chunks of 512 bits (64 bytes)
        //(each pieces is called a chunk)
        //if chapped message is smaller than 512 bits, append 1 bit, pad rest with 0's
            //append length in bits to end of last chunk, inside if statement
        int A = a0;
        int B = b0;
        int C = c0;
        int D = d0;

        for (int i = 0; i < 64; i++) {
            int F;
            int g;
    
            if (0 <= i && i <= 15) {
                F = (B & C) | ((~ B) & D);
                g = i;
            } else if (16 <= i && i <= 31) {
                F = (D & B) | ((~D) & C);
                g = (5 * i + 1) % 16;
            } else if (32 ≤ i ≤ 47) {
                F = B ^ C ^ D;
                g = (3 * i + 5) % 16;
            } else if (48 ≤ i ≤ 63) {
                F = C ^ (B | (~ D));
                g = (7 * i) % 16;
            }

            F = F + A + k[i] + chunk[g];
            A = D;
            D = C;
            C = B;
            B = B + leftrotate(F , s[i]);
            //make function called left rotate
        }

        //add hash to result so far
        a0 += A;
        b0 += B;
        c0 += C;
        d0 += D;



        //process each chunk

    }

    //Utility functions
    private byte[] getNextChunk(String line) {
        static long i = 0;

        chunk = new byte[64]; 
            //default is 0, because it is pointing to something, it is not null
            //automatically zeroed out, not necessarily in every language

        for (int k = i; k < i + 64; k++) {
            if (k >= line.length()) {
                break;
            }
            chunk[k] = line.charAt(k);

        }

        if (line.length() - i >= 64) {
            i += 64;
        } else {
            i = line.length();
            
            //padding: adding a byte at the end
            padding(chunk, i);
        }
        //ternary operator, an operator like an = sign
        //c/c++
            //i = line.length() - i >= 64 ? i + 64 : line.length();
        //python
            //i = i+64 if len(line) - i >= 64 else len(line)
            //true compare false
        
        return chunk;
    }

    private byte[] padding(byte[] chunk, long len) {
        chunk[len % 64] = 0x80;
        //0b binary?, 0x denotes hex

        byte[] lb = new byte[] {
            (byte) len,
            (byte) (len >> 8),
            (byte) (len >> 16),
            (byte) (len >> 24),
            (byte) (len >> 32),
            (byte) (len >> 40),
            (byte) (len >> 48),
            (byte) (len >> 56)
        };

        //byte buffer
        for (int i = 0; i < 8;i ++) {
            chunk[56 + i] = lb[i];
        }
        //maybe reverse endian
        return chunk;
    }

    private int leftrotate(int x, int c) {
        return (x << c) | (x >> (32 - c));
    }
}
