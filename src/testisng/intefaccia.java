/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package testisng;

import java.awt.Desktop;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.io.*;
import javax.sound.sampled.*;


public class intefaccia extends JFrame {

    private Clip clip;
    private Timer timer;
    private int val = 0;// Opacità iniziale del frame

    public intefaccia() {
        initComponents();
        canzonebase();
        startTimer();
        Pareggioxxl.setVisible(false);
        schermo3.setVisible(false);
        schermo2.setVisible(false);
        Pareggiobot.setVisible(false);
        schermo.setVisible(false);
        Pareggio1v1.setVisible(false);
        Vittoria3.setVisible(false);
        vitinidietrobot.setVisible(false);
        riprova.setVisible(false);
        Sconfitta.setVisible(false);
        sfondo2.setVisible(false);
        Dashboard.setVisible(false);
        ClassicDash.setVisible(false);
        Tris1v1.setVisible(false);
        TrisBot.setVisible(false);
        TrisXXL.setVisible(false);
        TrisChess.setVisible(false);
        Difficolta.setVisible(false);
        TutorialTris.setVisible(false);
        TutorialTris_2.setVisible(false);
        Tutorial_XXL.setVisible(false);
        Tutorial_Chess.setVisible(false);
        SfondoVittoria.setVisible(false);
        Vitindietro1.setVisible(false);
        giocatore.setVisible(false);
        Vittoria1.setVisible(false);
        Vitindietro2.setVisible(false);
        giocatore1.setVisible(false);

        Vittoria2.setVisible(false);
        Vitindietro3.setVisible(false);
        giocatore2.setVisible(false);

        Settings.setVisible(false);
        AudioOff.setVisible(false);

        // Aggiungi il KeyListener al frame
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Home.setVisible(false);
                    Dashboard.setVisible(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        setFocusable(true);
        requestFocus();
        po = 0;
        px = 0;
        PunteggioX.setText("" + px);
        Punteggio0.setText("" + px);

    }

    /*
___  ___          _           
|  \/  |         (_)          
| .  . |_   _ ___ _  ___ __ _ 
| |\/| | | | / __| |/ __/ _` |
| |  | | |_| \__ \ | (_| (_| |
\_|  |_/\__,_|___/_|\___\__,_|
                              
     */
    private void canzonebase() {
        try {
            String filePath = "canzone.wav";
            File audioFile = new File(filePath);
            AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);

            // Leggi i dati audio in un buffer di byte
            byte[] audioData = new byte[(int) audioFile.length()];
            ais.read(audioData);

            // Crea un ByteArrayInputStream dal buffer di byte
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
            AudioInputStream audioInputStream = new AudioInputStream(byteArrayInputStream, ais.getFormat(), audioData.length);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void canzonevittoria() {
        try {
            String filePath = "vittoria.wav";
            File audioFile = new File(filePath);
            AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);

            // Leggi i dati audio in un buffer di byte
            byte[] audioData = new byte[(int) audioFile.length()];
            ais.read(audioData);

            // Crea un ByteArrayInputStream dal buffer di byte
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
            AudioInputStream audioInputStream = new AudioInputStream(byteArrayInputStream, ais.getFormat(), audioData.length);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void canzonesconfitta() {
        try {
            String filePath = "perdita.wav";
            File audioFile = new File(filePath);
            AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);

            // Leggi i dati audio in un buffer di byte
            byte[] audioData = new byte[(int) audioFile.length()];
            ais.read(audioData);

            // Crea un ByteArrayInputStream dal buffer di byte
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
            AudioInputStream audioInputStream = new AudioInputStream(byteArrayInputStream, ais.getFormat(), audioData.length);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void suonoErrore() {
        try {
            String filePath = "errore.wav";
            File audioFile = new File(filePath);
            AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);

            // Leggi i dati audio in un buffer di byte
            byte[] audioData = new byte[(int) audioFile.length()];
            ais.read(audioData);

            // Crea un ByteArrayInputStream dal buffer di byte
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
            AudioInputStream audioInputStream = new AudioInputStream(byteArrayInputStream, ais.getFormat(), audioData.length);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stopSong() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    /*
    
  ___        _                     _             _ 
 / _ \      (_)                   (_)           (_)
/ /_\ \_ __  _ _ __ ___   __ _ _____  ___  _ __  _ 
|  _  | '_ \| | '_ ` _ \ / _` |_  / |/ _ \| '_ \| |
| | | | | | | | | | | | | (_| |/ /| | (_) | | | | |
\_| |_/_| |_|_|_| |_| |_|\__,_/___|_|\___/|_| |_|_|
                                                     
     */
    private void startTimer() {
        timer = new Timer(4600, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sfondo1.setVisible(false);
                sfondo2.setVisible(true);
            }
        });
        timer.setRepeats(false); // Imposta il timer per non ripetersi
        timer.start(); // Avvia il timer
    }

    // Funzione per cambiare l'immagine del pulsante
    private void changeButtonImage(JButton button) {
        // Cambia l'immagine del pulsante
        // Ad esempio,da iconX a iconZero
        if (button.getIcon().equals(iconX)) {
            button.setIcon(iconXD);
        } else {
            button.setIcon(iconZeroD);
        }
    }

// Inizializza il timer per cambiare l'immagine del pulsante dopo un certo periodo di tempo
    private void initButtonTimer(JButton button) {
        // Imposta un timer che eseguirà l'azione dopo un certo periodo di tempo
        buttonTimer = new Timer(650, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeButtonImage(button); // Cambia l'immagine del pulsante
            }
        });
        buttonTimer.setRepeats(false); // Imposta il timer per non ripetersi
    }

// Funzione per avviare il timer per un determinato pulsante
    private void startButtonTimer(JButton button) {
        initButtonTimer(button); // Inizializza il timer per il pulsante
        buttonTimer.start(); // Avvia il timer
    }

    /*
    
 _____ _                         
| ___ (_)                        
| |_/ /_ ___  ___  _ __ ___  ___ 
|    /| / __|/ _ \| '__/ __|/ _ \
| |\ \| \__ \ (_) | |  \__ \  __/
\_| \_|_|___/\___/|_|  |___/\___|
                                                                    
     */
    int[][] tris = new int[3][3];
    private String currentPlayer;

    Random random = new Random();
    ImageIcon iconZero = new ImageIcon("Cerchioanimato2.gif");
    ImageIcon iconX = new ImageIcon("Xanimata-ezgif.com-resize.gif");
    ImageIcon iconZeroD = new ImageIcon("cerchio.png");
    ImageIcon iconXD = new ImageIcon("ex.png");
    ImageIcon iconXBordo = new ImageIcon("ex1.png");
    ImageIcon iconOBordo = new ImageIcon("cerchio1.png");
    ImageIcon iconCambioX = new ImageIcon("TurnoX.png");
    ImageIcon iconCambioO = new ImageIcon("TurnoO.png");
    ImageIcon giocatoreX = new ImageIcon("VgiocatoreX.png");
    ImageIcon giocatoreO = new ImageIcon("VgiocatoreO.png");
    ImageIcon pareggio = new ImageIcon("pareggiotris.gif");

    private int po = 0;
    private int px = 0;

    /*
  _        __  
/  |      /  | 
`| |_   __`| | 
 | \ \ / / | | 
_| |\ V / _| |_
\___/\_/  \___/
                            
     */
    public void inizializzaMatrice() {
        int num = random.nextInt(2);
        System.out.println(num);
        if (num == 0) {
            currentPlayer = "x";
            Turno.setIcon(iconCambioX);
        } else {
            currentPlayer = "o";
            Turno.setIcon(iconCambioO);
        }
        tris[0][0] = 0;
        tris[0][1] = 0;
        tris[0][2] = 0;
        tris[1][0] = 0;
        tris[1][1] = 0;
        tris[1][2] = 0;
        tris[2][0] = 0;
        tris[2][1] = 0;
        tris[2][2] = 0;

        System.out.println(currentPlayer);
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tris[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWin() {
        return (checkRowsWin() || checkColumnsWin() || checkDiagonalsWin());
    }

    private boolean checkRowsWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(tris[i][0], tris[i][1], tris[i][2])) {
                return true;
            }
        }

        return false;
    }

