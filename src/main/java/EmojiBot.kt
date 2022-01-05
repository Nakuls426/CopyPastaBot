/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.json.JSONException
import org.json.JSONObject
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import java.io.*
import java.util.*

/**
 *
 * @author Nakul
 */
class EmojiBot : TelegramLongPollingBot() {

    override fun onUpdateReceived(update: Update) {
        val message = SendMessage()
        message.chatId = update.message.chatId.toString()
        if (update.hasMessage() && update.message.hasText()) {
            val appendText = StringBuilder()

            val array = update.message.text.toString()
                .replace("\"/[^0-9a-zA-Z]/g\"","")
                .split(" ")

            println(array)
           // val holdDetails = HoldDetails()
            val b = StringBuilder()
            //val addEmojisToList = ArrayList<String>()

            for (value in array) {
               // val t = text.split(" ")
                val file = File("C:\\Users\\Nakul\\Documents\\NetBeansProjects\\EmojiCopyPastaBot\\EmojiData.json")
                val reader = BufferedReader(FileReader(file))
                var st: String?

                while (reader.readLine().also {
                        st = it } != null) {
                    b.append(st)
                    // holdDetails.s = b.toString()
                }

                reader.close()

                /*//val values = arrayListOf("this","a")
                val ob = JSONObject(b.toString().trim())
                val ob1: JSONObject = ob.getJSONObject(value.lowercase())

                addEmojisToList.add(ob1.toString())*/
            }
            //val values = arrayListOf("this","a")

            val arr = arrayListOf("")
            array.forEach {
              //  println(it)
                //val isTooCommon = array.any { it in values }
                val emojiPastaText = setModifiedText(it,b)
                appendText.append(emojiPastaText)
            }

                message.text = appendText.toString()
           // message.setText(builder1.toString())
            try {
                execute(message) // Call method to send the message
            } catch (ignored: TelegramApiException) {
            }
        }
    }

    private fun setModifiedText (data:String,b:StringBuilder) :StringBuilder {
        val start = System.currentTimeMillis()
        val appendText = StringBuilder()
        val ob = JSONObject(b.toString())
        try {
            val ob1: JSONObject = ob.getJSONObject(data.lowercase())
            // Apply operation from left to right on each element.

            val hold = data + " " + "${ob1.names().get(getRandomPos(ob1.length()))}" + " "
            return appendText.append(hold)

            /*println(returnString(ob1,data.lowercase()))
            if (ob1.names().length() <= 1 || ob1.names().length() > 1) {
                val hold = data + " " + "${ob1.names().get(getRandomPos(ob1.length()))}" + " "
                return appendText.append(hold)
            }*/

        } catch (e: JSONException) {
        }
        return StringBuilder("$data ")
    }
    
    fun returnString (jsonObject: JSONObject,acc:String): String  {
        if (jsonObject.has(acc)) {
            return acc
        }
    return ""
    }

    override fun onUpdatesReceived(updates: List<Update?>?) = super.onUpdatesReceived(updates)

    override fun getBotToken() = "2075246418:AAHnPA1V23H8twB7wwdrKcAJNy77cADJyeE"

    override fun getBotUsername() = "emojiofy_bot"

    //override fun onRegister() = super.onRegister()
}