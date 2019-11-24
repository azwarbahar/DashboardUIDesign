package com.example.dashboarduidesign;

/**
 * Created by Muhammad Azwar Bahar on 24/11/19.
 */

public class DashboardItem {

    private String title;
    private int background;
    private int poster;

    public DashboardItem() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public DashboardItem(String title, int background, int poster) {
        this.title = title;
        this.background = background;
        this.poster = poster;
    }
}
