package ru.elleriumsoft.finder.object;

import java.io.Serializable;

/**
 * Created by Dmitriy on 23.04.2017.
 */
public class FinderData implements Serializable
{
    private Integer id;
    private String nameEmployee;
    private Integer idDepartment;
    private String nameDepartment;
    private Integer idProfession;
    private String nameProfession;
    private String employmentDate;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNameEmployee()
    {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee)
    {
        this.nameEmployee = nameEmployee;
    }

    public Integer getIdDepartment()
    {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment)
    {
        this.idDepartment = idDepartment;
    }

    public String getNameDepartment()
    {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment)
    {
        this.nameDepartment = nameDepartment;
    }

    public Integer getIdProfession()
    {
        return idProfession;
    }

    public void setIdProfession(Integer idProfession)
    {
        this.idProfession = idProfession;
    }

    public String getNameProfession()
    {
        return nameProfession;
    }

    public void setNameProfession(String nameProfession)
    {
        this.nameProfession = nameProfession;
    }

    public String getEmploymentDate()
    {
        return employmentDate;
    }

    public void setEmploymentDate(String employmentDate)
    {
        this.employmentDate = employmentDate;
    }
}