    private boolean checkColumnsWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(tris[0][i], tris[1][i], tris[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsWin() {
        return ((checkRowCol(tris[0][0], tris[1][1], tris[2][2]))
                || (checkRowCol(tris[0][2], tris[1][1], tris[2][0])));
    }

    private boolean checkRowCol(int c1, int c2, int c3) {
        if (c1 == c2 && c2 == c3 && c2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    private void resetBoard() {
        ImageIcon icon = new ImageIcon("miniSfondo.jpg");
        Uno.setIcon(icon);
        Due.setIcon(icon);
        Tre.setIcon(icon);
        Quattro.setIcon(icon);
        Cinque.setIcon(icon);
        Sei.setIcon(icon);
        Sette.setIcon(icon);
        Otto.setIcon(icon);
        Nove.setIcon(icon);
    }

    public void controllo() {
        if (checkForWin()) {
            if (currentPlayer.equals("o")) {
                Timer timer = new Timer(800, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        px++;
                        SfondoVittoria.setVisible(true);
                        stopSong();
                        canzonevittoria();
                        Vitindietro1.setVisible(true);
                        giocatore.setIcon(giocatoreX);
                        giocatore.setVisible(true);
                        PunteggioX.setText("" + px);
                        resetBoard();
                        inizializzaMatrice();
                    }
                });
                // Programma l'aggiornamento dell'immagine per la mossa del bot 
                timer.setRepeats(false);
                timer.start(); // Fai la mossa del computer
            } else {
                Timer timer = new Timer(800, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        po++;
                        SfondoVittoria.setVisible(true);
                        stopSong();
                        canzonevittoria();
                        Vitindietro1.setVisible(true);
                        giocatore.setIcon(giocatoreO);
                        giocatore.setVisible(true);
                        Punteggio0.setText("" + po);
                        resetBoard();
                        inizializzaMatrice();
                    }
                });
                // Programma l'aggiornamento dell'immagine per la mossa del bot dopo un secondo
                timer.setRepeats(false);
                timer.start(); // Fai la mossa del computer
            }

        } else {
            if (isBoardFull()) {
                schermo.setVisible(true);
                Pareggio1v1.setVisible(true);
                Turno.setVisible(false);
                Timer timer = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        inizializzaMatrice();
                        resetBoard();
                        schermo.setVisible(false);
                        Pareggio1v1.setVisible(false);
                        Turno.setVisible(true);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    public void inserisciIcona(JButton b, int n, int m) {
        if (tris[n][m] == 0) {
            if (currentPlayer.equals("x")) {
                b.setIcon(iconX);
                tris[n][m] = 1;
                currentPlayer = "o";
                Turno.setIcon(iconCambioO);
            } else {
                b.setIcon(iconZero);
                tris[n][m] = 2;
                currentPlayer = "x";
                Turno.setIcon(iconCambioX);
            }
            startButtonTimer(b);
        }
    }

    /*    
______       _   
| ___ \     | |  
| |_/ / ___ | |_ 
| ___ \/ _ \| __|
| |_/ / (_) | |_ 
\____/ \___/ \__|
                                
     */
    private void resetBoardBot() {
        ImageIcon icon = new ImageIcon("miniSfondo.jpg");
        CinqueBot.setIcon(icon);
        SeiBot.setIcon(icon);
        NoveBot.setIcon(icon);
        SetteBot.setIcon(icon);
        OttoBot.setIcon(icon);
        DueBot.setIcon(icon);
        QuattroBot.setIcon(icon);
        UnoBot.setIcon(icon);
        TreBot.setIcon(icon);
    }

    int difficolta = 0;

    private void mossaComputer() {
        int bestScore = Integer.MIN_VALUE;
        int bestMoveX = -1;
        int bestMoveY = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tris[i][j] == 0) {
                    tris[i][j] = 2; // Fai la mossa del computer

                    int score = minimax(tris, 0, false); // Calcola il punteggio della mossa
                    tris[i][j] = 0; // Annulla la mossa

                    if (score > bestScore) {
                        bestScore = score;
                        bestMoveX = i;
                        bestMoveY = j;
                    }
                }
            }
        }

        int temp = random.nextInt(difficolta);
        System.out.println(temp);
        if (temp == 0) {
            // Scegli una mossa casuale tra quelle disponibili
            int randomMove = random.nextInt(9);
            while (tris[randomMove / 3][randomMove % 3] != 0) {
                randomMove = random.nextInt(9);
            }
            bestMoveX = randomMove / 3;
            bestMoveY = randomMove % 3;
        }

        if (bestMoveX != -1 && bestMoveY != -1) {
            tris[bestMoveX][bestMoveY] = 2; // Fai la mossa migliore
            updateButton(bestMoveX, bestMoveY); // Aggiorna il pulsante grafico
        }
        if (checkForWin()) {

            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Sconfitta.setVisible(true);
                    riprova.setVisible(true);
                    stopSong();
                    canzonesconfitta();
                    po++;
                    resetBoardBot();
                    inizializzaMatrice();
                    PunteggioO1.setText("" + po);
                }
            });
            // Programma l'aggiornamento dell'immagine per la mossa del bot dopo un secondo
            timer.setRepeats(false);
            timer.start(); // Fai la mossa del computer

            return; // Termina la funzione se il computer ha vinto
        }
        // Termina la funzione se il computer ha vinto

    }

    private int minimax(int[][] board, int depth, boolean isMaximizing) {
        if (checkForWin()) {
            return isMaximizing ? -10 : 10; // Se il computer vince, restituisce un punteggio alto
        } else if (isBoardFull() || depth >= 9) {
            return 0; // Se c'è pareggio o la profondità massima è stata raggiunta, restituisce un punteggio neutro
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 2; // Simula la mossa del computer
                        int score = minimax(board, depth + 1, false);
                        board[i][j] = 0; // Annulla la mossa
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 1; // Simula la mossa del giocatore
                        int score = minimax(board, depth + 1, true);
                        board[i][j] = 0; // Annulla la mossa
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    private void updateButton(int x, int y) {
        System.out.println("Updating button at position (" + x + ", " + y + ")");
        //Timer timer = new Timer(800, new ActionListener() {
        //@Override
        //public void actionPerformed(ActionEvent e) {
        switch (x) {
            case 0:
                switch (y) {
                    case 0:
                        UnoBot.setIcon(iconZero);
                        startButtonTimer(UnoBot);
                        break;
                    case 1:
                        DueBot.setIcon(iconZero);
                        startButtonTimer(DueBot);
                        break;
                    case 2:
                        TreBot.setIcon(iconZero);
                        startButtonTimer(TreBot);
                        break;
                }
                break;
            case 1:
                switch (y) {
                    case 0:
                        QuattroBot.setIcon(iconZero);
                        startButtonTimer(QuattroBot);
                        break;
                    case 1:
                        CinqueBot.setIcon(iconZero);
                        startButtonTimer(CinqueBot);
                        break;
                    case 2:
                        SeiBot.setIcon(iconZero);
                        startButtonTimer(SeiBot);
                        break;
                }
                break;
            case 2:
                switch (y) {
                    case 0:
                        SetteBot.setIcon(iconZero);
                        startButtonTimer(SetteBot);
                        break;
                    case 1:
                        OttoBot.setIcon(iconZero);
                        startButtonTimer(OttoBot);
                        break;
                    case 2:
                        NoveBot.setIcon(iconZero);
                        startButtonTimer(NoveBot);
                        break;
                }
                break;
        }
    }

    public void nuovoTurno() {
        px++;
        resetBoardBot();
        inizializzaMatrice();
        PunteggioX1.setText("" + px);
    }

    public void inserisciIconaBot(JButton b, int n, int m) {
        if (tris[n][m] == 0) {
            b.setIcon(iconX);
            tris[n][m] = 1;
            startButtonTimer(b);
            if (checkForWin()) {
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Vittoria3.setVisible(true);
                        vitinidietrobot.setVisible(true);
                        stopSong();
                        canzonevittoria();
                        nuovoTurno();
                    }
                });
                // Programma l'aggiornamento dell'immagine per la mossa del bot dopo un secondo
                timer.setRepeats(false);
                timer.start(); // Fai la mossa del computer

            } else {
                if (isBoardFull()) {
                    schermo2.setVisible(true);
                    Pareggiobot.setVisible(true);
                    Timer timer = new Timer(5000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            inizializzaMatrice();
                            resetBoardBot();
                            schermo2.setVisible(false);
                            Pareggiobot.setVisible(false);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    Timer timer = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            mossaComputer();
                        }
                    });
                    // Programma l'aggiornamento dell'immagine per la mossa del bot dopo un secondo
                    timer.setRepeats(false);
                    timer.start(); // Fai la mossa del computer
                }
            }
        }
    }

    /*
___   ___ ___   ___  __      
\  \ /  / \  \ /  / |  |     
 \  V  /   \  V  /  |  |     
  >   <     >   <   |  |     
 /  .  \   /  .  \  |  `----.
/__/ \__\ /__/ \__\ |_______|
                             
     */
    int[][] trisXL = new int[5][5];
    Random randomXL = new Random();
    ImageIcon iconZeroDXL = new ImageIcon("Oridotta.png");
    ImageIcon iconXDXL = new ImageIcon("Xridotta.png");
    ImageIcon iconZeroXL = new ImageIcon("Cerchioanimatoridotto.gif");
    ImageIcon iconXXL = new ImageIcon("Xanimataridotta.gif");
    ImageIcon iconZerolXL = new ImageIcon("Oturn.png");
    ImageIcon iconXlXL = new ImageIcon("Xturn.png");

    public void inizializzaMatriceXL() {
        int num = randomXL.nextInt(2);
        System.out.println(num);
        if (num == 0) {
            currentPlayer = "x";
        } else {
            currentPlayer = "o";
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                trisXL[i][j] = 0;
            }
        }

        System.out.println("Current player: " + currentPlayer);
    }

    public boolean isBoardFullXL() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (trisXL[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void changeButtonImageXL(JButton button) {
        // Cambia l'immagine del pulsante in base alle tue esigenze
        // Ad esempio, se vuoi cambiare da iconX a iconZero
        if (button.getIcon().equals(iconXXL)) {
            button.setIcon(iconXDXL);
        } else {
            button.setIcon(iconZeroDXL);
        }
    }

// Inizializza il timer per cambiare l'immagine del pulsante dopo un certo periodo di tempo
    private void initButtonTimerXL(JButton button) {
        // Imposta un timer che eseguirà l'azione dopo un certo periodo di tempo (ad esempio, 3 secondi)
        buttonTimer = new Timer(650, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeButtonImageXL(button); // Cambia l'immagine del pulsante
            }
        });
        buttonTimer.setRepeats(false); // Imposta il timer per non ripetersi
    }

