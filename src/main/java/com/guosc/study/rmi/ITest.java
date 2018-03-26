package com.guosc.study.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by DOOM on 2018/3/21.
 */
public interface ITest extends Remote {
    public String hello(String name) throws RemoteException;
}
