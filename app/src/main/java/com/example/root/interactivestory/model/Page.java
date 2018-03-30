package com.example.root.interactivestory.model;

/**
 * Created by root on 26/3/17.
 */

public class Page {

    private String mText;
    private int mImageId;
    private Choice mChoice1;
    private Choice mChoice2;
    private boolean mIsFinal=false;

    public boolean isFinal() {
        return mIsFinal;
    }

    public void setFinal(boolean aFinal) {
        mIsFinal = aFinal;
    }

    public Page(int imageId, String text, Choice choice1, Choice choice2) {
        mText = text;
        mImageId = imageId;
        mChoice1 = choice1;
        mChoice2 = choice2;
    }

    public Page( int imageId, String text) {
        mText = text;
        mImageId = imageId;
        mChoice1 = null;
        mChoice2 = null;
        mIsFinal=true;
    }


    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }
}