// Funzione per avviare il timer per un determinato pulsante
    private void startButtonTimerXL(JButton button) {
        initButtonTimerXL(button); // Inizializza il timer per il pulsante
        buttonTimer.start(); // Avvia il timer
    }

    public boolean checkForWinXL() {
        return (checkRowsWinXL() || checkColumnsWinXL() || checkDiagonalsWinXL());
    }

    private boolean checkRowsWinXL() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) { // Cambiato da 3 a 2
                if (trisXL[i][j] != 0 && trisXL[i][j] == trisXL[i][j + 1] && trisXL[i][j] == trisXL[i][j + 2] && trisXL[i][j] == trisXL[i][j + 3]) { // Aggiunto controllo per quattro icone uguali
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkColumnsWinXL() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) { // Cambiato da 3 a 2
                if (trisXL[j][i] != 0 && trisXL[j][i] == trisXL[j + 1][i] && trisXL[j][i] == trisXL[j + 2][i] && trisXL[j][i] == trisXL[j + 3][i]) { // Aggiunto controllo per quattro icone uguali
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalsWinXL() {
        for (int i = 0; i < 2; i++) { // Cambiato da 3 a 2
            for (int j = 0; j < 2; j++) { // Cambiato da 3 a 2
                if (trisXL[i][j] != 0 && trisXL[i][j] == trisXL[i + 1][j + 1] && trisXL[i][j] == trisXL[i + 2][j + 2] && trisXL[i][j] == trisXL[i + 3][j + 3]) { // Aggiunto controllo per quattro icone uguali
                    return true;
                }
                if (trisXL[i][j + 3] != 0 && trisXL[i][j + 3] == trisXL[i + 1][j + 2] && trisXL[i][j + 3] == trisXL[i + 2][j + 1] && trisXL[i][j + 3] == trisXL[i + 3][j]) { // Aggiunto controllo per quattro icone uguali
                    return true;
                }
            }
        }
        return false;
    }

    private void resetBoardXL() {

        ImageIcon icon = new ImageIcon("miniSfondo.jpg");
        XXL3.setIcon(icon);
        XXL2.setIcon(icon);
        XXL1.setIcon(icon);
        XXL6.setIcon(icon);
        XXL4.setIcon(icon);
        XXL5.setIcon(icon);
        XXL7.setIcon(icon);
        XXL8.setIcon(icon);
        XXL9.setIcon(icon);
        XXL10.setIcon(icon);
        XXL11.setIcon(icon);
        XXL12.setIcon(icon);
        XXL13.setIcon(icon);
        XXL14.setIcon(icon);
        XXL15.setIcon(icon);
        XXL16.setIcon(icon);
        XXL17.setIcon(icon);
        XXL18.setIcon(icon);
        XXL19.setIcon(icon);
        XXL20.setIcon(icon);
        XXL21.setIcon(icon);
        XXL22.setIcon(icon);
        XXL23.setIcon(icon);
        XXL24.setIcon(icon);
        XXL25.setIcon(icon);

    }

    public void controlloXL() {
        if (checkForWinXL()) {
            if (currentPlayer.equals("o")) {
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        px++;
                        Vittoria2.setVisible(true);
                        stopSong();
                        canzonevittoria();
                        Vitindietro3.setVisible(true);
                        giocatore2.setIcon(giocatoreX);
                        giocatore2.setVisible(true);
                        PunteggioO2.setText("" + px);
                        resetBoardXL();
                        inizializzaMatriceXL();
                    }
                });
                // Programma l'aggiornamento dell'immagine per la mossa del bot dopo un secondo
                timer.setRepeats(false);
                timer.start();

            } else {
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        po++;
                        Vittoria2.setVisible(true);
                        stopSong();
                        canzonevittoria();
                        Vitindietro3.setVisible(true);
                        giocatore2.setIcon(giocatoreO);
                        giocatore2.setVisible(true);
                        PunteggioX2.setText("" + po);
                        resetBoardXL();
                        inizializzaMatriceXL();
                    }
                });
                // Programma l'aggiornamento dell'immagine per la mossa del bot dopo un secondo
                timer.setRepeats(false);
                timer.start(); // Fai la mossa del computer

            }
        } else {
            if (isBoardFullXL()) {
                schermo3.setVisible(true);
                Pareggioxxl.setVisible(true);
                //Turno.setVisible(false);
                Timer timer = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        inizializzaMatriceXL();
                        resetBoardXL();
                        schermo3.setVisible(false);
                        Pareggioxxl.setVisible(false);
                        //Turno.setVisible(true);
                    }
                });
                timer.setRepeats(false);
                timer.start();
                //JOptionPane.showMessageDialog(rootPane, "PAREGGIO", "Partita finita", HEIGHT);
            }
        }
    }

    public void inserisciIconaXL(JButton b, int n, int m) {
        if (trisXL[n][m] == 0) {
            if (currentPlayer.equals("x")) {
                b.setIcon(iconXXL);
                trisXL[n][m] = 1;
                currentPlayer = "o";
                turnoXXL.setIcon(iconZerolXL);
            } else {
                b.setIcon(iconZeroXL);
                trisXL[n][m] = 2;
                currentPlayer = "x";
                turnoXXL.setIcon(iconXlXL);
            }
            startButtonTimerXL(b);
        }
    }

    /*
 _____ _                   
/  __ \ |                  
| /  \/ |__   ___  ___ ___ 
| |   | '_ \ / _ \/ __/ __|
| \__/\ | | |  __/\__ \__ \
 \____/_| |_|\___||___/___/
                                                     
     */
    public void inizializzaMatriceChess() {
        int num = random.nextInt(2);
        System.out.println(num);
        if (num == 0) {
            currentPlayer = "x";
            TurnoChess.setIcon(iconCambioX);
        } else {
            currentPlayer = "o";
            TurnoChess.setIcon(iconCambioO);
        }
        tris[0][0] = 2;
        tris[0][1] = 2;
        tris[0][2] = 2;
        tris[1][0] = 0;
        tris[1][1] = 0;
        tris[1][2] = 0;
        tris[2][0] = 1;
        tris[2][1] = 1;
        tris[2][2] = 1;

        mossa = 0;
        for (int i = 0; i < 3; i++) {
            mossaX[i] = 0;
        }
        for (int i = 0; i < 3; i++) {
            mossaY[i] = 0;
        }

        System.out.println(currentPlayer);
    }

    ImageIcon icon = new ImageIcon("miniSfondo.jpg");
    int mossa = 0;
    int[] mossaX = {0, 0, 0};
    int[] mossaY = {0, 0, 0};
    String bottoneTemp = "";

    private void togliIcon(String temp) {
        if ("jButton47".equals(temp)) {
            Chess8.setIcon(icon);
            tris[0][0] = 0;
            mossaY[0] = 1;
        } else if ("jButton48".equals(temp)) {
            Chess6.setIcon(icon);
            tris[0][1] = 0;
            mossaY[1] = 1;
        } else if ("jButton49".equals(temp)) {
            Chess9.setIcon(icon);
            tris[0][2] = 0;
            mossaY[2] = 1;
        } else if ("jButton50".equals(temp)) {
            Chess7.setIcon(icon);
            tris[1][0] = 0;
        } else if ("jButton51".equals(temp)) {
            Chess1.setIcon(icon);
            tris[1][1] = 0;
        } else if ("jButton52".equals(temp)) {
            Chess2.setIcon(icon);
            tris[1][2] = 0;
        } else if ("jButton53".equals(temp)) {
            Chess4.setIcon(icon);
            tris[2][0] = 0;
            mossaX[0] = 1;
        } else if ("jButton54".equals(temp)) {
            Chess5.setIcon(icon);
            tris[2][1] = 0;
            mossaX[1] = 1;
        } else if ("jButton55".equals(temp)) {
            Chess3.setIcon(icon);
            tris[2][2] = 0;
            mossaX[2] = 1;
        }
    }

    private void resetBoardChess() {
        Chess1.setIcon(icon);
        Chess2.setIcon(icon);
        Chess3.setIcon(iconXBordo);
        Chess4.setIcon(iconXBordo);
        Chess5.setIcon(iconXBordo);
        Chess6.setIcon(iconOBordo);
        Chess7.setIcon(icon);
        Chess8.setIcon(iconOBordo);
        Chess9.setIcon(iconOBordo);
    }

    private Timer buttonTimer;

    public void spostaIcona(JButton b, int x, int y) {
        if (b.getIcon() == selezionato && mossa == 1) {
            togliSelezionato();
            if (currentPlayer.equals("x")) {
                b.setIcon(iconX);
                tris[x][y] = 1;
                currentPlayer = "o";
                TurnoChess.setIcon(iconCambioO);
            } else {
                b.setIcon(iconZero);
                tris[x][y] = 2;
                currentPlayer = "x";
                TurnoChess.setIcon(iconCambioX);
            }
            togliIcon(bottoneTemp);
            startButtonTimer(b);
            mossa = 0;
            boolean temp = muoviPedine();
            if (checkForWin() && temp == true) {
                if (currentPlayer.equals("o")) {
                    Timer timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            px++;
                            Vittoria1.setVisible(true);
                            stopSong();
                            canzonevittoria();
                            Vitindietro2.setVisible(true);
                            giocatore1.setIcon(giocatoreX);
                            giocatore1.setVisible(true);
                            PunteggioX3.setText("" + px);
                            resetBoardChess();
                            inizializzaMatriceChess();
                        }
                    });
                    // Programma l'aggiornamento dell'immagine per la mossa del bot dopo un secondo
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    Timer timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            po++;
                            Vittoria1.setVisible(true);
                            stopSong();
                            canzonevittoria();
                            Vitindietro2.setVisible(true);
                            giocatore1.setIcon(giocatoreO);
                            giocatore1.setVisible(true);
                            PunteggioO3.setText("" + po);
                            resetBoardChess();
                            inizializzaMatriceChess();
                        }
                    });
                    // Programma l'aggiornamento dell'immagine per la mossa del bot dopo un secondo
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        } else if (("x".equals(currentPlayer) && (b.getIcon() == iconZeroD || b.getIcon() == iconOBordo)) || ("o".equals(currentPlayer) && (b.getIcon() == iconXD || b.getIcon() == iconXBordo))) {
            stopSong();
            suonoErrore();
            Timer timer = new Timer(300, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stopSong();
                    canzonebase();
                }
            });
            // Programma l'aggiornamento dell'immagine per la mossa del bot dopo un secondo
            timer.setRepeats(false);
            timer.start();
        }
    }

    ImageIcon selezionato = new ImageIcon("Selezionato.png");

    public void togliSelezionato() {
        if (mossa == 1) {
            if (Chess1.getIcon() == selezionato) {
                Chess1.setIcon(icon);
            }
            if (Chess2.getIcon() == selezionato) {
                Chess2.setIcon(icon);
            }
            if (Chess3.getIcon() == selezionato) {
                Chess3.setIcon(icon);
            }
            if (Chess4.getIcon() == selezionato) {
                Chess4.setIcon(icon);
            }
            if (Chess5.getIcon() == selezionato) {
                Chess5.setIcon(icon);
            }
            if (Chess6.getIcon() == selezionato) {
                Chess6.setIcon(icon);
            }
            if (Chess7.getIcon() == selezionato) {
                Chess7.setIcon(icon);
            }
            if (Chess8.getIcon() == selezionato) {
                Chess8.setIcon(icon);
            }
            if (Chess9.getIcon() == selezionato) {
                Chess9.setIcon(icon);
            }
        }
    }

    public void mostraSelezionato() {
        if (mossa == 0) {
            if (Chess1.getIcon() == icon) {
                Chess1.setIcon(selezionato);
            }
            if (Chess2.getIcon() == icon) {
                Chess2.setIcon(selezionato);
            }
            if (Chess3.getIcon() == icon) {
                Chess3.setIcon(selezionato);
            }
            if (Chess4.getIcon() == icon) {
                Chess4.setIcon(selezionato);
            }
            if (Chess5.getIcon() == icon) {
                Chess5.setIcon(selezionato);
            }
            if (Chess6.getIcon() == icon) {
                Chess6.setIcon(selezionato);
            }
            if (Chess7.getIcon() == icon) {
                Chess7.setIcon(selezionato);
            }
            if (Chess8.getIcon() == icon) {
                Chess8.setIcon(selezionato);
            }
            if (Chess9.getIcon() == icon) {
                Chess9.setIcon(selezionato);
            }
        }

    }

    public boolean muoviPedine() {
        int tempX = 0;
        int tempY = 0;
        if ("o".equals(currentPlayer)) {
            for (int i = 0; i < 3; i++) {
                tempX += mossaX[i];
            }
        } else if ("x".equals(currentPlayer)) {
            for (int i = 0; i < 3; i++) {
                tempY += mossaY[i];
            }
        }
        if (tempX == 3) {
            System.out.println("tutte le pedine X sono state mosse");
            return true;
        } else if (tempY == 3) {
            System.out.println("tutte le pedine Y sono state mosse");
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TrisBot = new javax.swing.JPanel();
        Pareggiobot = new javax.swing.JLabel();
        schermo2 = new javax.swing.JLabel();
        Vittoria3 = new javax.swing.JLabel();
        vitinidietrobot = new javax.swing.JButton();
        Sconfitta = new javax.swing.JLabel();
        riprova = new javax.swing.JButton();
        BtnBack = new javax.swing.JButton();
        NewGame = new javax.swing.JButton();
        CinqueBot = new javax.swing.JButton();
        SeiBot = new javax.swing.JButton();
        NoveBot = new javax.swing.JButton();
        SetteBot = new javax.swing.JButton();
        OttoBot = new javax.swing.JButton();
        DueBot = new javax.swing.JButton();
        QuattroBot = new javax.swing.JButton();
        UnoBot = new javax.swing.JButton();
        TreBot = new javax.swing.JButton();
        PunteggioX1 = new javax.swing.JLabel();
        PunteggioO1 = new javax.swing.JLabel();
        Sfondo1 = new javax.swing.JLabel();
        TutorialTris2 = new javax.swing.JButton();
        Settings = new javax.swing.JPanel();
        SfondoSettings = new javax.swing.JLabel();
        manuale = new javax.swing.JButton();
        Chiudi = new javax.swing.JButton();
        AudioOn = new javax.swing.JButton();
        AudioOff = new javax.swing.JButton();
        Manuale = new javax.swing.JButton();
        Tris1v1 = new javax.swing.JPanel();
        Pareggio1v1 = new javax.swing.JLabel();
        giocatore = new javax.swing.JLabel();
        SfondoVittoria = new javax.swing.JLabel();
        schermo = new javax.swing.JLabel();
        Vitindietro1 = new javax.swing.JButton();
        Tre = new javax.swing.JButton();
        Quattro = new javax.swing.JButton();
        Due = new javax.swing.JButton();
        Sette = new javax.swing.JButton();
        Uno = new javax.swing.JButton();
        Otto = new javax.swing.JButton();
        Nove = new javax.swing.JButton();
        Sei = new javax.swing.JButton();
        Cinque = new javax.swing.JButton();
        PunteggioX = new javax.swing.JLabel();
        Punteggio0 = new javax.swing.JLabel();
        Turno = new javax.swing.JLabel();
        Sfondo = new javax.swing.JLabel();
        NuovaPartita = new javax.swing.JButton();
        BackToHome = new javax.swing.JButton();
        TutorialTris1 = new javax.swing.JButton();
        TrisXXL = new javax.swing.JPanel();
        Pareggioxxl = new javax.swing.JLabel();
        schermo3 = new javax.swing.JLabel();
        giocatore2 = new javax.swing.JLabel();
        Vittoria2 = new javax.swing.JLabel();
        Vitindietro3 = new javax.swing.JButton();
        NewGame1 = new javax.swing.JButton();
        turnoXXL = new javax.swing.JLabel();
        PunteggioX2 = new javax.swing.JLabel();
        PunteggioO2 = new javax.swing.JLabel();
        XXL1 = new javax.swing.JButton();
        XXL2 = new javax.swing.JButton();
        XXL3 = new javax.swing.JButton();
        XXL4 = new javax.swing.JButton();
        XXL5 = new javax.swing.JButton();
        XXL6 = new javax.swing.JButton();
        XXL7 = new javax.swing.JButton();
        XXL8 = new javax.swing.JButton();
        XXL9 = new javax.swing.JButton();
        XXL10 = new javax.swing.JButton();
        XXL11 = new javax.swing.JButton();
        XXL12 = new javax.swing.JButton();
        XXL13 = new javax.swing.JButton();
        XXL14 = new javax.swing.JButton();
        XXL15 = new javax.swing.JButton();
        XXL16 = new javax.swing.JButton();
        XXL17 = new javax.swing.JButton();
        XXL18 = new javax.swing.JButton();
        XXL19 = new javax.swing.JButton();
        XXL20 = new javax.swing.JButton();
        XXL21 = new javax.swing.JButton();
        XXL22 = new javax.swing.JButton();
        XXL23 = new javax.swing.JButton();
        XXL24 = new javax.swing.JButton();
        XXL25 = new javax.swing.JButton();
        SfondoXXL = new javax.swing.JLabel();
        BackXXL = new javax.swing.JButton();
        TutorialXXL = new javax.swing.JButton();
        Home = new javax.swing.JPanel();
        sfondo1 = new javax.swing.JLabel();
        sfondo2 = new javax.swing.JLabel();
        Invio = new javax.swing.JButton();
        Dashboard = new javax.swing.JPanel();
        SfondoDashboard = new javax.swing.JLabel();
        Chess = new javax.swing.JButton();
        Classic = new javax.swing.JButton();
        XXL = new javax.swing.JButton();
        impostazioni = new javax.swing.JButton();
        TrisChess = new javax.swing.JPanel();
        giocatore1 = new javax.swing.JLabel();
        Vittoria1 = new javax.swing.JLabel();
        Vitindietro2 = new javax.swing.JButton();
        backChess = new javax.swing.JButton();
        NewGame2 = new javax.swing.JButton();
        Chess1 = new javax.swing.JButton();
        Chess2 = new javax.swing.JButton();
        Chess3 = new javax.swing.JButton();
        Chess4 = new javax.swing.JButton();
        Chess5 = new javax.swing.JButton();
        Chess6 = new javax.swing.JButton();
        Chess7 = new javax.swing.JButton();
        Chess8 = new javax.swing.JButton();
        Chess9 = new javax.swing.JButton();
        PunteggioX3 = new javax.swing.JLabel();
        PunteggioO3 = new javax.swing.JLabel();
        TurnoChess = new javax.swing.JLabel();
        SfondoChess = new javax.swing.JLabel();
        TutorialChess = new javax.swing.JButton();
        TutorialTris_2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButton63 = new javax.swing.JButton();
        Difficolta = new javax.swing.JPanel();
        SfondoDifficolta = new javax.swing.JLabel();
        Easy = new javax.swing.JButton();
        Medium = new javax.swing.JButton();
        Hard = new javax.swing.JButton();
        BackToDash = new javax.swing.JButton();
        TutorialTris = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton61 = new javax.swing.JButton();
        Tutorial_Chess = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton65 = new javax.swing.JButton();
        Tutorial_XXL = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton64 = new javax.swing.JButton();
        ClassicDash = new javax.swing.JPanel();
        UnoVsPc = new javax.swing.JButton();
        UnoVsUno = new javax.swing.JButton();
        SfondoClassic = new javax.swing.JLabel();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(550, 273));
        setMaximumSize(new java.awt.Dimension(759, 420));
        setMinimumSize(new java.awt.Dimension(759, 420));
        setSize(new java.awt.Dimension(759, 420));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TrisBot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pareggiobot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/pipi-ezgif.com-gif-maker.gif"))); // NOI18N
        Pareggiobot.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TrisBot.add(Pareggiobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 140, 690, 110));

        schermo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/schermino.png"))); // NOI18N
        TrisBot.add(schermo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, 760, 260));

        Vittoria3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/TICTACTOE-ezgif.com-overlay.gif"))); // NOI18N
        TrisBot.add(Vittoria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        vitinidietrobot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vitinidietrobotActionPerformed(evt);
            }
        });
        TrisBot.add(vitinidietrobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 160, 50));

        Sconfitta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/giphy-ezgif.com-overlay.gif"))); // NOI18N
        TrisBot.add(Sconfitta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        riprova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                riprovaActionPerformed(evt);
            }
        });
        TrisBot.add(riprova, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 373, 160, 40));

        BtnBack.setBorderPainted(false);
        BtnBack.setContentAreaFilled(false);
        BtnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });
        TrisBot.add(BtnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 70));

        NewGame.setFont(new java.awt.Font("Liberation Sans", 1, 11)); // NOI18N
        NewGame.setBorderPainted(false);
        NewGame.setContentAreaFilled(false);
        NewGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameActionPerformed(evt);
            }
        });
        TrisBot.add(NewGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 170, 40));

        CinqueBot.setBorderPainted(false);
        CinqueBot.setContentAreaFilled(false);
        CinqueBot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CinqueBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CinqueBotActionPerformed(evt);
            }
        });
        TrisBot.add(CinqueBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 165, 60, 60));

        SeiBot.setBorderPainted(false);
        SeiBot.setContentAreaFilled(false);
        SeiBot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SeiBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeiBotActionPerformed(evt);
            }
        });
        TrisBot.add(SeiBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 165, 60, 60));

        NoveBot.setBorderPainted(false);
        NoveBot.setContentAreaFilled(false);
        NoveBot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NoveBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoveBotActionPerformed(evt);
            }
        });
        TrisBot.add(NoveBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 247, 60, 60));

        SetteBot.setBorderPainted(false);
        SetteBot.setContentAreaFilled(false);
        SetteBot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SetteBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetteBotActionPerformed(evt);
            }
        });
        TrisBot.add(SetteBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 247, 60, 60));

        OttoBot.setBorderPainted(false);
        OttoBot.setContentAreaFilled(false);
        OttoBot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OttoBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OttoBotActionPerformed(evt);
            }
        });
        TrisBot.add(OttoBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 247, 60, 60));

        DueBot.setBorderPainted(false);
        DueBot.setContentAreaFilled(false);
        DueBot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DueBot.setMaximumSize(new java.awt.Dimension(60, 60));
        DueBot.setPreferredSize(new java.awt.Dimension(60, 60));
        DueBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DueBotActionPerformed(evt);
            }
        });
        TrisBot.add(DueBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 84, 60, 60));

        QuattroBot.setBorderPainted(false);
        QuattroBot.setContentAreaFilled(false);
        QuattroBot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        QuattroBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuattroBotActionPerformed(evt);
            }
        });
        TrisBot.add(QuattroBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 165, 60, 60));

        UnoBot.setBorderPainted(false);
        UnoBot.setContentAreaFilled(false);
        UnoBot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UnoBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnoBotActionPerformed(evt);
            }
        });
        TrisBot.add(UnoBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 84, 60, 60));

        TreBot.setBorderPainted(false);
        TreBot.setContentAreaFilled(false);
        TreBot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TreBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TreBotActionPerformed(evt);
            }
        });
        TrisBot.add(TreBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 84, 60, 60));

        PunteggioX1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PunteggioX1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TrisBot.add(PunteggioX1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 212, 60, 20));

        PunteggioO1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PunteggioO1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TrisBot.add(PunteggioO1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 212, 60, 20));

        Sfondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/sfondoBase.png"))); // NOI18N
        TrisBot.add(Sfondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 760, 418));

        TutorialTris2.setText("jButton60");
        TutorialTris2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TutorialTris2ActionPerformed(evt);
            }
        });
        TrisBot.add(TutorialTris2, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 20, 50, 50));

        getContentPane().add(TrisBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        Settings.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SfondoSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/settings.png"))); // NOI18N
        SfondoSettings.setText("jLabel2");
        Settings.add(SfondoSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 297, 180));

        manuale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualeActionPerformed(evt);
            }
        });
        Settings.add(manuale, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 90, 90));

        Chiudi.setText("jButton1");
        Chiudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChiudiActionPerformed(evt);
            }
        });
        Settings.add(Chiudi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, -1));

        AudioOn.setText("jButton1");
        AudioOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AudioOnActionPerformed(evt);
            }
        });
        Settings.add(AudioOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 80, 50, 50));

        AudioOff.setText("jButton1");
        AudioOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AudioOffActionPerformed(evt);
            }
        });
        Settings.add(AudioOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 60, 50));

        Manuale.setText("jButton1");
        Manuale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManualeActionPerformed(evt);
            }
        });
        Settings.add(Manuale, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 60, 60));

        getContentPane().add(Settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 120, -1, -1));

        Tris1v1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pareggio1v1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pareggio1v1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/pipi-ezgif.com-gif-maker.gif"))); // NOI18N
        Pareggio1v1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Tris1v1.add(Pareggio1v1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 600, 110));

        giocatore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/giocatoreO.png"))); // NOI18N
        Tris1v1.add(giocatore, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 160, 40));

        SfondoVittoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/TICTACTOE-ezgif.com-overlay.gif"))); // NOI18N
        Tris1v1.add(SfondoVittoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        schermo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/schermino.png"))); // NOI18N
        Tris1v1.add(schermo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 760, 260));

        Vitindietro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Group 17.png"))); // NOI18N
        Vitindietro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Vitindietro1ActionPerformed(evt);
            }
        });
        Tris1v1.add(Vitindietro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 160, 40));

        Tre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        Tre.setBorderPainted(false);
        Tre.setContentAreaFilled(false);
        Tre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TreActionPerformed(evt);
            }
        });
        Tris1v1.add(Tre, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 89, 60, 60));

        Quattro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        Quattro.setBorderPainted(false);
        Quattro.setContentAreaFilled(false);
        Quattro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Quattro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuattroActionPerformed(evt);
            }
        });
        Tris1v1.add(Quattro, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 169, 60, 60));

        Due.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        Due.setBorderPainted(false);
        Due.setContentAreaFilled(false);
        Due.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Due.setMaximumSize(new java.awt.Dimension(60, 60));
        Due.setPreferredSize(new java.awt.Dimension(60, 60));
        Due.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DueActionPerformed(evt);
            }
        });
        Tris1v1.add(Due, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 89, 60, 60));

        Sette.setBorderPainted(false);
        Sette.setContentAreaFilled(false);
        Sette.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Sette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetteActionPerformed(evt);
            }
        });
        Tris1v1.add(Sette, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 251, 60, 60));

        Uno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        Uno.setBorderPainted(false);
        Uno.setContentAreaFilled(false);
        Uno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnoActionPerformed(evt);
            }
        });
        Tris1v1.add(Uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 89, 60, 60));

        Otto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        Otto.setBorderPainted(false);
        Otto.setContentAreaFilled(false);
        Otto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Otto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OttoActionPerformed(evt);
            }
        });
        Tris1v1.add(Otto, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 251, 60, 60));

        Nove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        Nove.setBorderPainted(false);
        Nove.setContentAreaFilled(false);
        Nove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Nove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoveActionPerformed(evt);
            }
        });
        Tris1v1.add(Nove, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 251, 60, 60));

        Sei.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        Sei.setBorderPainted(false);
        Sei.setContentAreaFilled(false);
        Sei.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Sei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeiActionPerformed(evt);
            }
        });
        Tris1v1.add(Sei, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 169, 60, 60));

        Cinque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        Cinque.setBorderPainted(false);
        Cinque.setContentAreaFilled(false);
        Cinque.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cinque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CinqueActionPerformed(evt);
            }
        });
        Tris1v1.add(Cinque, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 169, 60, 60));

        PunteggioX.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PunteggioX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tris1v1.add(PunteggioX, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 218, 60, 20));

        Punteggio0.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Punteggio0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tris1v1.add(Punteggio0, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 218, 60, 20));

        Turno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Turno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/pareggiotris.gif"))); // NOI18N
        Tris1v1.add(Turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 270, 50));

        Sfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/sfondoBase.png"))); // NOI18N
        Tris1v1.add(Sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 427));

        NuovaPartita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuovaPartitaActionPerformed(evt);
            }
        });
        Tris1v1.add(NuovaPartita, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 170, 40));

        BackToHome.setText("jButton46");
        BackToHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToHomeActionPerformed(evt);
            }
        });
        Tris1v1.add(BackToHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 70));

        TutorialTris1.setText("jButton60");
        TutorialTris1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TutorialTris1ActionPerformed(evt);
            }
        });
        Tris1v1.add(TutorialTris1, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 20, 50, 50));

        getContentPane().add(Tris1v1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        TrisXXL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TrisXXL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pareggioxxl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/pipi-ezgif.com-gif-maker.gif"))); // NOI18N
        TrisXXL.add(Pareggioxxl, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 130, 780, 140));

        schermo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/schermino.png"))); // NOI18N
        TrisXXL.add(schermo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 760, 270));

        giocatore2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/giocatoreO.png"))); // NOI18N
        TrisXXL.add(giocatore2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 160, 40));

        Vittoria2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/TICTACTOE-ezgif.com-overlay.gif"))); // NOI18N
        TrisXXL.add(Vittoria2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        Vitindietro3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Group 17.png"))); // NOI18N
        Vitindietro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Vitindietro3ActionPerformed(evt);
            }
        });
        TrisXXL.add(Vitindietro3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 160, 40));

        NewGame1.setFont(new java.awt.Font("Engravers MT", 0, 10)); // NOI18N
        NewGame1.setBorderPainted(false);
        NewGame1.setContentAreaFilled(false);
        NewGame1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NewGame1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGame1ActionPerformed(evt);
            }
        });
        TrisXXL.add(NewGame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 110, 40));
        TrisXXL.add(turnoXXL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 160, 50));

        PunteggioX2.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        PunteggioX2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TrisXXL.add(PunteggioX2, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 200, 50, 50));

        PunteggioO2.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        PunteggioO2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TrisXXL.add(PunteggioO2, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 200, 50, 50));

        XXL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL1.setBorderPainted(false);
        XXL1.setContentAreaFilled(false);
        XXL1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL1ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 90, 35, 35));

        XXL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL2.setContentAreaFilled(false);
        XXL2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL2ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 90, 35, 35));

        XXL3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL3.setBorderPainted(false);
        XXL3.setContentAreaFilled(false);
        XXL3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL3ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 90, 35, 35));

        XXL4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL4.setBorderPainted(false);
        XXL4.setContentAreaFilled(false);
        XXL4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL4ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 90, 35, 35));

        XXL5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL5.setBorderPainted(false);
        XXL5.setContentAreaFilled(false);
        XXL5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL5ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 35, 35));

        XXL6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL6.setBorderPainted(false);
        XXL6.setContentAreaFilled(false);
        XXL6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL6ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL6, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 140, 35, 35));

        XXL7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL7.setBorderPainted(false);
        XXL7.setContentAreaFilled(false);
        XXL7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL7ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL7, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 140, 35, 35));

        XXL8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL8.setBorderPainted(false);
        XXL8.setContentAreaFilled(false);
        XXL8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL8ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL8, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 140, 35, 35));

        XXL9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL9.setBorderPainted(false);
        XXL9.setContentAreaFilled(false);
        XXL9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL9ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL9, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 140, 35, 35));

        XXL10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL10.setBorderPainted(false);
        XXL10.setContentAreaFilled(false);
        XXL10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL10ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 35, 35));

        XXL11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL11.setBorderPainted(false);
        XXL11.setContentAreaFilled(false);
        XXL11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL11ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL11, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 195, 35, 35));

        XXL12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL12.setBorderPainted(false);
        XXL12.setContentAreaFilled(false);
        XXL12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL12ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL12, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 195, 35, 35));

        XXL13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL13.setBorderPainted(false);
        XXL13.setContentAreaFilled(false);
        XXL13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL13ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL13, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 195, 35, 35));

        XXL14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL14.setBorderPainted(false);
        XXL14.setContentAreaFilled(false);
        XXL14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        XXL14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL14ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL14, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 195, 35, 35));

        XXL15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL15.setBorderPainted(false);
        XXL15.setContentAreaFilled(false);
        XXL15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL15ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 193, 35, 35));

        XXL16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL16.setBorderPainted(false);
        XXL16.setContentAreaFilled(false);
        XXL16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL16ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL16, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 250, 35, 35));

        XXL17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL17.setBorderPainted(false);
        XXL17.setContentAreaFilled(false);
        XXL17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL17ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL17, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 250, 35, 35));

        XXL18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL18.setBorderPainted(false);
        XXL18.setContentAreaFilled(false);
        XXL18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL18ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL18, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 250, 35, 35));

        XXL19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL19.setBorderPainted(false);
        XXL19.setContentAreaFilled(false);
        XXL19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL19ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL19, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 250, 35, 35));

        XXL20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL20.setBorderPainted(false);
        XXL20.setContentAreaFilled(false);
        XXL20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL20ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL20, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 35, 35));

        XXL21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL21.setBorderPainted(false);
        XXL21.setContentAreaFilled(false);
        XXL21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL21ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL21, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 300, 35, 35));

        XXL22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL22.setBorderPainted(false);
        XXL22.setContentAreaFilled(false);
        XXL22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL22ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL22, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 300, 35, 35));

        XXL23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL23.setBorderPainted(false);
        XXL23.setContentAreaFilled(false);
        XXL23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL23ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL23, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 300, 35, 35));

        XXL24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL24.setBorderPainted(false);
        XXL24.setContentAreaFilled(false);
        XXL24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL24ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL24, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 300, 35, 35));

        XXL25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Xanimata-ezgif.com-resize.gif"))); // NOI18N
        XXL25.setBorderPainted(false);
        XXL25.setContentAreaFilled(false);
        XXL25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        XXL25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXL25ActionPerformed(evt);
            }
        });
        TrisXXL.add(XXL25, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 35, 35));

        SfondoXXL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/sfondoXXL.png"))); // NOI18N
        SfondoXXL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SfondoXXL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TrisXXL.add(SfondoXXL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 420));

        BackXXL.setText("jButton45");
        BackXXL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackXXLActionPerformed(evt);
            }
        });
        TrisXXL.add(BackXXL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 70));

        TutorialXXL.setText("jButton60");
        TutorialXXL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TutorialXXLActionPerformed(evt);
            }
        });
        TrisXXL.add(TutorialXXL, new org.netbeans.lib.awtextra.AbsoluteConstraints(681, 20, 50, 50));

        getContentPane().add(TrisXXL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        Home.setMinimumSize(new java.awt.Dimension(759, 420));
        Home.setPreferredSize(new java.awt.Dimension(759, 420));
        Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sfondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/ezgif.com-overlay (1).gif"))); // NOI18N
        sfondo1.setAlignmentY(0.0F);
        sfondo1.setOpaque(true);
        Home.add(sfondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        sfondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/RealHome.png"))); // NOI18N
        Home.add(sfondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, -1));

        Invio.setText("jButton1");
        Invio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvioActionPerformed(evt);
            }
        });
        Home.add(Invio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        getContentPane().add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SfondoDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Group 53.png"))); // NOI18N
        Dashboard.add(SfondoDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 430));

        Chess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChessActionPerformed(evt);
            }
        });
        Dashboard.add(Chess, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 220, 140));

        Classic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassicActionPerformed(evt);
            }
        });
        Dashboard.add(Classic, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 210, 110));

        XXL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XXLActionPerformed(evt);
            }
        });
        Dashboard.add(XXL, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 210, 120));

        impostazioni.setText("jButton1");
        impostazioni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                impostazioniActionPerformed(evt);
            }
        });
        Dashboard.add(impostazioni, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 10, 50, 60));

        getContentPane().add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 420));

        TrisChess.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        giocatore1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/giocatoreO.png"))); // NOI18N
        TrisChess.add(giocatore1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 160, 40));

        Vittoria1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/TICTACTOE-ezgif.com-overlay.gif"))); // NOI18N
        TrisChess.add(Vittoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        Vitindietro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Group 17.png"))); // NOI18N
        Vitindietro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Vitindietro2ActionPerformed(evt);
            }
        });
        TrisChess.add(Vitindietro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 160, 40));

        backChess.setBorderPainted(false);
        backChess.setContentAreaFilled(false);
        backChess.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backChess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backChessActionPerformed(evt);
            }
        });
        TrisChess.add(backChess, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 70));

        NewGame2.setFont(new java.awt.Font("Liberation Sans", 1, 11)); // NOI18N
        NewGame2.setBorderPainted(false);
        NewGame2.setContentAreaFilled(false);
        NewGame2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NewGame2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGame2ActionPerformed(evt);
            }
        });
        TrisChess.add(NewGame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 170, 40));

        Chess1.setBorderPainted(false);
        Chess1.setContentAreaFilled(false);
        Chess1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chess1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chess1ActionPerformed(evt);
            }
        });
        TrisChess.add(Chess1, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 165, 60, 60));

        Chess2.setBorderPainted(false);
        Chess2.setContentAreaFilled(false);
        Chess2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chess2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chess2ActionPerformed(evt);
            }
        });
        TrisChess.add(Chess2, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 165, 60, 60));

        Chess3.setBorderPainted(false);
        Chess3.setContentAreaFilled(false);
        Chess3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chess3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chess3ActionPerformed(evt);
            }
        });
        TrisChess.add(Chess3, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 247, 60, 60));

        Chess4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/ex1.png"))); // NOI18N
        Chess4.setBorderPainted(false);
        Chess4.setContentAreaFilled(false);
        Chess4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chess4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chess4ActionPerformed(evt);
            }
        });
        TrisChess.add(Chess4, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 247, 60, 60));

        Chess5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/ex1.png"))); // NOI18N
        Chess5.setBorderPainted(false);
        Chess5.setContentAreaFilled(false);
        Chess5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chess5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chess5ActionPerformed(evt);
            }
        });
        TrisChess.add(Chess5, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 247, 60, 60));

        Chess6.setBorderPainted(false);
        Chess6.setContentAreaFilled(false);
        Chess6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chess6.setMaximumSize(new java.awt.Dimension(60, 60));
        Chess6.setPreferredSize(new java.awt.Dimension(60, 60));
        Chess6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chess6ActionPerformed(evt);
            }
        });
        TrisChess.add(Chess6, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 84, 60, 60));

        Chess7.setBorderPainted(false);
        Chess7.setContentAreaFilled(false);
        Chess7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chess7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chess7ActionPerformed(evt);
            }
        });
        TrisChess.add(Chess7, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 165, 60, 60));

        Chess8.setBorderPainted(false);
        Chess8.setContentAreaFilled(false);
        Chess8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chess8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chess8ActionPerformed(evt);
            }
        });
        TrisChess.add(Chess8, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 84, 60, 60));

        Chess9.setBorderPainted(false);
        Chess9.setContentAreaFilled(false);
        Chess9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Chess9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chess9ActionPerformed(evt);
            }
        });
        TrisChess.add(Chess9, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 84, 60, 60));

        PunteggioX3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PunteggioX3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TrisChess.add(PunteggioX3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 212, 60, 20));

        PunteggioO3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PunteggioO3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TrisChess.add(PunteggioO3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 212, 60, 20));
        TrisChess.add(TurnoChess, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 110, 50));

        SfondoChess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/sfondoBase.png"))); // NOI18N
        TrisChess.add(SfondoChess, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 760, 418));

        TutorialChess.setText("jButton60");
        TutorialChess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TutorialChessActionPerformed(evt);
            }
        });
        TrisChess.add(TutorialChess, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 20, 60, 60));

        getContentPane().add(TrisChess, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        TutorialTris_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/tutorial1.png"))); // NOI18N
        jLabel12.setText("jLabel11");
        TutorialTris_2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        jButton63.setText("jButton61");
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });
        TutorialTris_2.add(jButton63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 110));

        getContentPane().add(TutorialTris_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        Difficolta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SfondoDifficolta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/difficoltà.png"))); // NOI18N
        SfondoDifficolta.setText("jLabel10");
        Difficolta.add(SfondoDifficolta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        Easy.setText("Easy");
        Easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EasyActionPerformed(evt);
            }
        });
        Difficolta.add(Easy, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 260, 140));

        Medium.setText("Medium");
        Medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MediumActionPerformed(evt);
            }
        });
        Difficolta.add(Medium, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 260, 140));

        Hard.setText("Hard");
        Hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HardActionPerformed(evt);
            }
        });
        Difficolta.add(Hard, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 260, 140));

        BackToDash.setText("jButton59");
        BackToDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToDashActionPerformed(evt);
            }
        });
        Difficolta.add(BackToDash, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 190, 150));

        getContentPane().add(Difficolta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        TutorialTris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/tutorial1.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        TutorialTris.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        jButton61.setText("jButton61");
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });
        TutorialTris.add(jButton61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 110));

        getContentPane().add(TutorialTris, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        Tutorial_Chess.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/tutorial3.png"))); // NOI18N
        jLabel14.setText("jLabel11");
        Tutorial_Chess.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        jButton65.setText("jButton61");
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });
        Tutorial_Chess.add(jButton65, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 110));

        getContentPane().add(Tutorial_Chess, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        Tutorial_XXL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/tutorial2.png"))); // NOI18N
        jLabel13.setText("jLabel11");
        Tutorial_XXL.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        jButton64.setText("jButton61");
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });
        Tutorial_XXL.add(jButton64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 110));

        getContentPane().add(Tutorial_XXL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        ClassicDash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UnoVsPc.setToolTipText("");
        UnoVsPc.setBorderPainted(false);
        UnoVsPc.setContentAreaFilled(false);
        UnoVsPc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UnoVsPc.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        UnoVsPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnoVsPcActionPerformed(evt);
            }
        });
        ClassicDash.add(UnoVsPc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 290, 230));

        UnoVsUno.setBorderPainted(false);
        UnoVsUno.setContentAreaFilled(false);
        UnoVsUno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UnoVsUno.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        UnoVsUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnoVsUnoActionPerformed(evt);
            }
        });
        ClassicDash.add(UnoVsUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 300, 270));

        SfondoClassic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/testisng/Group 16.png"))); // NOI18N
        ClassicDash.add(SfondoClassic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, -1, 430));

        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        ClassicDash.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 40));

        getContentPane().add(ClassicDash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChessActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        TrisChess.setVisible(true);
        po = 0;
        px = 0;
        PunteggioX3.setText("" + px);
        PunteggioO3.setText("" + px);
        mossa = 0;
        for (int i = 0; i < 3; i++) {
            mossaX[i] = 0;
        }
        for (int i = 0; i < 3; i++) {
            mossaY[i] = 0;
        }
        resetBoardChess();
        inizializzaMatriceChess();
    }//GEN-LAST:event_ChessActionPerformed

    private void ClassicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassicActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        ClassicDash.setVisible(true);
    }//GEN-LAST:event_ClassicActionPerformed

    private void XXLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXLActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        TrisXXL.setVisible(true);
        po = 0;
        px = 0;
        PunteggioX2.setText("" + px);
        PunteggioO2.setText("" + px);
        resetBoardXL();
        inizializzaMatriceXL();
    }//GEN-LAST:event_XXLActionPerformed

    private void UnoVsPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnoVsPcActionPerformed
        // TODO add your handling code here:
        po = 0;
        px = 0;
        ClassicDash.setVisible(false);
        Difficolta.setVisible(true);
        resetBoard();
        inizializzaMatrice();
        PunteggioX1.setText("0");
        PunteggioO1.setText("0");
    }//GEN-LAST:event_UnoVsPcActionPerformed

    private void UnoVsUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnoVsUnoActionPerformed
        // TODO add your handling code here:
        po = 0;
        px = 0;
        ClassicDash.setVisible(false);
        Tris1v1.setVisible(true);
        resetBoard();
        inizializzaMatrice();
        PunteggioX.setText("0");
        Punteggio0.setText("0");
    }//GEN-LAST:event_UnoVsUnoActionPerformed

    private void TreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TreActionPerformed
        // TODO add your handling code here:
        inserisciIcona(Tre, 0, 2);
        controllo();
    }//GEN-LAST:event_TreActionPerformed

    private void QuattroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuattroActionPerformed
        // TODO add your handling code here:
        inserisciIcona(Quattro, 1, 0);
        controllo();
    }//GEN-LAST:event_QuattroActionPerformed

    private void DueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DueActionPerformed
        // TODO add your handling code here:
        inserisciIcona(Due, 0, 1);
        controllo();
    }//GEN-LAST:event_DueActionPerformed

    private void SetteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetteActionPerformed
        // TODO add your handling code here:
        inserisciIcona(Sette, 2, 0);
        controllo();
    }//GEN-LAST:event_SetteActionPerformed

    private void UnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnoActionPerformed
        // TODO add your handling code here:
        inserisciIcona(Uno, 0, 0);
        controllo();
    }//GEN-LAST:event_UnoActionPerformed

    private void OttoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OttoActionPerformed
        // TODO add your handling code here:
        inserisciIcona(Otto, 2, 1);
        controllo();
    }//GEN-LAST:event_OttoActionPerformed

    private void NoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoveActionPerformed
        // TODO add your handling code here:
        inserisciIcona(Nove, 2, 2);
        controllo();
    }//GEN-LAST:event_NoveActionPerformed

    private void SeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeiActionPerformed
        // TODO add your handling code here:
        inserisciIcona(Sei, 1, 2);
        controllo();
    }//GEN-LAST:event_SeiActionPerformed

    private void CinqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CinqueActionPerformed
        // TODO add your handling code here:
        inserisciIcona(Cinque, 1, 1);
        controllo();
    }//GEN-LAST:event_CinqueActionPerformed

    private void NuovaPartitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuovaPartitaActionPerformed
        // TODO add your handling code here:
        po = 0;
        px = 0;
        PunteggioX.setText("" + px);
        Punteggio0.setText("" + po);
        resetBoard();
        inizializzaMatrice();
    }//GEN-LAST:event_NuovaPartitaActionPerformed

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        // TODO add your handling code here:
        resetBoardBot();
        inizializzaMatrice();
        TrisBot.setVisible(false);
        Dashboard.setVisible(true);
    }//GEN-LAST:event_BtnBackActionPerformed

    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameActionPerformed
        // TODO add your handling code here:
        po = 0;
        px = 0;
        PunteggioX.setText("" + px);
        Punteggio0.setText("" + po);
        resetBoardBot();
        inizializzaMatrice();
    }//GEN-LAST:event_NewGameActionPerformed

    private void CinqueBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CinqueBotActionPerformed
        // TODO add your handling code here:
        inserisciIconaBot(CinqueBot, 1, 1);
    }//GEN-LAST:event_CinqueBotActionPerformed

    private void SeiBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeiBotActionPerformed
        // TODO add your handling code here:
        inserisciIconaBot(SeiBot, 1, 2);
    }//GEN-LAST:event_SeiBotActionPerformed

    private void NoveBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoveBotActionPerformed
        // TODO add your handling code here:
        inserisciIconaBot(NoveBot, 2, 2);
    }//GEN-LAST:event_NoveBotActionPerformed

    private void SetteBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetteBotActionPerformed
        // TODO add your handling code here:
        inserisciIconaBot(SetteBot, 2, 0);
    }//GEN-LAST:event_SetteBotActionPerformed

    private void OttoBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OttoBotActionPerformed
        // TODO add your handling code here:
        inserisciIconaBot(OttoBot, 2, 1);
    }//GEN-LAST:event_OttoBotActionPerformed

    private void DueBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DueBotActionPerformed
        // TODO add your handling code here:
        inserisciIconaBot(DueBot, 0, 1);
    }//GEN-LAST:event_DueBotActionPerformed

    private void QuattroBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuattroBotActionPerformed
        // TODO add your handling code here:
        inserisciIconaBot(QuattroBot, 1, 0);
    }//GEN-LAST:event_QuattroBotActionPerformed

    private void UnoBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnoBotActionPerformed
        // TODO add your handling code here:
        inserisciIconaBot(UnoBot, 0, 0);
    }//GEN-LAST:event_UnoBotActionPerformed

    private void TreBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TreBotActionPerformed
        // TODO add your handling code here:
        inserisciIconaBot(TreBot, 0, 2);
    }//GEN-LAST:event_TreBotActionPerformed

    private void XXL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL3ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL3, 0, 2);
        controlloXL();
    }//GEN-LAST:event_XXL3ActionPerformed

    private void XXL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL2ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL2, 0, 1);
        controlloXL();
    }//GEN-LAST:event_XXL2ActionPerformed

    private void XXL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL1ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL1, 0, 0);
        controlloXL();
    }//GEN-LAST:event_XXL1ActionPerformed

    private void NewGame1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGame1ActionPerformed
        // TODO add your handling code here:
        po = 0;
        px = 0;
        PunteggioO2.setText("" + px);
        PunteggioX2.setText("" + px);
        resetBoardXL();
        inizializzaMatriceXL();

    }//GEN-LAST:event_NewGame1ActionPerformed

    private void XXL6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL6ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL6, 1, 0);
        controlloXL();
    }//GEN-LAST:event_XXL6ActionPerformed

    private void XXL4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL4ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL4, 0, 3);
        controlloXL();
    }//GEN-LAST:event_XXL4ActionPerformed

    private void XXL5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL5ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL5, 0, 04);
        controlloXL();
    }//GEN-LAST:event_XXL5ActionPerformed

    private void XXL7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL7ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL7, 1, 1);
        controlloXL();
    }//GEN-LAST:event_XXL7ActionPerformed

    private void XXL8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL8ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL8, 1, 2);
        controlloXL();
    }//GEN-LAST:event_XXL8ActionPerformed

    private void XXL9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL9ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL9, 1, 3);
        controlloXL();

    }//GEN-LAST:event_XXL9ActionPerformed

    private void XXL10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL10ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL10, 1, 4);
        controlloXL();
    }//GEN-LAST:event_XXL10ActionPerformed

    private void XXL11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL11ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL11, 2, 0);
        controlloXL();
    }//GEN-LAST:event_XXL11ActionPerformed

    private void XXL12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL12ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL12, 2, 1);
        controlloXL();
    }//GEN-LAST:event_XXL12ActionPerformed

    private void XXL13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL13ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL13, 2, 2);
        controlloXL();
    }//GEN-LAST:event_XXL13ActionPerformed

    private void XXL14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL14ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL14, 2, 3);
        controlloXL();
    }//GEN-LAST:event_XXL14ActionPerformed

    private void XXL15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL15ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL15, 2, 4);
        controlloXL();
    }//GEN-LAST:event_XXL15ActionPerformed

    private void XXL16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL16ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL16, 3, 0);
        controlloXL();
    }//GEN-LAST:event_XXL16ActionPerformed

    private void XXL17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL17ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL17, 3, 1);
        controlloXL();
    }//GEN-LAST:event_XXL17ActionPerformed

    private void XXL18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL18ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL18, 3, 2);
        controlloXL();
    }//GEN-LAST:event_XXL18ActionPerformed

    private void XXL19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL19ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL19, 3, 3);
        controlloXL();
    }//GEN-LAST:event_XXL19ActionPerformed

    private void XXL20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL20ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL20, 3, 4);
        controlloXL();
    }//GEN-LAST:event_XXL20ActionPerformed

    private void XXL21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL21ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL21, 4, 0);
        controlloXL();
    }//GEN-LAST:event_XXL21ActionPerformed

    private void XXL22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL22ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL22, 4, 1);
        controlloXL();
    }//GEN-LAST:event_XXL22ActionPerformed

    private void XXL23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL23ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL23, 4, 2);
        controlloXL();
    }//GEN-LAST:event_XXL23ActionPerformed

    private void XXL24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL24ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL24, 4, 3);
        controlloXL();
    }//GEN-LAST:event_XXL24ActionPerformed

    private void XXL25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XXL25ActionPerformed
        // TODO add your handling code here:
        inserisciIconaXL(XXL25, 4, 4);
        controlloXL();
    }//GEN-LAST:event_XXL25ActionPerformed

    private void BackXXLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackXXLActionPerformed
        // TODO add your handling code here:
        resetBoardXL();
        inizializzaMatriceXL();
        TrisXXL.setVisible(false);
        Dashboard.setVisible(true);
    }//GEN-LAST:event_BackXXLActionPerformed

    private void BackToHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToHomeActionPerformed
        // TODO add your handling code here:
        resetBoard();
        inizializzaMatrice();
        Tris1v1.setVisible(false);
        Dashboard.setVisible(true);
    }//GEN-LAST:event_BackToHomeActionPerformed

    private void backChessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backChessActionPerformed
        // TODO add your handling code here:
        resetBoardChess();
        inizializzaMatriceChess();
        TrisChess.setVisible(false);
        Dashboard.setVisible(true);
    }//GEN-LAST:event_backChessActionPerformed

    private void NewGame2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGame2ActionPerformed
        // TODO add your handling code here:
        po = 0;
        px = 0;
        PunteggioX.setText("" + px);
        Punteggio0.setText("" + px);
        mossa = 0;
        for (int i = 0; i < 3; i++) {
            mossaX[i] = 0;
        }
        for (int i = 0; i < 3; i++) {
            mossaY[i] = 0;
        }
        resetBoardChess();
        inizializzaMatriceChess();

    }//GEN-LAST:event_NewGame2ActionPerformed

    private void Chess1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chess1ActionPerformed
        // TODO add your handling code here: 
        spostaIcona(Chess1, 1, 1);
        if (("x".equals(currentPlayer) && Chess1.getIcon() == iconXD) || ("o".equals(currentPlayer) && Chess1.getIcon() == iconZeroD) || ("o".equals(currentPlayer) && Chess1.getIcon() == iconOBordo) || ("x".equals(currentPlayer) && Chess1.getIcon() == iconXBordo)) {
            mostraSelezionato();
            mossa = 1;
            bottoneTemp = "jButton51";
        }
    }//GEN-LAST:event_Chess1ActionPerformed

    private void Chess2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chess2ActionPerformed
        // TODO add your handling code here:
        spostaIcona(Chess2, 1, 2);
        if (("x".equals(currentPlayer) && Chess2.getIcon() == iconXD) || ("o".equals(currentPlayer) && Chess2.getIcon() == iconZeroD) || ("o".equals(currentPlayer) && Chess2.getIcon() == iconOBordo) || ("x".equals(currentPlayer) && Chess2.getIcon() == iconXBordo)) {
            mostraSelezionato();
            mossa = 1;
            bottoneTemp = "jButton52";
        }
    }//GEN-LAST:event_Chess2ActionPerformed

    private void Chess3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chess3ActionPerformed
        // TODO add your handling code here:
        spostaIcona(Chess3, 2, 2);
        if (("x".equals(currentPlayer) && Chess3.getIcon() == iconXD) || ("o".equals(currentPlayer) && Chess3.getIcon() == iconZeroD) || ("o".equals(currentPlayer) && Chess3.getIcon() == iconOBordo) || ("x".equals(currentPlayer) && Chess3.getIcon() == iconXBordo)) {
            mostraSelezionato();
            mossa = 1;
            bottoneTemp = "jButton55";
        }
    }//GEN-LAST:event_Chess3ActionPerformed

    private void Chess4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chess4ActionPerformed
        // TODO add your handling code here:
        spostaIcona(Chess4, 2, 0);
        if (("x".equals(currentPlayer) && Chess4.getIcon() == iconXD) || ("o".equals(currentPlayer) && Chess4.getIcon() == iconZeroD) || ("o".equals(currentPlayer) && Chess4.getIcon() == iconOBordo) || ("x".equals(currentPlayer) && Chess4.getIcon() == iconXBordo)) {
            mostraSelezionato();
            mossa = 1;
            bottoneTemp = "jButton53";
        }
    }//GEN-LAST:event_Chess4ActionPerformed

    private void Chess5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chess5ActionPerformed
        // TODO add your handling code here:
        spostaIcona(Chess5, 2, 1);
        if (("x".equals(currentPlayer) && Chess5.getIcon() == iconXD) || ("o".equals(currentPlayer) && Chess5.getIcon() == iconZeroD) || ("o".equals(currentPlayer) && Chess5.getIcon() == iconOBordo) || ("x".equals(currentPlayer) && Chess5.getIcon() == iconXBordo)) {
            mostraSelezionato();
            mossa = 1;
            bottoneTemp = "jButton54";
        }
    }//GEN-LAST:event_Chess5ActionPerformed

    private void Chess6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chess6ActionPerformed
        // TODO add your handling code here:
        spostaIcona(Chess6, 0, 1);
        if (("x".equals(currentPlayer) && Chess6.getIcon() == iconXD) || ("o".equals(currentPlayer) && Chess6.getIcon() == iconZeroD) || ("o".equals(currentPlayer) && Chess6.getIcon() == iconOBordo) || ("x".equals(currentPlayer) && Chess6.getIcon() == iconXBordo)) {
            mostraSelezionato();
            mossa = 1;
            bottoneTemp = "jButton48";
        }
    }//GEN-LAST:event_Chess6ActionPerformed

    private void Chess7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chess7ActionPerformed
        // TODO add your handling code here:
        spostaIcona(Chess7, 1, 0);
        if (("x".equals(currentPlayer) && Chess7.getIcon() == iconXD) || ("o".equals(currentPlayer) && Chess7.getIcon() == iconZeroD) || ("o".equals(currentPlayer) && Chess7.getIcon() == iconOBordo) || ("x".equals(currentPlayer) && Chess7.getIcon() == iconXBordo)) {
            mostraSelezionato();
            mossa = 1;
            bottoneTemp = "jButton50";
        }
    }//GEN-LAST:event_Chess7ActionPerformed

    private void Chess8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chess8ActionPerformed
        // TODO add your handling code here:
        spostaIcona(Chess8, 0, 0);
        if (("x".equals(currentPlayer) && Chess8.getIcon() == iconXD) || ("o".equals(currentPlayer) && Chess8.getIcon() == iconZeroD) || ("o".equals(currentPlayer) && Chess8.getIcon() == iconOBordo) || ("x".equals(currentPlayer) && Chess8.getIcon() == iconXBordo)) {
            mostraSelezionato();
            mossa = 1;
            bottoneTemp = "jButton47";
        }
    }//GEN-LAST:event_Chess8ActionPerformed

    private void Chess9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chess9ActionPerformed
        // TODO add your handling code here:
        spostaIcona(Chess9, 0, 2);
        if (("x".equals(currentPlayer) && Chess9.getIcon() == iconXD) || ("o".equals(currentPlayer) && Chess9.getIcon() == iconZeroD) || ("o".equals(currentPlayer) && Chess9.getIcon() == iconOBordo) || ("x".equals(currentPlayer) && Chess9.getIcon() == iconXBordo)) {
            mostraSelezionato();
            mossa = 1;
            bottoneTemp = "jButton49";
        }
    }//GEN-LAST:event_Chess9ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        ClassicDash.setVisible(false);
        Dashboard.setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void Vitindietro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Vitindietro1ActionPerformed
        // TODO add your handling code here:
        SfondoVittoria.setVisible(false);
        Vitindietro1.setVisible(false);
        giocatore.setVisible(false);
        stopSong();
        canzonebase();
        resetBoard();
    }//GEN-LAST:event_Vitindietro1ActionPerformed

    private void Vitindietro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Vitindietro2ActionPerformed
        // TODO add your handling code here:
        Vittoria1.setVisible(false);
        Vitindietro2.setVisible(false);
        giocatore1.setVisible(false);
        stopSong();
        canzonebase();
        resetBoardChess();
        inizializzaMatriceChess();
    }//GEN-LAST:event_Vitindietro2ActionPerformed

    private void Vitindietro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Vitindietro3ActionPerformed
        // TODO add your handling code here:
        Vittoria2.setVisible(false);
        Vitindietro3.setVisible(false);
        giocatore2.setVisible(false);
        stopSong();
        canzonebase();
        resetBoardXL();
    }//GEN-LAST:event_Vitindietro3ActionPerformed

    private void EasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EasyActionPerformed
        // TODO add your handling code here:
        Difficolta.setVisible(false);
        TrisBot.setVisible(true);
        difficolta = 2;
    }//GEN-LAST:event_EasyActionPerformed

    private void MediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MediumActionPerformed
        // TODO add your handling code here:
        Difficolta.setVisible(false);
        TrisBot.setVisible(true);
        difficolta = 6;
    }//GEN-LAST:event_MediumActionPerformed

    private void HardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HardActionPerformed
        // TODO add your handling code here:
        Difficolta.setVisible(false);
        TrisBot.setVisible(true);
        difficolta = 13;
    }//GEN-LAST:event_HardActionPerformed

    private void BackToDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToDashActionPerformed
        // TODO add your handling code here:
        Difficolta.setVisible(false);
        ClassicDash.setVisible(true);
    }//GEN-LAST:event_BackToDashActionPerformed

    private void TutorialTris2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TutorialTris2ActionPerformed
        // TODO add your handling code here:
        TrisBot.setVisible(false);
        TutorialTris.setVisible(true);
    }//GEN-LAST:event_TutorialTris2ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
        TutorialTris.setVisible(false);
        TrisBot.setVisible(true);
    }//GEN-LAST:event_jButton61ActionPerformed

    private void TutorialTris1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TutorialTris1ActionPerformed
        // TODO add your handling code here:
        Tris1v1.setVisible(false);
        TutorialTris_2.setVisible(true);
    }//GEN-LAST:event_TutorialTris1ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        // TODO add your handling code here:
        TutorialTris_2.setVisible(false);
        Tris1v1.setVisible(true);
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        // TODO add your handling code here:
        Tutorial_XXL.setVisible(false);
        TrisXXL.setVisible(true);
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed
        // TODO add your handling code here:
        Tutorial_Chess.setVisible(false);
        TrisChess.setVisible(true);
    }//GEN-LAST:event_jButton65ActionPerformed

    private void TutorialXXLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TutorialXXLActionPerformed
        // TODO add your handling code here:
        TrisXXL.setVisible(false);
        Tutorial_XXL.setVisible(true);
    }//GEN-LAST:event_TutorialXXLActionPerformed

    private void TutorialChessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TutorialChessActionPerformed
        // TODO add your handling code here:
        TrisChess.setVisible(false);
        Tutorial_Chess.setVisible(true);
    }//GEN-LAST:event_TutorialChessActionPerformed

    private void impostazioniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_impostazioniActionPerformed
        // TODO add your handling code here:
        Settings.setVisible(true);
        Chess.setVisible(false);
        Classic.setVisible(false);
        XXL.setVisible(false);
    }//GEN-LAST:event_impostazioniActionPerformed

    private void ChiudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChiudiActionPerformed
        // TODO add your handling code here:
        Settings.setVisible(false);
        Chess.setVisible(true);
        Classic.setVisible(true);
        XXL.setVisible(true);
    }//GEN-LAST:event_ChiudiActionPerformed

    ImageIcon smutato = new ImageIcon("settings.png");
    ImageIcon mutato = new ImageIcon("settingsMuto.png");
    private void AudioOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AudioOnActionPerformed
        // TODO add your handling code here:
        AudioOn.setVisible(false);
        AudioOff.setVisible(true);
        SfondoSettings.setIcon(mutato);
        stopSong();
    }//GEN-LAST:event_AudioOnActionPerformed

    private void AudioOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AudioOffActionPerformed
        // TODO add your handling code here:
        AudioOn.setVisible(true);
        AudioOff.setVisible(false);
        SfondoSettings.setIcon(smutato);
        canzonebase();
    }//GEN-LAST:event_AudioOffActionPerformed

    private void InvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InvioActionPerformed
        // TODO add your handling code here:
        Home.setVisible(false);
        Dashboard.setVisible(true);
    }//GEN-LAST:event_InvioActionPerformed

    private void vitinidietrobotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vitinidietrobotActionPerformed
        // TODO add your handling code here:
        Vittoria3.setVisible(false);
        vitinidietrobot.setVisible(false);
        stopSong();
        canzonebase();
        resetBoardBot();
        inizializzaMatrice();
    }//GEN-LAST:event_vitinidietrobotActionPerformed

    private void riprovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_riprovaActionPerformed
        // TODO add your handling code here:
        Sconfitta.setVisible(false);
        riprova.setVisible(false);
        stopSong();
        canzonebase();
        resetBoardBot();
        inizializzaMatrice();
    }//GEN-LAST:event_riprovaActionPerformed

    private void manualeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualeActionPerformed
        // TODO add your handling code here:
        try {
            File file = new File("tris.pdf"); // Sostituisci "percorso/al/tuo/file.pdf" con il percorso del tuo file PDF
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("Il file non esiste.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } // TODO add your handling code here:
    }//GEN-LAST:event_manualeActionPerformed

    private void ManualeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManualeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManualeActionPerformed

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
            java.util.logging.Logger.getLogger(intefaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(intefaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(intefaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(intefaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(intefaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(intefaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(intefaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(intefaccia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new intefaccia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AudioOff;
    private javax.swing.JButton AudioOn;
    private javax.swing.JButton Back;
    private javax.swing.JButton BackToDash;
    private javax.swing.JButton BackToHome;
    private javax.swing.JButton BackXXL;
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton Chess;
    private javax.swing.JButton Chess1;
    private javax.swing.JButton Chess2;
    private javax.swing.JButton Chess3;
    private javax.swing.JButton Chess4;
    private javax.swing.JButton Chess5;
    private javax.swing.JButton Chess6;
    private javax.swing.JButton Chess7;
    private javax.swing.JButton Chess8;
    private javax.swing.JButton Chess9;
    private javax.swing.JButton Chiudi;
    private javax.swing.JButton Cinque;
    private javax.swing.JButton CinqueBot;
    private javax.swing.JButton Classic;
    private javax.swing.JPanel ClassicDash;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel Difficolta;
    private javax.swing.JButton Due;
    private javax.swing.JButton DueBot;
    private javax.swing.JButton Easy;
    private javax.swing.JButton Hard;
    private javax.swing.JPanel Home;
    private javax.swing.JButton Invio;
    private javax.swing.JButton Manuale;
    private javax.swing.JButton Medium;
    private javax.swing.JButton NewGame;
    private javax.swing.JButton NewGame1;
    private javax.swing.JButton NewGame2;
    private javax.swing.JButton Nove;
    private javax.swing.JButton NoveBot;
    private javax.swing.JButton NuovaPartita;
    private javax.swing.JButton Otto;
    private javax.swing.JButton OttoBot;
    private javax.swing.JLabel Pareggio1v1;
    private javax.swing.JLabel Pareggiobot;
    private javax.swing.JLabel Pareggioxxl;
    private javax.swing.JLabel Punteggio0;
    private javax.swing.JLabel PunteggioO1;
    private javax.swing.JLabel PunteggioO2;
    private javax.swing.JLabel PunteggioO3;
    private javax.swing.JLabel PunteggioX;
    private javax.swing.JLabel PunteggioX1;
    private javax.swing.JLabel PunteggioX2;
    private javax.swing.JLabel PunteggioX3;
    private javax.swing.JButton Quattro;
    private javax.swing.JButton QuattroBot;
    private javax.swing.JLabel Sconfitta;
    private javax.swing.JButton Sei;
    private javax.swing.JButton SeiBot;
    private javax.swing.JButton Sette;
    private javax.swing.JButton SetteBot;
    private javax.swing.JPanel Settings;
    private javax.swing.JLabel Sfondo;
    private javax.swing.JLabel Sfondo1;
    private javax.swing.JLabel SfondoChess;
    private javax.swing.JLabel SfondoClassic;
    private javax.swing.JLabel SfondoDashboard;
    private javax.swing.JLabel SfondoDifficolta;
    private javax.swing.JLabel SfondoSettings;
    private javax.swing.JLabel SfondoVittoria;
    private javax.swing.JLabel SfondoXXL;
    private javax.swing.JButton Tre;
    private javax.swing.JButton TreBot;
    private javax.swing.JPanel Tris1v1;
    private javax.swing.JPanel TrisBot;
    private javax.swing.JPanel TrisChess;
    private javax.swing.JPanel TrisXXL;
    private javax.swing.JLabel Turno;
    private javax.swing.JLabel TurnoChess;
    private javax.swing.JButton TutorialChess;
    private javax.swing.JPanel TutorialTris;
    private javax.swing.JButton TutorialTris1;
    private javax.swing.JButton TutorialTris2;
    private javax.swing.JPanel TutorialTris_2;
    private javax.swing.JButton TutorialXXL;
    private javax.swing.JPanel Tutorial_Chess;
    private javax.swing.JPanel Tutorial_XXL;
    private javax.swing.JButton Uno;
    private javax.swing.JButton UnoBot;
    private javax.swing.JButton UnoVsPc;
    private javax.swing.JButton UnoVsUno;
    private javax.swing.JButton Vitindietro1;
    private javax.swing.JButton Vitindietro2;
    private javax.swing.JButton Vitindietro3;
    private javax.swing.JLabel Vittoria1;
    private javax.swing.JLabel Vittoria2;
    private javax.swing.JLabel Vittoria3;
    private javax.swing.JButton XXL;
    private javax.swing.JButton XXL1;
    private javax.swing.JButton XXL10;
    private javax.swing.JButton XXL11;
    private javax.swing.JButton XXL12;
    private javax.swing.JButton XXL13;
    private javax.swing.JButton XXL14;
    private javax.swing.JButton XXL15;
    private javax.swing.JButton XXL16;
    private javax.swing.JButton XXL17;
    private javax.swing.JButton XXL18;
    private javax.swing.JButton XXL19;
    private javax.swing.JButton XXL2;
    private javax.swing.JButton XXL20;
    private javax.swing.JButton XXL21;
    private javax.swing.JButton XXL22;
    private javax.swing.JButton XXL23;
    private javax.swing.JButton XXL24;
    private javax.swing.JButton XXL25;
    private javax.swing.JButton XXL3;
    private javax.swing.JButton XXL4;
    private javax.swing.JButton XXL5;
    private javax.swing.JButton XXL6;
    private javax.swing.JButton XXL7;
    private javax.swing.JButton XXL8;
    private javax.swing.JButton XXL9;
    private javax.swing.JButton backChess;
    private javax.swing.JLabel giocatore;
    private javax.swing.JLabel giocatore1;
    private javax.swing.JLabel giocatore2;
    private javax.swing.JButton impostazioni;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JButton manuale;
    private javax.swing.JButton riprova;
    private javax.swing.JLabel schermo;
    private javax.swing.JLabel schermo2;
    private javax.swing.JLabel schermo3;
    private javax.swing.JLabel sfondo1;
    private javax.swing.JLabel sfondo2;
    private javax.swing.JLabel turnoXXL;
    private javax.swing.JButton vitinidietrobot;
    // End of variables declaration//GEN-END:variables
}
