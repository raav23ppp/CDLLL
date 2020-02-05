package dta.cdll;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_a extends Fragment {


    View v;
    private RecyclerView myrecyclerview;
    private FirebaseRecyclerAdapter<model, ViewHolder> firebaseRecyclerAdapter;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference dRef;
    ProgressBar progressBar;


    public Fragment_a() {
        // Required empty public constructor
    }

    public static Fragment_a newInstance(String param1, String param2) {
        Fragment_a fragment = new Fragment_a();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_fragment_a, container, false);
        myrecyclerview=v.findViewById(R.id.recyclerView);
        progressBar=v.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);



        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Consulta a DB
//       FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        dRef = FirebaseDatabase.getInstance().getReference();
        Query query = dRef.child("data");


        FirebaseRecyclerOptions<model> firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<model>()
                .setQuery(query, model.class)
                .build();



        //Firebase Recycler
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<model, ViewHolder>(firebaseRecyclerOptions) {
            @Override
            protected void onBindViewHolder(@NonNull final ViewHolder blogPostHolder, int position, @NonNull final model model) {


                //CREAR LA CARDVIEW
                blogPostHolder.setBlogPost(model);


                //ACCION BOTON PLAY
                blogPostHolder.mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        blogPostHolder.mButton.setBackgroundResource(R.drawable.playbtnnreduced_png);

                        try {
                            blogPostHolder.playSong(model);
                            Toast.makeText(getActivity(),"Text!",Toast.LENGTH_SHORT).show();

                        }catch (Exception e){
                            Toast.makeText(getActivity(),"Error ",Toast.LENGTH_SHORT).show();
                        }


                    }
                });




                //ACCION AL PULSAR IMAGEN
                blogPostHolder.mImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
/*
                        //Abrir actividad individual artista
                        Intent mainIntent = new Intent(getActivity(),Artista_perfil.class);
                        Bundle dataBundle = new Bundle();
                        dataBundle.putString("imagen1",blogPostHolder.getUrl(model));
                        dataBundle.putString("genero",blogPostHolder.getgenero(model));
                        dataBundle.putString("nombre",blogPostHolder.getNombre(model));

                        mainIntent.putExtras(dataBundle);
                        startActivity(mainIntent);

*/
                    }
                });


            }

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_persona_item, parent, false);

                return new ViewHolder(view);
            }
        };
        myrecyclerview.setAdapter(firebaseRecyclerAdapter);
        progressBar.setVisibility(View.INVISIBLE);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        firebaseRecyclerAdapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();

        if (firebaseRecyclerAdapter!= null) {
            firebaseRecyclerAdapter.stopListening();
        }
    }

}
