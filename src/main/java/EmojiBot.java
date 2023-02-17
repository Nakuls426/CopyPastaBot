import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class EmojiBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());

        if (update.hasMessage() && update.getMessage().hasText()) {

            String[] array = update.getMessage().getText().split(" ");

            StringBuilder b = new StringBuilder();
            StringBuilder append = new StringBuilder();

            try {
                URL url = new URL("https://raw.githubusercontent.com/farkmarnum/emojify/main/src/data/emoji-data.json");
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(new InputStreamReader((InputStream) connection.getContent()));
                String s;
                while ((s = reader.readLine()) != null) {
                    append.append(s.trim());
                }
                connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (String value : array) {
                StringBuilder modifiedTxt = setModifiedText(value, append);
                b.append(modifiedTxt);
            }

            message.setText(b.toString());
            try {
                execute(message);
            } catch (TelegramApiException ignored) {
            }

        }
    }

    private StringBuilder setModifiedText(String value, StringBuilder jsonData) {
        StringBuilder appendText = new StringBuilder();
        JSONObject obj = new JSONObject(jsonData.toString());

        try {
            JSONObject object = obj.getJSONObject(value.toLowerCase(Locale.ROOT));
            String hold = value + " " + object.names().get(getRandomPos(object.length())) + " ";
            return appendText.append(hold);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return new StringBuilder(value + " ");
    }

    private int getRandomPos(int length) {
        Random rand = new Random();
        return rand.nextInt(length);
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotToken() {

        return "2075246418:AAHnPA1V23H8twB7wwdrKcAJNy77cADJyeE";
    }

    @Override
    public String getBotUsername() {

        return "emojiofy_bot";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }
}
