import org.json.JSONObject
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.random.Random

data class HoldDetails(var s:String = "", var x:String = "")
fun getRandomPos (i: Int) :Int = Random.nextInt(i)

fun main() {

    try {
        val bot = TelegramBotsApi(DefaultBotSession::class.java)

        //bot.registerBot(new EmojiBot());
        //bot.registerBot(new BotAbility());
        bot.registerBot(EmojiBot())
    } catch (ignored: Exception) {
    }


    /*val text = "This bot turns any text into copy pasta text"
        .replace("/[^0-9a-zA-Z]/g","")
        .lowercase(Locale.getDefault())

    val addEmojisToList = arrayListOf<String>()

    val b: StringBuilder = StringBuilder()
    val array = text.split(" ")
    //println(array)
    val holdDetails = HoldDetails()

    for (value in array) {
        val t = text.split(" ")
        val file = File("C:\\Users\\Nakul\\Documents\\NetBeansProjects\\EmojiCopyPastaBot\\EmojiData.json")
        val reader = BufferedReader(FileReader(file))
        var st: String?

        while (reader.readLine().also {
                st = it } != null) {
            b.append(st)
           // holdDetails.s = b.toString()
        }

        reader.close()
        val values = arrayListOf("this","a")
        val ob = JSONObject(b.toString().trim())
        val ob1: JSONObject = ob.getJSONObject(value)
       // println(ob1.)
        if (ob1.has(value)) {
            val a = ob1.getString(value)
            println(a)
        }

        addEmojisToList.add(ob1.toString())

        if (ob1.names().length() <= 1) {
            //println("${value.trim()}${ob1.names().get(0)}")
            //println(array.reduce { acc, _ -> acc+ob1.names().get(0)})

        }

        if (ob1.names().length() > 1) {
           // println("${value.trim()}${ob1.names().get(getRandomPos(ob1.length()))}")
           // println(ob1.names().get(1))
        }
    }

    //println(holdDetails.s)
    val values = arrayListOf("this","a")
    val arr = arrayListOf("")
    val s = StringBuilder()

    val omit = arrayListOf("a","an","the","this")
    val word = "this bot an turns any text into copy a pasta text.".split(" ")

    val isTooCommon = array.any { it in values }
    val iterator:Iterator<String> = omit.iterator()

    word.forEach { words->
        if (words.contains("a")) {
           // println(words)
        }

    }

    array.forEach { it ->
        //println("Values "+array.any { it in values })

        if (array.any {it in values}) {
            return
        }
        //println(it)
        val isTooCommon = array.any { it in values }
        if (isTooCommon) {
        }
        //println("${it.trim()}${ob1.names().get(0)}")
        //println(ob1.names())

        val ob = JSONObject(b.toString())
        val ob1: JSONObject = ob.getJSONObject(it)
        //println(returnAr(ob1,it))

        //    val hashMap = HashMap<String,Int>()
        //println(ob1)
        //println(ob.toString())

        // Apply operation from left to right on each element.
        if (ob1.names().length() <= 1  || ob1.names().length() >1) {
          //  println("${it.trim()}${ob1.names().get(getRandomPos(ob1.length()))}")
            val hold = "${it.trim()}${ob1.names().get(getRandomPos(ob1.length()))}"
            arr.add(hold)
            s.append(hold)
        }

        //println(holdDetails.s)
    }*/
    //println(s)

    /*for (ar:Int in 0 until arr.size) {
        println(arr[ar])
    }
    arr.forEach {
       // println(it.trim())
    }*/

    /*if (ob1.names().length() > 1) {
            println("${it.trim()}${ob1.names().get(getRandomPos(ob1.length()))}")
            //holdDetails.x = "${it.trim()}${ob1.names().get(getRandomPos(ob1.length()))}"
           // hashMap.put(it,array.indexOf(it));
        }

    if (isTooCommon) {
        val ob1: JSONObject = ob.getJSONObject(it)
        if (ob1.names().length() <= 1) {
            //println("${it.trim()}${ob1.names().get(0)}")
            //println(array.reduce { acc, _ -> acc+ob1.names().get(0)})
            //holdDetails.s = "${it.trim()}${ob1.names().get(0)}"
        }

        if (ob1.names().length() > 1) {
            // println("${it.trim()}${ob1.names().get(getRandomPos(ob1.length()))}")
            //holdDetails.x = "${it.trim()}${ob1.names().get(getRandomPos(ob1.length()))}"
        }

    }*/


/*
    for (o:Int in 0 until array1.size) {
        println(array1[o])
    }*/

    //println(floor(Math.random() * addEmojisToList[0].length).toInt())
//println(returnAr(word.toString(),omit.toString()))
}
fun returnIndex(ob:JSONObject) : String = "f"

fun returnAr(word: String,omit:String): String? {
    word.forEach { words ->
        if (omit.contains(words)) {
            println(words)
            return words.toString()
        }

    }
    return null
}
