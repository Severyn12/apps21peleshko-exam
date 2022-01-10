package domain;

import json.JsonPair;
import json.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import json.JsonObject;
import json.JsonNumber;
import json.JsonString;
import json.JsonBoolean;
import json.JsonArray;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private String stName;
    private String stSurname;
    private Integer stYear;
    private List<Tuple<String, Integer>> tests;

    public Student(String name, String surname, Integer year,
                   Tuple<String, Integer>... exams) {
        stName = name;
        stSurname = surname;
        stYear = year;
        tests = Arrays.asList(exams);

    }

    @Override
    public JsonObject toJsonObject() {
        boolean passed;
        JsonObject jsonSt = new JsonObject();
        jsonSt.add(new JsonPair("name", new JsonString(stName)));
        jsonSt.add(new JsonPair("surname", new JsonString(stSurname)));
        jsonSt.add(new JsonPair("year", new JsonNumber(stYear)));

        ArrayList<JsonObject> dataArr = new ArrayList();

        for (Tuple<String, Integer> exam: tests) {
            String key = exam.getKey();
            Integer value = exam.getValue();

            JsonPair courseName = new JsonPair("course", new JsonString(key));
            JsonPair courseMark = new JsonPair("mark", new JsonNumber(value));

            if (value > 2) {
                passed = true;
            }
            else {
                passed = false;
            }
            JsonPair coursePassed = new JsonPair("passed",
                    new JsonBoolean(passed));
            JsonObject jsTestObj = new JsonObject(courseName,
                    courseMark, coursePassed);

            dataArr.add(jsTestObj);

        }

        jsonSt.add(new JsonPair("exams",
                new JsonArray(dataArr.toArray(new JsonObject[0]))));
        return jsonSt;
    }
}