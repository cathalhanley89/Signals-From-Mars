package co.cathalhanley.signalsfrommars.model;


public class Page {
    private int mImageId;
    private String mText;
    private Choice mChoiceOne;
    private Choice mChoiceTwo;
    private boolean mIsFinal;

    public Page(int imageId, String text, Choice choiceOne, Choice choiceTwo){
        mImageId = imageId;
        mText = text;
        mChoiceOne = choiceOne;
        mChoiceTwo = choiceTwo;
    }

    public Page(int imageId, String text){
        mImageId = imageId;
        mText = text;
        mChoiceOne = null;
        mChoiceTwo = null;
        mIsFinal = true;
    }

    public boolean isFinal() {
        return mIsFinal;
    }

    public void setFinal(boolean isFinal) {
        mIsFinal = isFinal;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoiceOne() {
        return mChoiceOne;
    }

    public void setChoiceOne(Choice choiceOne) {
        mChoiceOne = choiceOne;
    }

    public Choice getChoiceTwo() {
        return mChoiceTwo;
    }

    public void setChoiceTwo(Choice choiceTwo) {
        mChoiceTwo = choiceTwo;
    }
}
