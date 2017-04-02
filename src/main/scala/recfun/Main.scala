package recfun

object Main {
  def main(args: Array[String]) {
    /*
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    */

    balance("())(".toList)
  }

  /**
    * Exercise 1
    * The numbers at the edge of the triangle are all 1,
    * and each number inside the triangle is the sum of the two numbers above it.
    * Write a function that computes the elements of Pascal’s triangle by means of a recursive process.
    * Do this exercise by implementing the pascal function in Main.scala,
    * which takes a column c and a row r, counting from 0 and returns the number at that spot in the triangle.
    * For example, pascal(0,2)=1,pascal(1,2)=2 and pascal(1,3)=3.
    * 1
    * 1 1
    * 1 2 1
    * 1 3 3 1
    * 1 4 6 4 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 | c == r) 1 else (pascal(c - 1, r - 1) + pascal(c, r - 1))
  }

  /**
    * Exercise 2
    * Write a recursive function which verifies the balancing of parentheses in a string, which we represent as a List[Char] not a String.
    * For example, the function should return true for the following strings:
    * *
    * (if (zero? x) max (/ 1 x))
    * I told him (that it’s not (yet) done). (But he wasn’t listening)
    * *
    * The function should return false for the following strings:
    * :-)
    * ())(
    * The last example shows that it’s not enough to verify that a string contains the same number of opening and closing parentheses.
    * *
    *chars.isEmpty: Boolean returns whether a list is empty
    *chars.head: Char returns the first element of the list
    *chars.tail: List[Char] returns the list without the first element
    * Hint: you can define an inner function if you need to pass extra parameters to your function.
    * *
    * Testing: You can use the toList method to convert from a String to aList[Char]: e.g. "(just an) example".toList.
    */
  def balance(chars: List[Char]): Boolean = {
    var finalValue = 0
    var total = 0

    def controle(chars: List[Char]) {
      var lettreAChecker = chars.head
      total += giveValue(lettreAChecker)
      if (chars.tail.length > 0 & total >= 0) controle(chars.tail)
    }

    def giveValue(lettre: Char): Int = {
      if (lettre == '(') 1 else if (lettre == ')')  -1 else  0
  }

    if (chars.isEmpty) {
      false
    } else {
      controle(chars)
      if(total == 0) true else false
    }
}

/**
  * Exercise 3
  */
def countChange (money: Int, coins: List[Int] ): Int = ???
}
