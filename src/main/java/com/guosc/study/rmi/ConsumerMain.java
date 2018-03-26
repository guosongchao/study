package com.guosc.study.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by DOOM on 2018/3/21.
 */
public class ConsumerMain {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 8080);

        ITest test = (ITest) registry.lookup("Test");

        registry.unbind("Test");
        System.out.println(test.hello("gsc"));
        registry.rebind("Test1", test);

        String[] s = registry.list();
        for(String ss : s){
            System.out.println(ss);
        }



        test = (ITest) registry.lookup("Test1");
        System.out.println(test.hello("gsc"));

    }
}
