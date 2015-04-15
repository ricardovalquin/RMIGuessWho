/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Interfaces.GuessWhoInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author rick
 */
public class GuessWhoView extends javax.swing.JFrame {

    GuessWhoInterface GWInterface;
//    GuessWhoClientStatesThread stateThread;
//    GuessWhoClientStatesThread thread;
    String answer;
//    ArrayList<JButton> buttons;
    String player;// when you log in your name is here
    String defiant;
    String testPlayer;
    int game = -1;// when you accept the challenge the game is here
    String otherPlayers[] = null;// other players online in the game
    String otherChallenges[] = null;
    JLabel[] LabelsOnLinePlayers;
    JLabel[] LabelsChallenges;

    /**
     * Creates new form GuessWhoView
     */
    public GuessWhoView(String host) throws NotBoundException, MalformedURLException, RemoteException  {
        player = "rick";
        testPlayer = "test";
        initComponents();
        //JOptionPane.showMessageDialog(null, "El login", "Chat", JOptionPane.ERROR_MESSAGE);
//        try{        
//            GWInterface = new GuessWhoClientTCP("localhost", 2015);
//            GWInterface = new GuessWhoClientTCP("localhost", 2015);
//            GWInterface.LogIn(player);
//            GWInterface.LogIn(testPlayer);
//            GWInterface.Challenge(testPlayer, player);//create the challenge
//            GWInterface.AskCharacteristic(0, testPlayer, "hairColor Amarillo");
//            btnAcceptChallenge.setEnabled(false);                           
//            thread = new GuessWhoClientStatesThread(this, GWInterface, player, game);
//            thread.start();
//                game = GWInterface.AnswerChallenges(player, testPlayer, "Aceptar");
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Error al conectar", "Chat", JOptionPane.ERROR_MESSAGE);
//        }

        if(host==null){
            GWInterface=(GuessWhoInterface) Naming.lookup("rmi://localhost/nmagic");
            GWInterface.LogIn(player);
            GWInterface.LogIn(testPlayer);
            GWInterface.Challenge(testPlayer, player);//create the challenge
            btnAcceptChallenge.setEnabled(false);                           

        }else try {
            GWInterface=(GuessWhoInterface) Naming.lookup("rmi://"+host+"/nmagic");
            GWInterface.LogIn(player);
            GWInterface.LogIn(testPlayer);
            GWInterface.Challenge(testPlayer, player);//create the challenge
            btnAcceptChallenge.setEnabled(false);                           

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void whoIsOnLine(String onlines) throws RemoteException{
        otherPlayers = GWInterface.SeeOnlinePlayers().split(",");
        LabelsOnLinePlayers = new JLabel[otherPlayers.length];
        ComboOnLines.addItem(otherPlayers[0]);

        for (int i = 0; i < otherPlayers.length; i++) {
            if (otherPlayers[i]!= null && (!otherPlayers[i].equals(player)) ) {
                for (int j = 1; j < ComboOnLines.getItemCount(); j++) {
                    if (!otherPlayers[i].equals(ComboOnLines.getItemAt(j))) {
                        ComboOnLines.addItem(otherPlayers[i]);
                    }
                }
//                LabelsOnLinePlayers[i] = new JLabel();//crear label
//               LabelsOnLinePlayers[i].setText( otherPlayers[i]);
//               onLinePanel.add(LabelsOnLinePlayers[i]);
            }
        }
    }
    
    public void ChallengesToMe(String challenges) throws RemoteException{
        otherChallenges = GWInterface.AskByChallenges(player).split(",");
        LabelsChallenges = new JLabel[otherChallenges.length];
        ComboChallenges.addItem(otherChallenges[0]);
        //ComboChallenges.addItem(otherChallenges[1]);

        
        for (int i = 0; i < otherChallenges.length; i++) {
            if (otherChallenges[i] != null) {
                if((ComboChallenges.getItemAt(i)!=null)&& (!ComboChallenges.getItemAt(i).toString().equals(otherChallenges[i]))){
                labelRetos.setText(challenges);
                ComboChallenges.addItem(otherChallenges[i]);
//                LabelsChallenges[i] = new JLabel();
//                LabelsChallenges[i].setText(otherChallenges[i]);
//                LabelsChallenges[i].setVisible(true);
//                challengesPanel.add(LabelsOnLinePlayers[i]);
                }
            }
        }
        challengesPanel.setVisible(true);
    }
    
    public void seeTurn(String trurn) throws RemoteException{
        LabelTurn.setText(GWInterface.SeeTurn(game));
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        challengesPanel = new javax.swing.JPanel();
        labelRetos = new javax.swing.JLabel();
        ComboChallenges = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnAna = new javax.swing.JButton();
        btnPatrick = new javax.swing.JButton();
        btnCraig = new javax.swing.JButton();
        btnJoe = new javax.swing.JButton();
        btnRebecca = new javax.swing.JButton();
        btnTom = new javax.swing.JButton();
        btnCindy = new javax.swing.JButton();
        btnHeater = new javax.swing.JButton();
        btnEric = new javax.swing.JButton();
        btnStella = new javax.swing.JButton();
        btnRobert = new javax.swing.JButton();
        btnSam = new javax.swing.JButton();
        btnSarah = new javax.swing.JButton();
        btnGary = new javax.swing.JButton();
        btnMary = new javax.swing.JButton();
        btnJack = new javax.swing.JButton();
        btnTheresa = new javax.swing.JButton();
        btnLuna = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        HairColor = new javax.swing.JComboBox();
        EyesColor = new javax.swing.JComboBox();
        SkinColor = new javax.swing.JComboBox();
        Sex = new javax.swing.JComboBox();
        Glases = new javax.swing.JComboBox();
        Barb = new javax.swing.JComboBox();
        Moustache = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        askCharacterChooser = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        LabelMyCharacter = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        LabelTurn = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelAnswer = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNickName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        onLinePanel = new javax.swing.JPanel();
        ComboOnLines = new javax.swing.JComboBox();
        btnAcceptChallenge = new javax.swing.JButton();
        btnRejectChallenge = new javax.swing.JButton();
        btnChallenge = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelRetos.setText("jLabel15");

        ComboChallenges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboChallengesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout challengesPanelLayout = new javax.swing.GroupLayout(challengesPanel);
        challengesPanel.setLayout(challengesPanelLayout);
        challengesPanelLayout.setHorizontalGroup(
            challengesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(challengesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRetos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(challengesPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(ComboChallenges, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        challengesPanelLayout.setVerticalGroup(
            challengesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(challengesPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelRetos)
                .addGap(18, 18, 18)
                .addComponent(ComboChallenges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Ana.png"))); // NOI18N
        btnAna.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Ana2.png"))); // NOI18N
        btnAna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnaActionPerformed(evt);
            }
        });

        btnPatrick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Patrick.png"))); // NOI18N
        btnPatrick.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Patrick2.png"))); // NOI18N
        btnPatrick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatrickActionPerformed(evt);
            }
        });

        btnCraig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Craig.png"))); // NOI18N
        btnCraig.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Craig2.png"))); // NOI18N
        btnCraig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCraigActionPerformed(evt);
            }
        });

