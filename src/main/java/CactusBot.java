import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class CactusBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

        SendMessage message = new SendMessage();
        long chat_id = update.getMessage().getChatId();
        String inputText = update.getMessage().getText();
        String outputText = null;

        //getting jokes

        if (inputText.contains("/joke")) {
            try {
                outputText = Jokes.getJoke();
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        } else if (inputText.contains("/convo")) {
            outputText = Topics.getTopic();
        } else if (inputText.contains("/fact"))  {
            outputText = Facts.getFacts();
        }

        message.setChatId(chat_id);
        message.setText(outputText);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public String getBotUsername() {
        return "cactus97bot";
    }

    public String getBotToken() {
        return "753681597:AAG-q2jSz5x_ntemdLKH8KWxeb-Kar7bMzk";
    }
}
