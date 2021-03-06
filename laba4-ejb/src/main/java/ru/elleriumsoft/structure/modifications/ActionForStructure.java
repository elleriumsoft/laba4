package ru.elleriumsoft.structure.modifications;

import ru.elleriumsoft.structure.objectstructure.ObjectOfStructure;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

/**
 * Created by Dmitriy on 26.03.2017.
 */
public interface ActionForStructure extends EJBObject
{
    Integer getIdForAction() throws RemoteException;
    void setIdForAction(Integer idForAction) throws RemoteException;
    String getAction() throws RemoteException;
    void setAction(String action) throws RemoteException;
    ObjectOfStructure action(String param, int maxId, ObjectOfStructure objectOfStructure) throws RemoteException;
}