        btnJoe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Joe.png"))); // NOI18N
        btnJoe.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Joe2.png"))); // NOI18N
        btnJoe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoeActionPerformed(evt);
            }
        });

        btnRebecca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Rebecca.png"))); // NOI18N
        btnRebecca.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Rebecca2.png"))); // NOI18N
        btnRebecca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRebeccaActionPerformed(evt);
            }
        });

        btnTom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Tom.png"))); // NOI18N
        btnTom.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Tom2.png"))); // NOI18N
        btnTom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomActionPerformed(evt);
            }
        });

        btnCindy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Cindy.png"))); // NOI18N
        btnCindy.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Cindy2.png"))); // NOI18N
        btnCindy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCindyActionPerformed(evt);
            }
        });

        btnHeater.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Heater.png"))); // NOI18N
        btnHeater.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Heater2.png"))); // NOI18N
        btnHeater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeaterActionPerformed(evt);
            }
        });

        btnEric.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Eric.png"))); // NOI18N
        btnEric.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Eric2.png"))); // NOI18N
        btnEric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEricActionPerformed(evt);
            }
        });

        btnStella.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Stella.png"))); // NOI18N
        btnStella.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Stella2.png"))); // NOI18N
        btnStella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStellaActionPerformed(evt);
            }
        });

        btnRobert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Robert.png"))); // NOI18N
        btnRobert.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Robert2.png"))); // NOI18N
        btnRobert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRobertActionPerformed(evt);
            }
        });

        btnSam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Sam.png"))); // NOI18N
        btnSam.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Sam2.png"))); // NOI18N
        btnSam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSamActionPerformed(evt);
            }
        });

        btnSarah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Sarah.png"))); // NOI18N
        btnSarah.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Sarah2.png"))); // NOI18N
        btnSarah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSarahActionPerformed(evt);
            }
        });

        btnGary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Gary.png"))); // NOI18N
        btnGary.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Gary2.png"))); // NOI18N
        btnGary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGaryActionPerformed(evt);
            }
        });

        btnMary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Mary.png"))); // NOI18N
        btnMary.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Mary2.png"))); // NOI18N
        btnMary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaryActionPerformed(evt);
            }
        });

        btnJack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Jack.png"))); // NOI18N
        btnJack.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Jack2.png"))); // NOI18N
        btnJack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJackActionPerformed(evt);
            }
        });

        btnTheresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Theresa.png"))); // NOI18N
        btnTheresa.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Theresa2.png"))); // NOI18N
        btnTheresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTheresaActionPerformed(evt);
            }
        });

        btnLuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Luna.png"))); // NOI18N
        btnLuna.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/Luna2.png"))); // NOI18N
        btnLuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLunaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAna, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCindy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPatrick, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHeater, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCraig, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEric, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnJoe, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStella, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRobert, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRebecca, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTom, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSam, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSarah, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGary, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMary, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnJack, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTheresa, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLuna, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAna, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnPatrick, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnCraig, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnJoe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnRebecca, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnTom, javax.swing.GroupLayout.PREFERRED_SIZE, 166, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCindy, javax.swing.GroupLayout.PREFERRED_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btnHeater, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEric, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnStella, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnRobert, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSarah, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnGary, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnMary, javax.swing.GroupLayout.PREFERRED_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btnJack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnTheresa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnLuna, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setText("My character");

        jLabel3.setText("Preguntas:");

        HairColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Amarillo", "Cafe", "Naranja", "Negro", " ", " ", " " }));
        HairColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HairColorActionPerformed(evt);
            }
        });

        EyesColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Azul", "Cafe", "Naranja", "Negro", "Verde" }));
        EyesColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EyesColorActionPerformed(evt);
            }
        });

        SkinColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blanco", "Negro" }));
        SkinColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SkinColorActionPerformed(evt);
            }
        });

        Sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "male", "female" }));
        Sex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SexActionPerformed(evt);
            }
        });

        Glases.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "true", "false" }));
        Glases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GlasesActionPerformed(evt);
            }
        });

        Barb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "true", "false" }));
        Barb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarbActionPerformed(evt);
            }
        });

        Moustache.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "true", "false" }));
        Moustache.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoustacheActionPerformed(evt);
            }
        });

        jLabel4.setText("Color de cabello");

        jLabel5.setText("Color de ojos");

        jLabel6.setText("Color de piel");

        jLabel7.setText("Bigote");

        jLabel8.setText("Barba");

        jLabel9.setText("Gafas");

        jLabel10.setText("Sexo");

        askCharacterChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ana", "Patrick", "Craig", "Joe", "Rebecca", "Tom", "Cindy", "Heather", "Eric", "Stella", "Robert", "Sam", "Sarah", "Gray", "Mary", "Jack", "Theresa", "Luna", " " }));
        askCharacterChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                askCharacterChooserActionPerformed(evt);
            }
        });

        jLabel11.setText("Personaje");

        LabelMyCharacter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/resourses/img/User.png"))); // NOI18N

        jLabel13.setText("TURNO:");

        LabelTurn.setText("...");

        jLabel14.setText("RESPUESTA:");

        labelAnswer.setText("...");

        jLabel16.setText("Nick:");

        txtNickName.setText("Enter your nick");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(LabelMyCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(HairColor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EyesColor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SkinColor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Moustache, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(Barb, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Glases, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Sex, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9)
                                        .addGap(111, 111, 111)
                                        .addComponent(jLabel10)
                                        .addGap(64, 64, 64)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(askCharacterChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel11))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel4)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel6)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel16)))
                        .addGap(18, 18, 18)
                        .addComponent(txtNickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(LabelTurn)
                    .addComponent(jLabel14)
                    .addComponent(labelAnswer))
                .addGap(118, 118, 118))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel16)
                            .addComponent(txtNickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelMyCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel13))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HairColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EyesColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SkinColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Moustache, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelTurn))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(askCharacterChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelAnswer)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Barb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Glases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("RETOS:");

        jLabel12.setText("ON LINE:");

        javax.swing.GroupLayout onLinePanelLayout = new javax.swing.GroupLayout(onLinePanel);
        onLinePanel.setLayout(onLinePanelLayout);
        onLinePanelLayout.setHorizontalGroup(
            onLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(onLinePanelLayout.createSequentialGroup()
                .addComponent(ComboOnLines, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        onLinePanelLayout.setVerticalGroup(
            onLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(onLinePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboOnLines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        btnAcceptChallenge.setText("Aceptar");
        btnAcceptChallenge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptChallengeActionPerformed(evt);
            }
        });

        btnRejectChallenge.setText("Rechazar");

        btnChallenge.setText("Retar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(challengesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(onLinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnChallenge, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAcceptChallenge, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(btnRejectChallenge)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRejectChallenge)
                            .addComponent(btnAcceptChallenge))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(challengesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(btnChallenge))
                        .addGap(18, 18, 18)
                        .addComponent(onLinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HairColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HairColorActionPerformed
        try {
            if(GWInterface.AskCharacteristic(game, player,"hairColor "+ HairColor.getItemAt(HairColor.getSelectedIndex()))){
                labelAnswer.setText("Si tiene cabello color: "+HairColor.getItemAt(HairColor.getSelectedIndex()) );
//            for (int i = 0; i< characterss.size(); i++) {
//                if (!characterss.get(i).getSelfcharacteristic().get(1).equals(HairColor.getItemAt(HairColor.getSelectedIndex()))) {//si el character tiene la misma característica
//                    labels.get(i).setEnabled(false);
//                }
//            }
            }else{
                labelAnswer.setText("NO tiene cabello color: "+HairColor.getItemAt(HairColor.getSelectedIndex()) );
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GuessWhoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_HairColorActionPerformed

    private void btnAcceptChallengeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptChallengeActionPerformed
            // tomar el seleccionado del panel retos
            // tomar el nick
            //player = txtNickName.getText();
            
            try{
//                thread = new GuessWhoClientStatesThread(this, GWInterface, player, game);
//                thread.start();
//                game = GWInterface.AnswerChallenges(player, testPlayer, "Aceptar");
                txtNickName.setText(player);
                txtNickName.setEditable(false);
                btnAcceptChallenge.setEnabled(false);
                btnRejectChallenge.setEnabled(false);
                btnChallenge.setEnabled(false);
                GWInterface.AnswerChallenges(player, defiant, "Aceptar");
//                game = thread.GWInterface.AnswerChallenges(player, defiant, "Aceptar");

                System.out.println("character of player: "+GWInterface.SeeCharacter(game, player));
                System.out.println("character of test: "+GWInterface.SeeCharacter(game, testPlayer));
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
//iniciar el hilo
            
    }//GEN-LAST:event_btnAcceptChallengeActionPerformed

    private void btnAnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnaActionPerformed
        btnAna.setEnabled(false);
    }//GEN-LAST:event_btnAnaActionPerformed

    private void btnCindyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCindyActionPerformed
        btnCindy.setEnabled(false);
    }//GEN-LAST:event_btnCindyActionPerformed

    private void btnHeaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeaterActionPerformed
        btnHeater.setEnabled(false);
    }//GEN-LAST:event_btnHeaterActionPerformed

    private void btnEricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEricActionPerformed
        btnEric.setEnabled(false);
    }//GEN-LAST:event_btnEricActionPerformed

    private void btnStellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStellaActionPerformed
        btnStella.setEnabled(false);
    }//GEN-LAST:event_btnStellaActionPerformed

    private void btnRobertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRobertActionPerformed
        btnRobert.setEnabled(false);
    }//GEN-LAST:event_btnRobertActionPerformed

    private void btnSamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSamActionPerformed
       btnSam.setEnabled(false);
    }//GEN-LAST:event_btnSamActionPerformed

    private void btnSarahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSarahActionPerformed
        btnSarah.setEnabled(false);
    }//GEN-LAST:event_btnSarahActionPerformed

    private void btnGaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGaryActionPerformed
        btnGary.setEnabled(false);
    }//GEN-LAST:event_btnGaryActionPerformed

    private void btnMaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaryActionPerformed
        btnMary.setEnabled(false);
    }//GEN-LAST:event_btnMaryActionPerformed

    private void btnJackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJackActionPerformed
        btnJack.setEnabled(false);
    }//GEN-LAST:event_btnJackActionPerformed

    private void btnTheresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTheresaActionPerformed
        btnTheresa.setEnabled(false);
    }//GEN-LAST:event_btnTheresaActionPerformed

    private void btnLunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLunaActionPerformed
        btnLuna.setEnabled(false);
    }//GEN-LAST:event_btnLunaActionPerformed

    private void btnCraigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCraigActionPerformed
        btnCraig.setEnabled(false);
    }//GEN-LAST:event_btnCraigActionPerformed

    private void btnPatrickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatrickActionPerformed
        btnPatrick.setEnabled(false);
    }//GEN-LAST:event_btnPatrickActionPerformed

    private void btnJoeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoeActionPerformed
        btnJoe.setEnabled(false);
    }//GEN-LAST:event_btnJoeActionPerformed

    private void btnRebeccaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRebeccaActionPerformed
        btnRebecca.setEnabled(false);
    }//GEN-LAST:event_btnRebeccaActionPerformed

    private void btnTomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomActionPerformed
        btnTom.setEnabled(false);
    }//GEN-LAST:event_btnTomActionPerformed

    private void EyesColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EyesColorActionPerformed
        try {
            if(GWInterface.AskCharacteristic(game, player,"eyesColor "+ EyesColor.getItemAt(EyesColor.getSelectedIndex()))){
                labelAnswer.setText("SI tiene ojos color: "+EyesColor.getItemAt(EyesColor.getSelectedIndex()) );
            }else{
                labelAnswer.setText("NO tiene ojos color: "+EyesColor.getItemAt(EyesColor.getSelectedIndex()) );
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GuessWhoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EyesColorActionPerformed

    private void SkinColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SkinColorActionPerformed
        try {
            if(GWInterface.AskCharacteristic(game, player,"skinColor "+ SkinColor.getItemAt(SkinColor.getSelectedIndex()))){
                labelAnswer.setText("SI tiene piel color: "+SkinColor.getItemAt(SkinColor.getSelectedIndex()) );
            }else{
                labelAnswer.setText("NO tiene piel color: "+SkinColor.getItemAt(SkinColor.getSelectedIndex()) );
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GuessWhoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SkinColorActionPerformed

    private void MoustacheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoustacheActionPerformed
        try {
            if(GWInterface.AskCharacteristic(game, player,"moustache "+ Moustache.getItemAt(Moustache.getSelectedIndex()))){
                labelAnswer.setText("SI tiene bigote");
            }else{
                labelAnswer.setText("NO tiene bigote");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GuessWhoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MoustacheActionPerformed

    private void BarbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarbActionPerformed
        try {
            if(GWInterface.AskCharacteristic(game, player,"barb "+ Barb.getItemAt(Barb.getSelectedIndex()))){
                labelAnswer.setText("SI tiene barba");
            }else{
                labelAnswer.setText("NO tiene barba");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GuessWhoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BarbActionPerformed

    private void GlasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GlasesActionPerformed
        try {
            if(GWInterface.AskCharacteristic(game, player,"glases "+ Glases.getItemAt(Glases.getSelectedIndex()))){
                labelAnswer.setText("SI tiene gafas");
            }else{
                labelAnswer.setText("NO tiene gafas");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GuessWhoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GlasesActionPerformed

    private void SexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SexActionPerformed
        try {
            if(GWInterface.AskCharacteristic(game, player,"sexo "+ Sex.getItemAt(Sex.getSelectedIndex()))){
                labelAnswer.setText("SI es: "+ Sex.getItemAt(Sex.getSelectedIndex()));
            }else{
                labelAnswer.setText("NO es: "+ Sex.getItemAt(Sex.getSelectedIndex()));
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GuessWhoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SexActionPerformed

    private void askCharacterChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_askCharacterChooserActionPerformed
        String characterChoosed = ""+ askCharacterChooser.getItemAt(askCharacterChooser.getSelectedIndex());
        System.out.println("verificando el pj escogido: "+characterChoosed);
        try {
            if (GWInterface.AskCharacter(game, player, characterChoosed)) {
                labelAnswer.setText("ganadorasdf");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GuessWhoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_askCharacterChooserActionPerformed

    private void ComboChallengesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboChallengesActionPerformed
        defiant = ComboChallenges.getSelectedItem().toString();
        btnAcceptChallenge.setEnabled(true);
    }//GEN-LAST:event_ComboChallengesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuessWhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuessWhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuessWhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuessWhoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GuessWhoView("localhost").setVisible(true);
                } catch (NotBoundException ex) {
                    Logger.getLogger(GuessWhoView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GuessWhoView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(GuessWhoView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Barb;
    private javax.swing.JComboBox ComboChallenges;
    private javax.swing.JComboBox ComboOnLines;
    private javax.swing.JComboBox EyesColor;
    private javax.swing.JComboBox Glases;
    private javax.swing.JComboBox HairColor;
    private javax.swing.JLabel LabelMyCharacter;
    private javax.swing.JLabel LabelTurn;
    private javax.swing.JComboBox Moustache;
    private javax.swing.JComboBox Sex;
    private javax.swing.JComboBox SkinColor;
    private javax.swing.JComboBox askCharacterChooser;
    private javax.swing.JButton btnAcceptChallenge;
    private javax.swing.JButton btnAna;
    private javax.swing.JButton btnChallenge;
    private javax.swing.JButton btnCindy;
    private javax.swing.JButton btnCraig;
    private javax.swing.JButton btnEric;
    private javax.swing.JButton btnGary;
    private javax.swing.JButton btnHeater;
    private javax.swing.JButton btnJack;
    private javax.swing.JButton btnJoe;
    private javax.swing.JButton btnLuna;
    private javax.swing.JButton btnMary;
    private javax.swing.JButton btnPatrick;
    private javax.swing.JButton btnRebecca;
    private javax.swing.JButton btnRejectChallenge;
    private javax.swing.JButton btnRobert;
    private javax.swing.JButton btnSam;
    private javax.swing.JButton btnSarah;
    private javax.swing.JButton btnStella;
    private javax.swing.JButton btnTheresa;
    private javax.swing.JButton btnTom;
    private javax.swing.JPanel challengesPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelAnswer;
    private javax.swing.JLabel labelRetos;
    private javax.swing.JPanel onLinePanel;
    private javax.swing.JTextField txtNickName;
    // End of variables declaration//GEN-END:variables
    //jButton1 = new JButton();
    //jLabel1
            
//Icon icon = new ImageIcon(getClass().getResource("bangheadonwall.jpg")); 
//JLabel label = new JLabel("An icon", image);
}
