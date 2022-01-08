/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author Nakul
 */

public class EmojiBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());

        if (update.hasMessage() && update.getMessage().hasText()) {

            String[] array = update.getMessage().getText().split(" ");
            //ArrayList<StringBuilder> arrayList = new ArrayList<>();

          //  ArrayList<String> ar = new ArrayList<>();
        //    ArrayList<String> stringArrayList = new ArrayList<>();

            StringBuilder b = new StringBuilder();
            StringBuilder append = new StringBuilder();

            try {
                URL url = new URL("https://raw.githubusercontent.com/farkmarnum/emojify/main/backend/data/emoji-data.json");
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
                StringBuilder modifiedTxt = setModifiedText(value,append);
                b.append(modifiedTxt);
            }

            message.setText(b.toString());
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException ignored) {}

        }
    }

    private StringBuilder setModifiedText(String value, StringBuilder jsonData) {
        StringBuilder appendText = new StringBuilder();
        JSONObject obj = new JSONObject(jsonData.toString().charAt(0));

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

    static int pickRandomEmo(int emojiNames) {
        return new Random().nextInt(emojiNames);
    }

    public static String pickRandomEmoji(String [] arr) {
        int i = new Random().nextInt(arr.length);
        return arr[i];
    }

    static Character randomCharacters(char [] arr ) {
        int i = new Random().nextInt(arr.length);
        return arr[i];
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates); //To change body of generated methods, choose Tools | Templates.
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
        super.onRegister(); //To change body of generated methods, choose Tools | Templates.
    }
}
/*



                File file = new File("C:\\Users\\Nakul\\Documents\\NetBeansProjects\\EmojiData.json");
                String st;
                BufferedReader reader = null;
                try {
                   reader = new BufferedReader(new FileReader(file));
                    while((st = reader.readLine())!= null) {
                        append.append(st);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    assert reader != null;
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

for (String value1 : hold.getEmojiData().split(",")) {
                System.out.println(value1);
                stringArrayList.add(value1);
                //System.out.println(stringArrayList.get(pickRandomEmo(stringArrayList.size())));
                ar.add(stringArrayList.get(pickRandomEmo(stringArrayList.size())));

            }


            for (String value : array) {
                    StringBuilder bb = new StringBuilder(value);
                    File file = new File("C:\\Users\\Nakul\\Documents\\NetBeansProjects\\EmojiCopyPastaBot\\EmojiData.json");
                    try {
                    FileInputStream fis = new FileInputStream(file);
                    } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    }

                    BufferedReader reader = null;
                    try {
                    reader = new BufferedReader(new FileReader(file));
                    } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    }
                    String st = null;
                    while(true) {
                    try {
                    assert reader != null;
                    if ((st = reader.readLine()) == null) break;
                    } catch (IOException e) {
                    e.printStackTrace();
                    }
                    b.append(st);

                    }
                    try {
                    reader.close();
                    } catch (IOException e) {
                    e.printStackTrace();
                    }
                    //arrayList.add(bb);

                    JSONObject ob = new JSONObject(b.toString().trim());
                    JSONObject ob1 = ob.getJSONObject(value);

                    hold.setEmojiData(ob1.toString());*/
