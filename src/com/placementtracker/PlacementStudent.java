package com.placementtracker;

public class PlacementStudent extends Student {

    private boolean eligible;
    private int rank;

    public PlacementStudent(int id, String name, double marks,
                             double attendance, String skills) {
        super(id, name, marks, attendance, skills);
        this.eligible = false;
        this.rank = 0;
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Eligible: " + (eligible ? "YES" : "NO"));
        if (eligible) {
            System.out.println("Rank: " + rank);
        }
    }
}
