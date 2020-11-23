package pl.timersk;


import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class ParseJSON {

    private final JSONObject objectJSON;
    private final int success;
    private final boolean dataErr;
    private final boolean circuitVisit;
    private final String event;
    private final String sundayEvent;
    private final int openingComments;
    private final int treasuresTalk;
    private final int diggingForSpiritualGems;
    private final int livingOption;
    private final int livingPart1;
    private final int livingPart2;
    private final int congregationBibleStudy;
    private final int concludingComments;

    HttpHandler hh = new HttpHandler();


    public ParseJSON() throws Exception {
        Date dateNow = new Date();
        String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(dateNow);

        JSONObject toSend = new JSONObject();
        toSend.put("token","Rafaello73" + modifiedDate);

        objectJSON = new JSONObject(hh.sendPost(URLS.URL_MEETINGS,toSend));

        success = objectJSON.getInt("success");

        String date = objectJSON.getJSONObject("options").getString("date");
         dataErr = objectJSON.getJSONObject("options").getBoolean("dataErr");
         circuitVisit = objectJSON.getJSONObject("options").getBoolean("circuitVisit");
         event = objectJSON.getJSONObject("options").getString("event");
         //event = "Kongres";
        sundayEvent = objectJSON.getJSONObject("options").getString("sundayEvent");

        openingComments = objectJSON.getJSONObject("meeting").getInt("openingComments");
        treasuresTalk = objectJSON.getJSONObject("meeting").getInt("treasuresTalk");
        diggingForSpiritualGems = objectJSON.getJSONObject("meeting").getInt("diggingForSpiritualGems");

        livingOption = objectJSON.getJSONObject("meeting").getInt("livingPartTwoPoint");
        //livingOption = 0;

        livingPart1 = objectJSON.getJSONObject("meeting").getInt("livingPart1");
        livingPart2 = objectJSON.getJSONObject("meeting").getInt("livingPart2");
        congregationBibleStudy = objectJSON.getJSONObject("meeting").getInt("congregationBibleStudy");
        concludingComments = objectJSON.getJSONObject("meeting").getInt("concludingComments");

    }

    /**
     * Multi array with meeting data
     * @return multi array with meeting data
     */
    public Object[][] meetingArray(){

        Object[][] result = {};

        if(success == 1) {

            if (!dataErr) {
                if (checkIfWeekend()) {
                    if (!sundayEvent.equals("")) {
                        result = new Object[1][3];
                        result[0][0] = 0;
                        result[0][1] = 0;
                        result[0][2] = sundayEvent;
                    } else {
                        result = new Object[4][3];
                        if (circuitVisit) {
                            result[0][0] = 30;
                            result[0][1] = 0;
                            result[0][2] = "Wykład publiczny";

                            result[1][0] = 30;
                            result[1][1] = 0;
                            result[1][2] = "Studium Strażnicy";

                            result[2][0] = 30;
                            result[2][1] = 0;
                            result[2][2] = "Przemówienie nadzorcy obwodu";

                            result[3][0] = 7;
                            result[3][1] = 0;
                            result[3][2] = "Zbiórka do służby";
                        } else {

                            result = new Object[3][3];

                            result[0][0] = 30;
                            result[0][1] = 0;
                            result[0][2] = "Wykład publiczny";

                            result[1][0] = 60;
                            result[1][1] = 0;
                            result[1][2] = "Studium Strażnicy";

                            result[2][0] = 7;
                            result[2][1] = 0;
                            result[2][2] = "Zbiórka do służby";
                        }
                    }//here
                } else {
                    //from here
                    if (!event.equals("")) {
                        result = new Object[1][3];
                        result[0][0] = 0;
                        result[0][1] = 0;
                        result[0][2] = event;
                    } else {

                        JSONArray arr = objectJSON.getJSONArray("tssk");
                        int len = arr.length();
                        int recordLength = 6 + len + livingOption;
                        result = new Object[recordLength][3];

                        result[0][0] = openingComments;
                        result[0][1] = 0;
                        result[0][2] = "Uwagi wstępne";

                        result[1][0] = treasuresTalk;
                        result[1][1] = 0;
                        result[1][2] = "Skarby ze Słowa Bożego";

                        result[2][0] = diggingForSpiritualGems;
                        result[2][1] = 0;
                        result[2][2] = "Wyszukiwanie duchowych skarbów";

                        int j = 0;
                        for (int i = 3; i < len + 3; i++) {

                            result[i][0] = arr.getJSONObject(j).getInt("pointTime");
                            result[i][1] = 0;
                            result[i][2] = arr.getJSONObject(j).getString("pointName");
                            j++;
                        }

                        result[len + 3][0] = livingPart1;
                        result[len + 3][1] = 0;
                        result[len + 3][2] = "Chrześcijański tryb życia, cz. 1";
                        if (livingOption == 1) {
                            result[len + 4][0] = livingPart2;
                            result[len + 4][1] = 0;
                            result[len + 4][2] = "Chrześcijański tryb życia, cz. 2";
                        }
                        if (circuitVisit) {
                            result[len + 4 + livingOption][0] = concludingComments;
                            result[len + 4 + livingOption][1] = 0;
                            result[len + 4 + livingOption][2] = "Powtórka i zapowiedź następnego zebrania";

                            result[len + 5 + livingOption][0] = 30;
                            result[len + 5 + livingOption][1] = 0;
                            result[len + 5 + livingOption][2] = "Przemówienie nadzorcy obwodu";

                        } else {
                            result[len + 4 + livingOption][0] = congregationBibleStudy;
                            result[len + 4 + livingOption][1] = 0;
                            result[len + 4 + livingOption][2] = "Zborowe studium Biblii";

                            result[len + 5 + livingOption][0] = concludingComments;
                            result[len + 5 + livingOption][1] = 0;
                            result[len + 5 + livingOption][2] = "Powtórka i zapowiedź następnego zebrania";
                        }
                    }
                    // to here
                }

            }  // dataErr

        }
        else{
            result = null;
        }
        return result;
    }


    /**
     * check if today is weekend day
     * @return true if weekend day, false if not
     */
    public boolean checkIfWeekend(){
        boolean results = false;
        LocalDate date = LocalDate.now();
        DayOfWeek dow = date.getDayOfWeek();
        String dayName = dow.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        if(dayName.equals("Sunday") || dayName.equals("Saturday")){
            results = true;
        }
        return results;
    }

}
