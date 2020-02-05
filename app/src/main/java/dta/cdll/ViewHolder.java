package dta.cdll;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView mTitle, mDescription,mGenero;
    public ImageView mImage;
    public Button mButton;
    public MediaPlayer mediaPlayer;


    public ViewHolder(View itemView){
        super(itemView);

        mTitle = itemView.findViewById(R.id.item_name);
        mGenero = itemView.findViewById(R.id.item_genero);
         mImage = itemView.findViewById(R.id.item_image);
         mButton=itemView.findViewById(R.id.button3);







    }

    void setBlogPost(model model) {
        String title = model.getTitle();
        mTitle.setText(title);
        String imageUrl = model.getImage();
        Picasso.get().load(imageUrl).into(mImage);
        String genero = model.getGenero();
        mGenero.setText(genero);
    }


    public String getUrl(model model){

        String url = model.getImage();

        return url;

    }

    public String getNombre(model model){

        String url = model.getTitle();

        return url;

    }

    public String getgenero(model model){

        String url = model.getGenero();

        return url;

    }


    void playSong (model model){

        String urlMusic = model.getUrlMusic();

        mediaPlayer= new MediaPlayer();

        try {
            mediaPlayer.setDataSource(urlMusic);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {

                    mp.start();



                }
            });

            mediaPlayer.prepare();

        }catch (Exception e){
            Log.i("III","Error: "+e);

        }



    }





}
