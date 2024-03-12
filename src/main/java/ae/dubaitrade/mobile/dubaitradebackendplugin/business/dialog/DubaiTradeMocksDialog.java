package ae.dubaitrade.mobile.dubaitradebackendplugin.business.dialog;

import ae.dubaitrade.mobile.dubaitradebackendplugin.business.pojo.CommonModule;
import ae.dubaitrade.mobile.dubaitradebackendplugin.business.pojo.DpWorldModule;
import ae.dubaitrade.mobile.dubaitradebackendplugin.business.pojo.Module;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DubaiTradeMocksDialog extends DialogWrapper {

    private JTextField urlField;
    private JTextField nameField;
    private JTextField packageField;
    private JTextArea requestBodyArea;
    private JTextArea responseBodyArea;

    private JComboBox<String> comboBox;

    public static Map<String, Module> map = new HashMap<>();

    public DubaiTradeMocksDialog() {
        super(true); // true to allow dialog resizing

        setTitle("Dubai Trade Mocks Configuration");
        // Create UI components
        urlField = new JTextField();
        nameField = new JTextField();
        packageField = new JTextField();
        requestBodyArea = new JTextArea();
        responseBodyArea = new JTextArea();
        comboBox = new JComboBox<>();
        map.put("Common",new CommonModule());
        map.put("DPWorld",new DpWorldModule());
//        map.put("User Management",new DpWorldModule());
        for (String key : map.keySet()) {
            comboBox.addItem(key);
        }
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // First Panel
        JPanel firstPanel = new JPanel(new GridLayout(3, 2, 5, 5)); // 3 rows, 2 columns
        firstPanel.add(new JLabel("URL:"));
        firstPanel.add(urlField = new JTextField());
        firstPanel.add(new JLabel("Name:"));
        firstPanel.add(nameField = new JTextField());
        firstPanel.add(new JLabel("Choose project:"));
        firstPanel.add(comboBox);

        panel.add(firstPanel);

        // Second Panel (panelJson)
        JPanel panelJson = new JPanel(new GridLayout(2, 1, 5, 5));
        panelJson.setBorder(BorderFactory.createTitledBorder("JSON Input"));

        // Request Body
        JPanel requestBodyPanel = new JPanel(new BorderLayout());
        requestBodyPanel.add(new JLabel("Request Body:"), BorderLayout.NORTH);
        requestBodyArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(requestBodyArea);
        requestBodyPanel.add(scrollPane, BorderLayout.CENTER);
        panelJson.add(requestBodyPanel);

        // Response Body
        JPanel responseBodyPanel = new JPanel(new BorderLayout());
        responseBodyPanel.add(new JLabel("Response Body:"), BorderLayout.NORTH);
        responseBodyArea = new JTextArea(10, 40);
        JScrollPane responseScrollPane = new JScrollPane(responseBodyArea);
        responseBodyPanel.add(responseScrollPane, BorderLayout.CENTER);
        panelJson.add(responseBodyPanel);

        panel.add(panelJson);

        return panel;
    }



    public String getRequestText() {
        return requestBodyArea.getText();
    }

    public String getResponseText() {
        return responseBodyArea.getText();
    }

    public String getName() {
        return nameField.getText();
    }
    public String getURL() {
        return urlField.getText();
    }

    public String getPackage() {
        return"";
    }

    public Module getModule() {
        return map.get(comboBox.getSelectedItem());
    }
}

