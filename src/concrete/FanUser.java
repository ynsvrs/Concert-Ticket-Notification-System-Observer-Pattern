package concrete;

import interfaces.IFan;

public class FanUser implements IFan {
    private String nickname;
    private String favoriteArtist;

    public FanUser(String nickname, String favoriteArtist) {
        this.nickname = nickname;
        this.favoriteArtist = favoriteArtist;
    }

    public FanUser() {
        this.nickname = "Unnamed Fan";
        this.favoriteArtist = "None";
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setFavoriteArtist(String favoriteArtist) {
        this.favoriteArtist = favoriteArtist;
    }

    @Override
    public void update(String concertUpdate) {
        if (concertUpdate.contains(favoriteArtist)) {
            System.out.println(" [" + nickname + "] received update about favorite artist: " + concertUpdate);
        } else {
            System.out.println(" [" + nickname + "] received general update: " + concertUpdate);
        }
    }

    @Override
    public String getNickname() {
        return nickname;
    }
}
