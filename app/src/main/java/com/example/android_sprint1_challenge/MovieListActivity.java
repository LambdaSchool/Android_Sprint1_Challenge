package com.example.android_sprint1_challenge;

import android.content.Context;
import android.widget.LinearLayout;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieListActivity implements Serializable {

    public static final int NEW_ENTRY_REQUEST = 2;
    Context context;

    static int nextId = 0;

    ArrayList<MovieListActivity> entryList;
    LinearLayout listLayout;




}
