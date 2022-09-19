package thread.thread_creation;

class Video extends Thread{
}



public class Solution {
    public static void main(String[] args) {
        Video video = new Video();
        video.start();
    }
}
