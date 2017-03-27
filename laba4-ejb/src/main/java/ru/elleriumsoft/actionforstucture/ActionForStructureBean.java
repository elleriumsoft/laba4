package ru.elleriumsoft.actionforstucture;

import ru.elleriumsoft.structure.StructureProcessingFromDb;
import ru.elleriumsoft.structure.StructureProcessingFromDbHome;

import javax.ejb.*;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by Dmitriy on 26.03.2017.
 */
public class ActionForStructureBean implements SessionBean
{
    private Integer idForAction;
    private String action;

    public void action(String param, int maxId)
    {
        System.out.println("action=" + action);
        System.out.println("param=" + param);
        if (param == null){ return;}

        if (action.equals("add"))
        {
            actionAddElement(param, maxId);
        }
        if (action.equals("edit"))
        {
            actionEditElement(param);
        }
        setIdForAction(0);
        setAction("");
    }

    private void actionEditElement(String param)
    {
        try
        {
            System.out.println("id=" + idForAction);
            StructureProcessingFromDb structureProcessingFromDb = getHome().findByPrimaryKey(idForAction);
            if (structureProcessingFromDb != null)
            {
                structureProcessingFromDb.setNameDepartmentWithUpdade(param);
            }
        } catch (RemoteException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (FinderException e)
        {
            e.printStackTrace();
        }
        System.out.println(param);
    }

    private void actionAddElement(String param, int id)
    {
        try
        {
            getHome().create(id+1, param, idForAction);
        } catch (CreateException e)
        {
            e.printStackTrace();
        } catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public Integer getIdForAction()
    {
        return idForAction;
    }

    public void setIdForAction(Integer idForAction)
    {
        this.idForAction = idForAction;
    }

    public ActionForStructureBean()
    {
    }

    public void setSessionContext(SessionContext sessionContext) throws EJBException
    {
    }

    public void ejbCreate() throws CreateException
    {
    }

    public void ejbRemove() throws EJBException
    {
    }

    public void ejbActivate() throws EJBException
    {
    }

    public void ejbPassivate() throws EJBException
    {
    }

    private StructureProcessingFromDbHome getHome()
    {
        StructureProcessingFromDbHome structureProcessingFromDbHome = null;
        try {
            InitialContext ic = new InitialContext();
            Object remoteObject = ic.lookup("java:global/laba4-ear-1.0/laba4-ejb-1.0/StructureProcessingFromDbEJB");
            structureProcessingFromDbHome = (StructureProcessingFromDbHome) PortableRemoteObject.narrow(remoteObject, StructureProcessingFromDbHome.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return structureProcessingFromDbHome;
    }
}