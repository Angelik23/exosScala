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

    //balance("())(".toList)
    countChange(4,List(1,2))
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
    if (c == 0 | c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
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
    var total = 0

    def controle(chars: List[Char]) {
      val lettreAChecker = chars.head
      total += giveValue(lettreAChecker)
      if (chars.tail.nonEmpty & total >= 0) controle(chars.tail)
    }

    def giveValue(lettre: Char): Int = {
      if (lettre == '(') 1 else if (lettre == ')') -1 else 0
    }

    if (chars.isEmpty) {
      false
    } else {
      controle(chars)
      if (total == 0) true else false
    }
  }

  /**
    * Exercise 3
    * Write a recursive function that counts how many different ways you can make change for an amount,
    * given a list of coin denominations. For example, there are 3 ways to give change for 4
    * if you have coins with denomination 1 and 2: 1+1+1+1, 1+1+2, 2+2.
    * Hint: Think of the degenerate cases.
    * How many ways can you give change for 0 CHF(swiss money)?
    * How many ways can you give change for >0 CHF, if you have no coins?
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    var nbPossibilite = 0

    def calcul(monnaie: Int, coins: List[Int]) {
      if(coins.nonEmpty) {
        val reste = monnaie % coins.head // cas où on utilise un type de monnaie au max
        if (reste == 0 ){
          nbPossibilite += 1
          if (coins.tail.length >=1) {
            calcul(monnaie, coins.tail)
          }
        } else {
          calcul(reste, coins.tail)
        //  calculAvecReste(monnaie, coins)
        }
      }
     }

 /*   def calculAvecReste(monnaie : Int, coins : List[Int]) : Int = {

         }*/

    if (money == 0 | coins.isEmpty) 0
    else {
      if (money % coins.head != 0) {
        // pour vérifier qu'il est possible de rendre la monnaie vis à vis du type d'argent qu'on a
        countChange(money, coins.tail)
      } else { // on peut rendre la monnaie
        calcul(money, coins)
        println(nbPossibilite)
        nbPossibilite
      }


    }
  }
}
