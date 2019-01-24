package ApplicationPack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonISO2  {
    private String jsonFile = "D:\\GitRep\\SystemTrayApplication\\src\\Files\\slim-2.json";
    public String loadFile(){
        try(BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(jsonFile)))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = buf.readLine();
            while(line!=null){
                stringBuilder.append(line).append("\n");
                line=buf.readLine();
            }
            return  stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String[] getAllValues(String key,String json_str) throws JSONException {
        List<String> list = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json_str);
        int counter = 0;
        while (!jsonArray.isNull(counter)) {
            list.add((String) jsonArray.getJSONObject(counter).get(key));
            counter++;

        }
        System.out.println(counter + " elements of "+key+" in file "+ jsonFile);
        return list.toArray(new String[counter]);
    }

    public String getCurrentCountry(){
        String countryISO2 = new PropWorker().getCountryISO2();
        return getValue(countryISO2,"alpha-2","name","Ukraine");
    }

    public String getISO2(String country){
        return getValue(country,"name","alpha-2","UA");
    }


    public String getValue(String givenValue,String givenKey, String searchingKey,String alternativeValue){
        try {
            JSONArray jsonArray = new JSONArray(loadFile());
            int len = jsonArray.length();
            for(int i=0;i<len;i++){
                if(givenValue.equals(jsonArray.getJSONObject(i).get(givenKey))){
                    return (String) jsonArray.getJSONObject(i).get(searchingKey);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return alternativeValue;
    }
}
