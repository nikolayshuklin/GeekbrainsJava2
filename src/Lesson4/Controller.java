package Lesson4;

public class Controller {

   @FXML
    TextArea messageArea;

    @FXML
    TextField newMessage;

    @FXML
    Button sendButton;

    public void sendMessageTypeAction (ActiveEvent activeEvent){
        String messageText = newMessage.getText().trim();
        if(!messageText.isEmpty()){
            messageArea.appendText(messageText + System.lineSeparator());
            newMessage.clear();
        }

    }
}
