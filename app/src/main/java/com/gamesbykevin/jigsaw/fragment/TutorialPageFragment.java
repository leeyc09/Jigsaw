package com.gamesbykevin.jigsaw.fragment;

import android.app.Fragment;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gamesbykevin.jigsaw.R;

public class TutorialPageFragment extends Fragment {

    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";

    //the fragment's page number
    private int pageNumber;

    /**
     * Factory method for this fragment class.
     * @param pageNumber The desired page #
     * @return The fragment representing the current page #
     */
    public static TutorialPageFragment create(int pageNumber) {

        TutorialPageFragment fragment = new TutorialPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public TutorialPageFragment() {
        //default constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get the arguments passed
        this.pageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //inflate the layout to access the ui elements
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_tutorial_page, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.tutorialImage);
        TextView textView = (TextView) view.findViewById(R.id.instructionsText);

        final int resIdImage;
        final int resIdText;

        switch (getPageNumber()) {

            case 0:
                resIdImage = R.drawable.tutorial1;
                resIdText = R.string.tutorial_instructions_1;
                break;

            case 1:
                resIdImage = R.drawable.tutorial2;
                resIdText = R.string.tutorial_instructions_2;
                break;

            case 2:
                resIdImage = R.drawable.tutorial3;
                resIdText = R.string.tutorial_instructions_3;
                break;
            case 3:
                resIdImage = R.drawable.tutorial4;
                resIdText = R.string.tutorial_instructions_4;
                break;

            case 4:
                resIdImage = R.drawable.tutorial5;
                resIdText = R.string.tutorial_instructions_5;
                break;

            case 5:
                resIdImage = R.drawable.tutorial6;
                resIdText = R.string.tutorial_instructions_6;
                break;

            case 6:
                resIdImage = R.drawable.tutorial7;
                resIdText = R.string.tutorial_instructions_7;
                break;

            case 7:
                resIdImage = R.drawable.tutorial8;
                resIdText = R.string.tutorial_instructions_8;
                break;

            case 8:
                resIdImage = R.drawable.tutorial9;
                resIdText = R.string.tutorial_instructions_9;
                break;

            default:
                throw new RuntimeException("Page # not defined: " + getPageNumber());
        }

        //update bitmap accordingly
        imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), resIdImage));

        //assign the appropriate instruction text
        textView.setText(resIdText);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onResume() {

        //call parent
        super.onResume();
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}