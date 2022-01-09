import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class EmojiMain {
    public static void main(String[] args) {

        try {
            TelegramBotsApi bot = new TelegramBotsApi(DefaultBotSession.class);
            bot.registerBot(new EmojiBot());
        } catch (Exception ignored) {

        }
    }
}
