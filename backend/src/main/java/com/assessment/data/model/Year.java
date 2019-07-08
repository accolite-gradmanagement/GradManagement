package com.assessment.data.model;

public class Year
{
    private Batch[] batches;

    private String yearName;

    public Batch[] getBatches ()
    {
        return batches;
    }

    public void setBatches (Batch[] batches)
    {
        this.batches = batches;
    }

    public String getYearName ()
    {
        return yearName;
    }

    public void setYearName (String yearName)
    {
        this.yearName = yearName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [batches = "+batches+", yearName = "+yearName+"]";
    }
}
