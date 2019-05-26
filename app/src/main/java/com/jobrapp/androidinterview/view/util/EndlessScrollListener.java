package com.jobrapp.androidinterview.view.util;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {
    private LinearLayoutManager linearLayoutManager;
    private int previousItemsInList = 0;
    private int visibleThreshold = 5;
    private boolean loading=true;
    public EndlessScrollListener(LinearLayoutManager linearLayoutManager){
        this.linearLayoutManager=linearLayoutManager;
    }

    public EndlessScrollListener(LinearLayoutManager linearLayoutManager, int visibleThreshold){
        this.linearLayoutManager=linearLayoutManager;
        this.visibleThreshold = visibleThreshold;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int currentItemsInList =linearLayoutManager.getItemCount();
        int visibleItemCount = recyclerView.getChildCount();
        int firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();

        if (loading) {
            if (currentItemsInList > previousItemsInList) {
                loading = false;
                previousItemsInList = currentItemsInList;
            }
        }
        if (!loading){
            if((currentItemsInList - visibleItemCount)
                    <= (firstVisibleItem + visibleThreshold)){
                loading=true;
                loadBottom();

            }else if (firstVisibleItem==0){
//                TODO: To manage loadingTop we need different boolean which is not needed for this interview task
//                loading=true;
//                loadTop();
            }

        }

    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public abstract void loadBottom();
    public abstract void loadTop();

    // Call this method whenever requesting data from 0
    public void resetState() {
        this.previousItemsInList = 0;
        this.loading = true;
    }
}
