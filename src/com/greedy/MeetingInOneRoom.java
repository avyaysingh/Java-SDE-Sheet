package com.greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class MeetingInOneRoom {
    public static void maxMeetings(int[] start, int[] finish) {
        ArrayList<Meeting> meetingsList = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetingsList.add(new Meeting(start[i], finish[i], i + 1));
        }
        MeetingComparator meetingComparator = new MeetingComparator();
        meetingsList.sort(meetingComparator);

        ArrayList<Integer> result = new ArrayList<>();
        result.add(meetingsList.get(0).pos);
        int limit = meetingsList.get(0).pos;

        for (int i = 1; i < start.length; i++) {
            if (meetingsList.get(i).start > limit) {
                limit = meetingsList.get(i).end;
                result.add(meetingsList.get(i).pos);
            }
        }

        for (int num :
                result) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        maxMeetings(start, finish);
    }
}

class MeetingComparator implements Comparator<Meeting> {

    @Override
    public int compare(Meeting o1, Meeting o2) {
        if (o1.end < o2.end) {
            return -1;
        } else if (o1.end > o2.end) {
            return 1;
        } else if (o1.pos < o2.pos) {
            return -1;
        }
        return 1;
    }
}

class Meeting {
    int start;
    int end;
    int pos;

    public Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
