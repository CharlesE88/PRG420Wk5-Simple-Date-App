/************************************************************************************
 * Program:  Simple Date App wk5
 * Purpose:     Week 5 Support Assignment
 * Programmer:  Charles Eudy
 * Creation Date:  5/28/2019
 ************************************************************************************/
package sample;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
public class Controller {
    @FXML
    private Button displayTimeDateBtn;
    @FXML
    private Label localDateLabel, localTimeLabel, dayOfWeekLabel, localTimeAndDateLabel;
    @FXML
    private Label compareToLabel, compareToLabel2, beforeLabel, afterLabel;
    LocalDate date = LocalDate.now();
    DayOfWeek myDayOfWeek = date.getDayOfWeek();
    @FXML
    void initialize() {
        displayTimeDateBtn.setOnAction(ActionEvent ->{
            displayValues();
            try {
                dates();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }
    private void displayValues(){
        localDateLabel.setText(String.valueOf(LocalDate.now()));
        localTimeLabel.setText(String.valueOf(LocalTime.now()));
        localTimeAndDateLabel.setText(String.valueOf(LocalDateTime.now()));
        dayOfWeekLabel.setText(String.valueOf(myDayOfWeek));
    }
    private void dates() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyy");
        Date date1 = dateFormat.parse("01-01-1980");
        Date date2 = dateFormat.parse("01-01-2020");
        Date todaysDate = dateFormat.parse(String.valueOf(date));
        if(todaysDate.compareTo(date1) > 0 || todaysDate.compareTo(date2) < 0){
            compareToLabel.setText("Today is later than January 1, 1980");
            compareToLabel2.setText("Today is earlier than January 1, 2020");
        }
        if(todaysDate.after(date1) || todaysDate.before(date2)){
            afterLabel.setText("Today is later than January 1, 1980");
            beforeLabel.setText("Today is earlier than January 1, 2020");
        }
    }
}
