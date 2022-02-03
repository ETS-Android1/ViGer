package apps.aqshalrzq.viger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMoviesViewPager();
    }

    private void setupMoviesViewPager() {
        ViewPager2 viewPager = findViewById(R.id.moviesViewPager);

        viewPager.setClipToPadding(false);
        viewPager.setClipChildren(false);
        viewPager.setOffscreenPageLimit(3);
        viewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(8));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });

        viewPager.setPageTransformer(compositePageTransformer);
        viewPager.setAdapter(new MovieAdapter(getMovies()));
    }

    private List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();

        Movie poster1 = new Movie();
        poster1.poster = R.drawable.viger_poster_01;
        poster1.name = "Boruto The Movie : Otsutsuki Version";
        poster1.category = "Action, Fighting, Drama";
        poster1.releaseDate = "December 18, 2018";
        poster1.rating = 4.5f;
        movies.add(poster1);

        Movie poster2 = new Movie();
        poster2.poster = R.drawable.viger_poster_02;
        poster2.name = "Mr. Bean Holiday";
        poster2.category = "Comedy, Family";
        poster2.releaseDate = "January 22, 2014";
        poster2.rating = 4.0f;
        movies.add(poster2);

        Movie poster3 = new Movie();
        poster3.poster = R.drawable.viger_poster_03;
        poster3.name = "Sobat Ambyar";
        poster3.category = "Comedy, Romance";
        poster3.releaseDate = "February 14, 2019";
        poster3.rating = 3.9f;
        movies.add(poster3);

        Movie poster4 = new Movie();
        poster4.poster = R.drawable.viger_poster_04;
        poster4.name = "The Dark Knight";
        poster4.category = "Action, Fighting, Superhero";
        poster4.releaseDate = "June 22, 2016";
        poster4.rating = 4.2f;
        movies.add(poster4);

        Movie poster5 = new Movie();
        poster5.poster = R.drawable.viger_poster_05;
        poster5.name = "Akhir Kisah Cinta Si Doel";
        poster5.category = "Romance, Social";
        poster5.releaseDate = "Desember 18, 2019";
        poster5.rating = 4.8f;
        movies.add(poster5);

        return movies;
    }
}