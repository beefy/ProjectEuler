package main

import (
	"fmt"
	"strconv"
	"math"
)

func main() {
	digit_count := float64(3)
	largest := 0
	for x := 0; x < int(math.Pow(10, digit_count)); x++ {
		for y := 0; y < int(math.Pow(10, digit_count)); y++ {
			product := x * y
			if product > largest && is_palindrome(product) {
				largest = product
			}
		}
	}
	fmt.Println(largest)
}

func is_palindrome(n int) bool {
	arr := []rune(strconv.Itoa(n))
	midpoint := len(arr) / 2
	for i := 0; i < midpoint; i++ {
		if arr[i] != arr[len(arr)-1-i] {
			return false
		}
	}

	return true
}
