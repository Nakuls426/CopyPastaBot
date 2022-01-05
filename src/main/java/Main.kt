import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

import kotlin.random.Random

fun getRandomPos (i: Int) :Int = Random.nextInt(i)

fun main() {

    try {
        val bot = TelegramBotsApi(DefaultBotSession::class.java)
        bot.registerBot(EmojiBot())
    } catch (ignored: Exception) {
    }
}

