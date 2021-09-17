


import sys

#has to be a 4 byte int
def swap_endian(num):
    return (
        (num >> 24) & 0x000000FF |
        (num >> 8) & 0x0000FF00 |
        (num << 8) & 0x00FF0000 |
        (num << 24) & 0xFF000000
    )

if len(sys.argv) > 1:
    print(swap_endian(int(sys.argv[1])))
