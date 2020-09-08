package books.Java.lesson102;

public class Song {
   private String title;
    private String artist;


    public String getArtist(){
        return artist;
    }
    public void setArtist(String a){
        artist = a;
    }

    public String getTitleitle(){
        return title;
    }
    public void setTitle(String t){
        title = t;
    }


/*
    void play() {
        soundPlayer.playSound(title);
    }

*/


    public static void main(String[] args) {
        Song t2 = new Song();
        t2.setArtist("Linkin Park");
        t2.setTitle("Numb");
      //  t2.play();


        Song s3 = new Song();
        s3.setArtist("Papa Roch");
        s3.setTitle("Last Resort");
      //  s3.play();
    }


}


