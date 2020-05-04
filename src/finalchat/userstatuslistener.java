/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalchat;

/**
 *
 * @author hp
 */
public interface userstatuslistener {
public void online(String login);
public void offline(String login);
public void onMessage(String fromLogin,String msgbody);
}
