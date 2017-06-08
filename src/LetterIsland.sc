import scala.collection.immutable.{HashMap, HashSet}

/*You are given string and number .

Consider a substring of string . For each position of string mark it
if there is an occurrence of the substring that covers the position.
More formally, position will be marked if there exists such index that:
 and . We will tell produce islands if all the marked positions form groups of contiguous positions.

  For example, if we have a string ababaewabaq the substring aba marks
  the positions 1, 2, 3, 4, 5, 8, 9, 10; that is XXXXXewXXXq (X denotes marked position).
  We can see 2 groups of contiguous positions, that is 2 islands. Finally, substring aba
  produces 2 islands in the string ababaewabaq.

Calculate and print the number of different substrings of string that produce exactly islands.

Input Format

The first line contains string . The string consists of lowercase letters only. The second line contains an integer .

Output Format

Output a single integer the answer to the problem.

  Sample Input

abaab
2

Sample Output

3

Explanation

All the suitable substrings are: a, ab, b.*/
import util.control.Breaks._


def boyer(str:String, k:Int):Int = {

  var x = 0
  var y = 1
  var round = 0
  while (true) {

    var curr = ""

    curr = str.substring(x, y);

    println("corrente " + curr);
    var p: StringBuilder = StringBuilder.newBuilder;
    p.append(str);
    val processed = new HashSet[String];
    var index = List.newBuilder
    var i = 0;
    var e = 1
    breakable {
      while (true) {
        if (e > str.length) {
          println("getting out")
          break
        }

        val aux = str.substring(i, e);
        if (aux == curr) {
          println("Found")
          p.replace(i, e, "X");
        }

        println(p)
        i = i + 1;
        e = e + 1;
      }
    }
    println("sum up")
    x = x + 1
    y = y + 1;
    if (y > str.length - 1) {
      round = round + 1
      x = round + 1
    }
    println("x :" + x + "y: " + y + "round: " + round );
    if (str.length - y < round) {
      println("saindo")
      break
    }
  }

  /*for (s <- str) {
    if (curr == s) {

    }
  }*/
    0;
}

boyer("abaab", 2)