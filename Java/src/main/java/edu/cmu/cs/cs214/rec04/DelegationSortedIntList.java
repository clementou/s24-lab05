package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    private SortedIntList sortedList = new SortedIntList();
    private int totalAdded = 0;

    @Override
    public boolean add(int num) {
        boolean result = sortedList.add(num);
        if (result) {
            totalAdded++;
        }
        return result;
    }

    @Override
    public boolean addAll(IntegerList list) {
        boolean changed = false;
        for (int i = 0; i < list.size(); i++) {
            boolean result = add(list.get(i));
            if (result) {
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public int get(int index) {
        return sortedList.get(index);
    }

    @Override
    public boolean remove(int num) {
        return sortedList.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        boolean changed = false;
        for (int i = 0; i < list.size(); i++) {
            boolean result = sortedList.remove(list.get(i));
            if (result) {
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public int size() {
        return sortedList.size();
    }

    public int getTotalAdded() {
        return totalAdded;
    }

}