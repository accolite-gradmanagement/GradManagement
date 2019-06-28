package com.assessment.data.model;

public class Batch
{
    private String[] tests;

    private String name;

    public String[] getTests ()
    {
        return tests;
    }

    public void setTests (String[] tests)
    {
        this.tests = tests;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [tests = "+tests+", name = "+name+"]";
    }
}