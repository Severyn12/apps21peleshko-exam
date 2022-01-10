package app;

import domain.*;
import json.JsonPair;
import json.JsonNumber;
import json.JsonArray;
import json.Json;
import json.JsonObject;
import json.JsonString;
import json.JsonBoolean;
import json.Tuple;



/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {

    public static Student studentData;


    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject stData = new JsonObject(name, surname, year, marks);
        print(stData); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}


        JsonPair courseOOPName = new JsonPair("course", new JsonString("OOP"));
        JsonPair courseOOPMark = new JsonPair("mark", new JsonNumber(3));
        JsonPair courseOOPpassed = new JsonPair("passed", new JsonBoolean(true));
        JsonObject jsonObjOOP = new JsonObject(courseOOPName, courseOOPMark, courseOOPpassed);

        JsonPair courseENGName = new JsonPair("course", new JsonString("English"));
        JsonPair courseENGMark = new JsonPair("mark", new JsonNumber(5));
        JsonPair courseENGpassed = new JsonPair("passed", new JsonBoolean(true));
        JsonObject jsonObjENG = new JsonObject(courseENGName, courseENGMark, courseENGpassed);

        JsonPair courseMathName = new JsonPair("course", new JsonString("Math"));
        JsonPair courseMathMark = new JsonPair("mark", new JsonNumber(2));
        JsonPair courseMathpassed = new JsonPair("passed", new JsonBoolean(false));
        JsonObject jsonObjMath = new JsonObject(courseMathName, courseMathMark, courseMathpassed);


        JsonPair exams = new JsonPair("exams", new JsonArray(jsonObjOOP, jsonObjENG, jsonObjMath));


        print(stData.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}

        studentData = new Student(
                "Andrii",
                "Rodionov",
                2,
                new Tuple<>("OOP", 3),
                new Tuple<>("English", 5),
                new Tuple<>("Math", 2)
        );


    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

    public static JsonObject sessionResult() {
        main(null);

        JsonObject jsonObject = studentData.toJsonObject();
        return jsonObject;
    }
}
