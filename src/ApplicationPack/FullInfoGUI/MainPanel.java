package ApplicationPack.FullInfoGUI;

import WeatherAPIWorker.WeatherWorker;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private WeatherWorker worker;
    private JLabel city;
    private JLabel temAndIcon;
    private JTextArea detailInfo;

    public MainPanel(WeatherWorker worker){

        this.worker = worker;
        setBackground(Color.WHITE);

        //Configure and set city name and country
        city = new JLabel(worker.getFullCity());
        city.setFont( new Font("TimesRoman", Font.PLAIN, 30));
        city.setPreferredSize(new Dimension(300,50));
        city.setHorizontalAlignment(SwingConstants.CENTER);
        add(city);

        //Configure and set temperature and appropriate icon
        temAndIcon = new JLabel((int)(worker.container().getMain().getTemp()-273.15)+"");
        temAndIcon.setIcon(worker.getImage());
        temAndIcon.setForeground(Color.red);
        temAndIcon.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        temAndIcon.setPreferredSize(new Dimension(300,50));
        temAndIcon.setHorizontalAlignment(SwingConstants.CENTER);
        add(temAndIcon);


        detailInfo = new JTextArea(worker.getFullWeather());
        detailInfo.setEditable(false);
        detailInfo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JScrollPane pane = new JScrollPane(detailInfo);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        pane.setPreferredSize(new Dimension(250,120));
        pane.setMaximumSize(new Dimension(250,120));
        add(pane);
    }

}
