from typing import List
import math


def sieve_of_eratosthenes(n: int) -> List[int]:
    sieve = range(n)
    for i in range(2, math.ceil(math.sqrt(n))):
        criteria = lambda y: y == i or y % i != 0
        sieve = list(filter(criteria, sieve))
    
    return sieve


if __name__ == "__main__":
    seive = sieve_of_eratosthenes(500000)
    print(seive[10001])
