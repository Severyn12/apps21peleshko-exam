package app;

import domain.Student;
import domain.BasicStudent;
import json.JsonPair;
import json.JsonNumber;
import json.JsonArray;
import json.Json;
import json.JsonObject;
import json.JsonString;
import json.JsonBoolean;




/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {

    private static JsonPair name;
    private static JsonPair surname;
    private static JsonPair year;
    private static JsonPair exams;

    private static Student studentData;


    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);

        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        print(jMarks); // [3, 4]

        name = new JsonPair("name", new JsonString("Andrii"));
        surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        year = new JsonPair("year", jYear);
        JsonObject stData = new JsonObject(name, surname, year, marks);
        print(stData); // {'name': 'Andrii', 'surname': 'Rodionov',
        // 'year': 2, 'marks': [3, 4]}


        JsonPair courseOOPName = new JsonPair("course", new JsonString("OOP"));
        JsonPair courseOOPMark = new JsonPair("mark", new JsonNumber(3));
        JsonPair courseOOPpassed = new JsonPair("passed",
                new JsonBoolean(true));
        JsonObject jsonObjOOP = new JsonObject(courseOOPName, courseOOPMark,
                courseOOPpassed);

        JsonPair courseENGName = new JsonPair("course",
                new JsonString("English"));
        JsonPair courseENGMark = new JsonPair("mark", new JsonNumber(5));
        JsonPair courseENGpassed = new JsonPair("passed",
                new JsonBoolean(true));
        JsonObject jsonObjENG = new JsonObject(courseENGName,
                courseENGMark, courseENGpassed);

        JsonPair courseMathName = new JsonPair("course",
                new JsonString("Math"));
        JsonPair courseMathMark = new JsonPair("mark",
                new JsonNumber(2));
        JsonPair courseMathpassed = new JsonPair("passed",
                new JsonBoolean(false));
        JsonObject jsonObjMath = new JsonObject(courseMathName,
                courseMathMark, courseMathpassed);


        exams = new JsonPair("exams", new JsonArray(jsonObjOOP,
                jsonObjENG, jsonObjMath));


        print(stData.projection("surname", "age", "year", "marks"));
        // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii",
                "Rodionov", 2);
        print(basicStudent.toJsonObject());
        // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}




    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

    public static JsonObject sessionResult() {
        main(null);

        JsonObject jsonObject = new JsonObject(name, surname, year, exams);
        return jsonObject;
    }
}
