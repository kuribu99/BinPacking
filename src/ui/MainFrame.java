package ui;

import algorithms.Algorithm;
import data.Data;
import data.FileFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initModels();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        comboboxAlgorithm = new javax.swing.JComboBox();
        panelFile = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbxPath = new javax.swing.JTextField();
        btnSelectPath = new javax.swing.JButton();
        btnExecute = new javax.swing.JButton();
        panelRandom = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnExecuteRandom = new javax.swing.JButton();
        spinnerLoadLimit = new javax.swing.JSpinner();
        spinnerParcelNumber = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        btnGenerate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboboxDistribution = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bin Packing Solver");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Algorithm");

        comboboxAlgorithm.setModel(algorithmModel);

        panelFile.setBorder(javax.swing.BorderFactory.createTitledBorder("Execute from File"));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("File Name");

        tbxPath.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbxPath.setText("data.txt");

        btnSelectPath.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSelectPath.setText("...");
        btnSelectPath.setToolTipText("");
        btnSelectPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectPathActionPerformed(evt);
            }
        });

        btnExecute.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnExecute.setText("Execute");
        btnExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecuteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFileLayout = new javax.swing.GroupLayout(panelFile);
        panelFile.setLayout(panelFileLayout);
        panelFileLayout.setHorizontalGroup(
            panelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFileLayout.createSequentialGroup()
                .addGroup(panelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFileLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExecute, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFileLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tbxPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelectPath, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelFileLayout.setVerticalGroup(
            panelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectPath, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxPath, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExecute, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRandom.setBorder(javax.swing.BorderFactory.createTitledBorder("Execute with Random Data"));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Load Limit");

        btnExecuteRandom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnExecuteRandom.setText("Execute");
        btnExecuteRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecuteRandomActionPerformed(evt);
            }
        });

        spinnerLoadLimit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spinnerLoadLimit.setModel(loadLimitSpinnerModel);

        spinnerParcelNumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spinnerParcelNumber.setModel(parcelNumberSpinnerModel);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Parcel Number");

        btnGenerate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGenerate.setText("Generate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Distribution");

        comboboxDistribution.setModel(distributionModel);

        javax.swing.GroupLayout panelRandomLayout = new javax.swing.GroupLayout(panelRandom);
        panelRandom.setLayout(panelRandomLayout);
        panelRandomLayout.setHorizontalGroup(
            panelRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRandomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRandomLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExecuteRandom, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelRandomLayout.createSequentialGroup()
                        .addGroup(panelRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRandomLayout.createSequentialGroup()
                                .addComponent(spinnerLoadLimit)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spinnerParcelNumber))
                            .addComponent(comboboxDistribution, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))))
        );
        panelRandomLayout.setVerticalGroup(
            panelRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRandomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerLoadLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerParcelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxDistribution, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRandomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExecuteRandom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRandom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelFile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboboxAlgorithm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRandom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecuteActionPerformed
        if (fileData == null) {
            try {
                fileData = readData(tbxPath.getText());
            }
            catch (FileNotFoundException ex) {
                fileData = null;
                showErrorMessage("File not found");

            }
            catch (FileFormatException ex) {
                fileData = null;
                showErrorMessage(ex.getMessage());
            }
        }

        execute(fileData);
    }//GEN-LAST:event_btnExecuteActionPerformed

    private void btnSelectPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectPathActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser(new File("").getAbsolutePath());

            switch (fileChooser.showOpenDialog(this)) {
                case JFileChooser.APPROVE_OPTION:
                    tbxPath.setText(fileChooser.getSelectedFile().getAbsolutePath());
                    break;
            }

            fileData = readData(tbxPath.getText());
        }
        catch (FileNotFoundException ex) {
            fileData = null;
            showErrorMessage("File not found");

        }
        catch (FileFormatException ex) {
            fileData = null;
            showErrorMessage(ex.getMessage());
        }
    }//GEN-LAST:event_btnSelectPathActionPerformed

    private void btnExecuteRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecuteRandomActionPerformed
        // Generate data if data does not exist
        if (generatedData == null) {
            btnGenerateActionPerformed(evt);
        }
        execute(generatedData);
    }//GEN-LAST:event_btnExecuteRandomActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        generatedData = Data.Generator.generate(
                comboboxDistribution.getSelectedIndex() + 1,
                (int) loadLimitSpinnerModel.getValue(),
                (int) parcelNumberSpinnerModel.getValue()
        );
    }//GEN-LAST:event_btnGenerateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExecute;
    private javax.swing.JButton btnExecuteRandom;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnSelectPath;
    private javax.swing.JComboBox comboboxAlgorithm;
    private javax.swing.JComboBox comboboxDistribution;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelFile;
    private javax.swing.JPanel panelRandom;
    private javax.swing.JSpinner spinnerLoadLimit;
    private javax.swing.JSpinner spinnerParcelNumber;
    private javax.swing.JTextField tbxPath;
    // End of variables declaration//GEN-END:variables
    private ComboBoxModel<String> algorithmModel;
    private ComboBoxModel<String> distributionModel;
    private SpinnerModel loadLimitSpinnerModel;
    private SpinnerModel parcelNumberSpinnerModel;
    private Data fileData;
    private Data generatedData;

    private void initModels() {
        algorithmModel = new DefaultComboBoxModel<>(new String[]{
            Algorithm.Factory.FIRST_FIT,
            Algorithm.Factory.BEST_FIT,
            Algorithm.Factory.WORST_FIT,
            Algorithm.Factory.FIRST_FIT_DECR,
            Algorithm.Factory.BEST_FIT_DECR,
            Algorithm.Factory.WORST_FIT_DECR,
            Algorithm.Factory.ENHANCED_BEST_FIT,
            Algorithm.Factory.ENHANCED_BEST_FIT_DECR,
            Algorithm.Factory.ENHANCED_WORST_FIT,
            Algorithm.Factory.ENHANCED_WORST_FIT_DECR
        });

        distributionModel = new DefaultComboBoxModel<>(new String[]{
            "Balanced",
            "More on low value",
            "More on high value",
            "More on center",
            "More on edge"
        });
        
        loadLimitSpinnerModel = new SpinnerNumberModel(10, 1, Integer.MAX_VALUE, 1);
        parcelNumberSpinnerModel = new SpinnerNumberModel(10, 1, Integer.MAX_VALUE, 1);
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showMessage(String title, String message, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    private Data readData(String fileName) throws FileNotFoundException, FileFormatException {
        fileData = Data.read(fileName);
        if (!fileData.isSuccess()) {
            throw new FileFormatException();
        }
        return fileData;
    }

    private void showResult(Algorithm.Result result) {
        ResultDialog dlg = new ResultDialog(this, true, result);
        dlg.setVisible(true);
    }

    private void execute(Data data) {
        // Only execute if data found
        if (data != null) {
            String algorithmName = comboboxAlgorithm.getSelectedItem().toString();
            Algorithm algorithm = Algorithm.Factory.make(algorithmName);
            if (algorithm == null) {
                showErrorMessage("Invalid algorithm name");
            }
            else {
                showResult(algorithm.execute(data));
            }
        }
    }

}
