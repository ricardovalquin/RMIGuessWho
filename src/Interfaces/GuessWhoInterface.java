/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author rick
 */
public interface GuessWhoInterface extends Remote {
    public boolean LogIn(String playerName) throws RemoteException;//
    
    public boolean LOgOut(String playerName)throws RemoteException;//
    
    public String SeeOnlinePlayers()throws RemoteException;//
    
    public boolean Challenge(String retador, String contrincante)throws RemoteException;//
    
    public int AnswerChallenges(String retado, String retador, String respuesta) throws RemoteException;
    
    // entrega un string que es el que te reta, VA EN EL HILO
    public String AskByChallenges(String retado) throws RemoteException;
    
    public String SeeCharacter(int partida, String nombre) throws RemoteException;// see my character
    
    public boolean AskCharacteristic(int partida, String player, String característica) throws RemoteException;
    
    public boolean AskCharacter (int partida, String player, String character) throws RemoteException;
    
    public String SeeTurn(int partida) throws RemoteException;
    
    public int SeeGame(String player) throws RemoteException;// retorna la partida que se está jugando
    
//    public String AskByGameState(int partida);
    
}
