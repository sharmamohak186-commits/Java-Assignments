package ass4.q2;

import java.util.*;

class MediaPlayerQueue {
    private final LinkedList<String> songs = new LinkedList<>();
    private final Set<String> history = new LinkedHashSet<>();
    private ListIterator<String> navigator;

    void add(String song) { if (song != null && !song.trim().isEmpty() && !songs.contains(song)) songs.add(song); reset(); }
    void addToFront(String song) { if (song != null && !song.trim().isEmpty()) { songs.remove(song); songs.addFirst(song); reset(); } }
    void remove(String song) { songs.remove(song); reset(); }
    void play(String song) { if (songs.contains(song)) { history.add(song); System.out.println("Playing: " + song); } }
    String next() { if (navigator.hasNext()) return navigator.next(); return null; }
    String previous() { if (navigator.hasPrevious()) return navigator.previous(); return null; }
    void reset() { navigator = songs.listIterator(); }
    void printState() { System.out.println("Queue: " + songs); System.out.println("History: " + history); }
}

public class Main {
    public static void main(String[] args) {
        MediaPlayerQueue player = new MediaPlayerQueue();
        player.add("Song A"); player.add("Song B"); player.add("Song C"); player.addToFront("Priority Song"); player.add("Song B");
        player.play("Priority Song"); System.out.println("Next: " + player.next()); System.out.println("Next: " + player.next());
        player.remove("Song C"); System.out.println("Previous: " + player.previous()); player.printState();
    }
}
