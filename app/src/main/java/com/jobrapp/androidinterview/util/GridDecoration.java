package com.jobrapp.androidinterview.util;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;


public class GridDecoration extends RecyclerView.ItemDecoration {
    private int spanCount;
    private int spacing;

    public GridDecoration(int spanCount, int spacing) {
        this.spanCount=spanCount;
        this.spacing=spacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount;
        outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
        outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
        if (position >= spanCount) {
            outRect.top = spacing; // item top
        }
        outRect.bottom = spacing;
        outRect.top=0;
        //super.getItemOffsets(outRect, view, parent, state);

    }
}
