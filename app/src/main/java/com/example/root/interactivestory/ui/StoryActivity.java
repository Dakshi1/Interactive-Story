package com.example.root.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.interactivestory.R;
import com.example.root.interactivestory.model.Page;
import com.example.root.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;
    private Story mStory=new Story();
    private static final String TAG=StoryActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent=getIntent();
        mName=intent.getStringExtra(getString(R.string.key_name));
        if(mName.equals(null) || mName.equals(""))
        {
            mName="Friend";
        }
        mImageView= (ImageView) findViewById(R.id.imageView);
        mTextView= (TextView) findViewById(R.id.storyTextView);
        mChoice1= (Button) findViewById(R.id.choiceButton1);
        mChoice2=(Button)  findViewById(R.id.choiceButton2);
        loadpage(0);
    }

    private void loadpage(int pageNumber) {
        mCurrentPage = mStory.getPage(pageNumber);
        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);
        String pageText = mCurrentPage.getText();
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);
        if (mCurrentPage.isFinal()) {

            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("PLAY AGAIN");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    finish();
                }
            });
        } else {
            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());
            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadpage(nextPage);
                }
            });
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadpage(nextPage);
                }
            });
        }
    }
}
