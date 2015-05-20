package co.cathalhanley.signalsfrommars.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import co.cathalhanley.signalsfrommars.R;
import co.cathalhanley.signalsfrommars.model.Page;
import co.cathalhanley.signalsfrommars.model.Story;


public class StoryActivity extends Activity {

    private static final String TAG = StoryActivity.class.getSimpleName();
    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoiceOne;
    private Button mChoiceTwo;
    private String mName;
    private Page mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));
        if (mName == null){
            mName = "Friend";
        }
        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoiceOne = (Button) findViewById(R.id.choiceButtonOne);
        mChoiceTwo = (Button) findViewById(R.id.choiceButtonTwo);

        loadPage(0);
    }

    private void loadPage(int choice){
        mCurrentPage = mStory.getPage(choice);
        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        String pageText = mCurrentPage.getText();
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);
        mImageView.setImageDrawable(drawable);
        if (mCurrentPage.isFinal()){
            mChoiceOne.setVisibility(View.INVISIBLE);
            mChoiceTwo.setText("PLAY AGAIN");
            mChoiceTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }else {
            mChoiceOne.setText(mCurrentPage.getChoiceOne().getText());
            mChoiceOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoiceOne().getNextPage();
                    loadPage(nextPage);
                }
            });
            mChoiceTwo.setText(mCurrentPage.getChoiceTwo().getText());
            mChoiceTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoiceTwo().getNextPage();
                    loadPage(nextPage);
                }
            });
        }
    }

}
