package com.example.rentagym.Workout;

public class Workout_Images_Items
{
    private String mText1;
    private String mText2;
    private Integer mImage1;
    private Integer mImage2;
    private Integer mImage3;

    public Workout_Images_Items(String text1, String text2, Integer Image1, Integer Image2, Integer Image3)
    {
        mText1 = text1;
        mText2 = text2;
        mImage1 = Image1;
        mImage2 = Image2;
        mImage3 = Image3;
    }

    public String getText1()
    {
        return mText1;
    }

    public String getText2()
    {
        return mText2;
    }

    public Integer getImage1()
    {
        return mImage1;
    }

    public Integer getImage2()
    {
        return mImage2;
    }

    public Integer getImage3()
    {
        return mImage3;
    }
}

