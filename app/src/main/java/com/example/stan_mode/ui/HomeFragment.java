package com.example.stan_mode.ui;
import androidx.annotation.Nullable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.stan_mode.MainActivity;
import com.example.stan_mode.R;
import com.example.stan_mode.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class HomeFragment extends Fragment {

    private GestureDetector gestureDetector;
    private ViewFlipper viewFlipper;
    private ViewFlipper viewFlipper2;
    private Context context;


    public interface OnNavigationSelectedListener {
        void onNavigationItemSelected(int itemId);
    }

    private OnNavigationSelectedListener listener;

    public void setOnNavigationSelectedListener(OnNavigationSelectedListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        assert container != null;
        context = container.getContext();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewFlipper = view.findViewById(R.id.viewFlipper);
        viewFlipper2 = view.findViewById(R.id.viewFlipper2);
        TextView leftArrow = (TextView) view.findViewById(R.id.left_arrow);
        TextView rightArrow = (TextView) view.findViewById(R.id.right_arrow);
        ImageView manpant = (ImageView) view.findViewById(R.id.manpant);
        ImageView womanpant = (ImageView) view.findViewById(R.id.girlpant);
        Button woman_btn = (Button) view.findViewById(R.id.woman_button);
        Button man_btn = (Button) view.findViewById(R.id.man_button);
        woman_btn.setOnClickListener(view1 -> {
            if (listener != null) {
                listener.onNavigationItemSelected(R.id.woman);
            }
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, WomanFragment.newInstance());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        man_btn.setOnClickListener(view1 -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, ManFragment.newInstance());
            transaction.addToBackStack(null);
            transaction.commit();
        });


        manpant.setOnClickListener(view1 -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, ManFragment.newInstance());
            transaction.addToBackStack(null);
            transaction.commit();

        });

        womanpant.setOnClickListener(view1 -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, WomanFragment.newInstance());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        leftArrow.setOnClickListener(view1 -> {
            showPreviousView();
            showPreviousView2();
        });
        rightArrow.setOnClickListener(view1 -> {
            showNextView();
            showNextView2();
        });

        view.setOnTouchListener(new OnSwipeListener(getContext()) {
            public void onSwipeRight() {
                showPreviousView();
                showPreviousView2();

            }

            public void onSwipeLeft() {
                showNextView();
                showNextView2();
            }
        });
        return view;
    }



    private void showNextView() {
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
        viewFlipper.showNext();
    }

    private void showPreviousView() {
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
        viewFlipper.showPrevious();
    }

    private void showNextView2() {
        viewFlipper2.setInAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left));
        viewFlipper2.setOutAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_right));
        viewFlipper2.showNext();
    }

    private void showPreviousView2() {
        viewFlipper2.setInAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_right));
        viewFlipper2.setOutAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_out_left));
        viewFlipper2.showPrevious();
    }



    public static class OnSwipeListener  implements View.OnTouchListener{

        private final GestureDetector gestureDetector;

        public OnSwipeListener(Context context){
            gestureDetector = new GestureDetector(context,new GestureListener());
        }

        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return  gestureDetector.onTouchEvent(motionEvent);
        }

        private final class GestureListener extends  GestureDetector.SimpleOnGestureListener{

            private static final int SWIPE_VELOCITY_THRESHOLD = 100;
            private static final int SWIPE_THRESHOLD = 100;

            @Override
            public boolean onDown(MotionEvent e){return  true;}

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                assert e1 != null;
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                    }
                } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeBottom();
                    } else {
                        onSwipeTop();
                    }
                }
                return true;
            }
        }
        public void onSwipeRight() {

        }

        public void onSwipeLeft() {
        }

        public void onSwipeTop() {
        }

        public void onSwipeBottom() {
        }

    }

}