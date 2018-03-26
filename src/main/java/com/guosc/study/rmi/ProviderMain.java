package com.guosc.study.rmi;

import com.guosc.study.rmi.impl.TestImpl;
import org.apache.commons.math.stat.inference.TTestImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by DOOM on 2018/3/21.
 */
public class ProviderMain {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {
        ITest test = new TestImpl();

        Registry registry = LocateRegistry.createRegistry(8080);

        registry.bind("Test", test);
        Thread.sleep(500000);
    }
}
