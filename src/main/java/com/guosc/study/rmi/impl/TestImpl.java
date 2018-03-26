package com.guosc.study.rmi.impl;

import com.guosc.study.rmi.ITest;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by DOOM on 2018/3/21.
 */
public class TestImpl implements ITest, Serializable {

//    public TestImpl() throws RemoteException {
//        super();
//    }

    @Override
    public String hello(String name) throws RemoteException{
        System.out.println(name);
        return "hi " + name;
    }
}
