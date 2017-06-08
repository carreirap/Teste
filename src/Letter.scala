import scala.collection.immutable.HashSet
import scala.collection.mutable.ListBuffer

/**
  * Created by pCarreira on 02/06/2017.
  */
object Letter {

  import util.control.Breaks._

  def main( args:Array[String] ):Unit = {
    val total = rodar("abaab",2)
    println(total)
  }

  def rodar(str:String, k:Int): Int = {
    var x = 0
    var y = 1
    var round = 0
    var total = 0;
    val cache = collection.mutable.TreeSet[String]()
    breakable {
      while (true) {

        var curr = ""

        curr = str.substring(x, y);
        //println("corrente -> " + curr);
        var a = cache.add(curr)

        if (a == true) {
          val newString = boyer2(str, curr);
          if (!newString.equals(""))
            total = total + accountIsland (newString, k)
        }
        y = y + 1;

        if (y > str.length) {
          x = x + 1
          y = x + 1;
          round = round + 1;
        }
        if (x > str.length || y > str.length ) break;
      }
    }
    total;
  }
  def boyer2(str:String, word:String):String = {
    var f = 0
    var s = 0
    var i = 0
    var p: StringBuilder = StringBuilder.newBuilder;
    p.append(str);
    var list = new ListBuffer[Int]()
    f = word.length - 1;
    var flagSaltar = false;
   // var cont = 0
    breakable {
      while (true) {
        //println(word)

        if (f == s) {
          //println("s: " + s + " i: " + i)
          if (str.charAt(i) == word.charAt(s)) {
            //println("Palavra encontrada");
            list += i
          }
        } else {
          breakable {
            val initial = i
            var found = 0
            var tmpList = new ListBuffer[Int]()
            for (end <- f to s by -1) {
              //println("End-> " + end + " str: " + str)
              if (str.charAt(end + i) == word(end)) {
                //println("F-> " + end + "  Found str.charAt(" + (end + i) + "): " + str.charAt(end + i) + " word(" + end + ") " + word(end))
                found = found + 1
                tmpList += (end + i)
              } else {
                //println("NOT F-> " + end + "  NOT Found str.charAt(" + (end + i) + "): " + str.charAt(end + i) + " word(" + end + ") " + word(end))
                i = end + i - 1;
                //println(i + "==" + initial)
                if (i == initial) {
                  i = i + 1;
                  //println(i + "==" + initial)
                }
                if (i < initial) {
                  i = initial + 1;
                }
                flagSaltar = true
                //System.exit(0);
                break
              }
            }
            //println("found: " + found + " f: " + f + "i: " + i)
            if (found == (f + 1)) {
              //List(0,12,30,4).foldLeft(mask)((s, i) => s.updated(i, '1'))
              list.appendAll(tmpList)
            }
          }

        }
        if (flagSaltar == false)
          i = i + 1;
        flagSaltar = false
        //println("sai i " + i)

        //println("f " + f)
        if (i + f > str.length - 1) break


      }

    }

    val newString = list.foldLeft(p.toString())((s, i) => s.updated(i, 'X'));
    //println(newString)
    if (list.size > 0)
      newString;
    else
      "";
  }



  def accountIsland (str:String, maxIsland:Int): Int = {
    import java.util.regex.Pattern
    val r2th = "(X{1,})"
    var count = 0
    //print("String = >" + str)
    val pat2 = Pattern.compile(r2th)
    val m2 = pat2.matcher(str)
    breakable {
      while (m2.find) {
        try {
          count += 1;
          if (count > maxIsland) {
            count = 0;
            break;
          }
        } catch {
          case e: Exception =>
            e.printStackTrace();
        }
      }
    }

    if (count < maxIsland) {
      count = 0
    } else {
      count = 1;
    }


    count;
  }

}
