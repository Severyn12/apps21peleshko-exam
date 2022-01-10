package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {

    private boolean boolValue;

    public JsonBoolean(Boolean bool) {
        this.boolValue = bool;
    }

    @Override
    public String toJson() {
        return  Boolean.toString(boolValue);
    }


}
