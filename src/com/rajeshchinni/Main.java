package com.rajeshchinni;

import java.util.*;

public class Main {

    private  static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        // Create a program that implements a playlist for songs
        // Create a Song class having Title and Duration for a song.
        // The program will have an Album class containing a list of songs.
        // The albums will be stored in an ArrayList
        // Songs from different albums can be added to the playlist and will appear in the list in the order
        // they are added.
        // Once the songs have been added to the playlist, create a menu of options to:-
        // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
        // List the songs in the playlist
        // A song must exist in an album before it can be added to the playlist (so you can only play songs that
        // you own).
        // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
        // started tracking the direction we were going.
        // As an optional extra, provide an option to remove the current song from the playlist
        // (hint: listiterator.remove()


        Album album = new Album("Stormbringer", "Deep purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love dont mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);                       // https://www.geeksforgeeks.org/java-util-arraylist-add-method-java/


        Album pitthu = new Album("For those about to rock", "AC/DC");
        pitthu.addSong("For those about to rock", 5.44);
        pitthu.addSong("I put the finger on you", 3.25);
        pitthu.addSong("Let's go", 3.45);
        pitthu.addSong("Inject the venom", 3.33);
        pitthu.addSong("Snowballed", 4.51);
        pitthu.addSong("Evil walks", 3.45);
        pitthu.addSong("C.O.D", 5.25);
        pitthu.addSong("Breaking the rules", 5.32);
        pitthu.addSong("Night of the long knives", 5.12);
        albums.add(pitthu);


        LinkedList<Song> rajs_meditation_songs_playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylist("You can't do it right", rajs_meditation_songs_playlist);
        albums.get(0).addToPlaylist("Holy man", rajs_meditation_songs_playlist);
        albums.get(0).addToPlaylist("Speed king", rajs_meditation_songs_playlist); // does not exist
        albums.get(0).addToPlaylist(9 , rajs_meditation_songs_playlist);

        albums.get(1).addToPlaylist(8, rajs_meditation_songs_playlist);
        albums.get(1).addToPlaylist(3, rajs_meditation_songs_playlist);
        albums.get(1).addToPlaylist(2, rajs_meditation_songs_playlist);
        albums.get(1).addToPlaylist(24, rajs_meditation_songs_playlist); // there is no track 24

        play(rajs_meditation_songs_playlist);

    }


    private static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> lIterator = playlist.listIterator();
        if (playlist.size() == 0){
            System.out.println("No songs in the playlist");
            return;
        }
        else {
            System.out.println("Now playing " + lIterator.next().toString());  // toString() is a method in Song class
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward){
                        if (lIterator.hasNext()){
                            lIterator.next();
                        }
                        forward = true;
                    }
                    if (lIterator.hasNext()){
                        System.out.println("Now playing " + lIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (lIterator.hasPrevious()){
                            lIterator.previous();
                        }
                        forward = false;
                    }
                    if (lIterator.hasPrevious()){
                        System.out.println("Now playing " + lIterator.previous().toString());
                    } else {
                        System.out.println("We have reached the start of playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward){
                        if (lIterator.hasPrevious()){
                            System.out.println("Now replaying " + lIterator.previous().toString());
                        }else {
                            System.out.println("We are at the start of the list");
                        }
                    }
                    else {
                        if (lIterator.hasNext()){
                            System.out.println("Now replaying" + lIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playlist.size() > 0){
                        lIterator.remove();
                        if (lIterator.hasNext()){
                            System.out.println("Now playing " + lIterator.next());
                        }else if (lIterator.hasPrevious()){
                            System.out.println("Now playing " + lIterator.previous());
                        }
                    }
                    break;
            }
        }


    }



    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - play next song\n" +
                "2 - play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - List songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - Delete current song from playlist");
    }


    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> itr = playList.iterator();
        System.out.println("******************");
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("******************");
    }






}
