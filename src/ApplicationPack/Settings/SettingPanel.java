package ApplicationPack.Settings;

import ApplicationPack.JsonISO2;
import ApplicationPack.PropWorker;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SettingPanel extends JPanel {
    private JLabel lb_country;
    private JLabel lb_city;
    private JComboBox<String> cb_country;
    private JTextField tf_city;
    private JButton btn_save;
    private JsonISO2 jsonISO2;

    public SettingPanel() throws JSONException {
        jsonISO2 = new JsonISO2();
        lb_country = new JLabel("Country");
        lb_country.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lb_country.setPreferredSize(new Dimension(130,40));
        add(lb_country);

        cb_country = new JComboBox<>(jsonISO2.getAllValues("name",jsonISO2.loadFile()));
        cb_country.setEditable(false);
        cb_country.setSelectedItem(jsonISO2.getCurrentCountry());
        cb_country.setPreferredSize(new Dimension(140,40));
        add(cb_country);

        lb_city = new JLabel("City");
        lb_city.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lb_city.setPreferredSize(new Dimension(130,40));
        add(lb_city);

        tf_city = new JTextField();
        tf_city.setText("Kiev");
        tf_city.setPreferredSize(new Dimension(140,40));
        add(tf_city);

        btn_save = new JButton("Save");
        btn_save.addActionListener(this::btnSaveListener);
//        btn_save.setPreferredSize(new Dimension());
        add(btn_save);
    }
    void btnSaveListener(ActionEvent e){
        PropWorker prop = new PropWorker();
        System.out.println("SettingPanel.Save button.");
        String oldCity = prop.getCity();
        String oldCounty = prop.getCountryISO2();
        String newCoutryISO = jsonISO2.getISO2((String) cb_country.getSelectedItem());
        String newCity;
        if(!oldCounty.equals(newCoutryISO)){
            prop.setProperti("country",newCoutryISO);
            System.out.println("Different ISO");
        }
        if(!oldCity.equals(newCity=tf_city.getText())){
            prop.setProperti("city",newCity);
            System.out.println("Different city");
        }
    }
}
