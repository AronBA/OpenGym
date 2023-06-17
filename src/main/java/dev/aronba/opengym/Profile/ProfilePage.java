package dev.aronba.opengym.Profile;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import dev.aronba.opengym.Window;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProfilePage extends JPanel {
    public ProfilePage() {
        Map<String, FlatLaf> flatLafMap = new HashMap<>();
        flatLafMap.put(FlatDarculaLaf.NAME, new FlatDarculaLaf());
        flatLafMap.put(FlatIntelliJLaf.NAME, new FlatIntelliJLaf());
        flatLafMap.put(FlatMacDarkLaf.NAME, new FlatMacDarkLaf());
        flatLafMap.put(FlatMacLightLaf.NAME, new FlatMacLightLaf());
        flatLafMap.put(FlatLightLaf.NAME, new FlatLightLaf());
        flatLafMap.put(FlatDarkLaf.NAME, new FlatDarkLaf());
        JComboBox<String> themesComboBox = new JComboBox(flatLafMap.keySet().toArray());
        themesComboBox.addActionListener(l -> {
            try {
                System.out.println();
                UIManager.setLookAndFeel(flatLafMap.get(themesComboBox.getSelectedItem().toString()));
                SwingUtilities.updateComponentTreeUI(Window.getInstance());
            } catch( Exception ex ) {
                System.err.println( "Failed to switch LaF" );
            }
        });
        add(themesComboBox);
    }
}
