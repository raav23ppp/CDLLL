package dta.cdll;

public class model {

    String image,title,genero, description,urlMusic;

    public model() {

    }

    public model(String image, String title, String description, String urlMusic, String genero) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.urlMusic=urlMusic;
        this.genero=genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUrlMusic() {
        return urlMusic;
    }

    public void setUrlMusic(String urlMusic) {
        this.urlMusic = urlMusic;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
