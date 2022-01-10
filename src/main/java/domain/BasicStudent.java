package domain;

import json.JsonString;
import json.Jsonable;
import json.JsonObject;
import json.JsonNumber;
import json.JsonPair;




/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    private String name;
    private String surname;
    private Integer year;

    public BasicStudent() {
    }

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonPair jsName = new JsonPair("name", new JsonString(name));
        JsonPair jsSurname = new JsonPair("surname", new JsonString(surname));
        JsonPair jsYear = new JsonPair("year", new JsonNumber(year));
        JsonObject jsonStudent = new JsonObject(jsName, jsSurname, jsYear);
        return jsonStudent;
    }
}
